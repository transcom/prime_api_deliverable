// A helpful function that's less characters to type to get a Collection
// Variable.
function envGet(v) {
  return pm.collectionVariables.get(v);
}

// A helpful function that's less characters to type to set a Collection
// Variable.
function envSet(k, v) {
  pm.collectionVariables.set(k, v);
}

// A helpful map of relationships between request file names and titles.
const requestIDToTitle = {
  'move-task-orders': 'Get MoveTaskOrder By ID',
  moves: 'Get All Moves',
  'mto-shipments-sit-extensions': 'Create SIT Extension For Shipment ID',
};

// The response JSON that Postman created.
const response = pm.response.json();

// The custom header for Postman Request ID which is the filename of the
// ./requests files.
const pmRequestID = pm.request.getHeaders()['Postman-Request-ID'];

// The template file that is set in example-get-move-task-orders/index.js that
// references example-get-move-task-orders/templates/visualize.html
const template = envGet('visualizeTemplate');

// A helpful string that can be used to show "undefined" in the Visualize tab.
const undefHTML = '<code>undefined</code>';

// The view object that gets fed into the template file. These are base values
// and will be modified in the next conditional checks around the status code.
var view = {
  viewUpdatedAt: '',
  pageTitle: requestIDToTitle[pmRequestID],
  pageHeading: 'GHC Contractor',
  pageAction: 'Receives Moves information',
  alertTitle: '',
  alertType: '',
  customerFullName: envGet('customerFullName'),
  moveCode: envGet('moveCode'),
  moveID: envGet('moveID'),
  mtoShipmentID: envGet('mtoShipmentID'),
  mtoShipmentETag: envGet('mtoShipmentETag'),
  reweighID: envGet('reweighID'),
  reweighETag: envGet('reweighETag'),
  errorMessage: '',
  errorDetail: '',
  errorTraceId: '',
  move_task_orders: false,
  moves: false,
  mto_shipments_sit_extensions: false,
  show_reweigh: false,
  show_payment_request: false,
  show_proof_of_service: false,
  show_updated_mto_shipment: false,
};

view.viewUpdatedAt = `${new Date()}`;

if (pm.response.code >= 300) {
  console.debug(response);
  view.alertTitle     = 'Something went wrong';
  view.alertType      = 'error';
  view.errorMessage   = response.title;
  view.errorDetail    = response.detail;
  view.errorTraceId   = response.instance;
}

if (pmRequestID === 'moves') {
  view.moves = true;

  if (pm.response.code === 200) {
    view.alertTitle = 'List All Moves';
    view.pageAction = 'Get All Moves';
    view.alertType  = 'success';
    view.movesList = response;
  }

}

if (pmRequestID === 'move-task-orders') {
  view.move_task_orders = true;

  // If the Move is found, we'll update the view object appropriately.
  if (pm.response.code === 200) {
    view.customerFullName = response.order.customer.firstName.trim();
    view.customerFullName += ' ';
    view.customerFullName += response.order.customer.lastName.trim();

    console.info('Setting customerFullName in the Collection Variables');
    envSet('customerFullName', view.customerFullName);

    view.moveCode = response.moveCode;
    view.moveID = response.id;

    console.info('Setting moveTaskOrderCode, moveTaskOrderID, moveTaskOrderETag in the Collection Variables');
    envSet('moveTaskOrderCode', view.moveCode);
    envSet('moveTaskOrderID', view.moveID);
    envSet('moveTaskOrderETag', response.eTag);
    envSet('mtoShipmentID', response.mtoShipments[0].id);
    envSet('mtoShipmentETag', response.mtoShipments[0].eTag);
    if (response.mtoShipments[0].reweigh) {
      envSet('reweighID', response.mtoShipments[0].reweigh.id);
      envSet('reweighETag', response.mtoShipments[0].reweigh.eTag);
      view.show_reweigh = true;
    }

    if (view.show_reweigh) {
      const reweigh = response.mtoShipments[0].reweigh;
      if (reweigh.weight || reweigh.verificationReason) {
        // reweigh requested and performed
        view.alertTitle = 'Reweigh has been requested and completed';
        view.alertType  = 'success';
      } else {
        // reweigh requested but not performed yet
        view.alertTitle = 'Reweigh has been requested';
        view.alertType  = 'warning';
      }
      view.reweigh_details = {
        id: reweigh.id,
        requestedAt: reweigh.requestedAt,
        requestedBy: reweigh.requestedBy,
        weight: reweigh.weight,
        verificationReason: reweigh.verificationReason,
        verificationProvidedAt: reweigh.verificationProvidedAt,
      }
    } else {
      view.alertTitle = 'Move is now available to GHC Prime Contractor';
      view.alertType  = 'success';
    }

    // prepare a payment request
    const paymentRequest = {
      isFinal: false,
      moveTaskOrderID: view.moveID,
      serviceItems: []
    };
    const serviceItemsToInvoice = envGet('serviceItemsToInvoice');
    response.mtoServiceItems
      .filter((serviceItem) => {
        return serviceItemsToInvoice.includes(serviceItem.reServiceCode) && serviceItem.mtoShipmentID === response.mtoShipments[0].id;
      })
      .forEach((serviceItem) => {
        console.info(serviceItem);
        const si = { id: serviceItem.id };
        if (serviceItem.reServiceCode === "DDASIT") {
          si.params = [{

            key: "SITPaymentRequestStart",
            value: "2021-09-01",
          },{
            key: "SITPaymentRequestEnd",
            value: "2021-09-30",
          }];
        }
        paymentRequest.serviceItems.add(si);
      });
    envSet('paymentRequestPayload', JSON.stringify(paymentRequest, null, 2));
    console.info(envGet('paymentRequestPayload'));
  }

  // If the Move is not found, we'll update the view object appropriately.
  if (pm.response.code === 404) {
    view.alertTitle   = 'Move is not available to GHC Prime Contractor';
    view.alertType    = 'error';
    view.moveCode     = undefHTML;
    view.moveID       = undefHTML;
    view.errorMessage = response.title;
  }
}

if (pmRequestID === 'create-sit-mto-service-items') {
  view.create_sit_mto_service_items = true;
  view.pageAction = 'Create Destination SIT Service Items';

  if (pm.response.code === 200) {
    view.alertTitle     = 'Destination SIT Service Items Created';
    view.alertType      = 'success';
    view.sitServiceItem = response;
  } else {
    view.alertTitle     = 'Destination SIT Service Items Create Failed';
  }
}

if (pmRequestID === 'mto-shipments-sit-extensions') {
  view.mto_shipments_sit_extensions = true;

  if (pm.response.code === 201) {
    view.alertTitle = 'SIT Extension Created';
    view.alertType  = 'success';
    view.pageAction = 'Create SIT Extension';
    view.sitExtension = response;
  }
}

if (pmRequestID === 'create-payment-request') {
  view.show_payment_request = true
  view.pageAction = 'Payment Request Creation';
  if (pm.response.code == 201) {
    let total = 0;
    view.alertTitle = 'Creation Succeeded';
    view.alertType = 'success';
    envSet('paymentRequestID', response.id);
    view.paymentRequest = response;
    view.paymentRequest.paymentServiceItems.forEach(psi => total += psi.priceCents);
    total = total/100
    view.paymentRequest.total = total;
    view.paymentRequest.payload = request.data;
  } else {
    view.alertTitle = 'Creation Failed';
  }
}

if (pmRequestID === 'upload-proof-of-service') {
  view.show_proof_of_service = true
  view.pageAction = 'Proof of Service Upload';
  if (pm.response.code == 201) {
    view.alertTitle = 'Upload Succeeded';
    view.alertType = 'success';
    view.proofOfServiceDetails = response;
  } else {
    view.alertTitle = 'Upload Failed';
    view.alertType = 'error';
  }
}

// response from update-mto-shipment endpoint is shipment JSON with new eTag
if (request.url.includes('/prime/v1/mto-shipments') && request.method === "PATCH") {
  view.show_updated_mto_shipment = true
  view.pageAction = 'Update Shipment';
  if (pm.response.code == 200) {
    envSet('mtoShipmentETag', response.eTag);
    view.alertTitle = 'Update Succeeded';
    view.alertType = 'success';
    view.updatesMade = {};
    Object.keys(JSON.parse(request.data)).forEach((key) => {
      view.updatesMade[key] = response[key];
    })
  } else {
    view.alertTitle = 'Update Failed';
    view.alertType = 'error';
  }
}

// Setup the visualization template.
pm.visualizer.set(template, view);
