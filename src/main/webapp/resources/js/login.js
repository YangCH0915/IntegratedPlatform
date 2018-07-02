createCode();

layui.use('layer', function() {
	var layer = layui.layer;
	$("#login").click(function() {
		var userName = $('#username').val();
		var password = $('#password').val();
		if(validate()) {
			var url = '/login';
			$.ajax(url,{
				type: 'POST',
				dataType: 'json',
				data: {
					username: userName,
					password: password
				},
				success: function(data) {
					if(data) {
						var code = data.state;
						if(code == 0) {
							window.location = data.data;
							$.cookie('platformUsername', userName);
						} else if(code == 1000) {
							layer.msg("用户不存在,请检查用户名是否正确");
						} else if(code == 1001) {
							layer.msg("密码错误");
						}
					}
				}
			});
		}
	});
});