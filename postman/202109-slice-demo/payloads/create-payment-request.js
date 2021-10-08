const addDays = require('../../utils/addDays');

const payload = {
  isFinal: false,
  moveTaskOrderID: "{{moveTaskOrderID}}",
  serviceItems: [
    {
      id: "f9628ea5-7aaf-401f-b663-3d0e050eee24",
      params: [{
        key: "SITPaymentRequestStart",
        value: addDays(-29),
      },{
        key: "SITPaymentRequestEnd",
        value: addDays(0),
      }]
    }
  ]
};

module.exports = payload;
