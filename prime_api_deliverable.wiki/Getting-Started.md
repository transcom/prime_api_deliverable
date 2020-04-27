Let's walk through setting up your environment to make your first API call to the Prime API.

1. [Install dependencies](#install-dependencies)
2. [Check out the MilMove project](#checkout-project)
2. [Run the Docker container](#run-prime-docker)
3. [Use the CLI Prime API Client](#run-prime-api-client)


## Install Dependencies
Required Libraries:
* [Homebrew](#homebrew)
* [Go](#go)
* [Docker](#docker)
* [Docker Compose](#docker-compose)
* [direnv](#direnv)
* [jq](#jq)
* [yarn](#yarn)


### Homebrew
* Use the following command to install Homebrew:
  * `/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`
  * **Note**: You'll be prompted to install Xcode Command Line Tools if you don't have them already.

### Go
  * `brew install go`
  * **Notes**:
    * Current Go version:  go1.14 (released 2020/02/25)
    *  We normally use the latest version of Go unless there's a known conflict (which will be announced by the team) or if we're in the time period just after a new version has been released.
    * If you have previously modified your PATH to point to a specific version of go, make sure to remove that. This would be either in your `.bash_profile` or `.bashrc`, and might look something like `PATH=$PATH:/usr/local/opt/go@1.12/bin`.
  * Add the following to your `.bash_profile`:
    * `export GOPATH=${GOPATH:-$(go env GOPATH)}`
    * `export PATH=$(go env GOPATH)/bin:$PATH`
  * Apply the changes to your shell:
    * `source ~/.bash_profile`
    
### Docker
* Install the Docker desktop app
  * Download the desktop app: https://www.docker.com/products/docker-desktop
  * Once downloaded, install and run. 
* Or install Docker via Homebrew
  * `brew cask install docker`
  * `open /Applications/Docker.app`

### Docker Compose
  * The Mac OS desktop app already includes Compose
  * For Windows, see Docker's installation instructions here: https://docs.docker.com/compose/install/

### direnv
  * `brew install direnv`
  * For direnv to work properly, it needs to be hooked into the shell.
    * Once the hook is configured, restart your shell for direnv to be activated.

#### BASH
Add the following line at the end of your `~/.bash_profile`:

`eval "$(direnv hook bash)"`

Make sure it appears even after rvm, git-prompt and other shell extensions that manipulate the prompt.

#### ZSH

Add the following line at the end of the ~/.zshrc file:

`eval "$(direnv hook zsh)"`


### jq
  * `brew install jq`

### yarn
  * `brew install yarn`


## Checkout Project
You can checkout this repository by running `git clone git@github.com:transcom/mymove.git`. Please check out the code in a directory like `~/Projects/mymove` and NOT in your $GOPATH. As an example:

```
mkdir -p ~/Projects
git clone git@github.com:transcom/mymove.git
cd mymove
```

### Local Env Variables
* Copy `.envrc.local.template` to `.envrc.local` if you do not already have `.envrc.local`.
  * `cp .envrc.local.template .envrc.local`

* #TODO: Explain which variables need to be manually replaced, if any.

* Modify `/etc/hosts` to include the `prime`, `office`, and `milmove` hosts.
```
  echo "127.0.0.1 primelocal" | sudo tee -a /etc/hosts
  echo "127.0.0.1 officelocal" | sudo tee -a /etc/hosts
  echo "127.0.0.1 milmovelocal" | sudo tee -a /etc/hosts
```

## Run Prime Docker
Make sure you've [installed the dependencies](#install-dependencies) before proceeding. From the `/mymove` directory, run:
`make run_prime_docker`

Wait for the script to finish running. When finished, you should see [#TODO--get expected view/text].

## Run Prime API Client
To verify your setup is working correctly, you can quickly test the API using the `prime-api-client` CLI tool. For this example, we'll GET `/move-task-orders`, which returns an array of all move task orders.

Run:
`go run ./cmd/prime-api-client --insecure fetch-mtos`

You should see a response similar to:
```
   [
        {
          "createdAt": "2020-03-23",
          "id": "c66e2e16-4b3c-467b-a3a8-c80e46135dd2",
          "isAvailableToPrime": true,
          "isCanceled": false,
          "moveOrder": {
            "confirmationNumber": "GBQP4Q",
            "customer": {
              "branch": "COAST_GUARD",
              "currentAddress": {
                "city": "",
                "id": "00000000-0000-0000-0000-000000000000",
                "postalCode": "",
                "state": "",
                "streetAddress1": ""
              },
              ...
        },
        ...
    ]
```

Congrats! You've made your first call to the Prime API. For more details on using the Prime API Client, visit the [Using the Prime API Client](/wiki/#prime-api-client) section. To learn more about available endpoints, visit [API Endpoints](https://github.com/transcom/prime_api_deliverable/wiki/API-Endpoints).

### Shutting down Docker
When you're finished testing, remember to shut down the server:

`make docker_compose_down`