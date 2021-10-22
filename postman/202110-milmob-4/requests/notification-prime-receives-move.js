const Collection  = require('postman-collection').Collection,
      Event       = require('postman-collection').Event,
      Item        = require('postman-collection').Item,
      Script      = require('postman-collection').Script;

const fs = require('fs'),
      path = require('path'),
      requestID = path.basename(__filename, '.js'),
      primeNotificationReceiveMoveScript = fs.readFileSync(
        path.resolve(
          __dirname,
          '../tests/prime-notification/receive-move.js'
        )
      );


module.exports = new Item({
  name: 'Receives notification for new shipment for move',
  id: requestID,
  request: {
    url: '{{baseUrl}}/move-task-orders/{{moveTaskOrderCode}}',
    method: 'GET',
    header: {
      'Postman-Request-ID': requestID,
    },
    description: `
    This request can be used to show that the Prime cannot access a Move until
    it is made available to the Prime.

    This request must be run before the Move is available to the Prime
    otherwise there will never be a 404 response for the template to show the
    error message.

    This request can also be used to show that the Prime has access to a Move
    given a Move Code or a MoveID and will show a success notification.

    This Request uses the templates found in
    **templates/prime-notification/receive-move.html**.
    `,
  },
  event: [
    new Event({
      listen: 'test',
      script: new Script({
        exec: primeNotificationReceiveMoveScript.toString().split('\n'),
      }),
    })
  ],
});
