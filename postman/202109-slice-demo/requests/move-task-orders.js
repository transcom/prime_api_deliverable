// utils
const { readScript, getRequestID } = require('../../utils/fileUtils'),
      createItem = require('../../utils/createItem');

// The Request ID. This is made up and is only used because we need to pass an
// ID to Postman SDK.
const requestID = getRequestID(__filename);

// The Request Description. This is used in the Postman.app to document what
// the Request does. It is displayed on the right-side of the UI.
const requestDescription = `
This retrieves a specific move using \`moveTaskOrderID\` collection variable. The
end point that is ues supports mto id or move code so either will work in this one variable.

This request will fill in all the other variables related to the move including etags.

The visualization for this request will also show if a reweigh has been requested.

This request will generate a payment request payload and save it in \`paymentRequestPayload\`
for use by the \`Create Payment Request\` request. The payment request payload will only contain
service items with codes listed in \`serviceItemsToInvoice\` and for the first shipment in the
move data response.
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
