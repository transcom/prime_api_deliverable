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
  <h3 class="site-component-section-title font-sans-xl">Moves</h3>

  <div class="usa-alert usa-alert--warning" id="alert" >
    <div class="usa-alert__body">
      <h4 id="alert-heading" class="usa-alert__heading margin-bottom-4">Shipments Approved</h4>
      <ul class="usa-content-list font-mono-md">
        <li><strong>Customer Name:</strong> {{response.order.customer.firstName}} {{response.order.customer.lastName}} </li>
        <li><strong>Move ID:</strong> {{response.id}}</li>
      </ul>
    </div>
  </div>

</body>
</html>
`
const responseJSON = pm.response.json();

if (pm.response.code == 200) {
  pm.visualizer.set(template, {
    response: responseJSON
  })
  // Set variable to update a shipment -- might not need these
  console.log(responseJSON.mtoShipments)
  let shipment = responseJSON.mtoShipments.find(ship => ship.primeActualWeight > 0)
  let shipmentID = shipment.id
  pm.environment.set("mtoShipmentID", shipmentID)
  pm.environment.set("mtoShipmentETag", shipment.eTag)
  console.log("SHIPMENT ID")
  console.log(shipmentID)
    console.log("SERVICE ITEMS::::::")
  responseJSON.mtoServiceItems.forEach(item => {
    if (item.mtoShipmentID === shipmentID && item.reServiceCode === "DOSHUT") {
        pm.environment.set("serviceItemDOSHUT", item.id)
    }
    if (item.mtoShipmentID === shipmentID && item.reServiceCode === "DCRT") {
        pm.environment.set("serviceItemDCRT", item.id)
    }
    if (item.mtoShipmentID === shipmentID && item.reServiceCode === "DUCRT") {
        pm.environment.set("serviceItemDUCRT", item.id)
    }
  })
 console.log(responseJSON.mtoServiceItems)
  console.log(pm.environment.get("serviceItemDOSHUT"))
  console.log(pm.environment.get("serviceItemDCRT"))
console.log(pm.environment.get("serviceItemDUCRT"))
  //
  console.log("LOOK HERE")
  console.log(pm.environment.get("moveTaskOrderID"))
  const postCreatePayment = {
    url: pm.environment.get("baseUrl") + '/payment-requests',
    method: 'POST',
    header: {
      'Content-Type': 'application/json'
    },
    body: {
      mode: 'raw',
      raw: JSON.stringify({
        "moveTaskOrderID": pm.environment.get("moveTaskOrderID"),
        "serviceItems": [
        {
            "id": pm.environment.get("serviceItemDOSHUT")
        },
        {
            "id": pm.environment.get("serviceItemDCRT")
        },
        {
            "id": pm.environment.get("serviceItemDUCRT")
        }
        ],
        "isFinal": false
      })
    }
  }

      pm.visualizer.set(template, {
        response: responseJSON
      })
      pm.sendRequest(postCreatePayment, (error, response) => {
        console.log(error ? error : response.json());
        template += `
<div class="margin-top-4 margin-bottom-2" id="paymentButton">
  <button class="usa-button" id="reqPayment" onclick="showMsg()">Request Payment</button>
</div>
<div class="hide" id="paymentRequest">
  <div class="usa-alert usa-alert--success" id="alert" >
    <div class="usa-alert__body">
      Payment request sent. Pending approval.
    </div>
  </div>
</div>
<script>
  function showMsg(){
    // Show updated shipment table
    update = document.getElementById("paymentRequest");
    update.className = 'show';

    button = document.getElementById("paymentButton");
    button.className = 'hide';

    // Change alert text
    alert = document.getElementById("alert-heading");
    alert.innerText = "Payment Requested";
  }
</script>
  `
        if (response.code == 201) {``
            pm.visualizer.set(template, {
                response: responseJSON
            })
            pr = response.json()
            pm.environment.set("paymentRequestID", pr.id)
            console.log(
              "\nPayment request ID: " + pr.id +
              "\nPayment request number: " + pr.paymentRequestNumber
            )
        }
      })
}
