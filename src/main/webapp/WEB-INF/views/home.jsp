<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>IDLE</title>
<meta name="description" content="IDLE">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/bootstrap.css" />"
	rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="<c:url value="/resources/js/index.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/js/main.css" />">
<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script src="<c:url value="/resources/js/vue.min.js" />"></script>
<script src="<c:url value="/resources/js/index.js" />"></script>
</head>
<body>
<jsp:include page="header.jsp" flush="true"/>
	<div id="app">
		<template> <!-- 头部 --> <el-row> <el-col :span="24">
		
		</el-col> </el-row> <!-- 搜索框 --> <el-row>
		<div style="height: 140px; box-shadow: 0 0 3px 3px #d3dce6">
			<div style="padding-top: 50px; width: 70%; margin-left: 20%">
				<el-input placeholder="Search for anything you want..."
					v-model="search_name" class="input-with-select"> <el-select
					v-model="type" slot="prepend" placeholder="type" size="medium">
				<el-option
					label="Antiques" value="1"></el-option> <el-option
					label="Baby" value="2"></el-option> <el-option
					label="Boats" value="3"></el-option> <el-option
					label="Books" value="4"></el-option> <el-option
					label="Cars" value="5"></el-option><el-option
					label="Clothing" value="6"></el-option><el-option
					label="Community" value="7"></el-option><el-option
					label="Electronics" value="8"></el-option><el-option
					label="Home" value="9"></el-option><el-option
					label="Jobs" value="10"></el-option><el-option
					label="Others" value="11"></el-option>
					 </el-select> <el-button
					slot="append" icon="el-icon-search" @click="search()"></el-button>
				</el-input>
			</div>
		</div>
		</el-row> <!-- 菜单栏 -->  <!-- 跑马灯 --> <el-row> <el-carousel :interval="3000"
			type="card" height="260px"> <el-carousel-item
			v-for="item in dataimg" :key="item">
		<div class="grid-content">
			<el-col :md="12" :offset="6">
			<div>
			<a :href="'/app/item/get/'+item.id">
				<img style="max-width: 100%; max-height: 100%;"
					:title="item.description" :alt="item.description" :src="item.photo"></a>
			</div>
			</el-col>
		</div>
		</el-carousel-item> </el-carousel> </el-row>
		<hr>
		<el-row>
		<div style="margin-top: 20px; float: right; margin-right: 50px;">
			<span style="font-weight: bold;">Sort By</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<el-radio-group v-model="sort" size="small" @change="search">
			<el-radio-button label="New"></el-radio-button> <el-radio-button
				label="Quantity"></el-radio-button> <el-radio-button label="Price"></el-radio-button>
			</el-radio-group>
		</div>
		</el-row> <el-row>
		<div
			style="float: left; width: 20%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px;">
			<a :href="'/app/item/get/'+goods[0].id"><img style="max-width: 100%; max-height: 100%;"
				:title="goods[0].description" alt="" :src="goods[0].photo" /></a>
		</div>
		 <div
			style="float: left; width: 24%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px; margin-left: 2%">
			<a :href="'/app/item/get/'+goods[1].id">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[1].description" alt="" :src="goods[1].photo" /></a>
		</div>
		<div
		
			style="float: left; width: 35%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px; margin-left: 2%">
			<a :href="'/app/item/get/'+goods[2].id">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[2].description" alt="" :src="goods[2].photo" /></a>
		</div>
		<div
			style="float: left; width: 15%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px; margin-left: 2%">
			<a :href="'/app/item/get/'+goods[3].id">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[3].description" alt="" :src="goods[3].photo" /></a>
		</div>
		</el-row> <el-row>
		<div
			style="float: left; width: 15%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px; margin-left: 2%">
			<a :href="'/app/item/get/'+goods[4].id">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[4].description" alt="" :src="goods[4].photo" /></a>
		</div>
		<div
			style="float: left; width: 35%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px; margin-left: 2%">
			<a :href="'/app/item/get/'+goods[5].id">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[5].description" alt="" :src="goods[5].photo" /></a>
		</div>
		<div
			style="float: left; width: 24%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px; margin-left: 2%">
			<a :href="'/app/item/get/'+goods[6].id">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[6].description" alt="" :src="goods[6].photo" /></a>
		</div>
		<div
			style="float: left; width: 20%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px;">
			<a :href="'/app/item/get/'+goods[7].id">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[7].description" alt="" :src="goods[7].photo" /></a>
		</div>
		</el-row> <el-row> <el-col :span="24">
		<div class="grid-content bg-purple-white"
			style="height: 50px; text-align: center;">
			<span style="margin-top: 20px"><font color="white" size="1px;">IDEL
					@ 2018</font></span>
		</div>
		</el-col> </el-row> </template>
	</div>
	<jsp:include page="footer.jsp" flush="true"/>
	 <script>
	  var errori = '<%=request.getParameter("error")%>';
	  if(errori=='noSearchResult'){
		  alert("No result is found");
	  }
  </script>
  
	
</body>

<script type="text/javascript">
  var app = new Vue({
      el: '#app',
      data: {
    	  type:'',
    	  search_name: '',
    	  dataimg: ${banners},
    	  sort: 'New',
    	  goods:${goods}
      },
      methods:{
    	  search : function(str){
    		  if(str){
    			  if(str=='-1'){
	    			  app.type="";  
    			  }else{
    				  if(str.length==1){
    				  app.type=str;  
    				  }
    			  }
    		  }
    		  //$.ajax({
				//	type: 'POST',
				  //  url: "${pageContext.request.contextPath }/home/search",
				    //data: {
				    	//sort : app.sort,
				    	//name : app.search_name,
				    	//type : app.type
				    //},
				    //success: function(r){
				    	//app.goods=r.rst;
					// }
				//});
    		  window.location.href="homeSearch?sort="+app.sort+"&name="+app.search_name+"&type="+app.type;
    		  
    		  
    	  }
      }
  });
  </script>
 
</html>
