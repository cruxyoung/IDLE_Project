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
	<jsp:include page="header.jsp" flush="true"/>
  
  <!-- replace with header.jsp -->
  <div class="container">
    <div class="row float-center">
      <div class="col-md-10 offset-md-1">
        <div class="table-wrapper" style="margin-top: 50px;">
          <form class="form" action="order/orderRefund" method="post">
          	<h1>Apply Refund</h1>
            <div class="form-group row">
              <input class="form-control col-md-6" value="${order.id}" name="orderId" type="hidden"/>
            </div>
            <div class="form-group row">
              <label class="col-md-2">Reasons：</label>
              <textarea class="form-control col-md-6" value="" name="reason" rows="5"></textarea>
            </div>
            <div class="form-group row justify-content-end col-md-6 float-center">
              <button class="btn btn-primary" type="submit">Submit</button>
              &nbsp;&nbsp;&nbsp;&nbsp;
             <a class="btn btn btn-outline-primary"
						href="http://localhost:8080/app/order/get/${order.id}"
						style="display: block; text-align: center">Cancel</a>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
  <div class="container-fluid">
    <jsp:include page="footer.jsp" flush="true"/>
    
  </div>
  <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
</body>
</html>
