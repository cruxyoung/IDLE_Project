
<%
      String username = (String)session.getAttribute("username");
      if(username == null){ %>
    	  <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
          <h5 class="my-0 mr-md-auto font-weight-normal">IDLE</h5>
          <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="/app/">Home</a>
            <a class="p-2 text-dark" href="/app/item/add">Publish Item</a>
            <a class="p-2 text-dark" href="/app/personalcenter/personalinfo">Personal Center</a>
            <a class="p-2 text-dark" href="/app/user/login">Log In</a>
          </nav>
          <a class="btn btn-outline-primary" href="/app/user/register">Sign Up</a>
        </div>
      <% }else{ %>
    	  <div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
          <h5 class="my-0 mr-md-auto font-weight-normal">IDLE</h5>
          <nav class="my-2 my-md-0 mr-md-3">
            <a class="p-2 text-dark" href="/app/">Home</a>
            <a class="p-2 text-dark" href="/app/item/add">Publish Item</a>
            <a class="p-2 text-dark" href="/app/personalcenter/personalinfo">Personal Center</a>
            <a class="p-2 text-dark" >Welcome ${sessionScope.username}!</a>
          </nav>
          <a class="btn btn-outline-primary" href="/app/user/signout" onclick="javascript: return confirmSignOut()">Sign Out</a>
        </div>
      <% }%>

<script type="text/javascript">
function confirmSignOut(){
var result = confirm("Are you sure to log out?");
return result;
}
</script>

