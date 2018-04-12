<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
<link type="text/css" rel="stylesheet" href="resources/css/reset.css">
<link type="text/css" rel="stylesheet" href="resources/css/main.css">
<link rel="SHORTCUT ICON" href="resources/images/project_logo.png"/>
</head>

<body>
<div class="headerBar">
	<div class="logoBar login_logo">
		<div class="comWidth">
			<div class="logo fl" align="center">
				<a href="#"><img width="40px" height="60px" src="resources/images/logo.png"></a>
			</div>
			<h3 class="welcome_title">欢迎登陆</h3>
		</div>
	</div>
</div>

<form action="/auth/login" method="post" >
<div class="loginBox">	

	<div class="login_cont">
		<ul class="login">
			<li class="l_tit">用户名</li>
			<li class="mb_10"><input type="text" name="username" class="login_input user_icon"></li>
			<li class="l_tit">密码</li>
			<li class="mb_10"><input type="password" name="password" class="login_input password_icon"></li>
			
			<li><input type="submit" value="" class="login_btn"></li>
		</ul>
		<div class="login_partners">
			<p class="l_tit">使用合作方账号登陆网站</p>
			<ul class="login_list clearfix">
				<li><a href="#">QQ</a></li>
				<li><span>|</span></li>
				<li><a href="#">网易</a></li>
				<li><span>|</span></li>
				<li><a href="#">新浪微博</a></li>
				<li><span>|</span></li>
				<li><a href="#">腾讯微薄</a></li>
				<li><span>|</span></li>
				<li><a href="#">新浪微博</a></li>
				<li><span>|</span></li>
				<li><a href="#">腾讯微薄</a></li>
			</ul>
		</div>
	</div>
</div>
</form>

</body>
</html>
