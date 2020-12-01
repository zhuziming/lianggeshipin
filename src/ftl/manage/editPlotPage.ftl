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
	  <h1 class="display-4">编缉子集信息</h1>
	  <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
	  <hr class="my-4">
	  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
	  <a class="btn btn-primary btn-lg" href="${indexpath}" role="button">回前台首页</a>
	  <a class="btn btn-primary btn-lg" href="${indexpath}/manage/index.action" role="button">回后台首页</a>
	</div>
	
	<input type="hidden" id="plotID" value="${plot.id}">
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">title</span>
	  </div>
	  <textarea id="title_" class="form-control">${(plot.title)!""}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">mate</span>
	  </div>
	  <textarea id="meta_" class="form-control">${(plot.meta)!""}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">html</span>
	  </div>
	  <textarea id="intro_" class="form-control">${(plot.intro)!""}</textarea>
	</div>
	
	<a class="btn btn-primary" href="javascript:editPlot();" role="button">更新</a>
</div>
</body>
</html>
<script>

function editPlot(){
	var title_ =  $("#title_").val();
	var meta_  =  $("#meta_").val();
	var intro_ =  $("#intro_").val();
	var plotID =  $("#plotID").val();
	
	$.ajax({
        type : "POST",
        url : "${indexpath}/manage/editPlot.action",
        data : {"plotID":plotID,"title":title_,"meta":meta_,"intro":intro_},
        success : function(result) {
            alert(result);
        }
    });
}

</script>