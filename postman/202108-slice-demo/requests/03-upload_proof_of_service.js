var template = `

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GHC Contractor - Moves</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uswds/2.11.1/css/uswds.min.css" integrity="sha512-jTdlH2LXTQ/nSPgY0SoocLYibqnSu0B7/DM2cmA3jPrw89dbtZKeytKXDJPYlZpjkHfHUlTe/4MTGovdM73AJw==" crossorigin="anonymous" />
    <style>
    li {
        list-style-type: none !important;
    }
    .hide {
        display: none;
    }
    .show {
        display: block;
    }
    </style>
    <script>

</script>
</head>
<body>
<h2 class="site-preview-heading font-sans-2xl">GHC Contractor</h6>
<h3 class="site-component-section-title font-sans-xl">Move #{{response.moveCode}}</h3>

<div class="usa-alert usa-alert--info" id="alert" >
  <div class="usa-alert__body">
    <h4 id="alert-heading" class="usa-alert__heading margin-bottom-2">Document Uploaded</h4>
  </div>
</div>

<div class="customer-info">
Customer Name:</strong> {{response.customerName}}
    <table class="usa-table usa-table--borderless usa-table--striped">
  <caption>Payment Request</caption>
  <tbody>
   <tr>
            <th>ID</th>
            <th>No.</th>
            <th>Status</th>
            <th>Document</th>

        </tr>
    <tr>
      <td>{{response.paymentRequestId}}</td>
        <td>{{response.paymentRequestNumber}}</td>
        <td>{{response.paymentRequestStatus}}</td>
        <td>{{response.filename}}
    </tr>
  </tbody>
</table>
</div>



</body>
</html>
`
let responseJSON = pm.response.json();
let templateJSON;
if (pm.response.code == 201){
         templateJSON = {
        "mtoShipmentID": pm.collectionVariables.get("mtoShipmentID"),
        "moveTaskOrderID": pm.collectionVariables.get("moveTaskOrderID"),
        "customerName": pm.collectionVariables.get("customerName"),
        "moveCode": pm.collectionVariables.get("moveCode"),
        "filename": responseJSON.filename,
        "updatedAt": responseJSON.updatedAt,
        "contentType": responseJSON.contentType,
        "paymentRequestId": pm.collectionVariables.get("paymentRequestId"),
        "paymentRequestNumber": pm.collectionVariables.get("paymentRequestNumber"),
        "paymentRequestStatus": pm.collectionVariables.get("paymentRequestStatus")
    }
    console.log(templateJSON)
pm.visualizer.set(template, {
    response: templateJSON
})
}

