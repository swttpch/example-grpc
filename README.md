# Repositório de Estudos gRPC com Spring Boot

Este é um repositório de estudos focado em aprender e experimentar a comunicação gRPC dentro do ecossistema Spring Boot.

## Descrição

O projeto demonstra uma implementação cliente-servidor usando gRPC. Ele foi construído com **Java 21**, **Maven** e está totalmente integrado com o **Spring Boot**.

Os principais componentes são:
- **Definição do Serviço (`.proto`):** O contrato do serviço gRPC é definido em um arquivo `.proto`, que é compilado automaticamente durante o processo de build do Maven para gerar as classes Java correspondentes.
- **Servidor gRPC (`GreeterService`):** Uma implementação do serviço gRPC que é iniciada junto com a aplicação Spring.
- **Cliente gRPC (`GreeterClient`):** Um cliente para consumir o serviço gRPC.
- **Controlador REST (`GreeterController`):** Um endpoint REST que utiliza o cliente gRPC para interagir com o servidor, expondo a funcionalidade gRPC através de uma API HTTP.

## Pré-requisitos

- **Java 21** ou superior
- **Maven**

## Como executar

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/swttpch/example-grpc.git
    cd example-grpc
    ```

2.  **Compile o projeto:**
    O processo de compilação do Maven irá automaticamente compilar o arquivo `.proto` e gerar as classes gRPC necessárias.
    ```bash
    mvn clean install
    ```

3.  **Execute a aplicação:**
    ```bash
    java -jar target/example-grpc-0.0.1-SNAPSHOT.jar
    ```
    O servidor gRPC será iniciado na porta 9090 e a aplicação Spring Boot na porta 8080 (padrão).

## Uso

### Via Cliente gRPC

Você pode usar um cliente gRPC como o [grpcurl](https://github.com/fullstorydev/grpcurl) ou [BloomRPC](https://github.com/bloomrpc/bloomrpc) para interagir com o servidor na porta 9090.

- **Serviço:** `br.com.swttpch.Greeter`
- **Método:** `SayHello`
- **Payload de exemplo:** `{"name": "Mundo"}`

### Via Endpoint REST

Você também pode acionar o cliente gRPC através do endpoint REST exposto pela aplicação Spring:

- **URL:** `http://localhost:8080/greet`
- **Método:** `GET`
- **Parâmetro de query:** `name`

**Exemplo de requisição:**
```bash
curl http://localhost:8080/greet?name=Mundo
```

Isso fará com que a aplicação Spring chame o servidor gRPC e retorne a saudação.
