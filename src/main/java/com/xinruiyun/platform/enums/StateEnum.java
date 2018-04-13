package com.xinruiyun.platform.enums;

/**
 * 使用枚举表述常量数据字典
 *
 * @author yan
 */
public enum StateEnum {

    SUCCESS(0, "成功"),
    LOGIN_USER_ERROR(1000,"用户名错误"),
    LOGIN_PASSWORD_ERROR(1001,"密码错误"),
    LOGIN_FAIL(1002, "登录失败，系统异常"),
    REGISTER_ERROR(1003,"提交数据为null"),
    REGISTER_FAIL(1004, "注册不成功，数据插入失败"),
    ADD_PRODUCT_ERROR(1005,"添加商品异常");

    private int state;

    private String stateInfo;

    StateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public static StateEnum stateOf(int index) {
        for (StateEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }
}
