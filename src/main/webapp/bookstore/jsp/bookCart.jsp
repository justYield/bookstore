<%@ page import="java.util.ArrayList"%>
<%@ page import="model.BookCart"%>
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
<link href="<%=path%>/bookstore/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/dataTables.responsive.css"
	rel="stylesheet">
<link href="<%=path%>/bookstore/css/bookstore.css" rel="stylesheet">
<link href="<%=path%>/bookstore/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
	<script src="<%=path%>/bookstore/js/bookCart.js"></script>
</head>

<body>
	<%
		ArrayList<BookCart> carts = new ArrayList<BookCart>();
		ArrayList<Book> books = new ArrayList<Book>();
		if (request.getAttribute("cart") != null) {
			carts = (ArrayList<BookCart>) request.getAttribute("cart");
			books = (ArrayList<Book>) request.getAttribute("booksInCart");
		}
	%>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

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

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Book Cart</h1>
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
											<th>Book Name</th>
											<th>Amount</th>
											<th></th>
										</tr>
									</thead>
									<tbody>
										<%
											for (int i = 0; i < carts.size(); i++) {
																				Book book = books.get(i);
																				BookCart cart = carts.get(i);
										%>
										<tr>
											<td><%=book.getTitle()%></td>
											<td><%=cart.getAmount()%></td>
											<td>
												<button class="btn btn-default delete" type="button"
													data-id="<%=cart.getId()%>">
													<i class="fa fa-trash"></i>
												</button>
											</td>
										</tr>
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
			<a href="buyAll?id=<%=session.getAttribute("id")%>"><h3>Buy books</h3></a>
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->


	<script src="<%=path%>/bookstore/js/jquery.min.js"></script>
	<script src="<%=path%>/bookstore/js/bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/jquery.dataTables.min.js"></script>
	<script src="<%=path%>/bookstore/js/dataTables.bootstrap.min.js"></script>
	<script src="<%=path%>/bookstore/js/bookstore.js"></script>
	<script src="<%=path%>/bookstore/js/bootbox.min.js"></script>

	<script src="<%=path%>/bookstore/js/bookCart.js"></script>

	<script>
		$(document).ready(function() {
			$('#dataTables').DataTable({
				responsive : true
			});
		});
	</script>

</body>

</html>

