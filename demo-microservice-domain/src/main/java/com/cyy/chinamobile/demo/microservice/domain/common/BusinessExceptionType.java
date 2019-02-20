package com.cyy.chinamobile.demo.microservice.domain.common;

public enum BusinessExceptionType {
	
	NULL_ARGUMENT("001", "XXX参数不能为NULL"),
	NOT_EXIST_IN_MYSQL("002", "数据库中不存在相应数据"), 
	NOT_EXIST_IN_REDIS("003", "redis中数据不存在"),
	DEVICE_BIND_EXCEPTION("004", "设备绑定异常"), 
	MICROSERVICE_EXCEPTION("005", "调用微服务异常"), 
	INCOMPLETE_DATA_IN_MYSQL("006", "数据库中数据不完整"),
	REMOTE_SERVER_EXCEPTION("007", "远程服务器异常"), 
	FILE_NOT_EXIST("008", "服务器上不存在对应文件"), 
	ONE_NET_REGISTER_EXCEPTION("009", "oneNet注册异常"),
	HEDGW_EXCEPTION("010", "调用网关异常"), 
	ILLEGAL_ARGUMENT_EXCEPTION("011", "参数非法异常"), 
	EXPIRED_DATA_IN_REDIS("012", "redis中数据过期"),
	ZOOKEEPER_STRATEGY_EXCEPTION("013", "zookeeper策略工厂获取数据异常"),
	USER_AUTH_EXCEPTION("014", "用户认证异常"),
	DICTIONARY_OPERATE_EXCEPTION("015", "字典查询异常"),
	CLOUD_STORAFE_NOT_EXIST("016", "云回放录像不存在或已被删除"),
	LOCAL_REPLAY_EXCEPTION("017", "有其他人正在使用本地回放"),
	FILE_UPLOAD_DOWN_EXCEPTION("018", "文件上传/下载失败"),
	;
	
	private String key;
	
	private String value;
	
	private BusinessExceptionType(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return "[" + this.key + "]  ";
	}

	public String getValue() {
		return value;
	}
	
	@Override
    public String toString() {
        return "[" + this.key + "]  " + this.value;
    }
}
