# Servicio API para pasarela de consulta de servicios público-privados

### Integrantes
- Andrés Buestán
- Pablo Calderón
- Cristian Moreno
- Bryam Vega

## Instrucciones para correr el servicio
//TODO: COmplementar los pasos para correr los servicios



## Pruebas Unitarias y de Integración

Las pruebas unitarias y de integración han sido ejecutadas a nivel del servicio **services-consume**, que es el punto central en donde convergen la llamada de los servicios a consumir.

## Documentación Swagger

La documentación Swagger se encuentra configurada a nivel del servicio **services-consume**, exponiendo los endpoints que serán consumidos por los clientes, a través del servicio API Gateway.
El acceso a la documentación se lo puede realizar a través de la siguiente URL expuesta directamente por el servicio: **http://localhost:8003/swagger-ui/index.html** 