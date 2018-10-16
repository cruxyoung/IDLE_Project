<div class="container-fluid">
<div class="row">
    <div class="col-sm">
      
    </div>
    <div class="col-sm">
      <form action="item/add" method="POST">
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
				<label for="item_photo"> Item photo(to be imple)</label>
				
				

			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
    </div>
    <div class="col-sm">
      
    </div>
  </div>

		


	</div>