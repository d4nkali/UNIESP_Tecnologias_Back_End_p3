#!/bin/bash

curl --request PATCH \
  --url http://localhost:8080/matriculas-alunos/atualiza-notas/2 \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/10.1.1' \
  --data '{
	"nota1": "7.00",
	"nota2": "8.00"
}'
