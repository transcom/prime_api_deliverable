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
This request creates Destination SIT service items for a shipment. It needs the 
shimpent id to be stored in \`mtoShipmentID\` collection variable. That can be set
by running \`MoveTaskOrders by ID\` request first.
`;

// Get the contents of the events/prerequest.js file
const requestPreRequestScript = readScript(__dirname, '../events/prerequest.js');

// Get the contents of the events/test.js file
const requestTestScript = readScript(__dirname, '../events/test.js');

module.exports = createItem({
  name: 'Create DDFSIT & DDASIT',
  requestID: requestID,
  url: '{{baseUrl}}/mto-service-items',
  method: 'POST',
  headers: {
    'Postman-Request-ID': requestID,
    'Content-Type': 'application/json',
  },
  description: requestDescription,
  payload: JSON.stringify(payload, null, 2),
  prerequestScript: requestPreRequestScript,
  testScript: requestTestScript,
});
