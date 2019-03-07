package com.cyy.chinamobile.tianditu.microservice.domain.common;

/**
 * 常量
 */
public interface CodeConstants {

    // 系统内部常量
    public interface SYSTEM_INTER_CONSTATNTS {
        public static final String NULL = "";
        public static final String CODE = "code";
        public static final String DISTRICT = "district";

        public static final String PROVINCE = "province";
        public static final String CITY = "city";
        public static final String AREA = "area";
        public static final String STREET = "street";
        public static final String PROVINCE_CODE = "provinceCode";
        public static final String CITY_CODE = "cityCode";
        public static final String AREA_CODE = "areaCode";
        public static final String STREET_CODE = "streetCode";
//        public static final String LOCAL_SITE_URL = "D:\\work\\ctu.chinamobile.com\\tianditu\\Html\\";
        public static final String LOCAL_SITE_URL = "http://192.168.160.130:2011/";
        public static final String HTML = ".html";

        public static final int FULLY_DELETION_ID = 0;

        // 设备注册的userToken分隔符
        public static final String DEVICE_REGISTER_USER_TOKEN_DELIMITER = "-";

        // 应用名称
        public static final String APPLICATION_NAME = "和守屋";

        // ios的AppStore的应用
        public static final Integer IOS_APP_STORE = 1;

        // ios的非AppStore的应用
        public static final Integer IOS_NOT_APP_STORE = 0;

        // 推送消息到第三方平台标识
        public static final Integer PUSH_MSG_TO_THIRD_PLATFORM_FLAG_YES = 1;

        // 不推送消息到第三方平台标识
        public static final Integer PUSH_MSG_THIRD_PLATFORM_FLAG_NO = 0;
    }

    // openAPI 消息类型
    public interface OPEN_API_MSG_TYPE {

        // TD注册
        // Wi-Fi连接方式
        public static final String TD_REGISTER_REQ = "MSG_P_THD_ADD_CAMERA_REQ";
        public static final String TD_REGISTER_REP = "MSG_P_THD_ADD_CAMERA_RSP";

        // 4G/有线连接方式
        public static final String TD_4G_OR_WIRED_REGISTER_REQ = "MSG_P_THD_4G_OR_WIRED_ADD_CAMERA_REQ";
        public static final String TD_4G_OR_WIRED_REGISTER_REP = "MSG_P_THD_4G_OR_WIRED_ADD_CAMERA_RSP";

        // 获取HEDGW服务
        public static final String GET_HEDGW_SERVICE_REQ = "MSG_P_THD_GET_CAMERA_CHN_ADDR_REQ";
        public static final String GET_HEDGW_SERVICE_REP = "MSG_P_THD_GET_CAMERA_CHN_ADDR_RSP";

        // 获取在线配置
        public static final String GET_ONLINE_CONF_REQ = "MSG_P_THD_GET_CAMERA_SETTINGS_REQ";
        public static final String GET_ONLINE_CONF_REP = "MSG_P_THD_GET_CAMERA_SETTINGS_RSP";

        // 更新在线配置
        public static final String MODIFY_ONLINE_CONF_REQ = "MSG_P_THD_SET_CAMERA_SETTINGS_REQ";
        public static final String MODIFY_ONLINE_CONF_REP = "MSG_P_THD_SET_CAMERA_SETTINGS_RSP";

        // 更新TD信息
        public static final String MODIFY_TD_MSG_REQ = "MSG_P_THD_SET_CAMERA_INFO_REQ";
        public static final String MODIFY_TD_MSG_REP = "MSG_P_THD_SET_CAMERA_INFO_RSP";

        // TD推送报警
        public static final String PUSH_NOTIFICATION_REQ = "MSG_P_PUSH_NOTIFICATION_REQ";
        public static final String PUSH_NOTIFICATION_RSP = "MSG_P_PUSH_NOTIFICATION_RSP";

    }

    // OpenAPI redis key前缀类型
    public interface OPENAPI_REDIS_KEY_PREFIX_TYPE {

        // OpenAPI TD注册userToken前缀
        public static final String OPENAPI_TD_REGISTER_USERTOKEN_PREFIX = "openApiTdRegisterUserToken_";
        // deviceToken前缀
        public static final String OPENAPI_DEVICE_TOKEN_PREFIX = "openApiDeviceToken_";

        // unifiedId前缀
        public static final String OPENAPI_UNIFIED_ID_PREFIX = "openApiUnifiedIdToken_";
    }

    // OPENAPI redis key失效时间
    public interface OPENAPI_REDIS_KEY_EXPIRE_TIMES {

        // OPENAPI的token KEY失效分钟数
        public static final int OPENAPI_USER_TOKEN_EXPIRE_MINUTES = 30;
    }

    // APP redis key前缀类型
    public interface APP_REDIS_KEY_PREFIX_TYPE {

        // 登录用户名盐值前缀
        public static final String APP_LOGIN_USER_CHANNEL_PREFIX = "appLoginUserChannel_";

        // 登录用户名盐值前缀
        public static final String APP_LOGIN_NAME_SALT_PREFIX = "appLoginNameSalt_";

        // 登录用户ID的token前缀
        public static final String APP_LOGIN_USER_ID_TOKEN_PREFIX = "appLoginUserIdToken_";

        // 手机号码短信验证码前缀
        public static final String APP_CELLPHONE_MESSAGE_CODE_PREFIX = "appCellphoneMessageCode_";

        // 华为推送前缀
        public static final String APP_HUAWEI_PUSH_PREFIX = "appHuaWeiPush_";

        // 华为推送前缀
        public static final String IOS_PLATFORM_TYPE_PREFIX = "iosPlatformType_";
    }

    // web redis key前缀类型
    public interface WEB_REDIS_KEY_PREFIX_TYPE {

        // 登录用户名盐值前缀
        public static final String WEB_LOGIN_NAME_SALT_PREFIX = "webLoginNameSalt_";

        // 登录用户ID的token前缀
        public static final String WEB_LOGIN_USER_ID_TOKEN_PREFIX = "webLoginUserIdToken_";

        // 登录用户ID重置token失效时间次数前缀
        public static final String WEB_LOGIN_USER_ID_TOKEN_COUNT_PREFIX = "webLoginUserIdTokenCount_";

        // 手机号码短信验证码前缀
        public static final String WEB_CELLPHONE_MESSAGE_CODE_PREFIX = "webCellphoneMessageCode_";

        // 图片验证码前缀
        public static final String WEB_IMAGE_VALIDATION_CODE_PREFIX = "webImageValidationCode_";
    }

    // APP redis key失效时间
    public interface APP_REDIS_KEY_EXPIRE_TIMES {

        // 登录用户ID的token KEY失效分钟数
        public static final int APP_LOGIN_USER_ID_TOKEN_EXPIRE_MINUTES = 60 * 24 * 15;

        // 登录用户名盐值 KEY失效分钟数
        public static final int APP_LOGIN_NAME_SALT_EXPIRE_MINUTES = 30;

        // 注册用户验证码KEY失效分钟数
        public static final int APP_CELLPHONE_MESSAGE_CODE_EXPIRE_MINUTES = 5;

        // 华为设备token KEY失效分钟数
        public static final int APP_HUAWEI_DEVICE_TOKEN_EXPIRE_MINUTES = 60 * 24 * 15;
    }

    // WEB redis key失效时间
    public interface WEB_REDIS_KEY_EXPIRE_TIMES {

        // 登录用户ID的token KEY失效分钟数
        public static final int WEB_LOGIN_USER_ID_TOKEN_EXPIRE_MINUTES = 30;

        // 登录用户名盐值 KEY失效分钟数
        public static final int WEB_LOGIN_NAME_SALT_EXPIRE_MINUTES = 30;

        // 注册用户验证码KEY失效分钟数
        public static final int WEB_CELLPHONE_MESSAGE_CODE_EXPIRE_MINUTES = 5;
    }

    // 登录前缀类型
    public interface LOGIN_REDIS_KEY_PREFIX_TYPE {

        // 登录用户ID的token前缀
        public static final String LOGIN_USER_ID_TOKEN_PREFIX = "LoginUserIdToken_";

        // sdk登录用户ID的token KEY失效分钟数
        public static final int SDK_LOGIN_USER_ID_TOKEN_EXPIRE_MINUTES = 60 * 24 * 15;

    }

    // 流媒体和云台控制redis key 前缀
    public interface HEDGW_STREAMCLOUD_CONTROL_REDIS_KEY_PREFIX {

        // 推流地址
        public static final String PUSH_URL = "pushUrl_";

        // 取流地址
        public static final String FETCH_URL = "fetchUrl_";

        // 客户端取流URL(首次)失效分钟数
        public static final int FETCH_URL_FIRST_EXPIRE_MINUTE = 5;

        // 客户端取流URL(开始播放)失效小时数
        public static final int FETCH_URL_ON_PLAY_EXPIRE_MINUTES = 60 * 24;

        // HEDGW推流失效分钟数
        public static final int PUSH_URL_EXPIRE_MINUTE = 5;

        // 客户端推流 key首次失效分钟数
        public static final int CLIENT_PUSH_URL_FIRST_EXPIRE_MINUTE = 1;

        // 客户端推流 key(流发布)失效分钟数
        public static final int CLIENT_PUSH_URL_PUBLISH_EXPIRE_MINUTES = 60;

        // HEDGW取流失效分钟数
        public static final int HEDGW_FTECH_URL_EXPIRE_MINUTE = 5;

        // 取流ClientId前缀
        public static final String FETCH_CLIENT_ID_TOKEN = "fetchClientIdToken_";

        // 推流ClientId前缀
        public static final String PUSH_CLIENT_ID_TOKEN = "pushClientIdToken_";

        // (客户端)取流clientId失效分钟数
        public static final int CLIENT_FETCH_CLIENT_ID_TOKEN_EXPIRE_MINUTES = 60 * 24;

        // (HEDGW)取流clientId失效分钟数
        public static final int HEDGW_FETCH_CLIENT_ID_TOKEN_EXPIRE_MINUTES = 60;

        // 取流clientId失效分钟数
        public static final int FETCH_CLIENT_ID_TOKEN_EXPIRE_MINUTES = 60;

        // (客户端)推流clientId失效分钟数
        public static final int CLIENT_PUSH_CLIENT_ID_TOKEN_EXPIRE_MINUTES = 60 * 24;

        // (HEDGW)推流clientId失效分钟数
        public static final int HEDGW_PUSH_CLIENT_ID_TOKEN_EXPIRE_MINUTES = 60;

        // 推流clientId失效分钟数
        public static final int PUSH_CLIENT_ID_TOKEN_EXPIRE_MINUTES = 60;

    }

    public interface HEDGW_STREAMCLOUD_CONTROL {
        // srs推流和取流流程动作
        public interface SRS_AUTH {
            // 连接到达
            public static final String ON_CONNECT = "on_connect";

            // 开始播放
            public static final String ON_PLAY = "on_play";

            // 停止播放
            public static final String ON_STOP = "on_stop";

            // 流发布
            public static final String ON_PUBLISH = "on_publish";

            // 流取消发布
            public static final String ON_UNPUBLISH = "on_unpublish";

            // 连接断开
            public static final String ON_CLOSE = "on_close";

            // 不鉴权token
            public static final String NO_AUTH_TOKEN = "efa24a65b2dc819caacdcc65";

        }
    }

    // 流媒体和云台控制消息类型
    public interface HEDGW_STREAMCLOUD_CONTROL_MSGCONTENT_REQUEST {

        public static final String MSG_PUSH_STREAM_REQ = "MSG_PUSH_STREAM_REQ";

        public static final String MSG_CONTROL_PTZ_REQ = "MSG_CONTROL_PTZ_REQ";

        public static final String MSG_STOP_PUSH_STREAM_REQ = "MSG_STOP_PUSH_STREAM_REQ";

        public static final String MSG_DEV_ONLINE_STATUS_NOTIFY = "MSG_DEV_ONLINE_STATUS_NOTIFY";

        public static final String MSG_TALKBACK_REQ = "MSG_TALKBACK_REQ";

        public static final String MSG_SEARCH_RECORDFILE_REQ = "MSG_SEARCH_RECORDFILE_REQ";

        public static final String MSG_PLAY_BACK_REQ = "MSG_PLAY_BACK_REQ";

        public static final String MSG_PLAY_BACK_CTRL_REQ = "MSG_PLAY_BACK_CTRL_REQ";

        public static final String MSG_DEV_GET_CONFIG_REQ = "MSG_DEV_GET_CONFIG_REQ";

        public static final String MSG_CLOUD_STORAGE_DELFILE_REQ = "MSG_CLOUD_STORAGE_DELFILE_REQ";

        public static final String MSG_CLOUD_STORAGE_DOWNLOAD_REQ = "MSG_CLOUD_STORAGE_DOWNLOAD_REQ";
    }

    public interface REQ_HEDGW {

        //
        public interface DEV_SET_CONFIG {
            public static final String MSG_DEV_SET_CONFIG_REQ = "MSG_DEV_SET_CONFIG_REQ";

            public static final Integer CONFIG_NO_DORMANCY = 1;

            public static final Integer CONFIG_NO_BODY_DETECTION = 2;

            public static final Integer CONFIG_NO_AUTO_ALARM_DURING = 3;

            public static final Integer SLEEPTAG_OFF = 0;

            public static final Integer SLEEPTAG_ON = 1;

            public static final String BODY_DETECTION_STATUS_OFF = "Off";

            public static final String BODY_DETECTION_STATUS_ON = "On";
        }

        // 设备ota升级参数
        public interface OTA_CONF {

            public static final String MSG_DEV_UPGRADE_REQ = "MSG_DEV_UPGRADE_REQ"; // ota升级设备网关请求标识

            public static final String DEV_UPGRADE_USER = "devUpgradeUser_"; // ota设备升级用户

            // 设备升级进度
            public static final String OTA_PREFIX = "deviceOtaUpgrade_";

            public static final Integer OTA_PREFIX_TIMEOUT_EXPIRE_HOURS = 24;

            public static final Integer OTA_PREFIX_EXPIRE_SECONDS = 120;

            public static final String DEV_OTA_STATUS = "devOtaStatus_";// ota 设备升级状态

            public static final Integer UPGRADE_STATUS_YES = 1;

            public static final Integer UPGRADE_STATUS_NO = 0;
        }
    }

    // APP 手机短信验证码类型
    public interface APP_MESSAGE_CODE_TYPE {

        // APP登录短信验证码
        public static final String APP_REGISTER_MESSAGE_CODT_TYPE = "1";

        // APP找回密码短信验证码
        public static final String APP_FIND_PWD_MESSAGE_CODT_TYPE = "2";
    }

    // WEB 手机短信验证码类型
    public interface WEB_MESSAGE_CODE_TYPE {

        // WEB登录短信验证码
        public static final String WEB_REGISTER_MESSAGE_CODT_TYPE = "3";

        // WEB找回密码短信验证码
        public static final String WEB_FIND_PWD_MESSAGE_CODT_TYPE = "4";
    }

    // 云台控制动作
    public interface CLOUD_CONTROL_ACTION {
        public static final int START = 1;// 云台开始转动

        public static final int STOP = 0;// 云台停止转动
    }

    // 请求视频流地址
    public interface OPEN_VIDEO {
        public static final int OPEN = 1;// 打开实时视频

        public static final int CLOSE = 0;// 关闭实时视频
    }

    // 录像文件存储方式
    public interface VIDEO_STORAGE_MODE {
        public static final int LOCAL_STORAGE = 0;

        public static final int ALICLOUD_STORAGE = 1;
    }

    // 设备配置类型
    public interface DEVICE_CONF_TYPE {

        // 存储信息查询
        public static final Integer QUERY_MEMORY_INFO = 1;
    }

    // 设备信息（redis）
    public interface REDIS_OF_DEVICE {

        // redis中设备号前缀
        public static final String DEV_PREFIX = "dev_";

        // redis中设备状态字段名
        public static final String DEV_LINK_STATUS = "link_status";

        // redis中设备电量key
        public static final String DEV_EL_STATUS = "electricity";

        // redis 设备状态过期时间戳
        public static final String DEV_TIMESTAMP = "timestamp";

    }

    // 环境配置
    public interface env_conf {

        // 开发环境
        public static final String DEV = "dev";

        // 测试环境
        public static final String TEST = "test";

        // 演示环境
        public static final String DEMO = "demo";

        // 现网环境
        public static final String PROD = "prod";

    }

    // 环境配置
    public interface server_env {

        // 阿里云服务器
        public static final String ALIYUN_SERVER = "aliyun";

        // 测试服务器
        public static final String TEST_SERVER = "c11";

        // 四川移动服务器
        public static final String SCYD_SERVER = "scyd";

        // 本地服务器
        public static final String LOCAL_SERVER = "local";

    }

    // 文件的content-type
    public interface FILE_CONTENT_TYPE {
        // 常见视频文件的content-type avi,wmv,mp4,flv,rmvb
        public static final String VIDEO_CONTENT_TYPE = "video/avi;video/x-ms-wmv;video/mpeg4;video/x-flv;application/vnd.rn-realmedia";

        // 常见图片文件的content-type bmp,png,gif,jpg
        public static final String IMAGE_CONTENT_TYPE = "application/x-bmp;image/png;application/x-png;image/gif;application/x-jpg;image/jpeg";

        // doc,xls文件的content-type
        public static final String DOCUMENT_CONTENT_TYPE = "application/msword;application/vnd.ms-excel;application/x-xls;application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    }

    // 告警来源
    public interface ALARM_CHANNEL {

        public static final int OPENAPI = 1;

        public static final int HEDGW = 2;

    }

    // 设备版本
    public interface DEVICE_VERSION {

        // 固件版本前缀
        public static final String FIRMWARE_VERSION = "FIRMWARE_VERSION ";

        // 推送极光状态
        public interface J_STATUS {

            public static final int NON = 0; // 未送达

            public static final int SUCCESS = 1; // 已送达

            public static final int FAIL = 2; // 发送失败

            public static final int UNNEED = 3; // 无需送达
        }
    }

    // zookeeper路径
    public interface ZK_PATH {

        public static final String BUSI_LOCK_PREFIX = "/demo/java/busi_lock/";

        public static final String SRS_LOAD = "/demo/srs/load";

        public static final String HEDGW_LOAD = "/demo/hedgw/load";

        public static final String AND_FAMILY_ACESS_TOKEN_LOCK = "/demo/java/andfamily/access_token_lock";
    }

    // 流媒体信息
    public interface SRS_NODE_INFO {

        public static final String DEVICE_BIND_SRS_PREFIX = "deviceBindSrs_"; // 直播时设备和srs绑定信息

    }

    // websocket推送
    public interface PUSH_WEB_SOCKET {
        // 读超时分钟数
        public static final int READ_TIMEOUT_MINUTE = 2;

        // 心跳超时次数限制
        public static final int HEARTBEAT_TIMEOUT_TIMES_LIMIT = 2;

        // 自定义心跳消息
        public static final String HEARTBEAT_MESSAGE = "{\"hb\":\"\"}";

    }

    // 系统字典配置
    public interface SYS_DICTIONARY {

        // 系统 通用状态
        public interface SYS_COMMON_STATUS {
            public static final Integer DICT_ID = 1;

            // 有效
            public static final String VALID = "1";

            // 无效
            public static final String INVALID = "0";
        }

        // 系统类型 APP和WEB后台
        public interface SYSTEM_TYPE {

            public static final Integer DICT_ID = 2;

            // APP后台
            public static final String APP = "1";

            // WEB后台
            public static final String WEB = "2";
        }

        // 短信发送模版ID
        public interface SEND_SMS_TEMP_ID {
            public static final Integer DICT_ID = 3;

            // 验证码
            public static final String VERIFICATION_CODE = "11006";

        }

        // 设备状态类型
        public interface DEVICE_STATUS {

            public static final Integer DICT_ID = 4;

            // 打开
            public static final String DEVICE_STATUS_ON = "On";

            // 关闭
            public static final String DEVICE_STATUS_OFF = "Off";
        }

        // 设备绑定方式
        public interface DEVICE_BIND_TYPE {

            public static final Integer DICT_ID = 5;

            // 设备扫手机二维码
            public static final String DEVICE_SCAN_MOBILE_QR_CODE = "1";

            // 手机扫设备二维码
            public static final String MOBILE_SCAN_DEVICE_QR_CODE = "2";

            // web端绑定
            public static final String WEB_SCAN_DEVICE_QR_CODE = "3";
        }

        // 设备状态类型
        public interface DEVICE_NET_STATUS {
            public static final Integer DICT_ID = 6;

            public static final String NORMAL = "0";

            public static final String SYSTEM_EXCEPTION = "2";

            public static final String NET_EXCEPTION = "1";
        }

        // 0-主码流，1-子码流，2-第三码流；如果是720p的摄像机对应高清，标清，流畅。如果是1080p的摄像机对应超高清，高清，流畅。目前默认摄像机为720p。
        public interface VIDEO_RESOLUTION {
            public static final Integer DICT_ID = 7;

            public static final String MAIN_CODE_STREAM = "0";// 主码流

            public static final String SUB_CODE_STREAM = "1";// 子码流

            public static final String THIRD_CODE_STREAM = "2";// 第三码流
        }

        // 设备网络状态
        public interface DEVICE_NETWORK_STATE {
            public static final Integer DICT_ID = 8;

            // 在线
            public static final String ON = "1";

            // 离线
            public static final String OFF = "0";
        }

        // 用户状态
        public interface USER_STATUS {

            public static final Integer DICT_ID = 9;

            // 有效
            public static final Integer VALID = 1;

            // 被冻结
            public static final Integer FREEZE = 0;
        }

        // 读标识
        public interface READ_FLAG {
            public static final Integer DICT_ID = 10;

            // 已读
            public static final String READ = "1";

            // 未读
            public static final String UNREAD = "0";
        }

        // 报警类型
        public interface ALARM_TYPE {
            public static final Integer DICT_ID = 11;

            // 移动侦测报警
            public static final String MOTION_DETECTION_ALARM = "1001";
        }

        // 报警配置类型
        public interface ALARM_CONF_TYPE {
            public static final Integer DICT_ID = 12;

            // 时间范围
            public static final String TIME = "1";
        }

        // 录像播放速度
        public interface PLAY_SPEED {
            public static final Integer DICT_ID = 13;

            // 正常播放
            public static final String NORMAL = "0";

            // 2倍速播放
            public static final String TWO_TIMES = "1";

            // 4倍速播放
            public static final String FOUR_TIMES = "2";

            // 8倍速播放
            public static final String EIGHT_TIMES = "3";

            // 16倍速播放
            public static final String SIXTEEN_TIMES = "4";
        }

        // 用户类型
        public interface USER_TYPE {
            public static final Integer DICT_ID = 14;

            // (个人或家庭)普通用户
            public static final Integer NORMAL_USER = 1;

            // 公司普通员工
            public static final Integer COMPANY_NORMAL_USER = 2;

            // 公司普通管理员
            public static final Integer COMPANY_NORMAL_ADMIN = 3;

            // 公司超级管理员
            public static final Integer COMPANY_NORMAL_SUPER_ADMIN = 4;

            // 系统普通管理员
            public static final Integer SYSTEM_NORMAL_ADMIN = 5;

            // 系统超级管理员
            public static final Integer SYSTEM_SUPER_ADMIN = 6;
        }

        // 文件类型
        public interface FILE_TYPE {

            public static final Integer DICT_ID = 15;

            // 视频
            public static final String FILE_VIDEO = "1";

            // 图片
            public static final String FILE_IMAGE = "2";

            // doc,xls,txt
            public static final String FILE_DOCUMENT = "3";

            // 其他
            public static final String FILE_OTHER = "4";
        }

        // 自动报警时长
        public interface AUTOMATIC_ALARM_TIME {

            public static final Integer DICT_ID = 16;
        }

        // 人体检测精度
        public interface BODY_DETECTION_ACCURACY {

            public static final Integer DICT_ID = 17;

            // 视频
            public static final String HIGH = "1";

            // 图片
            public static final String LOW = "2";
        }

        // APP首页设备类别(字典值为2,3,,见DeviceCategory枚举)
        public interface APP_HOME_PAGE_DEVICE_CATEGORY {

            public static final Integer DICT_ID = 18;

        }

        // 设备告警类型
        public interface DEVICE_ALARM_TYPE {

            public static final Integer DICT_ID = 19;
        }

    }

}
