<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>Title</title>
<title>Order</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>item</title>
<link href="resources/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="resources/css/order.css" rel="stylesheet" type="text/css" />
</head>
<body onload="load()">
	<form action="order/payNow.do" method="post" onsubmit='return payNow()'>
		<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
			<h5 class="my-0 mr-md-auto font-weight-normal">IDLE</h5>
			<nav class="my-2 my-md-0 mr-md-3">
				<a class="p-2 text-dark" href="/app/">Home</a> <a
					class="p-2 text-dark" href="/app/item/add">Publish Item</a> <a
					class="p-2 text-dark" href="#">Personal Center</a> <a
					class="p-2 text-dark" href="/app/login">Login</a>
			</nav>
			<a class="btn btn-outline-primary" href="#">Sign up</a>
		</div>
		<div class="container">
			<div class="row wrapper">
				<div class="col-md">
					<div class="row">
						<div class="col-md">
							<h1 class="title text-center">My Order</h1>
							<input class="form-control" type="hidden" name="itemId" value="${item.id}">
						</div>
					</div>
					<div class="row">
						<div class="col-md">
							<table>
								<tbody>
									<tr>
										<td>
											<div class="thumbnail-wrapper">
												<img src="resources/placeholder.png">
											</div>
										</td>
										<td>
											<div class="item-name">
												<div>
													<strong>Item Name</strong>
												</div>
												<div>
													<input class="form-control" type="text" disabled="disabled"	value="${item.name}">
												</div>
											</div>
										</td>
										<td>
											<div class="item-price">
												<div>
													<strong>Price</strong>
												</div>
												<div>
													<input class="form-control" type="text" disabled="disabled"	value="${item.price}">
												</div>
											</div>
										</td>
										<td>
											<div class="item-quantity">
												<div>
													<strong>Quantity</strong>
												</div>
												<div>
													<input class="form-control" type="text" disabled="disabled"	value="1">
												</div>
											</div>
										</td>
										<td>
											<div class="item-total">
												<div>
													<strong>Total</strong>
												</div>
												<div>
													<input class="form-control" type="text" disabled="disabled"	value="${item.price * 1}">
												</div>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-md title-2">
							<h2>Receiver Address</h2>
						</div>
					</div>
					<div class="row">
						<div class="col-md">
							<div class="legend">
								<div class="form-group row">
									<label class="col-md-2 custom-label"> ReceiverAddress</label> 
									<select class="form-control col-md-6" name="address" id="address">
										<option value="">Please select</option>
										<c:forEach items="${addressList}" var="address">
											<option value="${address.addressId}">${address.address}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md title-2">
							<h2>Payment</h2>
						</div>
					</div>
					<div class="row">
						<div class="col-md">
							<div class="legend">
								<div class="label">
									<Strong>My Wallet</Strong>
								</div>
								<div class="form-group row">
									<label class="col-md-2 custom-label">My Balance</label> 
									<input class="form-control col-md-3" disabled="disabled" value="${user.balance}" />
								</div>
							</div>
						</div>
					</div>
					<div class="row" style="margin-bottom: 30px;">
						<div class="col-md d-flex flex-row justify-content-end align-items-center">
							<strong>Total Price:</strong> 
							<input class="form-control" type="text" value="${item.price * 1}" disabled="disabled" id="totalPrice" style="width: 200px; margin-left: 20px;" /> 
							<button class="btn btn-primary" style="margin-left: 20px;" type="submit">Pay Now</button>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md">
					<div class="text-center">Contact Us: XXX@XXX.com</div>
				</div>
			</div>
		</div>

		<div class="container-fluid">
			<div class="container-fluid">
				<footer class="pt-4 my-md-5 pt-md-5 border-top">
					<div class="row">
						<div class="col-12 col-md">
							<img class="mb-2" src="resources/logo.png" width="200" height="100">
							<small class="d-block mb-3 text-muted">©2017-2018</small>
						</div>
						<div class="col-6 col-md">
							<h5>Contact</h5>
							<ul class="list-unstyled text-small">
								<li><a class="text-muted" href="#">News</a></li>
								<li><a class="text-muted" href="#">Random feature</a></li>
								<li><a class="text-muted" href="#">Team feature</a></li>
								<li><a class="text-muted" href="#">Stuff for developers</a></li>
								<li><a class="text-muted" href="#">Another one</a></li>
								<li><a class="text-muted" href="#">Last time</a></li>
							</ul>
						</div>
						<div class="col-6 col-md">
							<h5>Resources</h5>
							<ul class="list-unstyled text-small">
								<li><a class="text-muted" href="#">Resource</a></li>
								<li><a class="text-muted" href="#">Resource name</a></li>
								<li><a class="text-muted" href="#">Another resource</a></li>
								<li><a class="text-muted" href="#">Final resource</a></li>
							</ul>
						</div>
						<div class="col-6 col-md">
							<h5>About</h5>
							<ul class="list-unstyled text-small">
								<li><a class="text-muted" href="#">Team</a></li>
								<li><a class="text-muted" href="#">Locations</a></li>
								<li><a class="text-muted" href="#">Privacy</a></li>
								<li><a class="text-muted" href="#">Terms</a></li>
							</ul>
						</div>
					</div>
				</footer>
			</div>
			<!--  -->
		</div>
	</form>


	<script>
		function e(selector) {
			return document.querySelector(selector);
		}

		function load() {

		}

		function payNow() {
			var balance = '${user.balance}';
			var totalPrice = e('#totalPrice').value;
			if(parseFloat(totalPrice) > parseFloat(balance)){
				alert("Your balance is not enough. Please top up.");
				window.location.href = "personalcenter/personalinfo";
				return false;
			}
			
			var address = e('#address').value;

			if (address == "") {
				alert(" Address is Must ");
				return false;
			}
			return true
		}
	</script>

</body>
</html>
