function envGet(v) {
  return pm.collectionVariables.get(v);
}

function envSet(k, v) {
  pm.collectionVariables.set(k, v);
}

const response = pm.response.json(),
  template = envGet('updateShipmentTemplate'),
  pmRequestID = pm.request.getHeaders()['Postman-Request-ID'],
  undefHTML = '<code>undefined</code>',
  requestIDsToAction = {
        'update-shipment-with-scheduled-pickup-date' : 'Schedules Pickup Date',
        'update-shipment-with-estimated-weight'      : 'Counsels Estimated Weight',
        'update-shipment-with-actual-pickup-date'    : 'Submits Actual Pickup Date',
        'update-shipment-with-actual-weight'         : 'Submits Actual Weight',
        'update-shipment-with-reweigh-weight'        : 'Submits Reweigh Weight',
      },
      requestIDsToAlertType = {
        'update-shipment-with-scheduled-pickup-date' : 'info',
        'update-shipment-with-estimated-weight'      : 'info',
        'update-shipment-with-actual-pickup-date'    : 'info',
        'update-shipment-with-actual-weight'         : 'info',
        'update-shipment-with-reweigh-weight'        : 'success',
      };

// Create a view object rather than using the Response object that comes from
// Postman so we can modify the presentation of things in JavaScript rather
// than Handlerbars. It's probably cleaner to do this in the Handlebar template
// in the future.
// TODO: Research moving a lot of this logic surrounding the View object in
// plain {{}} templating.
var view = {
  pageTitle           : 'GHC Contractor',
  pageHeading         : 'Updating a shipment',
  pageAction          : requestIDsToAction[pmRequestID],
  alertType           : requestIDsToAlertType[pmRequestID],
  customerFullName    : undefHTML,
  moveCode            : undefHTML,
  moveID              : undefHTML,
  scheduledPickupDate : undefHTML,
  actualPickupDate    : undefHTML,
  estimatedWeight     : undefHTML,
  actualWeight        : undefHTML,
  reweighWeight       : undefHTML,
  reweighStatus       : undefHTML,
  reweighRequestedBy  : undefHTML,
  reweighSuccess      : false,
};

var hasReweigh = false;

// If the response is OK, let's modify the View object.
if (pm.response.code === 200) {
  // These are coming from the previous requests.
  view.customerFullName = envGet('customerFullName');
  view.moveCode         = envGet('moveTaskOrderCode');
  view.moveID           = envGet('moveTaskOrderID');

  const baseUrl = envGet('baseUrl'),
        postRequest = {
          url: `${baseUrl}/move-task-orders/${view.moveID}`,
          method: 'GET',
        };

  // I don't like this, but we've got a bug that prevents the Prime from seeing
  // Reweigh information when updating a shipment's details. The Swagger files
  // says it returns the Reweigh object, but the actual response is missing it.
  // TODO: Make a Jira ticket about this.
  pm.sendRequest(postRequest, (error, mtoResponse) => {
    if (mtoResponse.code === 200) {

      // FIXME: This is a terribly hacky way to do this, but the secondary
      // request gets all the Shipments items and then we take the first one
      // (as we're only expecting 1) and then we take that Reweigh object and
      // put it in here so it's like the Prime API returns the Reweigh object
      // we're expecting.
      // TODO: This this to the Jira ticket, maybe.
      response.reweigh = mtoResponse.json().mtoShipments[0].reweigh;
      hasReweigh = (typeof response.reweigh === 'object');

      if (hasReweigh) {
        view.reweighStatus      = '🟢 A Reweigh has been requested.';
        view.reweighRequestedBy = `<code>${response.reweigh.requestedBy}</code>`;
        if (response.reweigh.weight) {
          view.reweighStatus  = '✅ A Reweigh has been set by the GHC Contractor.';
          view.reweighWeight  = response.reweigh.weight;
          view.reweighSuccess = true;
        }
      } else {
        view.reweighStatus = '🔴 A Reweigh has not been requested.';
      }

      // Attempt to set a bunch of variables or 'undefined'.
      view.primeActualWeight   = response.primeActualWeight;
      view.scheduledPickupDate = response.scheduledPickupDate;
      view.actualPickupDate    = response.actualPickupDate;
      view.estimatedWeight     = response.primeEstimatedWeight;
      view.actualWeight        = response.primeActualWeight;

      // These are being set for the next request to consume as a {{variable}}.
      envSet('shipmentETag', response.eTag);
      envSet('shipmentID', response.id);

      // README: To get past the limitation of Postman variables, we'll have to
      // log the JSON payload for the next request into the Console for
      // copying into the Body of the Create Payment Request.
      // We only need to do this on the last request.
      if (pmRequestID === 'update-shipment-with-reweigh-weight') {
        var serviceItemsIDs = [];
        mtoResponse.json().mtoServiceItems.forEach(function(item) {
          serviceItemsIDs.push({
            id: item.id,
          });
        });
        envSet('serviceItemsIDs', serviceItemsIDs);
        console.info('Create Payment Request Body payload', JSON.stringify({
          isFinal: false,
          moveTaskOrderID: envGet('moveTaskOrderID'),
          serviceItems: serviceItemsIDs,
        }));
      }

      if (hasReweigh) {
        envSet('reweighID', response.reweigh.id);
        envSet('reweighETag', response.reweigh.eTag);
      }

      pm.visualizer.set(template, view);

    }

  });
}
