#!/bin/bash

curl --request PATCH \
  --url http://localhost:8080/matriculas-alunos/trancar/1 \
  --header 'User-Agent: insomnia/10.1.1'
