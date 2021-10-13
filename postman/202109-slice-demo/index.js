// Node JS libraries for working with the file system and file paths.
const fs      = require('fs'),
      path    = require('path')
      addDays = require('../utils/addDays');

// Postman SDK functions required from the `postman-collection` library.
const { Collection } = require('postman-collection');

// Helpful variables for saving Collection JSON files to the disk. It leverages
// the name of the current directory and the current working directory of this
// script.
const fileName = path.basename(__dirname + '.postman_collection.json'),
      savePath = path.join(process.cwd(), '/collections'),
      filePath = `${savePath}/${fileName}`;

// The Collection Description. This is used in the Postman.app to document what
// the Collection does. It is displayed on the right-side of the UI.
let collectionDescription = `
# September 2021 Slice Demo

See the link to the slice demo script

This Postman Collection was created with the Postman SDK and not the Postman.app UI.
`;

// Get the contents of the templates/visualize.html file
const visualizeTemplateFileName = path.resolve(__dirname, 'templates/visualize.html');
const visualizeTemplate = fs.readFileSync(visualizeTemplateFileName);

// This is a Collection in the Postman SDK.
// README: https://www.postmanlabs.com/postman-collection/Collection.html
let collection = new Collection({
  info: {
    name: "September 2021 Slice Demo",
    description: collectionDescription,
  },
  variable: [
    {
      id: "baseUrl",
      value: "https://primelocal:9443/prime/v1",
      type: "string",
    },
    {
      id: "serviceItemsToInvoice",
      value: "DLH,FSC",
      type: "string",
    },
    {
      id: "moveTaskOrderID",
      value: "RDY4PY",
      type: "string",
    },
    {
      id: "moveTaskOrderCode",
      value: "RDY4PY",
      type: "string",
    },
    {
      id: "sitDate",
      value: addDays(-30),
      type: "string",
    },
    {
      id: "primeEstimatedWeight",
      value: 13000,
      type: "int",
    },
    {
      id: "primeActualWeight",
      value: 13128,
      type: "int",
    },
    {
      id: "customerFullName",
      value: "",
      type: "string",
    },
    {
      id: "mtoShipmentID",
      value: "",
      type: "string",
    },
    {
      id: "mtoShipmentETag",
      value: "",
      type: "string",
    },
    {
      id: "reweighID",
      value: "",
      type: "string",
    },
    {
      id: "reweighETag",
      value: "",
      type: "string",
    },
    {
      id: "moveTaskOrderETag",
      value: "",
      type: "string",
    },
    {
      id: "paymentRequestPayload",
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
const createSITServiceItems = require('./requests/create-sit-mto-service-items');
const createSITExtension    = require('./requests/mto-shipments-sit-extensions');
const updateMTOShipmentSch  = require('./requests/update-mto-shipment-scheduled-date');
const updateMTOShipmentEst  = require('./requests/update-mto-shipment-estimated-weight');
const updateMTOShipmentAct  = require('./requests/update-mto-shipment-actual-weight');
const updateMTOShipmentDst  = require('./requests/update-mto-shipment-destination-address');
const paymentRequest        = require('./requests/create-payment-request');
const addReweighWeight      = require('./requests/add-reweigh-weight');

// Add a Request Item to the collection variable. This follows the
// documentation for what an Item is in Postman SDK.
// README: https://www.postmanlabs.com/postman-collection/Item.html
collection.items.add(movesRequest);
collection.items.add(moveTaskOrdersRequest);
collection.items.add(createSITServiceItems);
collection.items.add(createSITExtension);
collection.items.add(updateMTOShipmentSch);
collection.items.add(updateMTOShipmentEst);
collection.items.add(updateMTOShipmentAct);
collection.items.add(updateMTOShipmentDst);
collection.items.add(paymentRequest);
collection.items.add(addReweighWeight);

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
