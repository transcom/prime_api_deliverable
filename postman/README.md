# Postman Collections

Welcome to the Postman Collections documentation for the Prime API Deliverables.
This documentation is here to facilitate the creation of [Postman
Collections][pm-dev-collections] using JavaScript. If you are only concerned
with the Collections then please [see the Collections section of this
README][hl-collections] for more information.

[pm-collections]: https://learning.postman.com/docs/sending-requests/intro-to-collections/ "Official Postman Documentation about Collections."
[pm-dev-collections]: https://www.postmanlabs.com/postman-collection/Collection.html "Official Postman Developer Documentation about Collections."
[hl-collections]: #collections "Go to Collections section."
[gh-pm-collection]: https://github.com/postmanlabs/postman-collection

## Terminology

Because of the nature of this project, it's important to disambiguate some words
used in this documentation. The terminology referenced here is not meant to be
extensive, but rather should be used in a way to help address any confusion for
overloaded words.

The overload of terms happens because there are different meanings for the
official Postman.app and the `postman-collection` library.  There are also some
terms that exist in the `postman-collection` library that are not used by this
project because they aren't necessary for our purposes. But these terms do exist
in the Postman.app as well. Please reference them in order to properly use the
Collection files created by this project.

- Collection
    - [Official Postman.app Documentation][pm-collections].
    - [Developer documentation for the postman-collection JS
        library][pm-dev-collections].
- Request
    - [Official Postman.app Documentation][pm-request].
    - The `postman-collection` library is not used to create `Request({})`
        objects even though this exists in the developer documentation.
- Variables
    - [Official Postman.app Documentation][pm-variables].
    - The `postman-collection` library is not used to create neither
        `Variable({})` nor `VariableList(Variable({}))` objects even though they
        exist in the developer documentation.
- Visuals
    - [Official Postman.app Documentation][pm-visuals].
    - The `postman-collection` library does not have documentation for Visuals.
- Templates
    - [Official Postman.app Documentation][pm-templates].
    - The `postman-collection` library does not have documentation for
        Templates.
- Tests
    - [Official Postman.app Documentation][pm-tests].
    - [Developer documentation for the postman-collection JS
        library][pm-dev-event].
- Pre-Request
    - [Official Postman.app Documentation][pm-prerequest].
    - [Developer documentation for the postman-collection JS
        library][pm-dev-event].
- Headers
    - [Official Postman.app Documentation][pm-headers].
    - The `postman-collection` library is not used to create neither
        `Header({})` nor `HeaderList(Header({}))` objects even though they
        exist in the developer documentation.
- Body
    - [Official Postman.app Documentation][pm-body].
    - [Developer documentation for the postman-collection JS
        library][pm-dev-body].
- Certificates
    - [Official Postman.app Documentation][pm-certificates].
    - [Developer documentation for the postman-collection JS
        library][pm-dev-certificates].

[pm-request]: https://learning.postman.com/docs/sending-requests/requests/ "Description"
[pm-variables]: https://learning.postman.com/docs/sending-requests/variables/ "Description"
[pm-visuals]: https://learning.postman.com/docs/sending-requests/visualizer/ "Description"
[pm-templates]: https://learning.postman.com/docs/sending-requests/visualizer/#rendering-html "Description"
[pm-tests]: https://learning.postman.com/docs/writing-scripts/test-scripts/ "Description"
[pm-dev-event]: https://www.postmanlabs.com/postman-collection/Event.html "Description"
[pm-prerequest]: https://learning.postman.com/docs/writing-scripts/pre-request-scripts/ "Description"
[pm-headers]: https://learning.postman.com/docs/sending-requests/requests/#configuring-request-headers "Description"
[pm-body]: https://learning.postman.com/docs/sending-requests/requests/#sending-body-data "Description"
[pm-dev-body]: http "Description"
[pm-certificates]: http "Description"
[pm-dev-certificates]: http "Description"

These terms from above have official Postman documentation and also have a
different meaning when it pertains to the Postman Collection work in this
directory. This is shown above by linking to the official Postman.app
documentation and also linking to the `postman-collection` JavaScript developer
documentation.

## Directories

The directories are split into slices and dated with that given month's slice.
The files contained in these directories can be used to build a Postman
collection to be imported and shared using Postman.app.

### Collections

The `collections/` directory contains the generated output of the Postman
Collection module. These files must not be edited manually

### Utilities

### Slice Demos
