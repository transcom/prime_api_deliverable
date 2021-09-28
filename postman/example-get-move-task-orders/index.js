// Node JS libraries for working with the file system and file paths.
const fs   = require('fs'),
      path = require('path');

// Postman SDK functions required from the `postman-collection` library.
const Collection = require('postman-collection').Collection,
      Item       = require('postman-collection').Item,
      Event      = require('postman-collection').Event,
      Script     = require('postman-collection').Script;

// Helpful variables for saving Collection JSON files to the disk. It leverages
// the name of the current directory and the current working directory of this
// script.
const fileName = path.basename(__dirname + '.postman_collection.json'),
      savePath = path.join(process.cwd(), '/collections'),
      filePath = `${savePath}/${fileName}`;

// The Collection Description. This is used in the Postman.app to document what
// the Collection does. It is displayed on the right-side of the UI.
let collectionDescription = `
# Get Move Task Orders

This Postman Collection was created with the Postman SDK and not the Postman.app UI.
`;

// Get the contents of the templates/visualize.html file
const visualizeTemplateFileName = path.resolve(__dirname, 'templates/visualize.html');
const visualizeTemplate = fs.readFileSync(visualizeTemplateFileName);

// This is a Collection in the Postman SDK.
// README: https://www.postmanlabs.com/postman-collection/Collection.html
let collection = new Collection({
  info: {
    name: "Get Move Task Orders",
    description: collectionDescription,
  },
  variable: [
    {
      id: "baseUrl",
      value: "https://api.stg.move.mil/prime/v1",
      type: "string",
    },
    {
      id: "customerFullName",
      value: "",
      type: "string",
    },
    {
      id: "moveTaskOrderID",
      value: "",
      type: "string",
    },
    {
      id: "moveTaskOrderCode",
      value: "",
      type: "string",
    },
    {
      id: "moveTaskOrderETag",
      value: "",
      type: "string",
    },
    {
      id: 'visualizeTemplate',
      value: visualizeTemplate.toString(),
      type: 'string',
    },
  ],
});

// The Request ID. This is made up and is only used because we need to pass an ID to Postman SDK.
const requestID = 'get-move-task-orders-by-id';

// The Request Description. This is used in the Postman.app to document what
// the Request does. It is displayed on the right-side of the UI.
const requestDescription = `
This Postman Request was created with the Postman SDK and not the Postman.app
UI.

This request can be used to show that the Prime cannot access a Move until it
is made available to the Prime.

This request must be run before the Move is available to the Prime otherwise
there will never be a 404 response for the template to show the error message.

This request can also be used to show that the Prime has access to a Move given
a Move Code or a MoveID and will show a success notification.

This Request uses the templates found in
**templates/prime-notification/receive-move.html**.
`;

// Get the contents of the events/prerequest.js file
const requestPreRequestScriptFilePath = path.resolve(__dirname, 'events/prerequest.js'),
      requestPreRequestScript = fs.readFileSync(requestPreRequestScriptFilePath);

// Get the contents of the events/test.js file
const requestTestScriptFilePath = path.resolve(__dirname, 'events/test.js'),
      requestTestScript = fs.readFileSync(requestTestScriptFilePath);

// Add a Request Item to the collection variable. This follows the
// documentation for what an Item is in Postman SDK.
// README: https://www.postmanlabs.com/postman-collection/Item.html
collection.items.add(
  new Item({
    name: 'Get MoveTaskOrders by ID',
    id: requestID,
    // A Request is a plain JS object and not a Postman SDK Request.
    request: {
      url: '{{baseUrl}}/move-task-orders/{{moveTaskOrderID}}',
      method: 'GET',
      header: {
        'Postman-Request-ID': requestID,
      },
      description: requestDescription,
    },
    // An Event is an item in the event Array and represents a script that runs
    // either in Pre-Script or Tests.
    event: [
      new Event({
        listen: 'prerequest',
        script: requestPreRequestScript.toString(),
      }),
      new Event({
        listen: 'test',
        script: requestTestScript.toString(),
      }),
    ],
  }),
);

// Write the file synchronously to the disk.
fs.writeFileSync(
  filePath,
  JSON.stringify(collection, null, 2)
);

// If the file was saved properly, log a message to the screen about where the
// file can be found.
if (fs.existsSync(filePath)) {
  console.log(`💾 The Postman Collection has been saved at ${filePath}`);
}

