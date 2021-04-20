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
	  <h1 class="display-4">课程列表</h1>
	</div>
	
	<table class="table">
	   <tbody>
	   <#list courseList as course>
	    <tr>
	      <td>
				${course.name} 
				<a href="${indexpath}/manage/editCoursePage.action?courseID=${course.id}" role="button" class="btn btn-success">修改课程</a>
				<a href="${indexpath}/manage/addCourseWhichPage.action?courseID=${course.id}" role="button" class="btn btn-info">添加课程子集</a>
				<a href="${indexpath}/manage/getCourseWhichListPage.action?courseID=${course.id}" role="button" class="btn btn-secondary">查看课程子集</a>
				<a href="javascript:createCourseHtml(${course.id})" role="button" class="btn btn-danger">重新生成页面</a>
	      </td>
	    </tr>
	    </#list>
	  </tbody>
</div>
</body>
</html>
<script>
	function createCourseHtml(courseID){
		$.ajax({
	        type : "POST",
	        url : "${indexpath}/manage/createCourseHtml.action",
	        data : {"courseID":courseID},
	        success : function(result) {
	            alert(result);
	        }
	    });
	}
</script>