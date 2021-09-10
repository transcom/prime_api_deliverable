function envGet(v) {
  return pm.collectionVariables.get(v);
}

function envSet(k, v) {
  pm.collectionVariables.set(k, v);
}

const response = pm.response.json();
const template = envGet('primeNotificationTemplate');

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

// If the Move is found, we'll update the view object. Otherwise, we'll
// consider the response to be a 404 and modify the view for and error state.
if (pm.response.code === 200) {
  view.customerFullName += response.order.customer.firstName.trim();
  view.customerFullName += ' ';
  view.customerFullName += response.order.customer.lastName.trim();

  view.shipmentID = response.mtoShipments[0].id;
  envSet('shipmentETag', response.mtoShipments[0].eTag);

  view.moveCode = response.moveCode;
  view.moveID = response.id;

  view.alertTitle = 'Move is now available to GHC Prime Contractor';
  view.alertType = 'success';
} else {
  view.alertTitle = 'Move is not available to GHC Prime Contractor';
  view.alertType = 'error';
}

// Setup the visualization template.
pm.visualizer.set(template, view);
