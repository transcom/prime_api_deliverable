// utils
const createItem = require('./createItem');

module.exports = ({
  requestID,
  payload,
  name,
  description,
  prerequestScript = null,
  testScript = null,
}) => {
  return createItem({
    name,
    requestID,
    description,
    payload,
    url: '{{baseUrl}}/mto-shipments/{{mtoShipmentID}}',
    method: 'PATCH',
    headers: {
      'Postman-Request-ID': requestID,
      'Content-Type': 'application/json',
      'If-Match': '{{mtoShipmentETag}}',
    },
    prerequestScript,
    testScript,
  });
}
