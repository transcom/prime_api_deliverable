const fs = require('fs'),
      path = require('path'),
      paymentRequestTemplate = fs.readFileSync(
        path.resolve(
          __dirname,
          './templates/prime-update/payment-request.html'
        )
      ),
      primeNotificationTemplate = fs.readFileSync(
        path.resolve(
          __dirname,
          './templates/prime-notification/receive-move.html'
        )
      ),
      updateShipmentTemplate = fs.readFileSync(
        path.resolve(
          __dirname,
          './templates/prime-update/counsels-move.html'
        )
      ),
      api_url = 'https://api.stg.move.mil',
      environment = {
        baseUrl: {
          id: 'baseUrl',
          value: `${api_url}/prime/v1`,
          type: 'string',
        },
        supportUrl: {
          id: 'supportUrl',
          value: `${api_url}/support/v1`,
          type: 'string',
        },
        paymentRequestID: {
          id: 'paymentRequestID',
          value: '',
          type: 'string',
        },
        serviceItemsIDs: {
          id: 'serviceItemsIDs',
          value: [],
          type: 'array'
        },
        moveTaskOrderID: {
          id: 'moveTaskOrderID',
          value: '',
          type: 'string',
        },
        moveTaskOrderETag: {
          id: 'moveTaskOrderETag',
          value: '',
          type: 'string',
        },
        reweighID: {
          id: 'reweighID',
          value: '',
          type: 'string',
        },
        reweighETag: {
          id: 'reweighETag',
          value: '',
          type: 'string',
        },
        shipmentID: {
          id: 'shipmentID',
          value: '',
          type: 'string',
        },
        shipmentETag: {
          id: 'shipmentETag',
          value: '',
          type: 'string',
        },
        paymentRequestTemplate: {
          id: 'paymentRequestTemplate',
          value: paymentRequestTemplate.toString(),
          type: 'string',
        },
        primeNotificationTemplate: {
          id: 'primeNotificationTemplate',
          value: primeNotificationTemplate.toString(),
          type: 'string',
        },
        updateShipmentTemplate: {
          id: 'updateShipmentTemplate',
          value: updateShipmentTemplate.toString(),
          type: 'string',
        },
      };

module.exports = (function(){
  let environmentList =  [];
  for (const k in environment) {
      environmentList.push(environment[k])
  }
  return environmentList;
})();
