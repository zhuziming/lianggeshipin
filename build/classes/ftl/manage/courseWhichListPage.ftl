<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${csspath}/boots/bootstrap.min.css">
<script src="${jspath}/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
	<div class="jumbotron">
	  <h1 class="display-4">子集列表</h1>
	</div>
	
	<table class="table">
	   <tbody>
	   <#list whichList as which>
	    <tr>
	      <td>
				${which.name} 
				<a href="${indexpath}/manage/editCourseWhichPage.action?whichID=${which.id}" role="button" class="btn btn-success">修改子集</a>
	      </td>
	    </tr>
	    </#list>
	  </tbody>
</div>
</body>
</html>
<script>

</script>