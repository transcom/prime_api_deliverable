// payloads and utils
const payloads = require('../payloads'),
      { readScript, getRequestID } = require('../../utils/fileUtils'),
      createItem = require('../../utils/createItem');

// The Request ID. This is made up and is only used because we need to pass an
// ID to Postman SDK.
const requestID = getRequestID(__filename);
const payload = payloads[requestID];

// The Request Description. This is used in the Postman.app to document what
// the Request does. It is displayed on the right-side of the UI.
const requestDescription = `
This request will send a payload to the reweigh endpoint. It requires mtoShipmentID,
reweighETag, and reweighID to be set. These can be set by running the \`MoveTaskOrders by ID\`
request.
`;

// Get the contents of the events/prerequest.js file
const requestPreRequestScript = readScript(__dirname, '../events/prerequest.js');

// Get the contents of the events/test.js file
const requestTestScript = readScript(__dirname, '../events/test.js');

module.exports = createItem({
  name: 'Update the reweigh weight on a shipment',
  requestID: requestID,
  url: '{{baseUrl}}/mto-shipments/{{mtoShipmentID}}/reweighs/{{reweighID}}',
  method: 'PATCH',
  headers: {
    'Postman-Request-ID': requestID,
    'Content-Type': 'application/json',
    'If-Match': '{{reweighETag}}',
  },
  description: requestDescription,
  payload: JSON.stringify(payload, null, 2),
  prerequestScript: requestPreRequestScript,
  testScript: requestTestScript,
});
