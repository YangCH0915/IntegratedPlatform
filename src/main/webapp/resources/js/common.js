//var host = 'http://pay.azsdcn.com/IntegratedPlatform/';
var host = 'http://192.168.1.154:8080/';

/**
 * @description    根据某个字段实现对json数组的排序
 * @param   array  要排序的json数组对象
 * @param   field  排序字段（此参数必须为字符串）
 * @param   reverse 是否倒序（默认为false）
 * @return  array  返回排序后的json数组
 */
function jsonSort(array, field, reverse) {
	//数组长度小于2 或 没有指定排序字段 或 不是json格式数据
	if(array.length < 2 || !field || typeof array[0] !== "object") return array;
	//数字类型排序
	if(typeof array[0][field] === "number") {
		array.sort(function(x, y) {
			return x[field] - y[field]
		});
	}
	//字符串类型排序
	if(typeof array[0][field] === "string") {
		array.sort(function(x, y) {
			return x[field].localeCompare(y[field])
		});
	}
	//倒序
	if(reverse) {
		array.reverse();
	}
	return array;
}

function getCurrentTime() {
	var myDate = new Date();
	//获取当前年
	var year = myDate.getFullYear();
	//获取当前月
	var month = myDate.getMonth() + 1;
	//获取当前日
	var date = myDate.getDate();
	var h = myDate.getHours(); //获取当前小时数(0-23)
	var m = myDate.getMinutes(); //获取当前分钟数(0-59)
	var s = myDate.getSeconds();
	var now = year + '-' + p(month) + "-" + p(date) + " " + p(h) + ':' + p(m) + ":" + p(s);
	return now;
}

function p(s) {
	return s < 10 ? '0' + s : s;
}

function getPayType(state) {
	if(state == 'weixin_h5') {
		return '微信H5';
	} else if(state == 'weixin_gzh') {
		return '微信公众号';
	} else if(state == 'alipay_h5') {
		return '支付宝WAP';
	}
	return "";
}

function delAll() {
	$("#list tr").remove();
}

function doubleToFixed(value) {
	var success = new Number(value);
	return success.toFixed(2);
}

function checkLogin() {
	var user = $.cookie("platformUsername");
	if(user == "" || user === undefined) {
		alert("请重新登录");
		window.location.href = 'login.html';
	}
}