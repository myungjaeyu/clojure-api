# clojure-api

## Usage

Create an `.lein-env` file at the root.

```clj
{:db-type "mysql"
 :db-name ""
 :db-user "root"
 :db-host "127.0.0.1"
 :db-password ""}
```

```bash
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

## API Docs

```bash
http://localhost:3000/docs #swagger-ui
```
