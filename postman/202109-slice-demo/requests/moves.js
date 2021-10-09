// utils
const { readScript, getRequestID } = require('../../utils/fileUtils'),
      createItem = require('../../utils/createItem');

// The Request ID. This is made up and is only used because we need to pass an
// ID to Postman SDK.
const requestID = getRequestID(__filename);

// The Request Description. This is used in the Postman.app to document what
// the Request does. It is displayed on the right-side of the UI.
const requestDescription = `
This Postman Request was created with the Postman SDK and not the Postman.app
UI.

Gets all moves that have been reviewed and approved by the TOO. The \`since\`
parameter can be used to filter this list down to only the moves that have been
updated since the provided timestamp. A move will be considered updated if the
\`updatedAt\` timestamp on the move or on its orders, shipments, service items,
or payment requests, is later than the provided date and time.

This Request uses the templates found in
**templates/visualize.html**.
`;

// Get the contents of the events/prerequest.js file
const requestPreRequestScript = readScript(__dirname, '../events/prerequest.js');

// Get the contents of the events/test.js file
const requestTestScript = readScript(__dirname, '../events/test.js');

module.exports = createItem({
  name: 'List All Moves',
  requestID: requestID,
  url: '{{baseUrl}}/moves',
  method: 'GET',
  headers: {
    'Postman-Request-ID': requestID,
  },
  description: requestDescription,
  prerequestScript: requestPreRequestScript,
  testScript: requestTestScript,
});
