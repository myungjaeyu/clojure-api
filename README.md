# clojure-api-starter

## Usage

```
$ lein run
```

### Deploy in Docker

`src/service/db.clj`
```clj
{; :host "localhost"
   :host "db"}
```

```
$ docker-compose build && docker-compose up
```