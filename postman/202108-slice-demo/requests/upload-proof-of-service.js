const Collection  = require('postman-collection').Collection,
      Event       = require('postman-collection').Event,
      Item        = require('postman-collection').Item,
      Script      = require('postman-collection').Script,
      RequestBody = require('postman-collection').RequestBody;

const fs = require('fs'),
      path = require('path'),
      requestID = path.basename(__filename, '.js'),
      uploadProofOfService = fs.readFileSync(
        path.resolve(
          __dirname,
          '../tests/prime-update/upload-proof-of-service.js'
        )
      );

module.exports = new Item({
  name: 'Upload proof of service for payment request',
  id: requestID,
  request: {
    url: '{{baseUrl}}/payment-requests/{{paymentRequestID}}/uploads',
    method: 'POST',
    header: {
      'Postman-Request-ID': requestID,
      'Content-Type': 'multipart/form-data; charset=utf-8; boundary=";"',
    },
    description: `
    This request updates the Move with an estimated weight. This may or may not
    trigger a reweigh. This uses the template called
    **prime-update/counsels-move.html**.
    `,
    body: new RequestBody({
      mode: 'formdata',
      formdata: [{
        key: 'file',
        description: 'The file to upload.',
        type: 'file',
        src: '/Users/rsr/Downloads/proof_of_service.pdf',
      }],
    }),
  },
  event: [
    new Event({
      listen: 'test',
      script: new Script({
        exec: uploadProofOfService.toString().split('\n'),
      }),
    })
  ],
});


