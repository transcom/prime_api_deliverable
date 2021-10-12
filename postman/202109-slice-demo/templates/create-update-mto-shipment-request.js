// utils
const { readScript, getRequestID } = require('../../utils/fileUtils'),
      createItem = require('../../utils/createItem');

module.exports = ({requestID, payload, name, description}) => {
  // Get the contents of the events/prerequest.js file
  const requestPreRequestScript = readScript(__dirname, '../events/prerequest.js');

  // Get the contents of the events/test.js file
  const requestTestScript = readScript(__dirname, '../events/test.js');

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
    prerequestScript: requestPreRequestScript,
    testScript: requestTestScript,
  });
}
