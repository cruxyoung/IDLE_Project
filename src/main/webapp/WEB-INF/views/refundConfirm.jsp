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
<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
</head>
<body onload="load()">
	<jsp:include page="header.jsp" flush="true" />

	<!-- replace with header.jsp -->
	<div class="container">
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<div class="table-wrapper" style="margin-top: 50px;">
					<form class="form" action="order/refundConfirm" method="post"
						id="form">
						<h1>Apply Refund</h1>
						<div class="form-group row">
							<input name="operation" id="operation" type="hidden" /> <input
								class="form-control col-md-6" value="${order.id}" name="orderId"
								type="hidden" />
						</div>
						<div class="form-group row">
							<label class="col-md-2">Reasons：</label>
							<textarea class="form-control col-md-6" name="reason" rows="5"
								disabled="disabled">${order.refundReason}</textarea>
						</div>
						<c:if test="${order.orderStatus== 2}">
						<div class="form-group row justify-content-end col-md-6">
							<button class="btn btn-primary" onclick="agree()">Agree</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-danger" onclick="refuse()">Refuse</button>
						</div>
						</c:if>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<jsp:include page="footer.jsp" flush="true" />

	</div>
</body>
<script type="text/javascript">
	function agree() {
		$('#operation').val('agree');
		$("#form").submit();
	}
	function refuse() {
		$('#operation').val('refuse');
		$("#form").submit();
	}
</script>
</html>
