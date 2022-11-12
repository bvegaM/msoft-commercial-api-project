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


## Archivo Postman

FileName: proyecto_service-consume.postman_collection.json
Tipo autentificación: Bearer

- 1 Público Login Bearer. Método con el cual se podra acceder al Token para poder realizar las consultas configuradas
	   En la sección de autorización, se debe seleccionar el Type: Bearer Token, y en el valor del Token obtenido de la consulta o Login realizado, sin la palabra "Bearer"

- 2 Privado Get All. Obtiene los nombres de los servicios y las apis configuradas que seran consumidos; este api es de pruebas, y se lo configuró para validaciones internas

- 3 Privado FindById. Obtiene la información de un servicio especifíco

- 4 Privado FindByCode. Obtiene la información de un servicio especifíco

- 5 Público FindAll. Obtiene unicamente la información o los nombres de los servicios que estaran disponibles para los usuarios

- 6 Público AmmountByDNI. Obtiene los valores adeudados por medio de la identificación, para un servicio específico

- 7 Público AmmountByDNI. Obtiene los valores adeudados por medio de la identificación, para un servicio específico

- 8 Público AmmountByContract. Obtiene los valores adeudados por medio del número de contrato, para un servicio específico

- 9 Público FindContractByDNI. Obtiene el detalle de los contratos por medio de la identificación para un servicio en específico

- 10 Público FindPromotions. Obtiene las promociones actuales de un servicio en específico

- 11 Público AmmountByDNI. Obtiene todas las deudas de tosos los servicios configurados para un número de identificación ingresado

