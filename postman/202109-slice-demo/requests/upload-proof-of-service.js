// utils
const { readScript, getRequestID } = require('../../utils/fileUtils'),
      { RequestBody, FormParam } = require('postman-collection'),
      createItem = require('../../utils/createItem');

// The Request ID. This is made up and is only used because we need to pass an
// ID to Postman SDK.
const requestID = getRequestID(__filename);

// The Request Description. This is used in the Postman.app to document what
// the Request does. It is displayed on the right-side of the UI.
const requestDescription = `
This request uploads a proof of service document.

It requries the \`paymentRequestID\` to be set in the collection, which  can be done
by running the \`Create Payment Request\` request.

This request also requires that you provide the file, open the \`Body\` tab under the url
and fill in the first row. For **key** set it to \`file\`. Hover over the key row and set 
the type to \`file\`. Finally click **Select file** in the **Value** column and pick the file
you wish to upload.
`;

// Get the contents of the events/prerequest.js file
const requestPreRequestScript = readScript(__dirname, '../events/prerequest.js');

// Get the contents of the events/test.js file
const requestTestScript = readScript(__dirname, '../events/test.js');

module.exports = createItem({
  name: 'Upload Proof Of Service',
  requestID: requestID,
  url: '{{baseUrl}}/payment-requests/{{paymentRequestID}}/uploads',
  method: 'POST',
  headers: {
    'Postman-Request-ID': requestID,
    'Content-Type': 'multipart/form-data; charset=utf-8; boundary=";"',
  },
  body: new RequestBody({
    mode: 'formdata',
    // This sets up form data but the file key and file must be edited in postman directly
    formdata: [{
      key: 'file',
      description: 'The file to upload.',
      type: 'file',
      value: '/Users/john/projects/dod/mymove/tmp/uploads/proof_of_service.pdf',
    }],
  }),
  description: requestDescription,
  prerequestScript: requestPreRequestScript,
  testScript: requestTestScript,
});
