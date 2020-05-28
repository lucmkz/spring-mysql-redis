# Spring - MySql - Redis
Spring Boot Mysql Redis REST API Cache example
Project for FIAP MBA Persistence

##
### Prerequisites
- JDK 1.8
- Maven
- Mysql
- Redis
- Docker

## Quick Start

### Clone source
```
git clone https://github.com/lucmkz/spring-mysql-redis.git
cd spring-mysql-redis-cache
```

```
MySQL START
```

```
Redis START
```

##
### Swagger-ui REST API Reference & Test
- http://localhost:8080/swagger-ui.html
- Response Content Type : application/json

##
### TEST using CURL

- Create Costumer
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '  { \ 
     "deliveryAddress": "Rua Lins de Vasconcelos, 1", \ 
     "documentId": 10101010, \ 
     "houseAddress": "São Bento, 1", \ 
     "id": 9999, \ 
     "name": "Lucas", \ 
     "nationality": "Brazil" \ 
 }' 'http://localhost:8080/v1/costumer'
```

- Create Product (1)
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '  { \ 
     "code": "999", \ 
     "id": 999, \ 
     "name": "Leite", \ 
     "quantity": 100, \ 
     "value": 20 \ 
   }' 'http://localhost:8080/v1/products'
```

- Create Product (2)
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '  { \ 
     "code": "999", \ 
     "id": 999, \ 
     "name": "Pão", \ 
     "quantity": 1000, \ 
     "value": 10 \ 
   }' 'http://localhost:8080/v1/products'
```

- Create Order
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{ \ 
   "id": 999, \ 
   "product": [ \ 
     { \ 
       "id": "1" \ 
     }, \ 
     { \ 
       "id": "2" \ 
     } \ 
   ], \ 
   "costumer": { \ 
 		"id":	"1" \ 
 	} \ 
 }' 'http://localhost:8080/v1/order'
```

##
### Redis monitor
- https://redis.io/commands/monitor
