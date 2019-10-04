# Prime API

In this repository, you'll find a few things:

- `api.yaml`, a file that documents example endpoints in the REST API along with
    what data model payloads would look like.
- An example Ruby client
- An example Java client


## api.yaml

There are two important sections to pay attention to in `api.yaml`:

1. `definitions`: Defines the structure of the API payloads including error
   types.
2. `paths`: Defines which endpoints are available in the API, the parameters
   accepted by those endpoints, and the potential responses returned.

For further information and documentation, visit the [Swagger 2.0
specification](https://github.com/OAI/OpenAPI-Specification/blob/master/versions/2.0.md)

## API clients

The Ruby and Java clients include further documentation on how to interact with
the API from each respective client. Please note that you may generate a starter
API client in many other mainstream languages. To do so, visit [the Swagger
editor website](https://editor.swagger.io/), paste the contents of `api.yaml` in
the editor, and click on `Generate Client`.

## Authentication


