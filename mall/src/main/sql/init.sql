create user cds@'%' identified by 'cds';
create user cds@'localhost' identified by 'cds';
create database cds_mall;
use cds_mall;
grant all on cds_mall.* to cds@'%';
grant all on cds_mall.* to cds@'localhost';
create table cds_mall.mall_order
(
    id            bigint                           not null
        primary key,
    no            varchar(20)                      null,
    store_name    varchar(20) default '官方自营店' null comment '店铺名称',
    origin        varchar(20) default '手动创建',
    status        varchar(20) default '待发货' comment '待支付/待发货/运输中/已签收',
    item_qty      int4        default 1 comment '商品数量',
    customer_name varchar(20) comment '客户名称',
    express_no    varchar(20) comment '物流单号',
    pay_type      varchar(20) default '支付宝' comment '支付方式',
    delivery_time timestamp comment '发货时间',
    receipt_time  timestamp comment '收货时间',
    created_time  timestamp   default curtime()    not null,
    created_by    varchar(50) default 'system'     null,
    updated_time  timestamp   default curtime()    not null,
    updated_by    varchar(50) default 'system'     null
)
    comment '商城订单';

