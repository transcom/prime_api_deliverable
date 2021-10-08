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
  pageTitle: requestIDToTitle[pmRequestID],
  pageHeading: 'GHC Contractor',
  pageAction: 'Receives Moves information',
  alertTitle: '',
  alertType: '',
  customerFullName: envGet('customerFullName'),
  moveCode: envGet('moveCode'),
  moveID: envGet('moveID'),
  mtoShipmentID: envGet('mtoShipmentID'),
  errorMessage: '',
  move_task_orders: false,
  moves: false,
  mto_shipments_sit_extensions: false,
};

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
    view.customerFullName += response.order.customer.firstName.trim();
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

    view.alertTitle = 'Move is now available to GHC Prime Contractor';
    view.alertType  = 'success';
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

if (pmRequestID === 'mto-shipments-sit-extensions') {
  view.mto_shipments_sit_extensions = true;

  if (pm.response.code === 201) {
    view.alertTitle = 'SIT Extension Created';
    view.alertType  = 'success';
    view.pageAction = 'Create SIT Extension';
    view.sitExtension = response;
  }

}

// Setup the visualization template.
pm.visualizer.set(template, view);
