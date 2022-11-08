
insert into service_partner (id, code, name, status, date_starting, date_stopping, detail) values (1, 'S0001', 'Service Water', 'A', '2022-01-01', '2030-12-31', 'Service water details....');
insert into service_partner (id, code, name, status, date_starting, date_stopping, detail) values (2, 'S0002', 'DirecTV', 'A', '2022-01-01', '2030-12-31', 'DirecTV details...');


insert into api_detail (id, type, partner_id, method, uri, body) values  (1, 'AMMOUNT', 1, 'GET', 'http://localhost:8005/api/consulta_agua/cliente/{{dni}}', '');
insert into api_detail (id, type, partner_id, method, uri, body) values  (2, 'AMMOUNT', 1, 'GET', 'http://localhost:8005/api/consulta_agua/contrato/{{contract}}', '');
insert into api_detail (id, type, partner_id, method, uri, body) values  (3, 'CONTRACT', 1, 'GET', 'http://localhost:8005/api/contratos/cliente/{{dni}}', '');

insert into api_detail (id, type, partner_id, method, uri, body) values  (4, 'AMMOUNT', 2, 'POST', 'http://localhost:8004/servicio_api/cliente', '{  "cli_dni": "{{dni}}" }');
insert into api_detail (id, type, partner_id, method, uri, body) values  (5, 'PROMOTION', 2, 'GET', 'http://localhost:8004/servicio_api/promocion/{{date}}', '');




