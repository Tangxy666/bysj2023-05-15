package com.tangxy.soccerpro.entity;

import lombok.Getter;

/**
 * 统一返回结果状态信息类
 */
@Getter
public enum ResultCodeEnum {

    //2xx
    SUCCESS(200,"成功"),
    CREATED(201,"数据创建成功"),
    //4xx
    FAIL(400, "失败"),
    AUTH_FAIL(401,"鉴权失败"),
    NOT_AUTH(403,"拒绝接入"),
    NOT_FOUND(404,"指定资源不存在"),
    OUT_OF_BOUNDS(413,"请求过大"),
    //5xx
    SERVER_ERROR(500,"服务器错误"),
    NOT_IMPLEMENTED(501,"服务器不支持处理当前请求"),
    UNAVAILABLE(503,"服务不可用"),
    ;

    private Integer code;
    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
