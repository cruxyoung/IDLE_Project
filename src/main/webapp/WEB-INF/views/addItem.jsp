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
	
	<jsp:include page="header.jsp" flush="true"/>
	<jsp:include page="addItemCom.jsp" flush="true"/>
	<jsp:include page="footer.jsp" flush="true" />

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	</script>
</body>
</html>
