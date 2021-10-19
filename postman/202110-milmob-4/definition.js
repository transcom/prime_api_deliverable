const currentTime = require('../utils/currentTime');
let environments = require('./environment');

let description = `
This is a collection that represents the Prime's flow for the October Milmob 4
Demo. The following Prime Requests are performed in this collection.

- Request: Update shipment with a Reweigh
  - Postman Request 1: Prime gets notified a move has been created
  - Postman Request 2: Prime updates shipment with additional move details
  - Postman Request 3: Prime performs a reweigh
- Request: Prime gets notified that TOO approved move
  - Postman Request 4: Prime creates payment request to get paid
- Request: Prime submits a Proof of Service for Payment
  - Postman Request 5: Prime uploads proof of service documents
`;

let definition = {
  info: {
    name: '2021 October Milmob 4',
    description: description,
    schema: "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
  },
  variable: environments,
};

module.exports = definition;
