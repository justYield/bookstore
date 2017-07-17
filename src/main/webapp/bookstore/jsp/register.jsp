<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>BookStore</title>

<%
	String path = request.getContextPath();
%>
<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/jquery-validate/1.16.0/jquery.validate.min.js"></script>
<link href="<%=path%>/bookstore/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.responsive.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/bookstore.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>
<script>
	var path = "<%=path%>";
	$(document).ready(function() {
		var logined = "<s:property value='#session.logined' />";
		if (logined) {
			bootbox.alert("您已登录，无需注册！", function() {
				location.href = "index";//location.href实现客户端页面的跳转  
			})
		}
	});
</script>

<body>
	<script src="<%=path%>/bookstore/js/register.js"></script>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

		<div class="navbar-header">
			<a class="navbar-brand" href="homepage.jsp">BookStore</a>
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div class="yx-container container">
			<div class="row">
				<div>
					<form id="registerForm" class="form-horizontal"
						style="text-align: center" action="register" method="post"
						enctype="multipart/form-data">
						<div class="form-group">
							<div>
								<div class="form-group">
									<label for="nickName" class="col-md-2 control-label">昵称(*)</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="username"
											name="username" placeholder="请输入用户名" required="true"
											maxlength="14">
										<p class="help-block"></p>
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="col-md-2 control-label">密码(*)</label>
									<div class="col-md-6">
										<input type="password" class="form-control" id="password"
											name="password" placeholder="请输入密码" required="true"
											maxlength="20">
										<p class="help-block">长度大于6位</p>
									</div>
								</div>
								<div class="form-group">
									<label for="password" class="col-md-2 control-label">确认密码(*)</label>
									<div class="col-md-6">
										<input type="password" class="form-control"
											id="confirmPassword" name="confirmPassword"
											placeholder="请再次输入密码" required="true" maxlength="20">
										<p class="help-block">长度大于6位</p>
									</div>
								</div>
							</div>
						</div>
						<button id="submit" type="submit" class="btn">注册</button>
					</form>
				</div>
			</div>
		</div>
</body>
</html>