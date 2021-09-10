const fs = require('fs'),
      path = require('path'),
      Collection = require('postman-collection').Collection,
      fileName = `${Date.now()}.${path.basename(__dirname + 'postman_collection')}`,
      savePath = path.join(process.cwd(), '/collections'),
      filePath = `${savePath}/${fileName}`,
      definition = require('./definition'),
      GetAllMoves = require('./requests/get-all-moves'),
      NotificationPrimeReceivesMove = require('./requests/notification-prime-receives-move'),
      UpdateShipmentWithCounseling = require('./requests/update-shipment-with-counseling');

var sliceDemoCollection = new Collection({
  ...definition,
  item: [
    GetAllMoves,
    NotificationPrimeReceivesMove,
    UpdateShipmentWithCounseling,
  ],
});

fs.writeFileSync(
  filePath,
  JSON.stringify(sliceDemoCollection, null, 2)
);

if (fs.existsSync(filePath)) {
  console.log(`💾 The Postman Collection has been saved at ${filePath}`);
}
