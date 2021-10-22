const Collection  = require('postman-collection').Collection,
      Event       = require('postman-collection').Event,
      Item        = require('postman-collection').Item,
      Script      = require('postman-collection').Script,
      RequestBody = require('postman-collection').RequestBody;

const fs = require('fs'),
      path = require('path'),
      requestID = path.basename(__filename, '.js'),
      createPaymentRequest = fs.readFileSync(
        path.resolve(
          __dirname,
          '../tests/prime-update/create-payment-request.js'
        )
      );

module.exports = new Item({
  name: 'Create payment request for move',
  id: requestID,
  request: {
    url: '{{baseUrl}}/payment-requests',
    method: 'POST',
    header: {
      'Postman-Request-ID': requestID,
      'Content-Type': 'application/json',
    },
    description: `
    This requests creates a Payment Request for a Move. This uses the
    template called **prime-update/submits-payment-request.html**.
    `,
    body: '{{paymentRequestPayload}}'
  },
  event: [
    new Event({
      listen: 'test',
      script: new Script({
        exec: createPaymentRequest.toString().split('\n'),
      }),
    })
  ],
});

