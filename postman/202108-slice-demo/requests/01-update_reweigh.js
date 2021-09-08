const responseJSON = pm.response.json(),
      envGet = function(v) {
        return pm.collectionVariables.get(v);
      },
      envSet = function(k, v) {
        pm.collectionVariables.set(k, v);
      };

var view = {
  pageTitle: 'GHC Contractor - Reweighs',
  pageHeading: 'GHC Contractor',
  pageAction: 'Moves',
  alertTitle: 'New Move Approved',
};

// var shipment = ''

if (pm.response.code == 200) {

  let payload = envGet('updateShipmentPayload');

  pm.visualizer.set(envGet('updateShipmentTemplate'), {
    view: view,
    response: responseJSON
  })

  envSet('shipmentID', responseJSON.mtoShipments[0].id)
  envSet('eTag', responseJSON.mtoShipments[0].eTag)

  if (responseJSON.mtoShipments[0].destinationAddress) {
    console.log('Destination address found - excluding from update')
    payload.destinationAddress = {};
  }

  let primeWeights = {
    primeEstimatedWeight: envGet('primeEstimatedWeight'),
    primeActualWeight: envGet('primeActualWeight'),
  }

  if (responseJSON.mtoShipments[0].primeEstimatedWeight ||
      responseJSON.mtoShipments[0].primeActualWeight) {
    console.log('Weights found - excluding from update')
    primeWeights = {}
  }
  // Represents updating a shipment with pickup dates, weights, and new
  // destination address
  const patchUpdateShipment = {
    url: pm.environment.get('baseUrl') + '/mto-shipments/' + pm.environment.get('mtoShipmentID'),
    method: 'PATCH',
    header: {
      'Content-Type': 'application/json',
      'If-Match': envGet('eTag')
    },
    body: {
      mode: 'raw',
      raw: JSON.stringify({
        ...payload,
        ...primeWeights,
      })
    }
  }
  pm.sendRequest(patchUpdateShipment, (error, response) => {
    let shipment = response.json();
    if (response.code == 200) {
      // pm.environment.set('mtoShipmentETag', shipment.eTag)
      // envSet('eTag', shipment.eTag);
      // pm.environment.set('destinationAddressID', shipment.destinationAddress.id)
      // pm.environment.set('destinationAddressETag', shipment.destinationAddress.eTag)
      pm.visualizer.set(template, {
        response: responseJSON,
        shipment: shipment,
        cratingServiceItem: cratingServiceItem
      });
    }

  });

    /*

  pm.sendRequest(patchUpdateShipment, (error, response) => {
    shipment = response.json()
    console.log(error ? error : shipment);
console.log('PATCH UPDATE SHIPMENT')
    template += `
<div class='margin-top-4 margin-bottom-2'>
  <button class='usa-button' id='updateMove' onclick='showMoveUpdate()'>Update the Move</button>
</div>
<div class='hide' id='updatedShipment'>
  <table class='usa-table usa-table--borderless usa-table--striped'>
  <caption>Updated Shipment Information</caption>

  <tbody>
    <tr>
      <th scope='row'>Destination Address</th>
      <td>{{shipment.destinationAddress.streetAddress1}}, {{shipment.destinationAddress.city}}, {{shipment.destinationAddress.state}}, {{shipment.destinationAddress.postalCode}}</td>
    </tr>

    <tr>
      <th scope='row'>Scheduled Pickup Date</th>
      <td>{{shipment.scheduledPickupDate}}</td>
    </tr>

    <tr>
      <th scope='row'>Estimated Weight</th>
      <td>1400</td>
    </tr>

    <tr>
      <th scope='row'>Actual Pickup Date</th>
      <td>{{shipment.actualPickupDate}}</td>
    </tr>

    <tr>
      <th scope='row'>Actual Weight</th>
      <td>{{shipment.primeActualWeight}}</td>
    </tr>
  </tbody>
</table>
</div>
<script>
  function showMoveUpdate(){
    // Show updated shipment table
    update = document.getElementById('updatedShipment');
    update.className = 'show';

    // Change alert text
    alert = document.getElementById('alert-heading');
    alert.innerText = 'Shipment Updated';
  }
</script>
  `

    if (response.code == 200) {``
      pm.environment.set('mtoShipmentETag', shipment.eTag)
      pm.environment.set('destinationAddressID', shipment.destinationAddress.id)
      pm.environment.set('destinationAddressETag', shipment.destinationAddress.eTag)
      pm.visualizer.set(template, {
        response: responseJSON,
        shipment: shipment,
        cratingServiceItem: cratingServiceItem
      })
            console.log('IN SERVICE ITEMS')
        //CRATING :
        const postServiceItemCrating = {
                url: pm.environment.get('baseUrl') + '/mto-service-items/',
                method: 'POST',
                header: {
                    'Content-Type': 'application/json',
                    'If-Match': pm.environment.get('mtoShipmentETag')
                },
                body: {
                    mode: 'raw',
                    raw: JSON.stringify({
                        'crate': {
                            'height': 2400,
                            'length': 2400,
                            'width': 2400
                        },
                        'description': 'Antique dinnerware',
                        'item': {
                            'height': 2000,
                            'length': 2000,
                            'width': 2000
                        },
                        'reServiceCode': 'DCRT',
                        'reason': 'customer has antique dinnerware that needs to be crated',
                        'modelType': 'MTOServiceItemDomesticCrating',
                        'moveTaskOrderID': pm.environment.get('moveTaskOrderID'),
                        'mtoShipmentID': pm.environment.get('mtoShipmentID'),
                    })
                }
            }

        pm.sendRequest(postServiceItemCrating, (error, response) => {
            const serviceItems = response.json()
            console.log(error ? error : serviceItems);
            console.log('CREATED SERVICE ITEM')


            cratingServiceItem = serviceItems[0]
            console.log(cratingServiceItem)
            console.log(response.code)
            if (response.code == 200) {``
                template += `
                <div class='margin-top-4 margin-bottom-2'>
                <button class='usa-button' id='serviceItem' onclick='showCratingUpdate()'>Create a Service Item for Crating</button>
                </div>
                <div class='hide' id='cratingServiceItem'>
                <table class='usa-table usa-table--borderless usa-table--striped'>
                <caption>Crating Service Item</caption>

                <tbody>
                    <tr>
                    <th scope='row'>Service Item ID</th>
                    <td>{{cratingServiceItem.id}}</td>
                    </tr>
                    <tr>
                    <th scope='row'>Length</th>
                    <td>{{cratingServiceItem.crate.length}}</td>
                    </tr>

                    <tr>
                    <th scope='row'>Width</th>
                    <td>{{cratingServiceItem.crate.width}}</td>
                    </tr>

                    <tr>
                    <th scope='row'>Height</th>
                    <td>{{cratingServiceItem.crate.height}}</td>
                    </tr>
                </tbody>
                </table>
                </div>

                <script>
                function showCratingUpdate(){
                    // Show updated crating table
                    cratingServiceItem = document.getElementById('cratingServiceItem');
                    cratingServiceItem.className = 'show';

                    // Change alert text
                    alert = document.getElementById('alert-heading');
                    alert.innerText = 'Crating Service Item created';
                }
                </script>
                `
            pm.visualizer.set(template, {
                cratingID : cratingServiceItem.id,
                response: responseJSON,
                shipment: shipment,
                cratingServiceItem: cratingServiceItem
            })
            }
        });

            // SHUTTLING
            const postServiceItemShuttling = {
                url: pm.environment.get('baseUrl') + '/mto-service-items/',
                method: 'POST',
                header: {
                    'Content-Type': 'application/json',
                    'If-Match': pm.environment.get('mtoShipmentETag')
                },
                body: {
                    mode: 'raw',
                    raw: JSON.stringify({
                        'modelType': 'MTOServiceItemShuttle',
                        'reServiceCode': 'DOSHUT',
                        'reason': 'narrow street at origin address, needs shuttling',
                        'description': 'Things to be moved to the place by shuttle.',
                        'estimatedWeight': 1000,
                        'actualWeight': 2000,
                        'moveTaskOrderID': pm.environment.get('moveTaskOrderID'),
                        'mtoShipmentID': pm.environment.get('mtoShipmentID'),
                    })
                }
            }

        pm.sendRequest(postServiceItemShuttling, (error, response) => {
            const serviceItems = response.json()
            console.log(error ? error : serviceItems);
            console.log('CREATED SHUTTLING SERVICE ITEM*****')

            shuttlingServiceItem = serviceItems[0]
            console.log(serviceItems)
            console.log(shuttlingServiceItem)
        // const responseJSON = pm.response.json;
            console.log(response)
            if (response.code == 200) {``
                template += `
                    <div class='margin-top-4 margin-bottom-2'>
                    <button class='usa-button' id='serviceItem' onclick='showShuttlingUpdate()'> Create a Service Item for Shuttling</button>
                    </div>
                    <div class='hide' id='shuttlingServiceItem'>
                    <table class='usa-table usa-table--borderless usa-table--striped'>
                    <caption>Shuttling Service Item</caption>

                    <tbody>
                        <tr>
                        <th scope='row'>Shuttling Service Item ID</th>
                        <td>{{shuttlingServiceItem.id}}</td>
                        </tr>
                        <tr>
                        <th scope='row'>Estimated Weight</th>
                        <td>{{shuttlingServiceItem.estimatedWeight}}</td>
                        </tr>

                        <tr>
                        <th scope='row'>Actual Weight</th>
                        <td>{{shuttlingServiceItem.actualWeight}}</td>
                        </tr>
                    </tbody>
                    </table>
                    </div>

                    <script>
                    function showShuttlingUpdate(){
                        // Show updated shuttling table
                        shuttlingServiceItem = document.getElementById('shuttlingServiceItem');
                        shuttlingServiceItem.className = 'show';

                        // Change alert text
                        alert = document.getElementById('alert-heading');
                        alert.innerText = 'Shuttling Service Item created';
                    }
                    </script>
                    `

            pm.visualizer.set(template, {
                response: responseJSON,
                cratingServiceItem: cratingServiceItem,
                shuttlingServiceItem: shuttlingServiceItem,
                shipment: shipment
            })
            }
        });

          const postServiceItemUncrating = {
                url: pm.environment.get('baseUrl') + '/mto-service-items/',
                method: 'POST',
                header: {
                    'Content-Type': 'application/json',
                    'If-Match': pm.environment.get('mtoShipmentETag')
                },
                body: {
                    mode: 'raw',
                    raw: JSON.stringify({
                        'crate': {
                            'height': 2400,
                            'length': 2400,
                            'width': 2400
                        },
                        'description': 'uncrating dinnerware',
                        'item': {
                            'height': 2000,
                            'length': 2000,
                            'width': 2000
                        },
                        'reServiceCode': 'DUCRT',
                        'reason': null,
                        'modelType': 'MTOServiceItemDomesticCrating',
                        'moveTaskOrderID': pm.environment.get('moveTaskOrderID'),
                        'mtoShipmentID': pm.environment.get('mtoShipmentID'),
                    })
                }
            }


          pm.sendRequest(postServiceItemUncrating, (error, response) => {
            const serviceItems = response.json()
            console.log(error ? error : serviceItems);
            console.log('CREATED UNCRATING SERVICE ITEM*****')
            const uncratingServiceItem = serviceItems[0]
            console.log(uncratingServiceItem)
            template += `
               <div class='margin-top-4 margin-bottom-2'>
                <button class='usa-button' id='serviceItem' onclick='showUncratingUpdate()'>Create a Service Item for Uncrating</button>
                </div>
                <div class='hide' id='uncratingServiceItem'>
                <table class='usa-table usa-table--borderless usa-table--striped'>
                <caption>Uncrating Service Item</caption>

                <tbody>
                    <tr>
                    <th scope='row'>Service Item ID</th>
                    <td>{{uncratingServiceItem.id}}</td>
                    </tr>
                    <tr>
                    <th scope='row'>Length</th>
                    <td>{{uncratingServiceItem.crate.length}}</td>
                    </tr>

                    <tr>
                    <th scope='row'>Width</th>
                    <td>{{uncratingServiceItem.crate.width}}</td>
                    </tr>

                    <tr>
                    <th scope='row'>Height</th>
                    <td>{{uncratingServiceItem.crate.height}}</td>
                    </tr>
                </tbody>
                </table>
                </div>

        <script>
          function showUncratingUpdate(){
            // Show updated uncrating table
            uncratingServiceItem = document.getElementById('uncratingServiceItem');
            uncratingServiceItem.className = 'show';

            // Change alert text
            alert = document.getElementById('alert-heading');
            alert.innerText = 'Uncrating Service Item created';
          }
        </script>
          `
        //   const responseJSON = pm.response.json;
            console.log(response)
            if (response.code == 200) {``
            pm.visualizer.set(template, {
                response: responseJSON,
                cratingServiceItem: cratingServiceItem,
                uncratingServiceItem: uncratingServiceItem,
                shuttlingServiceItem: shuttlingServiceItem,
                shipment: shipment
            })
            }
          });
        }





    })
    */
  };
