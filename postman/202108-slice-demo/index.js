let fs = require('fs'),
    path = require('path'),
    definition = require('./definition'),
    Collection = require('postman-collection').Collection,
    fileName = path.basename(`${__dirname}.postman_collection`),
    savePath = path.join(process.cwd(), '/collections');

const filePath = `${savePath}/${fileName}`;

var sliceDemoCollection;

sliceDemoCollection = new Collection(definition);

fs.writeFileSync(
  filePath,
  JSON.stringify(sliceDemoCollection, null, 2)
);

if (fs.existsSync(filePath)) {
  console.log(`💾 The Postman Collection has been saved at ${filePath}`);
}
