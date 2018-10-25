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
      <form action="item/update/${item.id}?${_csrf.parameterName}=${_csrf.token}" method="POST" enctype="multipart/form-data">
			<div class="form-group">
				<label for="item_name">Item Name</label> 
				<input name="name" value="${item.name }"
					type="name" class="form-control" id="item_name"
					placeholder="Enter name"> 
				<label for="item_quantity">Item quantity</label> 
				<input name="quantity" type="number" value="${item.quantity}" class="form-control"
					id="item_quantity" placeholder="0"> 
				<label for="item_description">Item description</label> 
				<textarea name="description" value="${item.description}" class="form-control" id="item_description"
					placeholder="${item.description}" row="5"></textarea>
				<label for="item_price">Item price</label>
				<input name="price" type="number" value="${item.price}" class="form-control" id="item_price" placeholder="10">
				Category: 
				<select name="category">
				  <c:forEach items="${cates}" var="cate">
				  	<option value = "${cate.categoryName}">${cate.categoryName}</option> 
				  </c:forEach>
				</select>
				<br>
				<label for="item_photo"> Please submit photo of your item</label>
				<input type="file" name="file"><br /> 
				

			</div>
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