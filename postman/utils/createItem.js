// Node JS libraries for working with the file system and file paths.
const fs   = require('fs'),
      path = require('path');

// Postman SDK functions required from the `postman-collection` library.
const Item        = require('postman-collection').Item,
      Event       = require('postman-collection').Event,
      Script      = require('postman-collection').Script,
      RequestBody = require('postman-collection').RequestBody;

/**
 * createItem builds a Postman Item object
 *
 * params
 */
const createItem = ({
  name,
  requestID,
  url,
  method,
  headers,
  description,
  payload,
  prerequestScript,
  testScript,
}) => {
  return new Item({
    name: name,
    id: requestID,
    // A Request is a plain JS object and not a Postman SDK Request.
    request: {
      url: url,
      method: method,
      header: headers,
      description: description,
      body: new RequestBody({
        mode: 'raw',
        raw: payload,
      }),
    },
    // An Event is an item in the event Array and represents a script that runs
    // either in Pre-Script or Tests.
    // README: https://www.postmanlabs.com/postman-collection/Event.html
    event: [
      new Event({
        listen: 'prerequest',
        script: prerequestScript.toString(),
      }),
      new Event({
        listen: 'test',
        script: testScript.toString(),
      }),
    ],
  });
}

module.exports = createItem
