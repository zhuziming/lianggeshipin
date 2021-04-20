<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${indexpath}/css/boots/bootstrap.min.css">
<script src="${indexpath}/js/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
	<div class="jumbotron">
	  <h1 class="display-4">添加课程子集</h1>
	  <hr class="my-4">
	  <a class="btn btn-primary btn-lg" href="${indexpath}" role="button">回前台首页</a>
	  <a class="btn btn-primary btn-lg" href="${indexpath}/manage/index.action" role="button">回后台首页</a>
	</div>
	<div class="alert alert-primary" role="alert">
	 ${course.name}
	</div>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">哪一集</th>
      <th scope="col">子集名字</th>
      <th scope="col">收费URL</th>
      <th scope="col">免费URL</th>
      <th scope="col">是否免费</th>
    </tr>
  </thead>
  <form action="${indexpath}/manage/addCourseWhich.action">
  			<input type="hidden" name="courseID" value="${course.id}">
	  <tbody>
	  	<#list 1..10 as i>
	    <tr>
	      <td><input type="number" class="form-control is-valid" name="which${i}"  ></td>
	      <td><input type="text" class="form-control is-valid" name="name${i}"  ></td>
	      <td><input type="text" class="form-control is-valid" name="chargeUrl${i}"  ></td>
	      <td><input type="text" class="form-control is-valid" name="freeUrl${i}"  ></td>
	      <td>
	      	  <select class="custom-select" name="status${i}">
			    <option value="2">收费</option>
			    <option value="1">免费</option>
			  </select>
  		  </td>
	    </tr>
	   </#list>
	    <tr id="lineLast">
	      <td></td>
	      <td></td>
	      <td><button class="btn btn-primary" type="submit">提交</button></td>
	      <td></td>
	    </tr>
	  </tbody>
  </form>
</table>
</div>
</body>
</html>