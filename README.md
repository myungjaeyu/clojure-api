# clojure-api-starter

## Usage

Create an `.lein-env` file at the root.
```clj
{:db-type "mysql"
 :db-name ""
 :db-user ""
 :db-host ""
 :db-password ""}
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

## API Specification

#### /

- **Method** : GET
- **URL** : https://:your_server_url/
- **Response**

```json
{
    "message":"index"
}
```


#### /users

- **Method** : GET
- **URL** : https://:your_server_url/users
- **Response**

```json
[
    {
        "id":1,
        "name":"myungjaeyu"
    }
]
```

#### /users/:id

- **Method** : GET
- **URL** : https://:your_server_url/users
- **Response**

```json
{
    "id":1,
    "name":"myungjaeyu"
}
```


#### /users

- **Method** : POST
- **URL** : https://:your_server_url/users
- **Parameters**

| Field | Type |
| ---- | ----------- |
| name | String |

- **Response**

```json
{
    "id": 1,
    "name": "myungjaeyu"
}
```