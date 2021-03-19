package com.austin.common.core.bean;

/**
 * @Description:错误代码定义
 * @Author: GongJun
 * @Date: Created in 10:01 2021/1/21
 */
public class CodeMsg {
    //通用的异常
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(50000, "服务端异常");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(50001, "密码不能为空");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(50002, "手机号不能为空");
    public static CodeMsg MOBILE_ERROR = new CodeMsg(50003, "手机号格式错误");
    public static CodeMsg NO_USER = new CodeMsg(50004, "用户不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(50005, "密码错误");
    private int code;
    private String msg;


    //登陆模块异常....60000
    //商品模块...70000
    //订单...80000


    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    //注意需要重写toString 方法,不然到前端页面是一个对象的地址....
    @Override
    public String toString() {
        return "CodeMsg{" + "code=" + code + ", msg='" + msg + '\'' + '}';
    }

}
