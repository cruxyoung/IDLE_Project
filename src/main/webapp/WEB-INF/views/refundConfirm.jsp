<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
</head>
<body onload="load()">
	<!-- <jsp:include page="header.jsp" flush="true"/> -->
  <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal">IDLE</h5>
    <nav class="my-2 my-md-0 mr-md-3">
      <a class="p-2 text-dark" href="/app/">Home</a>
      <a class="p-2 text-dark" href="/app/item/add">Publish Item</a>
      <a class="p-2 text-dark" href="#">Personal Center</a>
      <a class="p-2 text-dark" href="/app/login">Login</a>
    </nav>
    <a class="btn btn-outline-primary" href="#">Sign up</a>
  </div>
  <!-- replace with header.jsp -->
  <div class="container">
    <div class="row">
      <div class="col-md-10 offset-md-1">
        <div class="table-wrapper" style="margin-top: 50px;">
          <form class="form" action="order/refundConfirm" method="post" id="form">
          	<h1>Apply Refund</h1>
            <div class="form-group row">
              <input name="operation" id="operation" type="hidden"/>
              <input class="form-control col-md-6" value="${order.id}" name="orderId" type="hidden"/>
            </div>
            <div class="form-group row">
              <label class="col-md-2">Reasons：</label>
              <textarea class="form-control col-md-6" name="reason" rows="5" disabled="disabled">${order.refundReason}</textarea>
            </div>
            <div class="form-group row justify-content-end col-md-6">
              <button class="btn btn-success" onclick="agree()">Agree</button>&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-danger" onclick="refuse()">Refuse</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="container-fluid">
    <!-- <jsp:include page="footer.jsp" flush="true"/> -->
    <div class="container-fluid">
      <footer class="pt-4 my-md-5 pt-md-5 border-top">
        <div class="row">
          <div class="col-12 col-md">
            <img class="mb-2" src="./resources/logo.png" width="200" height="100" >
            <small class="d-block mb-3 text-muted">© 2017-2018</small>
          </div>
          <div class="col-6 col-md">
            <h5>Contact </h5>
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
</body>
<script type="text/javascript">
	function agree(){
		$('#operation').val('agree');
		$("#form").submit();
	}
	function refuse(){
		$('#operation').val('refuse');
		$("#form").submit();
	}
</script>
</html>
