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
This Postman Request was created with the Postman SDK and not the Postman.app
UI.

This endpoint creates a storage in transit (SIT) extension request for a
shipment. A SIT extension request is a request an increase in the shipment day
allowance for the number of days a shipment is allowed to be in SIT. The total
SIT day allowance includes time spent in both origin and destination SIT.

This Request uses the templates found in
**templates/visualize.html**.
`;

// Get the contents of the events/prerequest.js file
const requestPreRequestScript = readScript(__dirname, '../events/prerequest.js');

// Get the contents of the events/test.js file
const requestTestScript = readScript(__dirname, '../events/test.js');

module.exports = createItem({
  name: 'Create SIT Extension',
  requestID: requestID,
  url: '{{baseUrl}}/mto-shipments/{{mtoShipmentID}}/sit-extensions',
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
