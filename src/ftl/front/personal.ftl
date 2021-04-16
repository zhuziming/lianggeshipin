<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${csspath}/boots/bootstrap.min.css">
<script src="${indexpath}/js/jquery.min.js"></script>
</head>
<body>

<main role="main" class="container">
  <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-purple rounded shadow-sm">
    <img class="mr-3" src="${user.picture}" alt="" width="48" height="48">
    <div class="lh-100">
      <h6 class="mb-0 lh-100">${user.nickname}</h6>
      <small>会员到期时间：${user.vipTime}</small>
    </div>
  </div>  
  
  <div class="my-3 p-3 bg-white rounded shadow-sm">
    <h6 class="border-bottom border-gray pb-2 mb-0">你还有 ${vipCardNum} 张会员卡</h6>
    <#list vipCardList as vipCard>
	    <div class="media text-muted pt-3">
	      <svg class="bd-placeholder-img mr-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: 32x32"><rect width="100%" height="100%" fill="<#if vipCard.name?index_of('1天会员')!=-1>#007bff</#if><#if vipCard.name?index_of('7天会员')!=-1>#e83e8c</#if><#if vipCard.name?index_of('30天会员')!=-1>#6f42c1</#if><#if vipCard.name?index_of('1年会员')!=-1>#000000</#if>"/></svg>
	      <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
	        <strong class="d-block text-gray-dark">${vipCard.name}</strong>
	                     发放日期：${vipCard.time}
	      </p>
	      <button type="button" class="btn btn-outline-primary btn-sm" onclick="activation(${vipCard.id})">激活</button>
	    </div>
    </#list>
  </div>

</main>

</body>
</html>
<script type="text/javascript">
	function activation(vipCardID){
		$.ajax({
		   type: "POST",
		   url: "${indexpath}/front/activation.action",
		   data: {"vipCardID":vipCardID},
		   dataType:"json",
		   success: function(msg){
			   	if(msg.success==1){
			   		alert(msg.msg);
			   	}else{
			   		alert(msg.msg);
			   	}
		   }
		});
	}
</script>