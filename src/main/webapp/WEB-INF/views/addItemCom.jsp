<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<div class="container-fluid">
<div class="row">
    <div class="col-sm">
      
    </div>
    <div class="col-sm">
      <form action="item/add?${_csrf.parameterName}=${_csrf.token}" method="POST" enctype="multipart/form-data">
			<div class="form-group">
				<label for="item_name">Item Name</label> 
				<input name="name" value=""
					type="name" class="form-control" id="item_name"
					placeholder="Enter name"> 
				<label for="item_quantity">Item quantity</label> 
				<input name="quantity" type="number" value="0" class="form-control"
					id="item_quantity" placeholder="0"> 
				<label for="item_description">Item description</label> 
				<textarea name="description" value="" class="form-control" id="item_description"
					placeholder="Item description..." row="5"></textarea>
				<label for="item_price">Item price</label>
				<input name="price" type="number" value="0" class="form-control" id="item_price" placeholder="10">
				Category: 
				<select name="category">
				  <c:forEach items="${cates}" var="cate">
				  	<option value = "${cate.categoryName}">${cate.categoryName}</option> 
				  </c:forEach>
				</select>
				<br>
				<label for="item_photo"> Please submit photo of your item</label>
				<input type="file" name="file"><br /> 
				
				

			</div>
			<button type="submit" class="btn btn-primary float-right">Submit</button>
		</form>
		
    </div>
    <div class="col-sm">
      
    </div>
  </div>

		


	</div>