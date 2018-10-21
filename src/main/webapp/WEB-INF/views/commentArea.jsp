<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="container-fluid">
<form action="comment/add" method="POST">

<label for="content">Comment:</label>
<textarea name="content" value="" class="form-control" id="content"
					placeholder="Please input your comment..." row="5"></textarea>


<button type="submit" class="btn btn-primary">Submit</button>
</form>



<div class="container">
            <div class="row">
                <div class="col-md-8">
                  <div class="page-header">
                    <h1><small class="pull-right">${comments.size()} </small> Comments </h1>
                  </div> 
                   <div class="comments-list">
                   <c:forEach items="${comments}" var="comment">
                   
                       <div class="media">
                           
                            
                            <div class="media-body">
                                
                              <h4 class="media-heading user_name">${comment.user.getUserName()} </h4>
                              ${comment.content} 
                              
                              <p><small><a href="">Like</a> - <a href="">Share</a></small></p>
                            </div>
                          </div>
                       
                       </c:forEach>
                   </div>
                    
                   
                    
                </div>
            </div>
        </div>

</div>
