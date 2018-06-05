insert into plan(plan_code, plan_name) values ('1S','one stream');
insert into plan(plan_code, plan_name) values ('2S','two stream');
insert into plan(plan_code, plan_name) values ('4S','four stream');

insert into country(country_code, country_name) values ('1', 'USA');
insert into country(country_code, country_name) values ('81', 'Japan');
insert into country(country_code, country_name) values ('91', 'India');
insert into country(country_code, country_name) values ('44', 'UK');

insert into price_info(plan_code, country_code, price, effective_date, status, rollout_status) values ('1S','1',9.99, current_date, 'ACTIVE', 'COMPLETE');
insert into price_info(plan_code, country_code, price, effective_date, status, rollout_status) values ('2S','1',10.99, current_date, 'ACTIVE', 'COMPLETE');
insert into price_info(plan_code, country_code, price, effective_date, status, rollout_status) values ('4S','1',11.99, current_date, 'ACTIVE', 'COMPLETE');
insert into price_info(plan_code, country_code, price, effective_date,  status, rollout_status) values ('1S','44',21, current_date, 'ACTIVE', 'COMPLETE');
insert into price_info(plan_code, country_code, price, effective_date, status, rollout_status) values ('2S','44',22, current_date, 'ACTIVE', 'COMPLETE');
insert into price_info(plan_code, country_code, price, effective_date, status, rollout_status) values ('2S','44',24, current_date, 'ACTIVE', 'COMPLETE');

select PRICE_INFO_SEQUENCE_ID.nextval;
select PRICE_INFO_SEQUENCE_ID.nextval;
select PRICE_INFO_SEQUENCE_ID.nextval;
select PRICE_INFO_SEQUENCE_ID.nextval;
select PRICE_INFO_SEQUENCE_ID.nextval;
select PRICE_INFO_SEQUENCE_ID.nextval;
select PRICE_INFO_SEQUENCE_ID.nextval;


insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan1_cust1@sample.com','us_plan1_cust1','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',current_date, dateadd('DAY',30,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan1_cust2@sample.com','us_plan1_cust2','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',current_date, dateadd('DAY',30,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan1_cust3@sample.com','us_plan1_cust3','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',current_date, dateadd('DAY',30,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan1_cust4@sample.com','us_plan1_cust4','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',current_date, dateadd('DAY',30,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan1_cust5@sample.com','us_plan1_cust5','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',current_date, dateadd('DAY',30,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan1_cust6@sample.com','us_plan1_cust6','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',current_date, dateadd('DAY',30,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan1_cust7@sample.com','us_plan1_cust7','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',current_date, dateadd('DAY',30,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan1_cust8@sample.com','us_plan1_cust8','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',current_date, dateadd('DAY',30,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan1_cust9@sample.com','us_plan1_cust9','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',current_date, dateadd('DAY',28,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan1_cust10@sample.com','us_plan1_cust10','1S', '1', 
select price_id from price_info where plan_code='1S' and country_code='1',current_date, dateadd('DAY',32,current_date), 'ACTIVE');


insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan2_cust1@sample.com','us_plan2_cust1','2S', '1', 
select price_id from price_info where plan_code='2S' and country_code='1',current_date, dateadd('DAY',30,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan2_cust2@sample.com','us_plan2_cust2','2S', '1', 
select price_id from price_info where plan_code='2S' and country_code='1',current_date, dateadd('DAY',30,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan2_cust3@sample.com','us_plan2_cust3','2S', '1', 
select price_id from price_info where plan_code='2S' and country_code='1',current_date, dateadd('DAY',32,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan2_cust4@sample.com','us_plan2_cust4','2S', '1', 
select price_id from price_info where plan_code='2S' and country_code='1',current_date, dateadd('DAY',28,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan2_cust5@sample.com','us_plan2_cust5','2S', '1', 
select price_id from price_info where plan_code='2S' and country_code='1',current_date, dateadd('DAY',28,current_date), 'ACTIVE');



insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan4_cust1@sample.com','us_plan4_cust1','4S', '1', 
select price_id from price_info where plan_code='4S' and country_code='1',current_date, dateadd('DAY',30,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan4_cust2@sample.com','us_plan4_cust2','4S', '1', 
select price_id from price_info where plan_code='4S' and country_code='1',current_date, dateadd('DAY',28,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan4_cust3@sample.com','us_plan4_cust3','4S', '1', 
select price_id from price_info where plan_code='4S' and country_code='1',current_date, dateadd('DAY',28,current_date), 'ACTIVE');
insert into customer(email, customer_name, plan_code, country_code, price_id, onboard_date, next_billdate, status) values (
'us_plan4_cust4@sample.com','us_plan4_cust4','4S', '1', 
select price_id from price_info where plan_code='4S' and country_code='1',current_date, dateadd('DAY',32,current_date), 'ACTIVE');



commit;



