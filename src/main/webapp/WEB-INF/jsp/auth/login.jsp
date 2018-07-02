<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html >
<head>
    <%@include file="../common/head.jspf"%>
    <title>综合管理平台</title>
    <link href="${serverPath}/resources/css/login/login.css" rel="stylesheet">
    <script src="${serverPath}/resources/js/verificationNumbers.js"></script>
    <script src="${serverPath}/resources/js/Particleground.js"></script>
</head>

<body>
<div class="login-hd">
    <div class="left-bg"></div>
    <div class="right-bg"></div>
    <div class="hd-inner">
        <span class="logo"></span>
        <span class="split"></span>
        <span class="sys-name">易创科技</span>
    </div>
</div>
<div class="login-bd">
    <div class="bd-inner">
        <div class="inner-wrap">
            <div class="lg-zone">
                <div class="lg-box">
                    <div class="lg-label">
                        <h4>用户登录</h4></div>
                    <form action="/login" method="post">
                        <div class="lg-username input-item clearfix">
                            <i class="iconfont">&#xe60d;</i>
                            <input type="text" id="username" name="username" placeholder="账号/邮箱">
                        </div>
                        <div class="lg-password input-item clearfix">
                            <i class="iconfont">&#xe634;</i>
                            <input type="password" id="password" name="password" placeholder="请输入密码">
                        </div>
                        <div class="lg-check clearfix">
                            <div class="input-item">
                                <i class="iconfont">&#xe633;</i>
                                <input type="text" placeholder="验证码" id="J_codetext" maxlength="4">
                            </div>
                            <canvas class="check-code" id="myCanvas" onclick="createCode()">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
                        </div>
                        <div class="tips clearfix">
                            <label><input type="checkbox" checked="checked">记住用户名</label>
                            <a href="javascript:;" class="forget-pwd">忘记密码？</a>
                        </div>
                        <div class="enter">
                            <!--<a href="javascript:;" class="purchaser" onClick="javascript:window.location='main.html'">确认登录</a>-->
                            <button type="submit" class="supplier">确认登录</button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="lg-poster"></div>
        </div>
    </div>
</div>
<div class="login-ft">
    <div class="ft-inner">
        <div class="about-us">
            <a href="javascript:;">关于我们</a>
            <a href="javascript:;">法律声明</a>
            <a href="javascript:;">服务条款</a>
            <a href="javascript:;">联系方式</a>
        </div>
        <div class="address">地址：深圳市软件产业园&nbsp;邮编：210019&nbsp;&nbsp;Copyright&nbsp;©&nbsp;2016&nbsp;-&nbsp;2022&nbsp;专注于视频会员与版权销售&nbsp;版权所有</div>
        <div class="other-info">建议使用IE8及以上版本浏览器&nbsp;鲁ICP备&nbsp;012345678号&nbsp;E-mail：yc17889@sohu.com</div>
    </div>
</div>
</body>
<script type="text/javascript" src="${serverPath}/resources/js/login.js"></script>
</html>
