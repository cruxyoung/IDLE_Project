
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>Title</title>
<title>Order</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>item</title>
<link href="resources/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css/order.css" rel="stylesheet" type="text/css" />
</head>
<body onload="load()">
	<!-- <jsp:include page="header.jsp" flush="true"/> -->
	<jsp:include page="header.jsp" flush="true" />
	<!-- replace with header.jsp -->
	<div class="container-fluid">
		<div class="row">
			<div class="col"></div>
			<!-- <div class="col-6 col-md"></div> -->
			<div class="col-8">

				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/personalinfo">Profile
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/address">Address
					</a></li>
					<li class="nav-item"><a class="nav-link" href="#">View
							History</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/myfavorite">My
							Favorite</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/mypublished">My
							Published</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/mybought">My
							Bought</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="http://localhost:8080/app/personalcenter/mysold">My Sold</a>
					</li>
				</ul>
				<br />
				<div align="center">
					<h3 class="form-signin-heading">Order Information</h3>
				</div>
				<br />
				<form class="form" action="order/orderConfirm" method="post">
					<div class="form-group row">
						<label class="col-md-2">Order No：</label> <input
							class="form-control col-md-10" value="${order.id}" name="orderId"
							readonly />
					</div>
					<div class="form-group row">
						<label class="col-md-2">Item：</label> <input
							class="form-control col-md-10" value="${order.item.name}"
							readonly />
					</div>
					<div class="form-group row">
						<label class="col-md-2">Seller：</label> <input
							class="form-control col-md-10" value="${order.seller.userName}"
							readonly />
					</div>
					<div class="form-group row">
						<label class="col-md-2">Seller contract Number：</label> <input
							class="form-control col-md-10" value="${order.seller.phone}"
							readonly />
					</div>
					<div class="form-group row">
						<label class="col-md-2">Buyer：</label> <input
							class="form-control col-md-10" value="${order.buyer.userName}"
							readonly />
					</div>
					<div class="form-group row">
						<label class="col-md-2">Buyer Address：</label> <input
							class="form-control col-md-10" value="${buyerAddress.address}"
							readonly />
					</div>
					<div class="form-group row">
						<label class="col-md-2">Transaction Time：</label> <input
							class="form-control col-md-10"
							value="<fmt:formatDate value="${order.lastEditTime}" pattern="yyyy-MM-dd HH:mm:ss" />"
							readonly />
					</div>
					<div class="form-group row">
						<label class="col-md-2">Order Status：</label> <input
							class="form-control col-md-10"
							value='<c:if test="${order.orderStatus== 0}">In Transaction</c:if><c:if test="${order.orderStatus== 1}">Transaction Finish</c:if><c:if test="${order.orderStatus== 2}">Refunding</c:if><c:if test="${order.orderStatus== 3}">Refund Finish</c:if><c:if test="${order.orderStatus== 4}">Refund Refused</c:if>'
							readonly />
					</div>

					<c:if test="${order.orderStatus== 0}">
						<div class="form-group row justify-content-end">
							<button class="btn btn-lg btn-primary btn-block" type="submit">confirm</button>

						</div>
					</c:if>

					<c:if test="${order.orderStatus== 2}">

						<a class="btn btn-lg btn-primary"
							href="http://localhost:8080/app/order/refundConfirm/${order.id}"
							style="display: block; text-align: center">Refund Process</a>

					</c:if>
					<br /> <a class="btn btn-lg btn-outline-primary"
						href="http://localhost:8080/app/personalcenter/mysold"
						style="display: block; text-align: center">Cancel</a>
				</form>


			</div>

			<div class="col"></div>
		</div>
	</div>
	<div class="container-fluid">
		<jsp:include page="footer.jsp" flush="true" />

	</div>
	<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
</body>
</html>
