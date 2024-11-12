#!bin/bash

curl --request POST \
  --url http://localhost:8080/matriculas-alunos \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/9.3.3' \
  --data '{
	"aluno": {
	"id": 1
	},
	"disciplina": {
			"id":1
	}
}	'
