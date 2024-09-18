curl --request PUT \
  --url http://localhost:8080/alunos/3 \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/9.3.3' \
  --data '{
	
	"nome": "kuririm",
	"cpf": "541556166-00",
	"email": "confia@email.com"
	
}'