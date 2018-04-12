package com.xinruiyun.platform.dto;

import com.xinruiyun.platform.enums.StateEnum;

public class AuthResult<T> {

    private int state;
    private T data;
    private String msg;

    public AuthResult() {
    }

    public AuthResult(StateEnum stateEnum, T data) {
        this.state = stateEnum.getState();
        this.data = data;
        this.msg = stateEnum.getStateInfo();
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "AuthResult{" +
                "state=" + state +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
