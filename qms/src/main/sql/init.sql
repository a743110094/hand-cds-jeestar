create user cds@'%' identified by 'cds';
create user cds@'localhost' identified by 'cds';
create database cds_qms;
use cds_qms;
grant all on cds_qms.* to cds@'%';
grant all on cds_qms.* to cds@'localhost';
create table cds_qms.inspection_tasks
(
    id           bigint                         not null
        primary key,
    name         varchar(50)                    null,
    no           varchar(20)                    null,
    type         varchar(20) default '出库质检' null,
    status       varchar(5)  default '初始化'   null,
    qty          int                            null,
    pass_qty     int                            null,
    reject_qty   int                            null,
    unit         varchar(4)  default '件'       null,
    origin       varchar(20) default '集星獭'   null,
    created_time timestamp   default curtime()  not null,
    created_by   varchar(50) default 'system'   null,
    updated_time timestamp   default curtime()  not null,
    updated_by   varchar(50) default 'system'   null
)
    comment '质检任务';

