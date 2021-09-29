console.info('I am inside example-get-move-task-orders/events/prerequest.js');
console.info('This file runs within the Postman.app JavaScript Runtime and not within Node JS.');
console.info('For more documentation on this, see this URL: https://learning.postman.com/docs/writing-scripts/script-references/postman-sandbox-api-reference/#using-external-libraries');

function envGet(v) {
  return pm.collectionVariables.get(v);
}

function envSet(k, v) {
  pm.collectionVariables.set(k, v);
}
