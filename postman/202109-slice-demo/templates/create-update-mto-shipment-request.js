// utils
const { readScript, getRequestID } = require('../../utils/fileUtils'),
      createItem = require('../../utils/createItem');

module.exports = ({requestID, payload, name, description}) => {
  // Get the contents of the events/prerequest.js file
  const requestPreRequestScript = readScript(__dirname, '../events/prerequest.js');

  // Get the contents of the events/test.js file
  const requestTestScript = readScript(__dirname, '../events/test.js');

  return createItem({
    name: 'Update the actual weight on a shipment',
    requestID: requestID,
    url: '{{baseUrl}}/mto-shipments/{{mtoShipmentID}}',
    method: 'PATCH',
    headers: {
      'Postman-Request-ID': requestID,
      'Content-Type': 'application/json',
      'If-Match': '{{mtoShipmentETag}}',
    },
    description: description,
    payload: payload,
    prerequestScript: requestPreRequestScript,
    testScript: requestTestScript,
  });
}
