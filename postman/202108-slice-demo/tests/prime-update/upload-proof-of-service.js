function envGet(v) {
  return pm.collectionVariables.get(v);
}

function envSet(k, v) {
  pm.collectionVariables.set(k, v);
}

const response = pm.response.json(),
      template = envGet('paymentRequestTemplate'),
      undefHTML = '<code>undefined</code>';

// Create a view object rather than using the Response object that comes from
// Postman so we can modify the presentation of things in JavaScript rather
// than Handlerbars. It's probably cleaner to do this in the Handlebar template
// in the future.
// TODO: Research moving a lot of this logic surrounding the View object in
// plain {{}} templating.
var view = {
  pageTitle            : 'GHC Contractor',
  pageHeading          : 'Uploading a proof of service',
  pageAction           : 'Uploads PDF',
  alertType            : 'success',
  customerFullName     : undefHTML,
  moveCode             : undefHTML,
  moveID               : undefHTML,
  status               : undefHTML,
  paymentRequestNumber : undefHTML,
  fileName             : undefHTML,
  fileUploaded         : false,
  createdAt            : undefHTML,
  fileName             : undefHTML,
};

// If the response is CREATED, let's modify the View object.
if (pm.response.code === 201) {
  // These are coming from the previous requests.
  view.customerFullName = envGet('customerFullName');
  view.moveCode         = envGet('moveTaskOrderCode');
  view.moveID           = envGet('moveTaskOrderID');

  view.status               = `<code>${envGet('paymentRequestStatus')}</code>`;
  view.paymentRequestNumber = `<code>${envGet('paymentRequestNumber')}</code>`;

  view.fileUploaded = true;
  view.createdAt    = response.createdAt;
  view.fileName     = response.filename;

  // Setup the visualization template.
  pm.visualizer.set(template, view);
}
