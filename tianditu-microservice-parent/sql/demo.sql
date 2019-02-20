
ALTER TABLE `t_device_alarm_record`
ADD COLUMN `unique_key`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '告警唯一性判断' AFTER `create_time`;

update t_device_alarm_record set unique_key = md5 (concat(device_id,alarm_message,alarm_time)) where id > 10 ;

/** 请重复执行下面一条语句直到影响行数为0为止 **/
delete from t_device_alarm_record where id in (select id from (select id, unique_key, count(unique_key) as cnt from t_device_alarm_record group by unique_key) a
where a.cnt > 1 order by cnt desc);


ALTER TABLE `t_device_alarm_record`
ADD UNIQUE INDEX `uk_record` (`unique_key`) USING BTREE COMMENT '告警记录唯一记录标识';