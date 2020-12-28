package com.gavin.study.vo;

import java.io.Serializable;
import java.util.Map;

/**
 * class description
 *
 * @author wangbingchang
 * @date 2020/12/28
 */
public class ResponseDTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 响应公共属性
     */
    private Map<String, String> responseHeader;

    /**
     * 服务执行状态
     * true: 成功, errCode = "0"
     * false: 失败 ,  errCode != "0"
     */
    private Boolean success;

    /**
     * 响应码 【小于0框架层使用，大于等于0应用层使用】
     * 0: 成功
     * 非0: 失败
     */
    private String code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应结果
     */
    private T body;


    public ResponseDTO() {
    }

    public ResponseDTO(Map<String, String> responseHeader, Boolean success, String code, String msg, T body) {
        this.responseHeader = responseHeader;
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.body = body;
    }

    public Map<String, String> getResponseHeader() {
        return responseHeader;
    }

    public void setResponseHeader(Map<String, String> responseHeader) {
        this.responseHeader = responseHeader;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public static  ResponseDTO.ResponseDTOBuilder builder() {
        return new ResponseDTO.ResponseDTOBuilder();
    }

    public static class ResponseDTOBuilder<T> {

        private Map<String, String> responseHeader;
        private Boolean success = true;
        private String code = "0";
        private String msg;
        private T body;


        public ResponseDTO.ResponseDTOBuilder<T> responseHeader(Map<String, String> responseHeader) {
            this.responseHeader = responseHeader;
            return this;
        }

        public ResponseDTO.ResponseDTOBuilder<T> success(Boolean success) {
            this.success = success;
            return this;
        }

        public ResponseDTO.ResponseDTOBuilder<T> code(String code) {
            this.code = code;
            return this;
        }

        public ResponseDTO.ResponseDTOBuilder<T> msg(String msg) {
            this.msg = msg;
            return this;
        }

        public ResponseDTO.ResponseDTOBuilder<T> body(T body) {
            this.body = body;
            return this;
        }

        public ResponseDTO<T> build() {
            return new ResponseDTO(this.responseHeader, success, code, msg, this.body);
        }
    }

    @Override
    public String toString() {
        return "ResponseDTO{responseHeader=" + this.responseHeader + ",success=" + success + ",code=" + code + ",msg=" + msg + ",body=" + body + "}";
    }
}