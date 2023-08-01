# Desafio Java Back-end - Softexpert

Teste para vaga na empresa Softexpert

[Descrição do desafio:](https://github.com/ArturSch/DesafioBackendSE)

## Instalação e configuração do ambiente

Este projeto foi desenvolvido utilizando [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)

### Clonar repositório

```
git clone https://github.com/BatistaYuri/DesafioBackendSE.git
```

### IDE

Importar como projeto Maven

Adicionar a variável de ambiente mercado_pago_access_token_test=TEST-6546483438479945-072708-b6835dbe79ffa6aa2301a56358af068e-794114148

Excecute o arquivo src\main\java\br\com\softexpert\desafio\DesafioJavaBackendApplication.java para rodar a aplicação na porta 8080.

Excecute o arquivo src\main\java\br\com\softexpert\desafio\DesafioJavaBackendApplication.java para rodar a aplicação na porta 8080.

### EXEMPLO

POST: http://localhost:8080/api/bill?companyPayment=mercado_pago

BODY:

```
{
    "id": 0,
    "orders": [
        {
            "id": 0,
            "name": "Hamburguer",
            "person": {
                "id": 0,
                "name": " Yuri(pagador)",
                "email": "yuri.b.1114@gmail.com",
                "payer": true
            },
            "price": 40
        },
        {
            "id": 1,
            "name": "Sobremesa",
            "person": {
                "id": 0,
                "name": " Yuri(pagador)",
                "email": "yuri.b.1114@gmail.com",
                "payer": true
            },
            "price": 2
        },
        {
            "id": 2,
            "name": "Sanduíche ",
            "person": {
                "id": 1,
                "name": "Leo",
                "email": "teste@gmail.com",
                "payer": false
            },
            "price": 8
        }
    ],
    "additions": [
        8
    ],
    "discounts": [
        20
    ]
}
```
