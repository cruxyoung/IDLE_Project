<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/libs/index.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/libs/main.css">
<script src="${pageContext.request.contextPath }/libs/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/libs/vue.min.js"></script>
<script src="${pageContext.request.contextPath }/libs/index.js"></script>
</head>
<body>
	<div id="app">
		<template> <!-- 头部 --> <el-row> <el-col :span="24">
		<div class="grid-content bg-purple-white" style="height: 50px;">
			<span style="font-size: 30px; padding-top: 5px; float: left;"><font
				color="white">IDLE</font></span> <span
				style="float: right; padding-top: 10px; margin-right: 20px;">
				<el-button type="text">Home</el-button>&nbsp;&nbsp;&nbsp; <el-button
					type="text">Publish idle items</el-button>&nbsp;&nbsp;&nbsp; <el-button
					type="text">Personal Center</el-button>&nbsp;&nbsp;&nbsp; <el-button
					type="text">Login</el-button>
			</span>
		</div>
		</el-col> </el-row> <!-- 搜索框 --> <el-row>
		<div style="height: 140px; box-shadow: 0 0 3px 3px #d3dce6">
			<div style="padding-top: 50px; width: 70%; margin-left: 20%">
				<el-input placeholder="Search for anything you want..."
					v-model="search_name" class="input-with-select"> <el-select
					v-model="type" slot="prepend" placeholder="type" size="medium">
				<el-option label="Education" value="1"></el-option> <el-option
					label="Electrics & Computers" value="2"></el-option> <el-option
					label="Clothing & Jewellery" value="3"></el-option> <el-option
					label="Home & Garden" value="4"></el-option> <el-option
					label="Cars & Vehicles" value="5"></el-option> </el-select> <el-button
					slot="append" icon="el-icon-search" @click="search()"></el-button>
				</el-input>
			</div>
		</div>
		</el-row> <!-- 菜单栏 --> <el-row> <el-col :span="4">
		<p style="font-weight: bold; margin-bottom: 0; font-size: 14px">All
			Categories</p>
		<a @click="search(-1)"
			style="text-decoration: underline; cursor: pointer; font-size: 10px; color: gray;">View
			all</a> </el-col> <el-col :span="4">
		<div style="float: left; margin-top: 2px;">
			<img height="70px;" alt=""
				src="${pageContext.request.contextPath }/images/1.jpg">
		</div>
		<div style="height: 60px;">
			<p style="font-weight: bold; margin-bottom: 0; font-size: 14px">Education</p>
			<a @click="search('1')"
				style="text-decoration: underline; cursor: pointer; font-size: 10px; color: gray;">11.9M
				items</a>
		</div>
		</el-col> <el-col :span="4">
		<div style="float: left; margin-top: 2px;">
			<img height="70px;" alt=""
				src="${pageContext.request.contextPath }/images/1.jpg">
		</div>
		<div style="height: 60px;">
			<p style="font-weight: bold; margin-bottom: 0; font-size: 14px">Electrics
				& Computers</p>
			<a @click="search('2')"
				style="text-decoration: underline; cursor: pointer; font-size: 10px; color: gray;">9.07M
				items</a>
		</div>
		</el-col> <el-col :span="4">
		<div style="float: left; margin-top: 2px;">
			<img height="70px;" alt=""
				src="${pageContext.request.contextPath }/images/1.jpg">
		</div>
		<div style="height: 60px;">
			<p style="font-weight: bold; margin-bottom: 0; font-size: 14px">Clothing
				& Jewellery</p>
			<a @click="search('3')"
				style="text-decoration: underline; cursor: pointer; font-size: 10px; color: gray;">7.75M
				items</a>
		</div>
		</el-col> <el-col :span="4">
		<div style="float: left; margin-top: 2px;">
			<img height="70px;" alt=""
				src="${pageContext.request.contextPath }/images/1.jpg">
		</div>
		<div style="height: 60px;">
			<p style="font-weight: bold; margin-bottom: 0; font-size: 14px">Home
				& Garden</p>
			<a @click="search('4')"
				style="text-decoration: underline; cursor: pointer; font-size: 10px; color: gray;">5.8M
				items</a>
		</div>
		</el-col> <el-col :span="4">
		<div style="float: left; margin-top: 2px;">
			<img height="70px;" alt=""
				src="${pageContext.request.contextPath }/images/1.jpg">
		</div>
		<div style="height: 60px;">
			<p style="font-weight: bold; margin-bottom: 0; font-size: 14px">Cars
				& Vehicles</p>
			<a @click="search('5')"
				style="text-decoration: underline; cursor: pointer; font-size: 10px; color: gray;">11.9M
				items</a>
		</div>
		</el-col> </el-row> <!-- 跑马灯 --> <el-row> <el-carousel :interval="3000"
			type="card" height="260px"> <el-carousel-item
			v-for="item in dataimg" :key="item">
		<div class="grid-content">
			<el-col :md="12" :offset="6">
			<div>
				<img style="max-width: 100%; max-height: 100%;"
					:title="item.content" :alt="item.content" :src="item.img">
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
				label="Near"></el-radio-button> <el-radio-button label="Price"></el-radio-button>
			</el-radio-group>
		</div>
		</el-row> <el-row>
		<div
			style="float: left; width: 20%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px;">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[0].content" alt="" :src="goods[0].img" />
		</div>
		<div
			style="float: left; width: 24%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px; margin-left: 2%">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[1].content" alt="" :src="goods[1].img" />
		</div>
		<div
			style="float: left; width: 35%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px; margin-left: 2%">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[2].content" alt="" :src="goods[2].img" />
		</div>
		<div
			style="float: left; width: 15%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px; margin-left: 2%">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[3].content" alt="" :src="goods[3].img" />
		</div>
		</el-row> <el-row>
		<div
			style="float: left; width: 15%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px; margin-left: 2%">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[4].content" alt="" :src="goods[4].img" />
		</div>
		<div
			style="float: left; width: 35%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px; margin-left: 2%">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[5].content" alt="" :src="goods[5].img" />
		</div>
		<div
			style="float: left; width: 24%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px; margin-left: 2%">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[6].content" alt="" :src="goods[6].img" />
		</div>
		<div
			style="float: left; width: 20%; box-shadow: 0 0 3px 3px #d3dce6; height: 300px;">
			<img style="max-width: 100%; max-height: 100%;"
				:title="goods[7].content" alt="" :src="goods[7].img" />
		</div>
		</el-row> <el-row> <el-col :span="24">
		<div class="grid-content bg-purple-white"
			style="height: 50px; text-align: center;">
			<span style="margin-top: 20px"><font color="white" size="1px;">IDEL
					@ 2018</font></span>
		</div>
		</el-col> </el-row> </template>
	</div>
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
    		  $.ajax({
					type: 'POST',
				    url: "${pageContext.request.contextPath }/home/search",
				    data: {
				    	sort : app.sort,
				    	name : app.search_name,
				    	type : app.type
				    },
				    success: function(r){
				    	app.goods=r.rst;
					}
				});
    	  }
      }
  })
  </script>
</html>
