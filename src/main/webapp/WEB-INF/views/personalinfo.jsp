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
    <a class="nav-link active" href="#">Personal Information</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="http://localhost:8080/app/personalcenter/address">Address Management</a>
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


<form class="form-signin" action="register.do" method="POST">
        <!-- <h2 class="form-signin-heading">Please Input Information</h2> -->
        <br/>
        
        <label for="username">User name</label>
        <input name="username" type="text" id="username" class="form-control" value='${user.userName}' required autofocus>
        <br/>
        
        <label for="email">Email</label>
        <input name="email" type="email" id="email" class="form-control"  value='${user.email}' required autofocus>
        <br/>
        
        <label for="phone">Phone</label>
        <input name="phone" type="text" id="phone" class="form-control"  value='${user.phone}' required autofocus>
        <br/>
        
        <label for="inputPassword"> New Password (Do not have to set new password!)</label>
        <input name="password" type="password" id="password" class="form-control" placeholder="Enter Password" required>
        <br/>
        
        <label for="confirmPassword">Confirm New Password</label>
        <input name="confirmpassword" type="password" id="confirmpassword" class="form-control" placeholder="Re-enter Password" required>
        <br/>
        
        <br/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Modify</button>
</form>

        
</div>

<div class="col"></div>
</div>


<div class="container-fluid">
	<jsp:include page="footer.jsp" flush="true"/>
	
</div>

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