<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <%@include file="../common/head.jspf" %>
    <title>综合管理平台</title>
</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo">
        <a href="#">后台管理系统</a>
    </div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe6da;</i>
    </div>

    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item to-index"><img src="images/head_icon.png"/></li>
        <li class="layui-nav-item">
            <a href="javascript:;" id="currentUser">当前账号：admin</a>
            <dl class="layui-nav-child">
                <!--<dd>
                    <a onclick="x_admin_show('个人信息','channel/user-info.html')">个人信息</a>
                </dd>-->
                <dd>
                    <a onclick="exit('login.html')" href="#">退出</a>
                </dd>
            </dl>
        </li>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6e5;</i>
                    <cite>用户管理</cite>
                    <i class="iconfont nav_right">&#xe642;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="user/user-list.html">
                            <i class="iconfont">&#xe609;</i>
                            <cite>用户列表</cite>
                        </a>
                    </li>
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="channel/channel-list.html">
                            <i class="iconfont">&#xe609;</i>
                            <cite>渠道列表</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b7;</i>
                    <cite>商品管理</cite>
                    <i class="iconfont nav_right">&#xe642;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="product/product-list.html">
                            <i class="iconfont">&#xe609;</i>
                            <cite>商品类别</cite>
                        </a>
                    </li>
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="subProduct/subproduct-list.html">
                            <i class="iconfont">&#xe609;</i>
                            <cite>子商品列表</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b9;</i>
                    <cite>支付通道</cite>
                    <i class="iconfont nav_right">&#xe642;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="passageway/passageway-list.html">
                            <i class="iconfont">&#xe609;</i>
                            <cite>通道列表</cite>
                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6cf;</i>
                    <cite>数据统计</cite>
                    <i class="iconfont nav_right">&#xe642;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="statistical/statistical-details.html">
                            <i class="iconfont">&#xe609;</i>
                            <cite>统计详情</cite>
                        </a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li>欢迎界面</li>
        </ul>
        <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='statistical/statistical-details.html' frameborder="0" scrolling="yes"
                        class="x-iframe"></iframe>
            </div>
        </div>
    </div>
</div>
<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <div class="copyright">©2017版权所有</div>
</div>
<!-- 底部结束 -->
</body>

</html>
