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
	  <h1 class="display-4">添加课程信息</h1>
	  <hr class="my-4">
	  <a class="btn btn-primary btn-lg" href="${indexpath}" role="button">回前台首页</a>
	  <a class="btn btn-primary btn-lg" href="${indexpath}/manage/index.action" role="button">回后台首页</a>
	</div>
	
	<input type="hidden" id="plotID" value="${plot.id}">
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">课程名字</span>
	  </div>
	  <textarea id="courseName" class="form-control"></textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">用户ID</span>
	  </div>
	  <textarea id="userID" class="form-control"></textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">课程第一集的Url</span>
	  </div>
	  <textarea id="courseUrl" class="form-control"></textarea>
	</div>

	<a class="btn btn-primary" href="javascript:addCourse();" role="button">提交</a>
</div>
</body>
</html>
<script>

function addCourse(){
	var plotID =  $("#plotID").val();
	var courseName = $("#courseName").val();
	var userID = $("#userID").val();
	var courseUrl = $("#courseUrl").val();
	
	$.ajax({
        type : "POST",
        url : "${indexpath}/manage/addCourse.action",
        data : {"plotID":plotID,"courseName":courseName,"userID":userID,"courseUrl":courseUrl},
        success : function(result) {
            alert(result);
        }
    });
}
</script>