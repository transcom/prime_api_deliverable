const fs = require('fs'),
      path = require('path'),
      Item = require('postman-collection').Item;

module.exports = new Item({
  name: "Get all Moves",
  id: "get-all-moves",
  request: {
    url: "{{baseUrl}}/moves",
    method: "GET",
    description: `
    This is a helper request that will not be used in the demo but may be
    helpful to the Prime to see all the Moves in the system available to the
    Prime.
    `,
  },
});