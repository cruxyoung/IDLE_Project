<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Personal Center</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Personal Center</title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />

</head>

<body>
<jsp:include page="header.jsp" flush="true"/>

<div class="container-fluid">
<div class="row">
<div class="col"></div> 
<!-- <div class="col-6 col-md"></div> -->
<div class="col-8">

<ul class="nav nav-tabs">
  <li class="nav-item">
    <a class="nav-link" href="http://localhost:8080/app/personalcenter/personalinfo">Personal Information</a>
  </li>
  <li class="nav-item">
    <a class="nav-link active" href="#">Address Management</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="http://localhost:8080/app/personalcenter/viewhistory">View History</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="http://localhost:8080/app/personalcenter/myfavorite">My Favorite</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="http://localhost:8080/app/personalcenter/mypublished">My Published</a>
  </li>
</ul>

</div>

<div class="col"></div>
</div>
</div>

<div class="container-fluid">
	<jsp:include page="footer.jsp" flush="true"/>
	
</div>

</body>

</html>

<script> 

//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error")%>';
  if(errori=='yes'){
   alert("Wrong username or password!");
  }
</script>