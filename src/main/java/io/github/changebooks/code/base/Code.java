package io.github.changebooks.code.base;

/**
 * 标准错误码
 *
 * @author changebooks@qq.com
 */
public interface Code {
    /**
     * OK
     */
    int SUCCESS_NUM = 0;

    /**
     * -- 禁用，易误解成HttpStatus.OK --
     */
    int IGNORE_NUM = 200;

    /**
     * 无访问权限
     */
    int FORBIDDEN = 403;

    /**
     * 页面不存在
     */
    int PAGE_NOT_FOUND = 404;

    /**
     * 请求方式不支持
     */
    int METHOD_NOT_ALLOWED = 405;

    /**
     * 系统运行异常
     */
    int SYSTEM_RUN_ERR = 500;

    /**
     * 脚本运行失败
     */
    int SCRIPT_RUN_ERR = 501;

    /**
     * 幂等
     */
    int IDEMPOTENT = 1000;

    /**
     * 重复请求
     */
    int CONFLICT = 1001;

    /**
     * 缺少参数
     */
    int NO_ARGS = 1101;

    /**
     * 参数错误
     */
    int ARGS_ERR = 1102;

    /**
     * 缺少结果
     */
    int NO_RESULT = 1111;

    /**
     * 结果错误
     */
    int RESULT_ERR = 1112;

    /**
     * Json格式错误
     */
    int JSON_ERR = 1201;

    /**
     * Xml格式错误
     */
    int XML_ERR = 1202;

    /**
     * 缺少文件
     */
    int NO_FILE = 1211;

    /**
     * 文件错误
     */
    int FILE_ERR = 1212;

    /**
     * 缺少目录
     */
    int NO_DIRECTORY = 1221;

    /**
     * 目录错误
     */
    int DIRECTORY_ERR = 1222;

    /**
     * 缺少资源
     */
    int NO_RESOURCE = 1231;

    /**
     * 资源错误
     */
    int RESOURCE_ERR = 1232;

    /**
     * 统计失败
     */
    int AGGREGATE_ERR = 1301;

    /**
     * 查询失败
     */
    int FIND_ERR = 1311;

    /**
     * 新增失败
     */
    int INSERT_ERR = 1312;

    /**
     * 修改失败
     */
    int UPDATE_ERR = 1313;

    /**
     * 删除失败
     */
    int DELETE_ERR = 1314;

    /**
     * 查询数据库失败
     */
    int DB_FIND_ERR = 1321;

    /**
     * 新增数据库失败
     */
    int DB_INSERT_ERR = 1322;

    /**
     * 修改数据库失败
     */
    int DB_UPDATE_ERR = 1323;

    /**
     * 删除数据库失败
     */
    int DB_DELETE_ERR = 1324;

    /**
     * 查询缓存失败
     */
    int CACHE_FIND_ERR = 1331;

    /**
     * 新增缓存失败
     */
    int CACHE_INSERT_ERR = 1332;

    /**
     * 修改缓存失败
     */
    int CACHE_UPDATE_ERR = 1333;

    /**
     * 删除缓存失败
     */
    int CACHE_DELETE_ERR = 1334;

    /**
     * 查询属性失败
     */
    int ATTRIBUTE_FIND_ERR = 1341;

    /**
     * 新增属性失败
     */
    int ATTRIBUTE_INSERT_ERR = 1342;

    /**
     * 修改属性失败
     */
    int ATTRIBUTE_UPDATE_ERR = 1343;

    /**
     * 删除属性失败
     */
    int ATTRIBUTE_DELETE_ERR = 1344;

    /**
     * 读文件失败
     */
    int FILE_READ_ERR = 1351;

    /**
     * 创建文件失败
     */
    int FILE_CREATE_ERR = 1352;

    /**
     * 写文件失败
     */
    int FILE_WRITE_ERR = 1353;

    /**
     * 删文件失败
     */
    int FILE_DELETE_ERR = 1354;

    /**
     * 读目录失败
     */
    int DIRECTORY_READ_ERR = 1361;

    /**
     * 创建目录失败
     */
    int DIRECTORY_CREATE_ERR = 1362;

    /**
     * 删目录失败
     */
    int DIRECTORY_DELETE_ERR = 1364;

    /**
     * 上传失败
     */
    int UPLOAD_ERR = 1401;

    /**
     * 下载失败
     */
    int DOWNLOAD_ERR = 1402;

    /**
     * HTTP请求失败
     */
    int HTTP_ERR = 1411;

    /**
     * RPC调用失败
     */
    int RPC_ERR = 1412;

    /**
     * 发消息失败
     */
    int SEND_MSG_ERR = 1421;

    /**
     * 未登录
     */
    int NO_TOKEN = 1501;

    /**
     * Token错误
     */
    int TOKEN_ERR = 1502;

    /**
     * 登录过期
     */
    int TOKEN_EXPIRED = 1503;

    /**
     * 未知错误
     */
    int UNKNOWN_ERR = 2008;

    /**
     * 缺少时间
     */
    int NO_TIME = 10001;

    /**
     * 时间格式错误
     */
    int TIME_ERR = 10002;

    /**
     * 缺少日期
     */
    int NO_DATE = 10011;

    /**
     * 日期格式错误
     */
    int DATE_ERR = 10012;

    /**
     * 缺少排序
     */
    int NO_SORT = 10101;

    /**
     * 排序错误
     */
    int SORT_ERR = 10102;

    /**
     * 排序是正整数
     */
    int SORT_POSITIVE = 10103;

    /**
     * 缺少版本
     */
    int NO_VERSION = 10201;

    /**
     * 版本错误
     */
    int VERSION_ERR = 10202;

    /**
     * 版本不存在
     */
    int VERSION_UNSUPPORTED = 10203;

    /**
     * 缺少类型
     */
    int NO_TYPE = 10211;

    /**
     * 类型错误
     */
    int TYPE_ERR = 10212;

    /**
     * 类型不支持
     */
    int TYPE_UNSUPPORTED = 10213;

    /**
     * 缺少进度
     */
    int NO_PROGRESS = 10221;

    /**
     * 进度错误
     */
    int PROGRESS_ERR = 10222;

    /**
     * 进度不支持
     */
    int PROGRESS_UNSUPPORTED = 10223;

    /**
     * 缺少业务id
     */
    int NO_BIZ_ID = 11001;

    /**
     * 业务id错误
     */
    int BIZ_ID_ERR = 11002;

    /**
     * 业务id重复
     */
    int BIZ_ID_CONFLICT = 11003;

    /**
     * 业务id不存在
     */
    int BIZ_ID_UNSUPPORTED = 11004;

    /**
     * 缺少主键
     */
    int NO_ID = 12001;

    /**
     * 主键错误
     */
    int ID_ERR = 12002;

    /**
     * 主键是正整数
     */
    int ID_POSITIVE = 12003;

    /**
     * 主键重复
     */
    int ID_CONFLICT = 12004;

    /**
     * 主键不存在
     */
    int ID_UNSUPPORTED = 12005;

    /**
     * 缺少流水id
     */
    int NO_FLOW_ID = 12011;

    /**
     * 流水id错误
     */
    int FLOW_ID_ERR = 12012;

    /**
     * 流水id是正整数
     */
    int FLOW_ID_POSITIVE = 12013;

    /**
     * 流水id重复
     */
    int FLOW_ID_CONFLICT = 12014;

    /**
     * 流水不存在
     */
    int FLOW_UNSUPPORTED = 12015;

    /**
     * 缺少用户id
     */
    int NO_USER_ID = 12021;

    /**
     * 用户id错误
     */
    int USER_ID_ERR = 12022;

    /**
     * 用户id是正整数
     */
    int USER_ID_POSITIVE = 12023;

    /**
     * 用户id重复
     */
    int USER_ID_CONFLICT = 12024;

    /**
     * 用户不存在
     */
    int USER_UNSUPPORTED = 12025;

    /**
     * 缺少平台id
     */
    int NO_PLATFORM_ID = 12031;

    /**
     * 平台id错误
     */
    int PLATFORM_ID_ERR = 12032;

    /**
     * 平台id是正整数
     */
    int PLATFORM_ID_POSITIVE = 12033;

    /**
     * 平台id重复
     */
    int PLATFORM_ID_CONFLICT = 12034;

    /**
     * 平台不存在
     */
    int PLATFORM_UNSUPPORTED = 12035;

    /**
     * 缺少店铺id
     */
    int NO_SHOP_ID = 12041;

    /**
     * 店铺id错误
     */
    int SHOP_ID_ERR = 12042;

    /**
     * 店铺id是正整数
     */
    int SHOP_ID_POSITIVE = 12043;

    /**
     * 店铺id重复
     */
    int SHOP_ID_CONFLICT = 12044;

    /**
     * 店铺不存在
     */
    int SHOP_UNSUPPORTED = 12045;

}
