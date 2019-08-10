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

Request URL - `http://localhost:3000`

### Deploy in Docker

`.lein-env`

```clj
{:db-host "db"}
 ```
```
$ docker-compose build && docker-compose up
```

Request URL - `http://localhost:80`