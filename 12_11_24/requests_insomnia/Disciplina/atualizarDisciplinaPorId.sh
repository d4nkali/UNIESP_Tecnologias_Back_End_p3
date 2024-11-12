#!/bin/bash

curl --request PUT \
  --url http://localhost:8080/disciplina/1 \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/9.3.3' \
  --data '{
	"nome": "Backend 1",
	"professor": {
		"id": 4
	}
}	'
