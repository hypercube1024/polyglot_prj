package com.polyglot.app.api.model;

/**
 * @author Pengtao Qiu
 */
public class MessageResponse {
    private int code;
    private String msg;
    private String content;
    private long ts;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTs() {
        return ts;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }

    @Override
    public String toString() {
        return "MessageResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", content='" + content + '\'' +
                ", ts=" + ts +
                '}';
    }
}
