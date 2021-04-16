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
	  	<h1 class="display-4">查询用户</h1>	  
	  	<hr class="my-4">
	  	<form class="form-inline my-2 my-lg-0" action="${indexpath}/manage/getUserByNickname.action">
      		<input class="form-control mr-sm-2" name="nickname" type="text" placeholder="Search" aria-label="Search">
      		<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
		</form>
	  	<#if pageSum??>
	  		<#if pageSum lt 7>
	  			<nav aria-label="Page navigation example">
					 <ul class="pagination justify-content-end">
					    <li class="page-item">
					      <a class="page-link" href="${indexpath}/manage/queUserPage.action?page=1">首页</a>
					    </li>
	  					<#list 1..pageSum as i>
	  					<li class="page-item"><a class="page-link" href="${indexpath}/manage/queUserPage.action?page=${i}">${i}</a></li>
						</#list>
						<li class="page-item">当前第${page}页</li>
					    <li class="page-item">
					      <a class="page-link" href="${indexpath}/manage/queUserPage.action?page=${pageSum}">末页${pageSum}</a>
					    </li>
					 </ul>
				</nav>
	  		<#elseif pageSum gt 6>
  				<nav aria-label="Page navigation example">
					 <ul class="pagination justify-content-end">
					    <li class="page-item">
					      <a class="page-link" href="${indexpath}/manage/queUserPage.action?page=1">首页</a>
					    </li>
	  					<li class="page-item"><a class="page-link" href="${indexpath}/manage/queUserPage.action?page=${pageSum-6}">${pageSum-6}</a></li>
	  					<li class="page-item"><a class="page-link" href="${indexpath}/manage/queUserPage.action?page=${pageSum-5}">${pageSum-5}</a></li>
	  					<li class="page-item"><a class="page-link" href="${indexpath}/manage/queUserPage.action?page=${pageSum-4}">${pageSum-4}</a></li>
	  					<li class="page-item"><a class="page-link" href="${indexpath}/manage/queUserPage.action?page=${pageSum-3}">${pageSum-3}</a></li>
	  					<li class="page-item"><a class="page-link" href="${indexpath}/manage/queUserPage.action?page=${pageSum-2}">${pageSum-2}</a></li>
	  					<li class="page-item"><a class="page-link" href="${indexpath}/manage/queUserPage.action?page=${pageSum-1}">${pageSum-1}</a></li>
	  					<li class="page-item"><a class="page-link" href="${indexpath}/manage/queUserPage.action?page=${pageSum}">${pageSum}</a></li>
					    <li class="page-item">当前第${page}页</li>
					    <li class="page-item">
					      <a class="page-link" href="${indexpath}/manage/queUserPage.action?page=${pageSum}">末页${pageSum}</a>
					    </li>
					 </ul>
				</nav>
	  		</#if>
	  	</#if>
	</div>
	
	<div class="container">
	  	<div class="row">
	  		<#list userList as user>
			    <div class="mb-3 col-xl-2 col-lg-2 col-md-3 col-sm-4 col-6">
			      <a class="btn btn-outline-primary" href="${indexpath}/manage/personal.action?userID=${user.id}" role="button">${user.nickname}</a>
			    </div>
		    </#list>
	  	</div>
	</div>

<div>
</body>
</html>