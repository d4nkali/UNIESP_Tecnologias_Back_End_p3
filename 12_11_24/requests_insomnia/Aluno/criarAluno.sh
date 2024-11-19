#!/usr/bin/bash

curl --request POST \
  --url http://localhost:8080/alunos \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/9.3.3' \
  --data '{
	"nome": "Danilo",
	"email": "exemplo@email.com",
	"cpf": "1213231131-12"
}'
