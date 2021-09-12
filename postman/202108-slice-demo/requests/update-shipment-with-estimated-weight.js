const Collection  = require('postman-collection').Collection,
      Event       = require('postman-collection').Event,
      Item        = require('postman-collection').Item,
      Script      = require('postman-collection').Script,
      RequestBody = require('postman-collection').RequestBody;

const fs = require('fs'),
      path = require('path'),
      requestID = path.basename(__filename, '.js'),
      payload = require(`../payloads/${requestID}`),
      primeCounselsMove = fs.readFileSync(
        path.resolve(
          __dirname,
          '../tests/prime-update/counsels-move.js'
        )
      );

module.exports = new Item({
  name: 'Update shipment with estimated weight',
  id: requestID,
  request: {
    url: '{{baseUrl}}/mto-shipments/{{shipmentID}}',
    method: 'PATCH',
    header: {
      'Postman-Request-ID': requestID,
      'Content-Type': 'application/json',
      'If-Match': '{{shipmentETag}}',
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
      listen: 'test',
      script: new Script({
        exec: primeCounselsMove.toString().split('\n'),
      }),
    })
  ],
});

