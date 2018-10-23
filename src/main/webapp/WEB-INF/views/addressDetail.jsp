<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Address Detail</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Address Detail</title>
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
						href="http://localhost:8080/app/personalcenter/personalinfo">Personal
							Information</a></li>
					<li class="nav-item"><a class="nav-link active" href="#">Address
							Management</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/viewhistory">View
							History</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/myfavorite">My
							Favorite</a></li>
					<li class="nav-item"><a class="nav-link"
						href="http://localhost:8080/app/personalcenter/mypublished">My
							Published</a></li>
				</ul>

				<br />

		<form class="form-addressModify" action="modify/${address.addressId}" method="POST">

        <br/>
        
        <label for="recivername">Receiver Name</label>
        <input name="recivername" type="text" id="recivername" class="form-control" value='${address.receiverName}' required autofocus>
        <br/>
        
        <label for="receiverphone">Receiver Phone</label>
        <input name="receiverphone" type="text" id="receiverphone" class="form-control" value='${address.receiverPhone}' required>
        <br/>
        
        <label for="address">Address</label>
        <input name="address" type="text" id="address" class="form-control" value='${address.address}' required autofocus>
        <br/>
        
        <br/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Modify</button>
        <br/>
        <a class="btn btn-lg btn-outline-primary" href="http://localhost:8080/app/personalcenter/address" style="display:block;text-align:center">Cancel</a>
      </form>

			</div>

			<div class="col"></div>
		</div>
	</div>

	<div class="container-fluid">
		<jsp:include page="footer.jsp" flush="true" />

	</div>

</body>

</html>