<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Login</title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />

</head>

<body>
<jsp:include page="header.jsp" flush="true"/>

<div class="container-fluid">
<div class="row">
<div class="col-6 col-md"></div>
<!-- <div class="col-6 col-md"></div> -->
<div class="col-6 col-md">
<form class="form-signin" action="login.do" method="POST">
        <h2 class="form-signin-heading">Please Sign In</h2>
        <br/>
        <label for="username" class="sr-only">User name</label>
        <input name="username" type="text" id="username" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <br/>
        <input name="password" type="password" id="password" class="form-control" placeholder="Password" required>
        <br/>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <br/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <br/>
        <a class="btn btn-outline-primary" href="/app/user/register" style="display:block;text-align:center">Create a New Account.</a>
      </form>
      </div>
<!-- <div class="col-6 col-md"></div> -->
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
  var result ='<%=request.getParameter("SignUpresult")%>';
  if(errori=='yes'){
   alert("Wrong username or password!");
  }else if(errori=='notlogin'){
	  alert("Please Sign In!");
  }
  if(result=='0'){
	alert("Sign Up Successfully!");
	  
  }
</script>