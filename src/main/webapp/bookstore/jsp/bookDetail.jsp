<%@ page import="model.Book"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>BookStore</title>
<%
	String path = request.getContextPath();
%>
<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
<link href="<%=path%>/bookstore/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.responsive.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/bookstore.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
</head>
<body>
<%Book book = (Book)request.getAttribute("detail"); %>

	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			
		<form class= "search-bar">
			<input type="text" name="searchString" />
			<button class="btn btn-default" type="submit">Search</button>
		</form>
		
		<div class="navbar-header">
			<a class="navbar-brand" href="homepage">BookStore</a>
		</div>

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<%
					if(session.getAttribute("username") == null) {
					%>
					<li><a href="<%=path%>/bookstore/jsp/login.jsp" type=redirect><i class="fa fa-sign-in fa-fw"></i>
							Login</a></li>
					<li><a href="<%=path%>/bookstore/jsp/register.jsp" type=redirect><i class="fa fa-plus fa-fw"></i>
							Register</a></li>
					<%} else if(session.getAttribute("role").equals("user")) {%>
					<li><span>Hi, <s:property value="#session.username" />!</span></li>
					<li><a href="#"><i class="fa fa-user fa-fw"></i>
							User Info</a></li>
					<li><a href="myOrdersPro"><i class="fa fa-reorder fa-fw"></i>
							My Orders</a></li>
					<li><a href="myCartPro"><i class="fa fa-shopping-cart fa-fw"></i>
							My Cart</a></li>
					<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
							Log out</a></li>
					<%} else { %>
					<li><span>Hi, <s:property value="#session.username" />!</span></li>
					<li><a href="#"><i class="fa fa-user fa-fw"></i>
							User Info</a></li>
					<li><a href="allUsersPro" class="active"><i
							class="fa fa-user fa-fw"></i> Manage</a></li>
					<li><a href="myOrdersPro"><i class="fa fa-reorder fa-fw"></i>
							My Orders</a></li>
					<li><a href="myCartPro"><i class="fa fa-shopping-cart fa-fw"></i>
							My Cart</a></li>
					<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
							Log out</a></li>
					<%} %>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>


		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Book Detail</h1>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div><h2><%=book.getTitle()%></h2></div>
					<div>
						<div><h3>Author</h3></div>
						<div><p><%=book.getAuthor()%></p></div>
					</div>
					<div>
						<div><h3>Publisher</h3></div>
						<div><p><%=book.getPublisher()%></p></div>
					</div>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

</body>
</html>