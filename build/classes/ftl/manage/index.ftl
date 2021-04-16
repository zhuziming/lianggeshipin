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
	  <h1 class="display-4">元气满满的一天</h1>
	  <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
	  <hr class="my-4">
	  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
	  <a class="btn btn-primary btn-lg" href="${indexpath}" role="button">回前台首页</a>
	  <a class="btn btn-primary btn-lg" href="${indexpath}/manage/index.action" role="button">回后台首页</a>
	</div>
	<ul class="list-group">
	  <li class="list-group-item"><a href="${indexpath}/manage/addAnimatedPage.action">添加动漫名称</a></li>
	  <li class="list-group-item"><a href="${indexpath}/manage/queAnimatedPage.action">查寻所有动漫</a></li>
	  <li class="list-group-item"><a href="${indexpath}/manage/queUserPage.action">查寻所有用户</a></li>
	  <li class="list-group-item"><a href="javascript:createIndex()">重新生成首页</a></li>
	  <li class="list-group-item"><a href="javascript:createBaiduXml()">生成百度推广文件</a></li>
	</ul>
</div>
</body>
</html>
<script>
	function createIndex(){
		$.ajax({
	        type : "POST",
	        url : "${indexpath}/manage/createIndex.action",
	        success : function(result) {
	            alert(result);
	        }
	    });
	}
	
	function createBaiduXml(){
		$.ajax({
	        type : "POST",
	        url : "${indexpath}/manage/createBaiduXml.action",
	        success : function(result) {
	            alert(result);
	        }
	    });
	}
</script>