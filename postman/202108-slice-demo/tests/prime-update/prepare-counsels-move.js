function envGet(v) {
  return pm.collectionVariables.get(v);
}

function envSet(k, v) {
  pm.collectionVariables.set(k, v);
}

pm.request.headers.add({
  key: 'If-Match',
  value: envGet('shipmentETag'),
});
