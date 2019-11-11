-- name: get-users
SELECT *
    FROM `user`

-- name: get-user
SELECT *
    FROM `user`
    WHERE `id` = :id

-- name: create-user<!
INSERT 
    INTO `user` 
    (`name`) 
    VALUES (:name)