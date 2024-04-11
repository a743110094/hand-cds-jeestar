create user cds@'%' identified by 'cds';
create user cds@'localhost' identified by 'cds';
create database cds_wms;
use cds_wms;
grant all on cds_wms.* to cds@'%';
grant all on cds_wms.* to cds@'localhost';
create table cds_wms.deliver_tasks
(
    id            bigint                        not null
        primary key,
    name          varchar(50)                   null,
    no            varchar(20)                   null,
    type          varchar(20) default '出库'    null comment '出库/入库',
    status        varchar(5)  default '初始化'  null comment '初始化/作业中/已取消/已完成',
    qty           int                           null,
    warehouse     varchar(10)                    null comment '仓库名称',
    sub_inventory varchar(10)                    null comment '子库名称',
    lot           varchar(10)                    null comment '货位名称',
    unit          varchar(4)  default '件'      null,
    origin        varchar(20) default '集星獭'  null,
    created_time  timestamp   default curtime() not null,
    created_by    varchar(50) default 'system'  null,
    updated_time  timestamp   default curtime() not null,
    updated_by    varchar(50) default 'system'  null
)
    comment '拣货任务';

