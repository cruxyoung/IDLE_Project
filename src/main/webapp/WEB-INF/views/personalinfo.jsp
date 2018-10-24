<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Personal Center</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Personal Center</title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />

<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">
	
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
    <a class="nav-link active" href="http://localhost:8080/app/personalcenter/personalinfo">Personal Information</a>
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


<form class="form-modifyuser" action="modifyuserinfo.do" method="POST">
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
        <input name="password" type="password" id="password" class="form-control" placeholder="Enter Password" value='${user.password}' required>
        <br/>
        
        <label for="confirmPassword">Confirm New Password</label>
        <input name="confirmpassword" type="password" id="confirmpassword" class="form-control" placeholder="Re-enter Password" value='${user.password}' required>
        <br/>
        
        <br/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Modify</button>
</form>

<div class="col-6">
<form class="form-topup" action="topup.do" method="POST">
	<br/>
    <label for="originalbalance">Your Balance: <span class="fa fa-usd"></span> ${user.balance}</label>
    <br/><br/>
    <input name="balance" type="text" id="balance" class="form-control" placeholder="Enter how much you want to charge..." required autofocus>
    <br/>
    <button class="btn btn-lg btn-primary btn-block" type="submit">Top Up</button>
</form>
</div>
        
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

  var errori ='<%=request.getParameter("error")%>';
  var updateResult ='<%=request.getParameter("updateresult")%>';
  if(errori=='wrongPassword'){
   alert("Two passwords you input are not same, Please try again!");
  }
  if(errori=='balanceWrong'){
	  alert("Balance you input should be numberic!");
  }
  if(updateResult != 'null'){
	  alert(updateResult);
  }
</script>