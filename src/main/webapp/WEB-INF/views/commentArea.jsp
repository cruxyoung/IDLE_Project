<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<div class="row">
		<div class="col"></div>
		<div class="col-8">
			<form action="comment/add" method="POST">

				<label for="content">Comment:</label>
				<textarea  required="required"  name="content" value="" class="form-control" id="content"
					placeholder="Please input your comment..." row="5"></textarea>


				<button type="submit" class="btn btn-primary float-right">Submit</button>
			</form>
			<br><br>
			<div class="page-header">
				<h4>
					${comments.size()} Comments
				</h4>
			</div>
			<div class="comments-list">
				<c:forEach items="${comments}" var="comment">
					
					<div class="media">
					  <img class="align-self-start mr-3" src="<c:url value="/resources/avatar.png"/>" alt="Generic placeholder image" width="50" height="50">
					  <div class="media-body">
					    <h6 class="mt-0">Posted By: ${comment.user.getUserName()}</h6>
						<p>${comment.content}</p>
						<a href="comment/delete/${comment.id}"><span
											class="fa fa-remove"
											onclick="javascript: return confirmDelete()"></span></a>
           &nbsp&nbsp <a href="update/comment/${comment.id}"><span
											class="fa fa-pencil"
											></span></a>
							</p>					    
					  </div>
					</div>

				</c:forEach>
			</div>
		</div>
		<div class="col"></div>
	</div>
	
	

<script type="text/javascript">
function confirmDelete(){
var result = confirm("Are you sure to delete it?");
return result;
}
</script>

<script type="text/javascript">
var errori='<%=request.getParameter("error")%>';
if(errori=='notAuthorized'){
	alert("Your are not allowed to touch comments of other users!!!");
}
</script>





</div>
