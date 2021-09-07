const DEMO_ENVIRONMENT_URL = 'https://api.demo.dp3.us';

let baseUrl = {
  id: 'baseUrl',
  value: `${DEMO_ENVIRONMENT_URL}/prime/v1`,
  type: 'string',
};

let supportUrl = {
  id: 'supportUrl',
  value: `${DEMO_ENVIRONMENT_URL}/support/v1`,
  type: 'string',
};


module.exports = [
  baseUrl,
  supportUrl,
];
