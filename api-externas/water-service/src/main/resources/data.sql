Insert into Customer (id, cedula, nombre, fecha_Nacimiento) values (1, '0103767661', 'Cristian Andres Moreno Cobos', '1986-02-22');
Insert into Customer (id, cedula, nombre, fecha_Nacimiento) values (2, '0301560280', 'Mayra de la Nube Reinoso Lopez', '1980-10-23');
Insert into Customer (id, cedula, nombre, fecha_Nacimiento) values (3, '0101056885', 'Enrique Moreno', '1954-04-12');

Insert into Contract (id, fecha, direccion_domicilio, cliente_id) values (1, '2010-04-15', 'FRENTE AL COLEGIO CESAR DAVILA', 1);
Insert into Contract (id, fecha, direccion_domicilio, cliente_id) values (2, '2008-03-12', 'TRIBUNA S/N Y REBENQUE', 3);
Insert into Contract (id, fecha, direccion_domicilio, cliente_id) values (3, '2005-08-10', 'PACHACAMAC 5-90 Y PASEO DE LOS CAÑARIS', 3);
Insert into Contract (id, fecha, direccion_domicilio, cliente_id) values (4, '2010-07-08', 'EN EL VALLE SECTOR CATALINA BAJO', 2);

Insert Into Service_Water (id, fecha_Corte, fecha_Emision, fecha_Max_Pago, observacion, monto_intereses, monto_mora, tiene_intereses, tiene_mora, valor_minimo, valor_total, contrato_id)
values (1, '2022-10-15', '2022-11-01', '2022-11-10', 'PAGO DEL AGUA DEL MES DE OCTUBRE', 0.0, 0.0, FALSE, FALSE, 25, 35.48, 1);
Insert Into Service_Water (id, fecha_Corte, fecha_Emision, fecha_Max_Pago, observacion, monto_intereses, monto_mora, tiene_intereses, tiene_mora, valor_minimo, valor_total, contrato_id)
values (2, '2022-09-15', '2022-10-01', '2022-10-10', 'PAGO DEL AGUA DEL MES DE SEPTIEMBRE', 2.48, 0.55, TRUE, TRUE, 27.54, 45.79, 2);
Insert Into Service_Water (id, fecha_Corte, fecha_Emision, fecha_Max_Pago, observacion, monto_intereses, monto_mora, tiene_intereses, tiene_mora, valor_minimo, valor_total, contrato_id)
values (3, '2022-10-15', '2022-11-01', '2022-11-10', 'PAGO DEL AGUA DEL MES DE OCTUBRE', 0.0, 0.0, FALSE, FALSE, 28, 32.54, 2);
Insert Into Service_Water (id, fecha_Corte, fecha_Emision, fecha_Max_Pago, observacion, monto_intereses, monto_mora, tiene_intereses, tiene_mora, valor_minimo, valor_total, contrato_id)
values (4, '2022-08-15', '2022-09-01', '2022-09-10', 'PAGO DEL AGUA DEL MES DE AGOSTO', 5.25, 1.48, TRUE, TRUE, 19, 28.34, 3);
Insert Into Service_Water (id, fecha_Corte, fecha_Emision, fecha_Max_Pago, observacion, monto_intereses, monto_mora, tiene_intereses, tiene_mora, valor_minimo, valor_total, contrato_id)
values (5, '2022-09-15', '2022-10-01', '2022-10-10', 'PAGO DEL AGUA DEL MES DE SEPTIEMBRE', 2.64, 0.70, TRUE, TRUE, 32, 45.50, 3);
Insert Into Service_Water (id, fecha_Corte, fecha_Emision, fecha_Max_Pago, observacion, monto_intereses, monto_mora, tiene_intereses, tiene_mora, valor_minimo, valor_total, contrato_id)
values (6, '2022-10-15', '2022-11-01', '2022-11-10', 'PAGO DEL AGUA DEL MES DE OCTUBRE', 0.0, 0.0, FALSE, FALSE, 31, 48.50, 3);
Insert Into Service_Water (id, fecha_Corte, fecha_Emision, fecha_Max_Pago, observacion, monto_intereses, monto_mora, tiene_intereses, tiene_mora, valor_minimo, valor_total, contrato_id)
values (7, '2022-10-15', '2022-11-01', '2022-11-10', 'PAGO DEL AGUA DEL MES DE OCTUBRE', 0.0, 0.0, FALSE, FALSE, 42, 50.45, 4);
