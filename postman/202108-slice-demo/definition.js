let environments = require('./environment');

let description = `
This is a collection that represents the Prime's flow for the August 2021 Slice
Demo. The following Prime Requests are performed in this collection.

- Postman Request 1: Prime gets notified a move has been created
- Postman Request 2: Prime updates shipment with additional move details
- Postman Request 3: Prime performs a reweigh
- Postman Request 4: Prime creates payment request to get paid
- Postman Request 5: Prime uploads proof of serivce documents
`;

let definition = {
  info: {
    name: "2021-08 Prime API Slice Demo",
    description: description,
    schema: "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
  },
  variable: environments,
};

module.exports = definition;