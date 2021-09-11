const Collection  = require('postman-collection').Collection,
      Event       = require('postman-collection').Event,
      Item        = require('postman-collection').Item,
      Script      = require('postman-collection').Script,
      RequestBody = require('postman-collection').RequestBody;

const fs = require('fs'),
      path = require('path'),
      requestID = path.basename(__filename, '.js'),
      prepareUploadProofOfService = fs.readFileSync(
        path.resolve(
          __dirname,
          '../tests/prime-update/prepare-upload-proof-of-service.js'
        )
      ),
      uploadProofOfService = fs.readFileSync(
        path.resolve(
          __dirname,
          '../tests/prime-update/upload-proof-of-service.js'
        )
      );

module.exports = new Item({
  name: 'Upload Proof Of Service',
  id: requestID,
  request: {
    url: '{{baseUrl}}/payment-requests/:paymentRequestID/uploads',
    method: 'POST',
    header: {
      'Content-Type': 'application/json',
      'If-Match': ''
    },
    description: `
    This request updates the Move with an estimated weight. This may or may not
    trigger a reweigh. This uses the template called
    **prime-update/counsels-move.html**.
    `,
  },
  event: [
    new Event({
      listen: 'prerequest',
      script: new Script({
        exec: prepareUploadProofOfService.toString().split('\n'),
      }),
    }),
    new Event({
      listen: 'test',
      script: new Script({
        exec: uploadProofOfService.toString().split('\n'),
      }),
    })
  ],
});


