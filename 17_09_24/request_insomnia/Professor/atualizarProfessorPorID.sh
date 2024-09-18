curl --request PUT \
  --url http://localhost:8080/professor/1 \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/9.3.3' \
  --data '{
	
	"nome": "dan33",
	"cpf": "541556166-00",
	"email": "confia@email.com"
	
}'