function envGet(v) {
  return pm.collectionVariables.get(v);
}

function envSet(k, v) {
  pm.collectionVariables.set(k, v);
}

const response = pm.response.json(),
      template = envGet('primeNotificationTemplate'),
      undefHTML = '<code>undefined</code>';

var view = {
  pageTitle: 'GHC Contractor - Notified of Move',
  pageHeading: 'GHC Contractor',
  pageAction: 'Receives Moves information',
  alertType: 'error',
  customerFullName: '',
  shipmentID: '',
  moveCode: '',
  moveID: pm.request.url.path.pop(),
  errorMessage: response.title,
};

// By default, a shipment would not have a Reweigh until it was requested.
var hasReweigh = false;

// If the Move is found, we'll update the view object. Otherwise, we'll
// consider the response to be a 404 and modify the view for and error state.
if (pm.response.code === 200) {
  view.customerFullName += response.order.customer.firstName.trim();
  view.customerFullName += ' ';
  view.customerFullName += response.order.customer.lastName.trim();

  view.shipmentID = response.mtoShipments[0].id;

  view.moveCode = response.moveCode;
  view.moveID = response.id;


  view.alertTitle = 'Move is now available to GHC Prime Contractor';
  view.alertType = 'success';

  console.info('Setting Collection variables for later.');
  envSet('customerFullName', view.customerFullName);
  envSet('shipmentID', view.shipmentID);
  envSet('shipmentETag', response.mtoShipments[0].eTag);
  envSet('moveTaskOrderCode', view.moveCode);
  envSet('moveTaskOrderID', view.moveID);
  envSet('moveTaskOrderETag', response.eTag);

  var serviceItemsIDs = [];
  response.mtoServiceItems.forEach(function(item) {
    serviceItemsIDs.push({
      id: item.id,
    });
  });

  // prepare a payment request
  const paymentRequestPayload = {
    isFinal: false,
    moveTaskOrderID: view.moveID,
    serviceItems: []
  };
  paymentRequestPayload.serviceItems = serviceItemsIDs;
  envSet('paymentRequestPayload', JSON.stringify(paymentRequestPayload, null, 2));

} else {
  view.alertTitle = 'Move is not available to GHC Prime Contractor';
  view.alertType = 'error';
  view.moveCode = undefHTML;
  if (view.moveID === ":moveID") {
    view.moveID = undefHTML;
  }
}

// Setup the visualization template.
pm.visualizer.set(template, view);
