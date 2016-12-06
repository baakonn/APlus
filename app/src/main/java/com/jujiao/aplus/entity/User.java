package com.jujiao.aplus.entity;



public class User {

    private String sessionToken;

    private String nickname;

    private String username;

    /**
     * 验证手机号
     */
    private String mobilePhoneNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号验证码,发送短信验证时请求使用
     */
    private String smsCode;

    /**
     * 头像图片地址
     */
    private String avatar;

    private String company;

}
