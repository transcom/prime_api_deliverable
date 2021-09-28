console.info('I am inside example-get-move-task-orders/events/test.js');
console.info('This file runs within the Postman.app JavaScript Runtime and not within Node JS.');
console.info('For more documentation on this, see this URL: https://learning.postman.com/docs/writing-scripts/script-references/postman-sandbox-api-reference/#using-external-libraries');

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

// The response JSON that Postman created.
const response = pm.response.json();

// The template file that is set in example-get-move-task-orders/index.js that
// references example-get-move-task-orders/templates/visualize.html
const template = envGet('visualizeTemplate');

// A helpful string that can be used to show "undefined" in the Visualize tab.
const undefHTML = '<code>undefined</code>';

// The view object that gets fed into the template file. These are base values
// and will be modified in the next conditional checks around the status code.
var view = {
  pageTitle: 'GHC Contractor - Move Card',
  pageHeading: 'GHC Contractor',
  pageAction: 'Receives Moves information',
  alertTitle: '',
  alertType: '',
  customerFullName: envGet('customerFullName'),
  moveCode: envGet('moveCode'),
  moveID: envGet('moveID'),
  errorMessage: '',
};

// By default, a shipment would not have a Reweigh until it was requested.
var hasReweigh = false;

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

// Setup the visualization template.
pm.visualizer.set(template, view);
