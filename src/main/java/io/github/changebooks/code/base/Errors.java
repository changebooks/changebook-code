package io.github.changebooks.code.base;

/**
 * 标准错误枚举
 *
 * @author changebooks@qq.com
 */
public enum Errors implements IResult {
    /**
     * 错误码 : 错误信息
     */
    SUCCESS(Code.SUCCESS_NUM, Message.SUCCESS),
    FORBIDDEN(Code.FORBIDDEN, Message.FORBIDDEN),
    PAGE_NOT_FOUND(Code.PAGE_NOT_FOUND, Message.PAGE_NOT_FOUND),
    METHOD_NOT_ALLOWED(Code.METHOD_NOT_ALLOWED, Message.METHOD_NOT_ALLOWED),
    SYSTEM_RUN_ERR(Code.SYSTEM_RUN_ERR, Message.SYSTEM_RUN_ERR),
    SCRIPT_RUN_ERR(Code.SCRIPT_RUN_ERR, Message.SCRIPT_RUN_ERR),
    IDEMPOTENT(Code.IDEMPOTENT, Message.IDEMPOTENT),
    CONFLICT(Code.CONFLICT, Message.CONFLICT),
    NO_ARGS(Code.NO_ARGS, Message.NO_ARGS),
    ARGS_ERR(Code.ARGS_ERR, Message.ARGS_ERR),
    NO_RESULT(Code.NO_RESULT, Message.NO_RESULT),
    RESULT_ERR(Code.RESULT_ERR, Message.RESULT_ERR),
    JSON_ERR(Code.JSON_ERR, Message.JSON_ERR),
    XML_ERR(Code.XML_ERR, Message.XML_ERR),
    NO_FILE(Code.NO_FILE, Message.NO_FILE),
    FILE_ERR(Code.FILE_ERR, Message.FILE_ERR),
    NO_DIRECTORY(Code.NO_DIRECTORY, Message.NO_DIRECTORY),
    DIRECTORY_ERR(Code.DIRECTORY_ERR, Message.DIRECTORY_ERR),
    NO_RESOURCE(Code.NO_RESOURCE, Message.NO_RESOURCE),
    RESOURCE_ERR(Code.RESOURCE_ERR, Message.RESOURCE_ERR),
    AGGREGATE_ERR(Code.AGGREGATE_ERR, Message.AGGREGATE_ERR),
    FIND_ERR(Code.FIND_ERR, Message.FIND_ERR),
    INSERT_ERR(Code.INSERT_ERR, Message.INSERT_ERR),
    UPDATE_ERR(Code.UPDATE_ERR, Message.UPDATE_ERR),
    DELETE_ERR(Code.DELETE_ERR, Message.DELETE_ERR),
    DB_FIND_ERR(Code.DB_FIND_ERR, Message.DB_FIND_ERR),
    DB_INSERT_ERR(Code.DB_INSERT_ERR, Message.DB_INSERT_ERR),
    DB_UPDATE_ERR(Code.DB_UPDATE_ERR, Message.DB_UPDATE_ERR),
    DB_DELETE_ERR(Code.DB_DELETE_ERR, Message.DB_DELETE_ERR),
    CACHE_FIND_ERR(Code.CACHE_FIND_ERR, Message.CACHE_FIND_ERR),
    CACHE_INSERT_ERR(Code.CACHE_INSERT_ERR, Message.CACHE_INSERT_ERR),
    CACHE_UPDATE_ERR(Code.CACHE_UPDATE_ERR, Message.CACHE_UPDATE_ERR),
    CACHE_DELETE_ERR(Code.CACHE_DELETE_ERR, Message.CACHE_DELETE_ERR),
    ATTRIBUTE_FIND_ERR(Code.ATTRIBUTE_FIND_ERR, Message.ATTRIBUTE_FIND_ERR),
    ATTRIBUTE_INSERT_ERR(Code.ATTRIBUTE_INSERT_ERR, Message.ATTRIBUTE_INSERT_ERR),
    ATTRIBUTE_UPDATE_ERR(Code.ATTRIBUTE_UPDATE_ERR, Message.ATTRIBUTE_UPDATE_ERR),
    ATTRIBUTE_DELETE_ERR(Code.ATTRIBUTE_DELETE_ERR, Message.ATTRIBUTE_DELETE_ERR),
    FILE_READ_ERR(Code.FILE_READ_ERR, Message.FILE_READ_ERR),
    FILE_CREATE_ERR(Code.FILE_CREATE_ERR, Message.FILE_CREATE_ERR),
    FILE_WRITE_ERR(Code.FILE_WRITE_ERR, Message.FILE_WRITE_ERR),
    FILE_DELETE_ERR(Code.FILE_DELETE_ERR, Message.FILE_DELETE_ERR),
    DIRECTORY_READ_ERR(Code.DIRECTORY_READ_ERR, Message.DIRECTORY_READ_ERR),
    DIRECTORY_CREATE_ERR(Code.DIRECTORY_CREATE_ERR, Message.DIRECTORY_CREATE_ERR),
    DIRECTORY_DELETE_ERR(Code.DIRECTORY_DELETE_ERR, Message.DIRECTORY_DELETE_ERR),
    UPLOAD_ERR(Code.UPLOAD_ERR, Message.UPLOAD_ERR),
    DOWNLOAD_ERR(Code.DOWNLOAD_ERR, Message.DOWNLOAD_ERR),
    HTTP_ERR(Code.HTTP_ERR, Message.HTTP_ERR),
    RPC_ERR(Code.RPC_ERR, Message.RPC_ERR),
    SEND_MSG_ERR(Code.SEND_MSG_ERR, Message.SEND_MSG_ERR),
    NO_TOKEN(Code.NO_TOKEN, Message.NO_TOKEN),
    TOKEN_ERR(Code.TOKEN_ERR, Message.TOKEN_ERR),
    TOKEN_EXPIRED(Code.TOKEN_EXPIRED, Message.TOKEN_EXPIRED),
    UNKNOWN_ERR(Code.UNKNOWN_ERR, Message.UNKNOWN_ERR),
    NO_TIME(Code.NO_TIME, Message.NO_TIME),
    TIME_ERR(Code.TIME_ERR, Message.TIME_ERR),
    NO_DATE(Code.NO_DATE, Message.NO_DATE),
    DATE_ERR(Code.DATE_ERR, Message.DATE_ERR),
    NO_SORT(Code.NO_SORT, Message.NO_SORT),
    SORT_ERR(Code.SORT_ERR, Message.SORT_ERR),
    SORT_POSITIVE(Code.SORT_POSITIVE, Message.SORT_POSITIVE),
    NO_VERSION(Code.NO_VERSION, Message.NO_VERSION),
    VERSION_ERR(Code.VERSION_ERR, Message.VERSION_ERR),
    VERSION_UNSUPPORTED(Code.VERSION_UNSUPPORTED, Message.VERSION_UNSUPPORTED),
    NO_TYPE(Code.NO_TYPE, Message.NO_TYPE),
    TYPE_ERR(Code.TYPE_ERR, Message.TYPE_ERR),
    TYPE_UNSUPPORTED(Code.TYPE_UNSUPPORTED, Message.TYPE_UNSUPPORTED),
    NO_PROGRESS(Code.NO_PROGRESS, Message.NO_PROGRESS),
    PROGRESS_ERR(Code.PROGRESS_ERR, Message.PROGRESS_ERR),
    PROGRESS_UNSUPPORTED(Code.PROGRESS_UNSUPPORTED, Message.PROGRESS_UNSUPPORTED),
    NO_BIZ_ID(Code.NO_BIZ_ID, Message.NO_BIZ_ID),
    BIZ_ID_ERR(Code.BIZ_ID_ERR, Message.BIZ_ID_ERR),
    BIZ_ID_CONFLICT(Code.BIZ_ID_CONFLICT, Message.BIZ_ID_CONFLICT),
    BIZ_ID_UNSUPPORTED(Code.BIZ_ID_UNSUPPORTED, Message.BIZ_ID_UNSUPPORTED),
    NO_ID(Code.NO_ID, Message.NO_ID),
    ID_ERR(Code.ID_ERR, Message.ID_ERR),
    ID_POSITIVE(Code.ID_POSITIVE, Message.ID_POSITIVE),
    ID_CONFLICT(Code.ID_CONFLICT, Message.ID_CONFLICT),
    ID_UNSUPPORTED(Code.ID_UNSUPPORTED, Message.ID_UNSUPPORTED),
    NO_FLOW_ID(Code.NO_FLOW_ID, Message.NO_FLOW_ID),
    FLOW_ID_ERR(Code.FLOW_ID_ERR, Message.FLOW_ID_ERR),
    FLOW_ID_POSITIVE(Code.FLOW_ID_POSITIVE, Message.FLOW_ID_POSITIVE),
    FLOW_ID_CONFLICT(Code.FLOW_ID_CONFLICT, Message.FLOW_ID_CONFLICT),
    FLOW_UNSUPPORTED(Code.FLOW_UNSUPPORTED, Message.FLOW_UNSUPPORTED),
    NO_USER_ID(Code.NO_USER_ID, Message.NO_USER_ID),
    USER_ID_ERR(Code.USER_ID_ERR, Message.USER_ID_ERR),
    USER_ID_POSITIVE(Code.USER_ID_POSITIVE, Message.USER_ID_POSITIVE),
    USER_ID_CONFLICT(Code.USER_ID_CONFLICT, Message.USER_ID_CONFLICT),
    USER_UNSUPPORTED(Code.USER_UNSUPPORTED, Message.USER_UNSUPPORTED),
    NO_PLATFORM_ID(Code.NO_PLATFORM_ID, Message.NO_PLATFORM_ID),
    PLATFORM_ID_ERR(Code.PLATFORM_ID_ERR, Message.PLATFORM_ID_ERR),
    PLATFORM_ID_POSITIVE(Code.PLATFORM_ID_POSITIVE, Message.PLATFORM_ID_POSITIVE),
    PLATFORM_ID_CONFLICT(Code.PLATFORM_ID_CONFLICT, Message.PLATFORM_ID_CONFLICT),
    PLATFORM_UNSUPPORTED(Code.PLATFORM_UNSUPPORTED, Message.PLATFORM_UNSUPPORTED),
    NO_SHOP_ID(Code.NO_SHOP_ID, Message.NO_SHOP_ID),
    SHOP_ID_ERR(Code.SHOP_ID_ERR, Message.SHOP_ID_ERR),
    SHOP_ID_POSITIVE(Code.SHOP_ID_POSITIVE, Message.SHOP_ID_POSITIVE),
    SHOP_ID_CONFLICT(Code.SHOP_ID_CONFLICT, Message.SHOP_ID_CONFLICT),
    SHOP_UNSUPPORTED(Code.SHOP_UNSUPPORTED, Message.SHOP_UNSUPPORTED),

    ;

    /**
     * 错误码
     * 0：正确、gt 0：错误、lt 0：弃用
     */
    private final int code;

    /**
     * 错误信息
     * ok：正确、!ok：错误
     */
    private final String message;

    Errors(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
