<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>My Published</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>My Published</title>
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet">

</head>

<body>
	<jsp:include page="header.jsp" flush="true" />

	<div class="container-fluid">
		<div class="row">
			<div class="col"></div>
			<!-- <div class="col-6 col-md"></div> -->
			<div class="col-8">

				<ul class="nav nav-tabs">
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/personalinfo">Profile
					</a></li>
					<li class="nav-item"><a class="nav-link "
						href="http://localhost:8080/app/personalcenter/address">Address
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/viewhistory">View
							History</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/myfavorite">My
							Favorite</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="http://localhost:8080/app/personalcenter/mypublished">My
							Published</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/mybought">My
							Bought</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/mysold">My Sold</a>
					</li>
				</ul>

				<br />

				<div class="row margin-top-20">
					<table class="table">
						<thead>
							<tr>
								<th class="seq">Id</th>
								<th>Item Photo</th>
								<th>Item Name</th>
								<th>Item Quantity</th>
								<th>Item Price</th>
								<th></th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="item" items="${itemlist}" varStatus="loop">
								<tr>
									<td>${loop.index + 1}</td>
									<td><img class="mb-2" src="<c:out value='${item.photo}'/>"
										alt="" height="150px" width="180px"></td>
									<td>${item.name}</td>
									<td>${item.quantity}</td>
									<td>${item.price}</td>
									<td><a href="#"><span class="fa fa-pencil"></span></a>
										&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a
										href="http://localhost:8080/app/item/delete/${item.id}"><span
											class="fa fa-remove"
											onclick="javascript: return confirmDelete()"></span></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>

			</div>

			<div class="col"></div>
		</div>
	</div>

	<div class="container-fluid">
		<jsp:include page="footer.jsp" flush="true" />

	</div>

</body>

</html>

<script> 

  var result ='<%=request.getParameter("result")%>
	';
	if (result == 'yes') {
		alert("Delete Successfully!");
	}
</script>
<script type="text/javascript">
	function confirmDelete() {
		var result = confirm("Are you sure to delete it?");
		return result;
	}
</script>