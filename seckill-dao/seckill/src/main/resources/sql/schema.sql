-- 数据库初始化脚本
--创建数据库
create DATABASE seckill;
--使用数据库
use seckill;
--创建秒杀表
CREATE TABLE seckill(
`seckill_id` BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
`name` VARCHAR(120) NOT null COMMENT '商品名称',
`number` INT NOT NULL COMMENT '库存数量',
`start_time` TIMESTAMP NULL DEFAULT NULL COMMENT '秒杀开始时间',
`end_time` TIMESTAMP NULL DEFAULT NULL COMMENT '秒杀结束时间',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)ENGINE=INNODB AUTO_INCREMENT=1000 CHARSET=utf8 COMMENT '秒杀库存表'
--初始化数据
INSERT INTO seckill(name,number,start_time,end_time)
VALUES('99元秒杀大沙发100',100,'2018-11-07 00:00:00','2018-11-08 00:00:00'),
('1元秒杀iphone99',10,'2018-11-08 00:00:00','2018-11-09 00:00:00'),
('888元秒杀华硕飞行堡垒',111,'2018-11-09 00:00:00','2018-11-10 00:00:00'),
('1000元秒杀荣耀100',10,'2018-11-06 00:00:00','2018-11-07 00:00:00')

-- 秒杀成功明细表
CREATE TABLE success_killed(
`seckill_id` BIGINT NOT NULL COMMENT '秒杀商品id',
`user_phone` BIGINT NOT NULL COMMENT '用户手机号',
`state` TINYINT NOT NULL DEFAULT -1 COMMENT '状态显示：-1：无效 0：成功 1：已付款',
`create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
-- 联合主键
PRIMARY KEY (seckill_id,user_phone),
KEY idx_create_time(create_time)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '秒杀成功明细表';
-- 用户登录认证相关表
