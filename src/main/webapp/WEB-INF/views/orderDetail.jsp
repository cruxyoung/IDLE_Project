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
          <form class="form">
            <div class="form-group row">
              <label class="col-md-2">Order No：</label>
              <input class="form-control col-md-6" value="${order.id}" readonly />
            </div>
            <div class="form-group row">
              <label class="col-md-2">Item：</label>
              <input class="form-control col-md-6" value="${order.item.name}" readonly />
            </div>
            <div class="form-group row">
              <label class="col-md-2">Seller：</label>
              <input class="form-control col-md-6" value="${order.seller.userName}" readonly />
            </div>
            <div class="form-group row">
              <label class="col-md-2">Seller contract Number：</label>
              <input class="form-control col-md-6" value="${order.seller.phone}" readonly />
            </div> 
            <div class="form-group row">
              <label class="col-md-2">Buyer：</label>
              <input class="form-control col-md-6" value="${order.buyer.userName}" readonly />
            </div>
            <div class="form-group row">
              <label class="col-md-2">Buyer Address：</label>
              <input class="form-control col-md-6" value="${buyerAddress.address}" readonly />
            </div> 
            <div class="form-group row">
              <label class="col-md-2">Transaction Time：</label>
              <input class="form-control col-md-6" value="<fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm:ss" />" readonly />
            </div>
            <div class="form-group row">
              <label class="col-md-2">Order Status：</label>
              <input class="form-control col-md-6" value='<c:if test="${order.orderStatus== 0}">in Transaction</c:if><c:if test="${order.orderStatus== 1}">Transaction finish</c:if><c:if test="${order.orderStatus== 2}">refunding</c:if><c:if test="${order.orderStatus== 3}">refund finish</c:if><c:if test="${order.orderStatus== 4}">refund refunded</c:if>'  readonly />
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
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
</body>
</html>
