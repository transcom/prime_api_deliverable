const fs = require('fs'),
      path = require('path'),
      Collection = require('postman-collection').Collection,
      fileName = path.basename(__dirname + '.postman_collection.json'),
      savePath = path.join(process.cwd(), '/collections'),
      filePath = `${savePath}/${fileName}`,
      definition = require('./definition'),
      NotificationPrimeReceivesMove         = require('./requests/notification-prime-receives-move'),
      UpdateShipmentWithScheduledPickupDate = require('./requests/update-shipment-with-scheduled-pickup-date'),
      UpdateShipmentWithEstimatedWeight     = require('./requests/update-shipment-with-estimated-weight'),
      UpdateShipmentWithActualPickupDate    = require('./requests/update-shipment-with-actual-pickup-date'),
      UpdateShipmentWithActualWeight        = require('./requests/update-shipment-with-actual-weight'),
      UpdateShipmentWithReweighWeight       = require('./requests/update-shipment-with-reweigh-weight'),
      CreatePaymentRequest                  = require('./requests/create-payment-request'),
      UploadProofOfServiceDocument          = require('./requests/upload-proof-of-service');

var sliceDemoCollection = new Collection({
  ...definition,
  item: [
    NotificationPrimeReceivesMove,
    UpdateShipmentWithScheduledPickupDate,
    UpdateShipmentWithEstimatedWeight,
    UpdateShipmentWithActualPickupDate,
    UpdateShipmentWithActualWeight,
    UpdateShipmentWithReweighWeight,
    CreatePaymentRequest,
    UploadProofOfServiceDocument,
  ],
});

fs.writeFileSync(
  filePath,
  JSON.stringify(sliceDemoCollection, null, 2)
);

if (fs.existsSync(filePath)) {
  console.log(`💾 The Postman Collection has been saved at ${filePath}`);
}
