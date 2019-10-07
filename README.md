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

### Mutual TLS

When making web requests from a client (i.e. a web browser), it is extremely
common for a client to verify that the server they are talking to is in fact the
correct server. This is done by requesting a certificate from the server, and
asking a Certificate Authority if that certificate is valid.

In some cases, it's preferable to perform this verification for not only the
server, but the client as well. This is called Mutual TLS authentication, and
requires the client to send a valid, signed certificate to the server with each
request.

In order to interact with the Milmove API, you'll need to configure your API
client to send a signed certificate for authentication in each request.

In the Ruby client, you can configure the path to your private key and
certificate in `ruby-client/lib/swagger_client/configuration.rb`:

```ruby
#...

def initialize
  @scheme = 'https'
  @host = ''
  @base_path = '/api/v1'
  @api_key = {}
  @api_key_prefix = {}
  @timeout = 0
  @client_side_validation = true
  @verify_ssl = true
  @verify_ssl_host = true
  @params_encoding = nil
  @cert_file = nil # <- path to certificate
  @key_file = nil # <- path to private key
  @debugging = false
  @inject_format = false
  @force_ending_format = false
  @logger = defined?(Rails) ? Rails.logger : Logger.new(STDOUT)

  yield(self) if block_given?
end

#...
```

### User authorization

Since all requests made to the API will use mutual TLS authentication instead of
a typical user login scheme, you'll need a way to indicate which specific users
perform perform each request to the API. `api.yaml` defines a required header to
be sent with each request that indicates the `requestor`, a unique identifier
that can be used to trace which actions are done by a specific user.
