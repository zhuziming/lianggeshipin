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
	  <h1 class="display-4">查询所有动漫名称</h1>
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
      <th scope="col">操作</th>
    </tr>
  </thead>
	  <tbody>
	  	<#list animatedList as animated>
	  		<tr>
		      <td>${(animated.animatedName)!''}</td>
		      <td>
		      	<a class="btn btn-primary" href="${indexpath}/manage/addPlotPage.action?animatedID=${animated.id}" role="button">插入子集</a>
		      	<a class="btn btn-primary" href="${indexpath}/manage/queAllPlot.action?animatedID=${animated.id}" role="button">查看所有分集</a>
		      	<a class="btn btn-primary" href="javascript:createPlay(${animated.id})" role="button">重新生成页面</a>
		      </td>
		    </tr>
		</#list>
	    
	  </tbody>
</table>
</div>
</body>
</html>
<script>
	function createPlay(animatedID){
		$.ajax({
	        type : "POST",
	        url : "${indexpath}/manage/createPlay.action",
	        data : {"animatedID":animatedID},
	        success : function(result) {
	            alert(result);
	        }
	    });
	}
</script>
