<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<div class="row">
		<div class="col"></div>
		<div class="col-8">
			<form action="comment/add" method="POST">

				<label for="content">Comment:</label>
				<textarea name="content" value="" class="form-control" id="content"
					placeholder="Please input your comment..." row="5"></textarea>


				<button type="submit" class="btn btn-primary">Submit</button>
			</form>

			<div class="page-header">
				<h4>
					${comments.size()} Comments
				</h4>
			</div>
			<div class="comments-list">
				<c:forEach items="${comments}" var="comment">
					<div class="media">
						<div class="media-body">

							<h4 class="media-heading user_name">Posted By: ${comment.user.getUserName()}
							</h4>
							${comment.content}

							<p>
							<a href="comment/delete/${comment.id}" onclick="javascript: return confirmDelete()">Delete</a>
       
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
	alert("Your are not allowed to delete comments of other users!!!");
}
</script>





</div>
