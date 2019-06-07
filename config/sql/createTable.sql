use test;

CREATE TABLE `orders_`
(
    `order_id`   int      NOT NULL COMMENT '订单号',
    `user_id`    int      NOT NULL COMMENT '用户id',
    `createTime` datetime NOT NULL COMMENT '下单时间',
    `note`       varchar(100) DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`order_id`),
    KEY `FK_orders_1` (`user_id`),
    CONSTRAINT `FK_orders_id` FOREIGN KEY (`user_id`) REFERENCES `user_` (`id`)
        ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;

CREATE TABLE `user_`
(
    `id`       int         NOT NULL AUTO_INCREMENT COMMENT '用户id',
    `username` varchar(32) NOT NULL COMMENT '用户名称',
    `birthday` date         DEFAULT NULL COMMENT '用户生日',
    `sex`      char(1)      DEFAULT NULL COMMENT '性别',
    `address`  varchar(256) DEFAULT NULL COMMENT '地址',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10001
  DEFAULT CHARSET = UTF8;

CREATE TABLE `items_`
(
    `item_id`     int            NOT NULL AUTO_INCREMENT COMMENT '商品id',
    `item_name`   varchar(32)    NOT NULL COMMENT '商品名',
    `item_price`  decimal(10, 1) NOT NULL COMMENT '商品单价',
    `item_detail` text COMMENT '商品描述',
    `item_pic`    varchar(64) DEFAULT NULL COMMENT '商品图片',
    `createTime`  datetime       NOT NULL COMMENT '生产时间',
    PRIMARY KEY (`item_id`),
    UNIQUE (`item_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1000000001
  DEFAULT CHARSET = UTF8;

CREATE TABLE `orderdetail_`
(
    `id`            int NOT NULL AUTO_INCREMENT,
    `orders_id`      int NOT NULL COMMENT '订单id',
    `items_id`       int NOT NULL COMMENT '商品id',
    `items_quantity` int NOT NULL COMMENT '商品数量',
    PRIMARY KEY (`id`),
    KEY `FK_orderdetail_1` (`orders_id`),
    KEY `FK_orderdetail_2` (`items_id`),
    CONSTRAINT `FK_orderdetail_1` FOREIGN KEY (`orders_id`) REFERENCES `orders_` (`order_id`) ON
        DELETE
        NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `FK_orderdetail_2` FOREIGN KEY (`items_id`) REFERENCES `items_` (`item_id`) ON
        DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;



