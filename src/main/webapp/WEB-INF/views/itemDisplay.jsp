<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<title>Item</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>item</title>
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/comment-list.css" />" rel="stylesheet" type="text/css" />
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">


<style>
.red-icon{
color:red !important;
}
</style>
</head>


<body>
<jsp:include page="header.jsp" flush="true"/>




<div class="container-fluid">



<div class="row">
<div class="col-6 col-md"></div>
<div class="col-6 col-md">
<img class="mb-2" src="<c:out value='${item.photo}'/>" alt="" height="300px" width="300px">

</div>
<div class="col-6 col-md">
<ul class="list-unstyled">

<li><h4>Name: <c:out value='${item.name}'/></h4></li>
<li><h4>Description: <c:out value='${item.description}'/></h4>  </li>
<li><h4>Owner: <c:out value='${item.owner.getUserName()}'/></h4>  </li>
<li><h4>Quantity: <c:out value='${item.quantity}'/></h4>  </li>
<li><h4>Price: $<c:out value='${item.price}'/></h4>  </li>



<li><h4>Category: <c:out value='${item.category.categoryName}'/></h4></li>
<%
	Long fav = (Long)session.getAttribute("favStatus");
	if(fav==0){ %>
		<li><a href="/app/item/changeFav"><span class="fa fa-heart"></span></a>&nbsp&nbsp <a href="/app/item/update/${item.id.intValue()}"><span class="fa fa-pencil"></span></a></li>
	<% }else { %>
	<li><a href="/app/item/changeFav"><span class="fa fa-heart red-icon"></span></a>&nbsp&nbsp <a href="/app/item/update/${item.id.intValue()}"><span class="fa fa-pencil"></span></a></li>
<% } %>
<li></li>
</ul>

<a href="/app/order/createorder/${item.id.intValue()}"><input class="btn btn-primary" type="button" value="Buy it now!"></a>


</div>
<div class="col-6 col-md"></div>


</div>


</div>

<jsp:include page="commentArea.jsp" flush="true"/>


<div class="container-fluid">
	<jsp:include page="footer.jsp" flush="true"/>
</div>




<script> 

//取出传回来的参数error并与yes比较
  var errori ='<%=request.getParameter("error")%>';
  if(errori=='sameUser'){
   alert("You cannot buy your own item");
  }
  
</script>


</body>

</html>