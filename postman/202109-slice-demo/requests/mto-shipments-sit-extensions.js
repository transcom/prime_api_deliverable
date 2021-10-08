// Node JS libraries for working with the file system and file paths.
const fs   = require('fs'),
      path = require('path');

// Postman SDK functions required from the `postman-collection` library.
const Item        = require('postman-collection').Item,
      Event       = require('postman-collection').Event,
      Script      = require('postman-collection').Script,
      RequestBody = require('postman-collection').RequestBody;

// The Request ID. This is made up and is only used because we need to pass an
// ID to Postman SDK.
const requestID = path.basename(__filename, '.js');
const payload = require(`../payloads/${requestID}`);

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
const requestPreRequestScriptFilePath = path.resolve(__dirname, '../events/prerequest.js'),
      requestPreRequestScript = fs.readFileSync(requestPreRequestScriptFilePath);

// Get the contents of the events/test.js file
const requestTestScriptFilePath = path.resolve(__dirname, '../events/test.js'),
      requestTestScript = fs.readFileSync(requestTestScriptFilePath);

module.exports = new Item({
  name: 'Create SIT Extension',
  id: requestID,
  // A Request is a plain JS object and not a Postman SDK Request.
  request: {
    url: '{{baseUrl}}/mto-shipments/{{mtoShipmentID}}/sit-extensions',
    method: 'POST',
    header: {
      'Postman-Request-ID': requestID,
      'Content-Type': 'application/json',
    },
    description: requestDescription,
    body: new RequestBody({
      mode: 'raw',
      raw: JSON.stringify(payload, null, 2),
    }),
  },
  // An Event is an item in the event Array and represents a script that runs
  // either in Pre-Script or Tests.
  // README: https://www.postmanlabs.com/postman-collection/Event.html
  event: [
    new Event({
      listen: 'prerequest',
      script: requestPreRequestScript.toString(),
    }),
    new Event({
      listen: 'test',
      script: requestTestScript.toString(),
    }),
  ],
});
