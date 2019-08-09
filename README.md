# clojure-api-starter

## Usage

Create an `.lein-env` file at the root.
```clj
{:db-type "postgres"
 :db-name "postgres"
 :db-user "postgres"
 :db-host "localhost"
 :db-password "postgres"}
```

```
$ lein run
```

### Deploy in Docker

```
$ docker-compose build && docker-compose up
```