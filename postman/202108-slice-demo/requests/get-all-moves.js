const fs = require('fs'),
      path = require('path'),
      requestID = path.basename(__filename, '.js'),
      Item = require('postman-collection').Item;

module.exports = new Item({
  name: 'Get all moves available to GHC Prime',
  id: requestID,
  request: {
    url: '{{baseUrl}}/moves',
    method: 'GET',
    header: {
      'Postman-Request-ID': requestID,
    },
    description: `
    This is a helper request that will not be used in the demo but may be
    helpful to the Prime to see all the Moves in the system available to the
    Prime.
    `,
  },
});
