<%@ page contentType="text/html; charset=UTF-8"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>订单-支付</title>
<script type="text/javascript">
	function onBridgeReady() {
		WeixinJSBridge.invoke('getBrandWCPayRequest', {
			"appId" : "${appid}", //公众号名称，由商户传入     
			"timeStamp" : "${timeStamp}", //时间戳，自1970年以来的秒数     
			"nonceStr" : "${nonceStr}", //随机串     
			"package" : "${packageValue}",
			"signType" : "MD5", //微信签名方式：     
			"paySign" : "${sign}" //微信签名 
		}, function(res) {
			if (res.err_msg == "get_brand_wcpay_request:ok") {
				window.location.href = "${callbackUrl}";
			}else if (res.err_msg == "get_brand_wcpay_request:fail") {
				window.location.href = "${callbackUrl}";
			} else if (res.err_msg == "get_brand_wcpay_request:cancel") {
				window.location.href = "${callbackUrl}";
			}else {
				alert(res.err_desc);
			}
		});
	}
	if (typeof WeixinJSBridge == "undefined") {
		if (document.addEventListener) {
			document.addEventListener('WeixinJSBridgeReady', onBridgeReady,false);
		} else if (document.attachEvent) {
			document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
			document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
		}
	} else {
		onBridgeReady();
	}
</script>
</head>
<body>
	<script type="text/javascript">
		$(document).ready(function() {
			onBridgeReady();
		});
	</script>
</body>
</html>
