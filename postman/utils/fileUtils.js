/**
 * This file has utils to avoid needing the fs and path libraries in every request file
 */

// Node JS libraries for working with the file system and file paths.
const fs   = require('fs'),
      path = require('path');

/**
 * readScript reads file data into variable
 */
const readScript = (directory, filename) => {
  // Get the contents of the file
  const scriptFilePath = path.resolve(directory, filename);
  return fs.readFileSync(scriptFilePath);
}

/**
 * getRequestID simple helper to extract request id
 */
const getRequestID = (filename) => {
  return path.basename(filename, '.js');
}

module.exports = { readScript, getRequestID };
