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
	  <h1 class="display-4">课程子集</h1>
	  <hr class="my-4">
	  <a class="btn btn-primary btn-lg" href="${indexpath}" role="button">回前台首页</a>
	  <a class="btn btn-primary btn-lg" href="${indexpath}/manage/index.action" role="button">回后台首页</a>
	</div>
	<input type="hidden" id="whichID" value="${courseWhich.id}">
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">课程ID</span>
	  </div>
	  <textarea id="courseID" class="form-control">${courseWhich.courseID}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">第几集</span>
	  </div>
	  <textarea id="whichEpisode" class="form-control">${courseWhich.whichEpisode}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">子集名称</span>
	  </div>
	  <textarea id="name" class="form-control">${courseWhich.name}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">收费URL</span>
	  </div>
	  <textarea id="chargeUrl" class="form-control">${courseWhich.chargeUrl}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">免费URL</span>
	  </div>
	  <textarea id="freeUrl" class="form-control">${courseWhich.freeUrl}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">是否免费</span>
	  </div>
	  	<select class="custom-select" id="status">
	    	<option ${(courseWhich.status==2)?string('selected="selected"', ' ')} value="2">收费</option>
	    	<option ${(courseWhich.status==1)?string('selected="selected"', ' ')} value="1">免费</option>
	    </select>
	</div>
	
	<a class="btn btn-primary" href="javascript:editCourseWhich();" role="button">更新</a>
</div>
</body>
</html>
<script>

function editCourseWhich(){
	
	var whichID =  $("#whichID").val();
	var courseID =  $("#courseID").val();
	var whichEpisode =  $("#whichEpisode").val();
	var name =  $("#name").val();
	var chargeUrl =  $("#chargeUrl").val();
	var freeUrl =  $("#freeUrl").val();
	var status =  $("#status").val();

	
	$.ajax({
        type : "POST",
        url : "${indexpath}/manage/editCourseWhich.action",
        data : {"whichID":whichID,"courseID":courseID,"whichEpisode":whichEpisode,"name":name,
        "chargeUrl":chargeUrl,"freeUrl":freeUrl,"status":status},
        success : function(result) {
            alert(result);
        }
    });
}

</script>