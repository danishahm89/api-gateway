# API Gateway

A Spring Cloud Gateway that works as the single entry point for the microservices of this practice project. It finds services through Eureka and forwards requests to them.

## Tech stack

- Java 17
- Spring Boot 3.3.2
- Spring Cloud 2023.0.3 (Gateway, Netflix Eureka Client)
- Spring Boot Actuator
- Maven

## Configuration

| Setting | Value |
|---|---|
| Application name | `api-gateway` |
| Port | `8765` |
| Eureka server | `http://localhost:8761/eureka` |
| Discovery locator | enabled |

## Routing

- **Automatic routes:** with the discovery locator enabled, every service registered in Eureka is reachable through the gateway at `/{service-name}/...`.
- **Custom route:** `ApiGatewayConfiguration` defines a route that sends requests matching `/customer-management/` to the `customer-management` service through the load balancer (`lb://customer-management`).

Example:

```bash
curl http://localhost:8765/customer-management/...
```

## Run locally

Start these first: [config-server](https://github.com/danishahm89/config-server) and [eureka-server](https://github.com/danishahm89/eureka-server). Then start the gateway from the `api-gateway` folder.

```bash
cd api-gateway
mvn spring-boot:run
```

## Related repositories

- [eureka-server](https://github.com/danishahm89/eureka-server): service discovery
- [config-server](https://github.com/danishahm89/config-server): centralized configuration
- [cloud-config](https://github.com/danishahm89/cloud-config): the configuration files

## Concepts shown

- API gateway pattern with Spring Cloud Gateway
- Dynamic routing through service discovery
- Client-side load balancing (`lb://`)
