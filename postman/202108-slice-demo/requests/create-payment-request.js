const Collection  = require('postman-collection').Collection,
      Event       = require('postman-collection').Event,
      Item        = require('postman-collection').Item,
      Script      = require('postman-collection').Script,
      RequestBody = require('postman-collection').RequestBody;

const fs = require('fs'),
      path = require('path'),
      requestID = path.basename(__filename, '.js'),
      preparePrimeCounselsMove = fs.readFileSync(
        path.resolve(
          __dirname,
          '../tests/prime-update/prepare-counsels-move.js'
        )
      ),
      primeCounselsMove = fs.readFileSync(
        path.resolve(
          __dirname,
          '../tests/prime-update/counsels-move.js'
        )
      );

module.exports = new Item({
  name: 'Create Payment Request',
  id: requestID,
  request: {
    url: '{{baseUrl}}/payment-requests',
    method: 'POST',
    header: {
      'Content-Type': 'application/json',
      'If-Match': '',
    },
    description: `
    This requests creates a Payment Request for a Move. This uses the
    template called **prime-update/submits-payment-request.html**.
    `,
  },
  event: [
    new Event({
      listen: 'prerequest',
      script: new Script({
        exec: preparePrimeCounselsMove.toString().split('\n'),
      }),
    }),
    new Event({
      listen: 'test',
      script: new Script({
        exec: primeCounselsMove.toString().split('\n'),
      }),
    })
  ],
});

