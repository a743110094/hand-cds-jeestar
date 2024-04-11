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
    type          varchar(20) default '����'    null comment '����/���',
    status        varchar(5)  default '��ʼ��'  null comment '��ʼ��/��ҵ��/��ȡ��/�����',
    qty           int                           null,
    warehouse     varchar(10)                    null comment '�ֿ�����',
    sub_inventory varchar(10)                    null comment '�ӿ�����',
    lot           varchar(10)                    null comment '��λ����',
    unit          varchar(4)  default '��'      null,
    origin        varchar(20) default '����̡'  null,
    created_time  timestamp   default curtime() not null,
    created_by    varchar(50) default 'system'  null,
    updated_time  timestamp   default curtime() not null,
    updated_by    varchar(50) default 'system'  null
)
    comment '�������';

