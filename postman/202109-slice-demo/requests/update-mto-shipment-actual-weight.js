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
Updates the shipment identified by \`mtoShipmentID\` to update the actual weight
and actual pickup date.
`;

// Get the contents of the events/test.js file
const requestTestScript = readScript(__dirname, '../events/test.js');

module.exports = createUpdateMTOShipmentRequest({
  name: 'Update the actual weight on a shipment',
  requestID: requestID,
  description: requestDescription,
  payload: JSON.stringify(payload, null, 2).replace(/"{{/g, '{{').replace(/}}"/g, '}}'),
  testScript: requestTestScript,
});
