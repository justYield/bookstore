<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Book"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>BookStore</title>

<%
	String path = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
<link href="<%=path%>/bookstore/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.responsive.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/bookstore.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="<%=path%>/bookstore/js/homepage.js"></script>
</head>

<script>
	var path = "<%=path%>";
	var books = "<%=request.getAttribute("books")%>"
	$(document).ready(function() {
		if (books == "null") {
			location.href = "listBooks";
		}
	});
</script>


<body>
	<%
		ArrayList<Book> bookList = new ArrayList<Book>();
		if (request.getAttribute("books") != null) {
			bookList = (ArrayList<Book>) request.getAttribute("books");
		}
	%>
	
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

		<form class="search-bar" action="search">
			<input type="text" name="searchString" />
			<button class="btn btn-default" type="submit">Search</button>
		</form>

		<div class="navbar-header">
			<a class="navbar-brand" href="homepage.jsp">BookStore</a>
		</div>

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<%
					if(session.getAttribute("username") == null) {
					%>
					<li><a  type=redirect data-toggle="modal" data-target="#myModal"><i
							class="fa fa-sign-in fa-fw"></i> Login</a></li>
					<li><a href="<%=path%>/bookstore/jsp/register.jsp"
						type=redirect><i class="fa fa-plus fa-fw"></i> Register</a></li>
					<%} else if(session.getAttribute("role").equals("user")) {%>
					<li><span>Hi, <s:property value="#session.username" />!
					</span></li>
					<li><a href="profile?id=<%=session.getAttribute("id")%>"><i class="fa fa-user fa-fw"></i> User Info</a></li>
					<li><a href="myOrdersPro?id=<%=session.getAttribute("id")%>"><i class="fa fa-reorder fa-fw"></i>
							My Orders</a></li>
					<li><a href="myCartPro?id=<%=session.getAttribute("id")%>"><i
							class="fa fa-shopping-cart fa-fw"></i> My Cart</a></li>
					<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
							Log out</a></li>
					<%} else { %>
					<li><span>Hi, <s:property value="#session.username" />!
					</span></li>
					<li><a href="#"><i class="fa fa-user fa-fw"></i> User Info</a></li>
					<li><a href="allUsersPro"><i class="fa fa-user fa-fw"></i> Manage</a></li>
					<li><a href="myOrdersPro"><i class="fa fa-reorder fa-fw"></i>
							My Orders</a></li>
					<li><a href="myCartPro"><i
							class="fa fa-shopping-cart fa-fw"></i> My Cart</a></li>
					<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
							Log out</a></li>
					<%} %>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="Login" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel"></h4>
				</div>
				<form class="modal-body form-signin" action="login">
					<h2 class="form-signin-heading">Please login</h2>
					<input type="text" class="form-control" name="username"
						placeholder="Name" required="true" autofocus="" /> 
					<input type="password" class="form-control" name="password"
						placeholder="Password" required="true" />
					<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
				</form>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Books</h1>
				</div>
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables">
									<thead>
										<tr>
											<th>Title</th>
											<th>Author</th>
											<th>Price(元)</th>
											<th>Publisher</th>
											<th>Date</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < bookList.size(); i++) {
																				Book book = bookList.get(i);
										%>
										<tr>
											<td><%=book.getTitle()%></td>
											<td><%=book.getAuthor()%></td>
											<td><%=(float)book.getPrice()/100%></td>
											<td><%=book.getPublisher()%></td>
											<td><%=book.getDate()%></td>
											<td>
												<button class="btn btn-default add" type="button"
													data-bookid="<%=book.getId()%>" 
													data-user="<%=session.getAttribute("username")%>"
													data-userid="<%=session.getAttribute("id")%>">
													<i class="fa fa-shopping-cart" title="add book to cart"></i>
												</button>
												 <a href="detail?id=<%=book.getId()%>"> 
												 <i class="fa fa-info" title="Book info">&nbsp;detail</i>
												</a>
											</td>
											<%
											}
										%>
										
									</tbody>
								</table>
							</div>
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<div class="modal fade" id="modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="modalTitle"></h4>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
							<form role="form">
								<div class="form-group">
									<label>Amount</label> <input class="form-control" name="amount">
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="save">Save</button>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
	<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/bookstore/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/bookstore.js"></script>
	<script src="<%=path%>/bookstore/js/bootbox.min.js"></script>

</body>
</html>