const Collection  = require('postman-collection').Collection,
      Event       = require('postman-collection').Event,
      Item        = require('postman-collection').Item,
      Script      = require('postman-collection').Script,
      RequestBody = require('postman-collection').RequestBody;

const fs = require('fs'),
      path = require('path'),
      requestID = path.basename(__filename, '.js'),
      payload = require(`../payloads/${requestID}`),
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
  name: 'Update Shipment With Estimated Weight',
  id: requestID,
  request: {
    url: '{{baseUrl}}/move-task-orders/:shipmentID',
    method: 'PATCH',
    header: {
      'Content-Type': 'application/json',
      'If-Match': ''
    },
    description: `
    This request updates the Move with an estimated weight. This may or may not
    trigger a reweigh. This uses the template called
    **prime-update/counsels-move.html**.
    `,
    body: new RequestBody({
      mode: 'raw',
      raw: JSON.stringify(payload),
    }),
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
