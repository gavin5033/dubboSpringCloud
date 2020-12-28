package com.gavin.study.enums;

/**
 * class description
 *
 * @author wangbingchang
 * @date 2020/12/28
 */
public enum BizCodeEnume {


    TOO_MANY_REQUESTS_EXCEPTION("10003", "请求频率太高");

    private String code;

    private String desc;

    BizCodeEnume(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
