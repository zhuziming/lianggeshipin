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
	  <h1 class="display-4">查询动漫子集</h1>
	  <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
	  <hr class="my-4">
	  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
	  <a class="btn btn-primary btn-lg" href="${indexpath}" role="button">回前台首页</a>
	  <a class="btn btn-primary btn-lg" href="${indexpath}/manage/index.action" role="button">回后台首页</a>
	</div>
	
	<div class="container">
	  	<div class="row">
	  		<#list plotList as plot>
			    <div class="mb-3 col-xl-2 col-lg-2 col-md-3 col-sm-4 col-6">
			      <a class="btn btn-outline-primary" href="${indexpath}/manage/editPlotPage.action?plotID=${plot.id}" role="button">${plot.plotName}</a>
			    </div>
		    </#list>
	  	</div>
	</div>
</div>
</body>
</html>
<script>

</script>