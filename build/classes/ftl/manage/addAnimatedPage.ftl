<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="http://localhost:8080/lianggeshipin/css/boots/bootstrap.min.css">
<script src="http://localhost:8080/lianggeshipin/js/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
	<div class="jumbotron">
	  <h1 class="display-4">添加动漫</h1>
	  <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
	  <hr class="my-4">
	  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
	  <a class="btn btn-primary btn-lg" href="${indexpath}" role="button">回前台首页</a>
	  <a class="btn btn-primary btn-lg" href="${indexpath}/manage/index.action" role="button">回后台首页</a>
	</div>
	
	<table class="table">
  <thead>
    <tr>
      <th scope="col">动漫名称</th>
    </tr>
  </thead>
	  <tbody>
	    <tr>
	      <td><input type="text" class="form-control is-valid" id="animatedName"  required></td>
	    </tr>
	  </tbody>
</table>
<a class="btn btn-outline-primary" href="javascript:addAnimated();" role="button">提交</a>
</div>
</body>
</html>
<script>
	function addAnimated(){
		var animated_name = $("#animatedName").val();
		$.ajax({
            type : "POST",
            url : "${indexpath}/manage/addAnimated.action",
            data : {"animatedName":animated_name},
            success : function(result) {
                alert(result);
            }
        });
		
	}
	
</script>