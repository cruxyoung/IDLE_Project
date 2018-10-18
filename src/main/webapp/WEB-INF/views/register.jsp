<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Register</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Register</title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />

</head>

<body>
<jsp:include page="header.jsp" flush="true"/>

<div class="container-fluid">
<div class="row">
<div class="col-6 col-md"></div>

<div class="col-6 col-md">
<form class="form-signin" action="register.do" method="POST">
        <h2 class="form-signin-heading">Please Input Information</h2>
        <br/>
        
        <label for="username">User name</label>
        <input name="username" type="text" id="username" class="form-control" placeholder="Enter username" required autofocus>
        <br/>
        
        <label for="inputPassword">Password</label>
        <input name="password" type="password" id="password" class="form-control" placeholder="Enter Password" required>
        <br/>
        
        <label for="confirmPassword">Confirm Password</label>
        <input name="confirmpassword" type="password" id="confirmpassword" class="form-control" placeholder="Re-enter Password" required>
        <br/>
        
        <label for="email">Email</label>
        <input name="email" type="email" id="email" class="form-control" placeholder="Enter email" required autofocus>
        <br/>
        
        <label for="phone">Phone</label>
        <input name="phone" type="text" id="phone" class="form-control" placeholder="Enter phone number" required autofocus>
        <br/>
        
        <br/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign Up</button>
        <br/>
        <a class="btn btn-outline-primary" href="/app/user/login" style="display:block;text-align:center">Already has account? Log in.</a>
      </form>
      </div>

<div class="col-6 col-md"></div>
</div>
</div>




<div class="container-fluid">
	<jsp:include page="footer.jsp" flush="true"/>
	
</div>





<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>

</html>

<script> 

//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error")%>';
  if(errori=='wrongPassword'){
   alert("Two passwords you input are not same, Please try again!");
  }else if(errori != 'null'){
	  alert(errori);
  }
</script>