$(function() {
	$("#registerForm").validate({
		rules : {
			username : "required",
			password : {
				required : true,
				minlength : 6
			},
			confirmPassword : {
				required : true,
				minlength : 6,
				equalTo : "#password"
			}
		},
		messages : {
			username : "请输入姓名",
			password : {
				required : "请输入密码",
				minlength : "密码不能小于6个字 符"
			},
			confirmPassword : {
				required : "请输入确认密码",
				minlength : "确认密码不能小于6个字符",
				equalTo : "两次输入密码不一致"
			}
		}
	});
});