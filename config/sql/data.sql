INSERT INTO `items_` (item_id, item_name, item_price, item_detail, item_pic, createTime)
VALUES (1000001, '台式机', 3000.0, '该电脑质量很好', NULL, '2019-06-01 13:22:33'),
       (1000002, '笔记本', 5000.0, '该笔记本续航很给力', NULL, '2019-06-01 13:23:21'),
       (1000003, '电脑包', 200.0, '容量大，背感舒适', NULL, '2019-06-01 13:24:11');

INSERT INTO `user_` (id, username, birthday, sex, address)
VALUES (1, '王五', '1995-01-02', '男', NULL),
       (2, '张三', '1995-04-20', '男', NULL),
       (3, '李四', '1996-03-21', '男', NULL),
       (4, '陈梅', '1994-09-30', '女', NULL),
       (5, '马冬梅', '1996-10-10', '女', NULL),
       (6, '张婷婷', '1996-02-14', '女', NULL);

insert into `orders_` (user_id, order_id, createTime, note)
values (1, '1000010', '2015-02-04 13:22:35', NULL),
       (1, '1000011', '2015-02-03 13:22:41', NULL),
       (6, '1000012', '2015-02-12 16:13:23', NULL);

INSERT INTO `orderdetail_` (orders_id, items_id, items_quantity)
VALUES (1000010, 1000001, 1),
       (1000010, 1000002, 3),
       (1000011, 1000003, 4),
       (1000012, 1000002, 3);
