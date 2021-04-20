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
	  <h1 class="display-4">修改课程</h1>
	  <hr class="my-4">
	  <a class="btn btn-primary btn-lg" href="${indexpath}" role="button">回前台首页</a>
	  <a class="btn btn-primary btn-lg" href="${indexpath}/manage/index.action" role="button">回后台首页</a>
	</div>
	<input type="hidden" id="courseID" value="${course.id}">
	<input type="hidden" id="plotID" value="${course.plotID}">
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">用户ID</span>
	  </div>
	  <textarea id="userID_" class="form-control">${course.userID}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">课程名称</span>
	  </div>
	  <textarea id="name_" class="form-control">${course.name}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">第一集URL</span>
	  </div>
	  <textarea id="url_" class="form-control">${course.url}</textarea>
	</div>
	
	<a class="btn btn-primary" href="javascript:editCourse();" role="button">更新</a>
</div>
</body>
</html>
<script>

function editCourse(){
	
	var courseID =  $("#courseID").val();
	var plotID =  $("#plotID").val();
	var userID_ =  $("#userID_").val();
	var name_ =  $("#name_").val();
	var url_ =  $("#url_").val();
	
	$.ajax({
        type : "POST",
        url : "${indexpath}/manage/editCourse.action",
        data : {"courseID":courseID,"plotID":plotID,"userID_":userID_,"name_":name_,"url_":url_},
        success : function(result) {
            alert(result);
        }
    });
}

</script>