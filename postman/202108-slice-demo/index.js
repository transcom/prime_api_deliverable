const fs = require('fs'),
      path = require('path'),
      Collection = require('postman-collection').Collection,
      Event = require('postman-collection').Event,
      Item = require('postman-collection').Item,
      Script = require('postman-collection').Script,
      fileName = path.basename(`${__dirname}.postman_collection`),
      savePath = path.join(process.cwd(), '/collections'),
      filePath = `${savePath}/${fileName}`,
      requestScript = fs.readFileSync(path.resolve(__dirname, './requests/01-update_reweigh.js'));

var sliceDemoCollection;
var definition = require('./definition');

sliceDemoCollection = new Collection({
  ...definition,
  item: [
    new Item({
      name: "Update Shipment with a Reweigh",
      id: "update-shipment-with-a-reweigh",
      request: {
        url: "{{baseUrl}}/move-task-orders/:shipmentID",
        method: "GET",
      },
      event: [
        new Event({
          listen: 'test',
          script: new Script({
            exec: requestScript.toString().split('\n'),
          }),
        })
      ],
    }),
  ],
});

fs.writeFileSync(
  filePath,
  JSON.stringify(sliceDemoCollection, null, 2)
);

if (fs.existsSync(filePath)) {
  console.log(`💾 The Postman Collection has been saved at ${filePath}`);
}
