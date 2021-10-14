// Node JS libraries for working with the file system and file paths.
const fs   = require('fs'),
      path = require('path');

// Postman SDK functions required from the `postman-collection` library.
const { Item, Event, Script, RequestBody } = require('postman-collection');

/**
 * createItem builds a Postman Item object
 */
const createItem = ({
  name,
  requestID,
  url,
  method,
  headers,
  description,
  body = null,
  payload = null,
  prerequestScript = null,
  testScript = null,
}) => {
  // An Event is an item in the event Array and represents a script that runs
  // either in Pre-Script or Tests.
  // README: https://www.postmanlabs.com/postman-collection/Event.html
  const events = [];
  if (prerequestScript !== null) {
    const e = new Event({
      listen: 'prerequest',
      script: prerequestScript.toString(),
    });
    events.push(e);
  }
  if (testScript !== null) {
    const e = new Event({
      listen: 'test',
      script: testScript.toString(),
    });
    events.push(e);
  }

  let reqBody = new RequestBody({
    mode: 'raw',
    raw: payload,
  });
  if (body !== null) {
    reqBody = body;
  }

  return new Item({
    name: name,
    id: requestID,
    // A Request is a plain JS object and not a Postman SDK Request.
    request: {
      url,
      method,
      header: headers,
      description,
      body: reqBody,
    },
    event: events,
  });
}

module.exports = createItem
