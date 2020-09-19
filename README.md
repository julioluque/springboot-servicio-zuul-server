# springboot-servicio-zuul-server
Microservicio con Spring Boot, Spring Cloud, Netflix, Eureka Balanceo de carga con Ribbon Clientes Feign y Rest Template Base de datos H2
https://github.com/julioluque

# Lista de microservicios dentro de este ecosistema.
Estos son los proyectos que se utilizaran para pruebas de integracion. 
Levantamos en el orden que esta detallado a continuacion.

## SERVIDORES
- springboot-servicio-config-server
Servidor de condfiguracion transversal, Toma credenciales de git
Puerto 8888

- springboot-servicio-eureka-server
Servidor de aplicaciones
Control de balanceo de carga por Ribbon embebido.
Puerto 8761

- springboot-servicio-zuul-server
Gateway o puerta de entrada.
Registrado como cliente Eureka
Puertto 8090


## API ORQUESTADORA
- springboot-servicio-producto
Control de persistencia con H2 y JPA
Registrado como Cliente de Eureka
Puerto 8001

## APIS DE DOMINIO
### springboot-servicio-item
Cliente Feign llamado por "servicio-producto"
Control de balanceo de carga (Pasa control a Eureka)
Control de tolerancia a fallos por circuit breaker con Hystrix
Registrado como Cliente de Eureka
Puerto 8002


### springboot-servicio-detalle
Cliente feign llamado por "servicio-item"
Puerto 8003
