// Node JS libraries for working with the file system and file paths.
const fs   = require('fs'),
      path = require('path');

// Postman SDK functions required from the `postman-collection` library.
const Collection = require('postman-collection').Collection;

// Helpful variables for saving Collection JSON files to the disk. It leverages
// the name of the current directory and the current working directory of this
// script.
const fileName = path.basename(__dirname + '.postman_collection.json'),
      savePath = path.join(process.cwd(), '/collections'),
      filePath = `${savePath}/${fileName}`;

// The Collection Description. This is used in the Postman.app to document what
// the Collection does. It is displayed on the right-side of the UI.
let collectionDescription = `
# MB-9088 Testing Prime SIT Extension Submission

> Taken from MB-9298

##### User Statement

**Given** I'm the Prime
**When** I submit a SIT extension for a shipment on a move
**Then** I need the move status to change to \`approvals requested\`
**So** that I can be confident that the TOO will be made aware of my request

##### Acceptance Criteria

- When the prime creates an extension request, the move status is set to
  approvals requested
- Confirm in the TOO UI that the move shows up on the TOO move queue.

This Postman Collection was created with the Postman SDK and not the Postman.app UI.
`;

// Get the contents of the templates/visualize.html file
const visualizeTemplateFileName = path.resolve(__dirname, 'templates/visualize.html');
const visualizeTemplate = fs.readFileSync(visualizeTemplateFileName);

// This is a Collection in the Postman SDK.
// README: https://www.postmanlabs.com/postman-collection/Collection.html
let collection = new Collection({
  info: {
    name: "MB-9088 Testing Prime SIT Extension Submission",
    description: collectionDescription,
  },
  variable: [
    {
      id: "baseUrl",
      value: "https://primelocal:9443/prime/v1",
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
      id: "shipmentID",
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

// See the files in the ./requests folder to see what they export.
const movesRequest          = require('./requests/moves');
const moveTaskOrdersRequest = require('./requests/move-task-orders');
const createSITExtension    = require('./requests/mto-shipments-sit-extensions');

// Add a Request Item to the collection variable. This follows the
// documentation for what an Item is in Postman SDK.
// README: https://www.postmanlabs.com/postman-collection/Item.html
collection.items.add(movesRequest);
collection.items.add(moveTaskOrdersRequest);
collection.items.add(createSITExtension);

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

