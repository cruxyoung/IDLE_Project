<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<title>UpdateItem</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Update Item</title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />

</head>

<body>
	
	<jsp:include page="header.jsp" flush="true"/>
	
	
	<div class="container-fluid">
<div class="row">
    <div class="col-sm">
      
    </div>
    <div class="col-sm">
      <form action="item/update/comment/${comment.id}" method="POST" >
				<label for="content">Please input your modification!</label> 
				<textarea name="content" class="form-control" id="content"
					placeholder="${comment.content}" row="10">${comment.content}</textarea>

			
			<button type="submit" class="btn btn-primary float-right">Submit</button>
		</form>
		
    </div>
    <div class="col-sm">
      
    </div>
  </div>
	
	<jsp:include page="footer.jsp" flush="true" />
	
<script type="text/javascript">
var errori='<%=request.getParameter("error")%>';
if(errori=='notAuthorized'){
	alert("Your are not allowed to delete comments of other users!!!");
}
</script>
</body>
</html>