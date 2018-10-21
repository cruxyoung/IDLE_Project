<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
<title>Item</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>item</title>
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet" type="text/css" />

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

<li><h3>item name: <c:out value='${item.name}'/></h3></li>
<li><h3>item description: <c:out value='${item.description}'/></h3>  </li>
<li><h3>item owner: <c:out value='${item.owner.getUserName()}'/></h3>  </li>
<li><h3>item quantity: <c:out value='${item.quantity}'/></h3>  </li>
<li><h3>item Category: <c:out value='${item.category.categoryName}'/></h3>
</ul>

<input class="btn btn-primary" type="button" value="Buy it now!">


</div>
<div class="col-6 col-md"></div>


</div>


</div>

<jsp:include page="commentArea.jsp" flush="true"/>


<div class="container-fluid">
	<jsp:include page="footer.jsp" flush="true"/>
	
</div>



<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


</body>

</html>