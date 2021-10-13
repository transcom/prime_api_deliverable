// payloads and utils
const payloads = require('../payloads'),
      { readScript, getRequestID } = require('../../utils/fileUtils'),
      createUpdateMTOShipmentRequest = require('../../utils/create-update-mto-shipment-request');

// The Request ID. This is made up and is only used because we need to pass an
// ID to Postman SDK.
const requestID = getRequestID(__filename);
const payload = payloads[requestID];

// The Request Description. This is used in the Postman.app to document what
// the Request does. It is displayed on the right-side of the UI.
const requestDescription = `
This Postman Request was created with the Postman SDK and not the Postman.app
UI.

This endpoint Updates the shipment.

This Request uses the templates found in
**templates/visualize.html**.
`;

// Get the contents of the events/test.js file
const requestTestScript = readScript(__dirname, '../events/test.js');

module.exports = createUpdateMTOShipmentRequest({
  name: 'Update the destination address on a shipment',
  requestId: requestID,
  description: requestDescription,
  payload: JSON.stringify(payload, null, 2),
  testScript: requestTestScript,
});
