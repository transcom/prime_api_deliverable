const fs = require('fs'),
      path = require('path'),
      updateShipmentTemplate = fs.readFileSync(
        path.resolve(__dirname, './templates/index.tmpl')
      ),
      updateShipmentPayload = require('./payloads/update-shipment');

const DEMO_ENVIRONMENT_URL = 'https://api.demo.dp3.us';
const ACTUAL_WEIGHT = 5100;
const ESTIMATED_WEIGHT = 4800;

var environment = {
  baseUrl: {
    id: 'baseUrl',
    value: `${DEMO_ENVIRONMENT_URL}/prime/v1`,
    type: 'string',
  },
  supportUrl: {
    id: 'supportUrl',
    value: `${DEMO_ENVIRONMENT_URL}/support/v1`,
    type: 'string',
  },
  reweighID: {
    id: 'reweighID',
    value: '',
    type: 'string',
  },
  shipmentID: {
    id: 'shipmentID',
    value: '',
    type: 'string',
  },
  eTag: {
    id: 'eTag',
    value: '',
    type: 'string',
  },
  primeEstimatedWeight: {
    id: 'primeEstimatedWeight',
    value: ESTIMATED_WEIGHT,
    type: 'number',
  },
  primeActualWeight: {
    id: 'primeActualWeight',
    value: ACTUAL_WEIGHT,
    type: 'number',
  },
  updateShipmentTemplate: {
    id: 'updateShipmentTemplate',
    value: updateShipmentTemplate.toString(),
    type: 'string',
  },
  updateShipmentPayload: {
    id: 'updateShipmentPayload',
    value: updateShipmentPayload,
    type: 'object',
  },
};

module.exports = (function(){
  let environmentList =  [];
  for (const k in environment) {
      environmentList.push(environment[k])
  }
  return environmentList;
})();
