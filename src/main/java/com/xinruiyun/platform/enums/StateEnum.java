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
    REGISTER_ERROR(2001,"提交数据为null"),
    REGISTER_FAIL(2002, "注册不成功，数据插入失败"),
    REGISTER_USER_EXIST(2003, "用户名已存在"),
    QUERY_USER_EMPTY(3001, "用户列表为空"),
    QUERY_USER_ERROR(3002, "查询用户列表异常"),
    ADD_PRODUCT_ERROR(1005,"添加商品异常"),
    PRODUCT_LIST_NULL(1006,"没有添加商品"),
    PRODUCT_LIST_ERROR(1007,"获取商品列表异常");

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
