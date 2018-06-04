insert into plan(plan_code, plan_name) values ('1S','one stream');
insert into plan(plan_code, plan_name) values ('2S','two stream');
insert into plan(plan_code, plan_name) values ('4S','four stream');

insert into country(country_code, country_name) values ('1', 'USA');
insert into country(country_code, country_name) values ('81', 'Japan');
insert into country(country_code, country_name) values ('91', 'India');
insert into country(country_code, country_name) values ('44', 'UK');

insert into price_info(plan_code, country_code, price, effective_date, status, rollout_status) values ('1S','1',9.99, current_timestamp, 'ACTIVE', 'COMPLETE');
insert into price_info(plan_code, country_code, price, effective_date, status, rollout_status) values ('2S','1',11.99, current_timestamp, 'ACTIVE', 'COMPLETE');
insert into price_info(plan_code, country_code, price, effective_date,  status, rollout_status) values ('1S','44',11.99, current_timestamp, 'ACTIVE', 'COMPLETE');
insert into price_info(plan_code, country_code, price, effective_date, status, rollout_status) values ('2S','44',14.99, current_timestamp, 'ACTIVE', 'COMPLETE');

select PRICE_INFO_SEQUENCE_ID.nextval;
select PRICE_INFO_SEQUENCE_ID.nextval;
select PRICE_INFO_SEQUENCE_ID.nextval;
select PRICE_INFO_SEQUENCE_ID.nextval;
select PRICE_INFO_SEQUENCE_ID.nextval;


insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status)
values ('sangeetha@demo.com','Sangeetha','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',
current_timestamp, current_timestamp, 'ACTIVE');

insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status)
values ('kumar@demo.com','Kumar','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',
current_timestamp, current_timestamp, 'ACTIVE');

insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status)
values ('tarun@demo.com','Tarun','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',
current_timestamp, current_timestamp, 'ACTIVE');

insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status)
values ('thuy@demo.com','Thuy','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',
current_timestamp, current_timestamp, 'ACTIVE');

insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status)
values ('alex@demo.com','Alex','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',
current_timestamp, current_timestamp, 'ACTIVE');

insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status)
values ('jerry@demo.com','Jerry','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',
current_timestamp, current_timestamp, 'ACTIVE');

insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status)
values ('bala@demo.com','Bala','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',
current_timestamp, current_timestamp, 'ACTIVE');

insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status)
values ('monika@demo.com','Monika','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',
current_timestamp, current_timestamp, 'ACTIVE');

commit;



