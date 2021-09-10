const fs = require('fs'),
      path = require('path'),
      Collection = require('postman-collection').Collection,
      Event = require('postman-collection').Event,
      Item = require('postman-collection').Item,
      Script = require('postman-collection').Script,
      primeNotificationReceiveMoveScript = fs.readFileSync(
        path.resolve(
          __dirname,
          '../tests/prime-notification/receive-move.js'
        )
      );


module.exports = new Item({
  name: 'Notification: Prime receives new Move.',
  id: 'notification-prime-receives-move',
  request: {
    url: '{{baseUrl}}/move-task-orders/:shipmentID',
    method: 'GET',
    description: `
    This request is to show the Prime cannot access a Move until it is made
    available to the Prime. This request must be run before the Move is
    available to the Prime otherwise there will never be a sucessful 404
    state for the template to show the error message. This request can also
    be used to show that the Prime has access to a Move given a Move Code
    or a MoveID.
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
