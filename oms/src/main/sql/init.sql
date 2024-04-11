create user cds@'%' identified by 'cds';
create user cds@'localhost' identified by 'cds';
create database cds_oms;
use cds_oms;
grant all on cds_oms.* to cds@'%';
grant all on cds_oms.* to cds@'localhost' ;
create table cds_oms.mallOrder
(
    id           bigint primary key,
    name         varchar(50),
    no           varchar(20),
    origin       varchar(20) default '集星獭',
    created_time timestamp   default CURRENT_TIME,
    created_by   varchar(50) default 'system',
    updated_time timestamp   default CURRENT_TIME,
    updated_by   varchar(50) default 'system'
)