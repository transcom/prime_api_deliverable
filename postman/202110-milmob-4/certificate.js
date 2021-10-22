var CertificateList = require('postman-collection').CertificateList,
   certificateList = new CertificateList({}, [
       {
           name: 'my certificate for example.com',
           matches: ['https://example.com/*'],
           key: { src: '/path/to/key/file' },
           cert: { src: '/path/to/certificate/file' }
       },
       {
           name: 'my certificate for example2.com',
           matches: ['https://example2.com/*'],
           key: { src: '/path/to/key/file' },
           cert: { src: '/path/to/key/file' }
       }
]);

module.export = certificateList;
