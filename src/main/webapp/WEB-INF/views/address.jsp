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
					<li class="nav-item"><a class="nav-link active"
						href="http://localhost:8080/app/personalcenter/address">Address
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/viewhistory">View
							History</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/myfavorite">My
							Favorite</a></li>
					<li class="nav-item"><a class="nav-link"
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
								<th>Receiver</th>
								<th>Phone</th>
								<th>Address</th>
								<th></th>
							</tr>
						</thead>
						<tbody>

							<c:forEach var="address" items="${addresslist}" varStatus="loop">
								<tr>
									<td>${loop.index + 1}</td>
									<td>${address.receiverName}</td>
									<td>${address.receiverPhone}</td>
									<td>${address.address}</td>
									<td><a href="address/addressdetail/${address.addressId}"><span
											class="fa fa-pencil"></span></a>
										&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <a
										href="address/delete/${address.addressId}"><span
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


		<div class="row">
			<div class="col-4"></div>
			<div class="col-4">
				<br /> <a class="btn btn-outline-primary"
					href="/app/personalcenter/address/addaddress"
					style="display: block; text-align: center">Add a New Address.</a>
			</div>
			<div class="col-4"></div>
		</div>
	</div>

	<div class="container-fluid">
		<jsp:include page="footer.jsp" flush="true" />

	</div>

</body>

</html>

<script> 

//取出传回来的参数error并与yes比较
  var updateresult ='<%=request.getParameter("updateresult")%>';
	if (updateresult != 'null') {
		alert(updateresult);
	}
</script>

<script type="text/javascript">
	function confirmDelete() {
		var result = confirm("Are you sure to delete it?");
		return result;
	}
</script>