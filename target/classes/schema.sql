CREATE TABLE PLAN (
    PLAN_CODE VARCHAR(64) NOT NULL,
    PLAN_NAME VARCHAR(255) NOT NULL
);

CREATE TABLE COUNTRY (
    COUNTRY_CODE VARCHAR(64) NOT NULL PRIMARY KEY,
    COUNTRY_NAME VARCHAR(255) NOT NULL
);

CREATE TABLE PRICE_INFO (
    PRICE_ID BIGINT(19) NOT NULL AUTO_INCREMENT,
    PLAN_CODE VARCHAR(64) NOT NULL,
    COUNTRY_CODE VARCHAR(64) NOT NULL REFERENCES COUNTRY(COUNTRY_CODE),
    PRICE DECIMAL(10,2),
    EFFECTIVE_DATE TIMESTAMP NULL,
    STATUS VARCHAR2(64),
    ROLLOUT_STATUS VARCHAR2(64)
);

CREATE SEQUENCE PRICE_INFO_SEQUENCE_ID START WITH (select max(PRICE_ID) + 1 from PRICE_INFO);

CREATE TABLE CUSTOMER (
    EMAIL VARCHAR(255) NOT NULL,
    CUSTOMER_NAME VARCHAR(255) NOT NULL,
    PLAN_CODE VARCHAR(64) NOT NULL,
    COUNTRY_CODE VARCHAR(64) NOT NULL,
    PRICE_ID BIGINT(19) NOT NULL REFERENCES PRICE_INFO(PRICE_ID),
    ONBOARD_DATE TIMESTAMP NOT NULL,
    NEXT_BILLDATE TIMESTAMP NOT NULL,
    STATUS VARCHAR(64) NOT NULL
);