const fs        = require('fs'),
      path      = require('path'),
      Item      = require('postman-collection').Item,
      requestID = path.basename(__filename, '.js');

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
    helpful to get all the Moves available to the Prime.
    `,
  },
});
