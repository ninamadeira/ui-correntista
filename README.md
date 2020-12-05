# ui-correntista

Entrada de dados do correntista e publisher na exchange. Essa decide para qual fila do rabbitmq a mensagem será enviada.

### Comando do docker para rodar o rabbitmq
```
Comando: 
docker run -d -p 15672:15672 -p 5672:5672 --name rabbitmq rabbitmq:3-management
Caso tenha o container do rabbitmq instalado e não executando:
docker start id-container
```
### Gerenciar RabbitMQ
```
http://localhost:15672
```
### Validação de cpf/cnpj conforme o tipo: 1 - pessoa física ou 2 - pessoa jurídica
```
POST
http://localhost:8081/send
{
"nome":"Luis Kamon",
"tipo":1,
"cpfOuCnpj":"11443913006"
}

POST
http://localhost:8081/send
{
"nome": "React Ltda",
"tipo": 2,
 "cpfOuCnpj": "62865792000114"
}
```

### Postman ou Insomnia
```
Para testar sugiro Postman ou Insomnia.
Exemplo:
POST
http://localhost:8081/send
{
"nome":"Luis Kamon",
"tipo":1,
"cpfOuCnpj":"11443913006"
}

POST
http://localhost:8081/send
{
"nome": "React Ltda",
"tipo": 2,
 "cpfOuCnpj": "62865792000114"
}
```
### Implementação
```
Spring Boot Rest API
Produtor RabbitMQ
Validadores
Design Pattern
Versão Java: 11
```