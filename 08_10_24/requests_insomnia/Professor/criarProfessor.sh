curl --request POST \
  --url http://localhost:8080/professor \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/9.3.3' \
  --data '{
	"nome": "Joao Vitor",
	"email": "exemplo@email.com",
	"cpf": "69696969696-12"
}'