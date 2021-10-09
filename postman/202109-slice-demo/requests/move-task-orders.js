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

This endpoint gets an individual MoveTaskOrder by ID.

It will provide information about the Customer and any associated MTOShipments,
MTOServiceItems and PaymentRequests.

This Request uses the templates found in
**templates/visualize.html**.
`;

// Get the contents of the events/prerequest.js file
const requestPreRequestScript = readScript(__dirname, '../events/prerequest.js');

// Get the contents of the events/test.js file
const requestTestScript = readScript(__dirname, '../events/test.js');

module.exports = createItem({
  name: 'MoveTaskOrders by ID',
  requestID: requestID,
  url: '{{baseUrl}}/move-task-orders/{{moveTaskOrderID}}',
  method: 'GET',
  headers: {
    'Postman-Request-ID': requestID,
  },
  description: requestDescription,
  prerequestScript: requestPreRequestScript,
  testScript: requestTestScript,
});
