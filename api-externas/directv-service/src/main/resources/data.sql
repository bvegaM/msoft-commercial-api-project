Insert into Customer (cli_id, cli_cedula, cli_nombre, cli_fecha_nacimiento) values (1, '0103767661', 'Cristian Andres Moreno Cobos', '1986-02-22');
Insert into Customer (cli_id, cli_cedula, cli_nombre, cli_fecha_nacimiento) values (2, '0301560280', 'Mayra de la Nube Reinoso Lopez', '1980-10-23');
Insert into Customer (cli_id, cli_cedula, cli_nombre, cli_fecha_nacimiento) values (3, '0101056885', 'Enrique Moreno', '1954-04-12');

Insert into Contract (cnt_id, cnt_fecha, cnt_direccion, cli_id) values (1, '2010-04-15', 'FRENTE AL COLEGIO CESAR DAVILA', 1);
Insert into Contract (cnt_id, cnt_fecha, cnt_direccion, cli_id) values (2, '2008-03-12', 'TRIBUNA S/N Y REBENQUE', 3);
Insert into Contract (cnt_id, cnt_fecha, cnt_direccion, cli_id) values (3, '2005-08-10', 'PACHACAMAC 5-90 Y PASEO DE LOS CAÑARIS', 3);
Insert into Contract (cnt_id, cnt_fecha, cnt_direccion, cli_id) values (4, '2010-07-08', 'EN EL VALLE SECTOR CATALINA BAJO', 2);

Insert Into Service_Directv (sdr_id, sdr_deuda_corte, sdr_deuda_emision, sdr_deuda_vencimiento, sdr_observacion, sdr_deuda_minimo, sdr_deuda_total, cnt_id)
values (1, '2022-10-15', '2022-11-02', '2022-11-10', 'PAGO DE DIRECTV DEL MES DE OCTUBRE', 48, 55.62, 1);
Insert Into Service_Directv (sdr_id, sdr_deuda_corte, sdr_deuda_emision, sdr_deuda_vencimiento, sdr_observacion, sdr_deuda_minimo, sdr_deuda_total, cnt_id)
values (2, '2022-10-15', '2022-11-02', '2022-11-04', 'PAGO DE DIRECTV DEL MES DE OCTUBRE', 75, 85.54, 2);
Insert Into Service_Directv (sdr_id, sdr_deuda_corte, sdr_deuda_emision, sdr_deuda_vencimiento, sdr_observacion, sdr_deuda_minimo, sdr_deuda_total, cnt_id)
values (3, '2022-10-15', '2022-11-02', '2022-11-10', 'PAGO DE DIRECTV DEL MES DE OCTUBRE', 100, 100.25, 3);
Insert Into Service_Directv (sdr_id, sdr_deuda_corte, sdr_deuda_emision, sdr_deuda_vencimiento, sdr_observacion, sdr_deuda_minimo, sdr_deuda_total, cnt_id)
values (4, '2022-10-15', '2022-11-02', '2022-11-06', 'PAGO DE DIRECTV DEL MES DE OCTUBRE', 38, 45.20, 4);

Insert Into Promotion(pro_id, pro_promo_desde, pro_promo_hasta, pro_promo_titulo, pro_promo_detalle, pro_promo_url)
values (1, '2022-11-01', '2022-11-30', 'HBO 50% POR TRES MESES', 'DURENTE TRES MESES PAGARA EL 50% DEL PAQUETE DE HBO', '/PROMOCION/HBO/');
Insert Into Promotion(pro_id, pro_promo_desde, pro_promo_hasta, pro_promo_titulo, pro_promo_detalle, pro_promo_url)
values (2, '2022-11-01', '2022-11-15', 'START 75% DURANTE 2 MESES', 'DURENTE DOS MESES PAGARA EL 75% DEL PAQUETE DE START', '/PROMOCION/START/');
Insert Into Promotion(pro_id, pro_promo_desde, pro_promo_hasta, pro_promo_titulo, pro_promo_detalle, pro_promo_url)
values (3, '2022-11-01', '2022-11-10', 'CANAL DEL FUTBOL GRATIS POR UN MES', 'DURENTE UN MESES SERA GRATIS EL PAQUETE DE CANAL DEL FUTBOL', '/PROMOCION/CANALFUTBOL/');

Insert into Promotion_Detail(prd_id, prd_promo_url, pro_id)
values (1, '/HBO1.png', 1);
Insert into Promotion_Detail(prd_id, prd_promo_url, pro_id)
values (2, '/HBO2.png', 1);
Insert into Promotion_Detail(prd_id, prd_promo_url, pro_id)
values (3, '/HBO3.png', 1);
Insert into Promotion_Detail(prd_id, prd_promo_url, pro_id)
values (4, '/START1.png', 2);
Insert into Promotion_Detail(prd_id, prd_promo_url, pro_id)
values (5, '/START2.png', 2);
Insert into Promotion_Detail(prd_id, prd_promo_url, pro_id)
values (6, '/CANALFUTBOL.png', 3);