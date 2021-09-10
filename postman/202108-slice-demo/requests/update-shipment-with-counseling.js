const fs = require('fs'),
      path = require('path'),
      Collection = require('postman-collection').Collection,
      Event = require('postman-collection').Event,
      Item = require('postman-collection').Item,
      Script = require('postman-collection').Script,
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
  name: 'Update: Prime updates Move with counseling information',
  id: 'update-shipment-with-counseling',
  request: {
    url: '{{baseUrl}}/move-task-orders/:shipmentID',
    method: 'PATCH',
    description: `
    This request is used to update the Move with a _destination address_
    and _pickup dates_ that are _scheduled_ and _actual_ dates. This update
    is a two-part process as the Prime is going to be doing a physical move
    between updating the _scheduled_ pickup date and then the _actual_
    pickup date. Since this is a two-part request, the Visualize tab will
    contain a button to perform the secondary request rather than including a
    different Request.
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

