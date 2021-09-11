const requestIDsToETag = {
  'update-shipment-with-scheduled-pickup-date': 'shipmentETag',
  'update-shipment-with-estimated-weight': 'shipmentETag',
  'update-shipment-with-actual-pickup-date': 'shipmentETag',
  'update-shipment-with-actual-weight': 'shipmentETag',
  'update-shipment-with-reweigh-weight': 'reweighETag',
}

function envGet(v) {
  return pm.collectionVariables.get(v);
}

function envSet(k, v) {
  pm.collectionVariables.set(k, v);
}

pm.request.headers.add({
  key: 'If-Match',
  value: envGet(requestIDsToETag[pm.info.requestId]),
});
