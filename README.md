# Servicio API para pasarela de consulta de servicios público-privados

### Integrantes
- Andrés Buestán
- Pablo Calderón
- Cristian Moreno
- Bryam Vega

## Instrucciones para correr el servicio
Para correr el presente proyecto se debe ejecutar en orden estos servicios:

- 1 config-service: Contiene el servidor que tiene las configuraciones de los servicios
- 2 eureka-service: Contiene el servidor para registrar los servicios
- 3 auth-service: Contiene los servicios de autenticacion y autorizacion
- 4 api-externas: Se debe correr los servicios que estan dentro de dicha carpeta para poder utilizar el siguiente servicio
- 5 service-consume: Contiene un servicio que llama a los servicios de api-externas
- 6 gateway-service: Contiene al servidor de gateway para estandarizar la comunicacion por puertos


## Pruebas Unitarias y de Integración

Las pruebas unitarias y de integración han sido ejecutadas a nivel del servicio **services-consume**, que es el punto central en donde convergen la llamada de los servicios a consumir.

## Documentación Swagger

La documentación Swagger se encuentra configurada a nivel del servicio **services-consume**, exponiendo los endpoints que serán consumidos por los clientes, a través del servicio API Gateway.
El acceso a la documentación se lo puede realizar a través de la siguiente URL expuesta directamente por el servicio: **http://localhost:8003/swagger-ui/index.html** 
