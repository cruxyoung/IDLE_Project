<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>



<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<h1>Hello world!</h1>

	<div class="container-fluid">

		<form action="item/add" method="POST">
			<div class="form-group">
				<label for="item_name">Item Name</label> 
				<input name="name"
					type="name" class="form-control" id="item_name"
					placeholder="Enter name"> 
				<label for="item_quantity">Item quantity</label> 
				<input name="quantity" class="form-control"
					id="item_quantity" placeholder="0"> 
				<label for="item_description">Item description</label> 
				<textarea name="description" class="form-control" id="item_description"
					placeholder="Item description..." row="5"></textarea>
				<label for="item_price">Item price</label>
				<input name="price" class="form-control" id="item_price" placeholder="10">
				<label for="item_photo"> Item photo(to be imple)</label>
				
				

			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>


	</div>

	<P>The time on the serve.</P>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</body>
</html>
