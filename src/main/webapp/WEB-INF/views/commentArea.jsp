<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="container-fluid">
<form action="comment/add" method="POST">

<label for="content">Comment:</label>
<textarea name="content" value="" class="form-control" id="content"
					placeholder="Please input your comment..." row="5"></textarea>


<button type="submit" class="btn btn-primary">Submit</button>
</form>

<table>
<c:forEach items="${comments}" var="comment">
        <tr>
            <td>${comment.content}</td>
        </tr>
    </c:forEach>

</table>


</div>
