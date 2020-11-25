<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${csspath}/boots/bootstrap.min.css">
<link rel="stylesheet" href="${csspath}/lianggeshipin.css">
<script src="${indexpath}/js/jquery.min.js"></script>
<title>小猪佩奇 Peppa Pig 中文 英文 播放 下载</title>
</head>
<body>

<div class="container-fluid">
	<div class="jumbotron index-bgi">
	  <h1 class="display-4">小猪佩奇</h1>
	  <p class="lead">本网站所有的页面都是两个视频，左边是中文，右边是英文。在学习英语的时候如果只看英文动漫，并不理解其中的意思。
	  	<br>如果能先看一遍中文的动漫，再看英文时就知道它在说什么，更好的理解语言。</p>
	  <hr class="my-4">
	  <p>为了过英语四级，冲呀！</p>
	  <a class="btn btn-primary btn-lg" href="#" role="button">元气满满的一天</a>
	</div>
	
	<nav aria-label="breadcrumb">
	  	<ol class="breadcrumb">
	  		<#list animatedList as animated>
		    	<li class="breadcrumb-item active" aria-current="page">
		    		<a href="${indexpath}/${animated.url}">${(animated.animatedName)!""}</a>
		    	</li>
		    </#list>
	  	</ol>
	</nav>
	
	<#list animatedList as animated>
		<div class="alert alert-secondary" role="alert">
		 ${(animated.animatedName)!""}
		</div>
		<#assign plotlist=mapPlotList[animated.animatedName]/>
		<div class="row">
			<#list plotlist as plot>
				<#if plot_index gt 7>  <#comment> 只显示8条数据，超出就隐藏 </#comment>
					<div name="${animated.id}" class="col-xl-3 col-lg-3 col-md-4 col-sm-6 d-none">
				      	<a href="${indexpath}/${animated.id}/${plot.whichEpisode}.html">
				      		<img src="${animatedImgPath}/${animated.id}/${plot.imgUrl}" class="img-fluid" alt="${plot.plotName}">
				      		<p class="l-plot-sort">${(plot.plotName)!""}</p>
				      	</a>
				    </div>
				<#else>
					<div name="${animated.id}" class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
				      	<a href="${indexpath}/${animated.id}/${plot.whichEpisode}.html">
				      		<img src="${animatedImgPath}/${animated.id}/${plot.imgUrl}" class="img-fluid" alt="${plot.plotName}">
				      		<p class="l-plot-sort">${(plot.plotName)!""}</p>
				      	</a>
				    </div>
				</#if>
		    
		    </#list>
			<div class="col-xl-3 col-lg-3 col-md-4 col-sm-6">
		      	<a href="javascript:delClass('${animated.id}');">
		      		<img src="${imgpath}/showMore.jpg" class="img-fluid">
		      	</a>
		    </div>
	  	</div>
  	</#list>
</div>
</body>
</html>
<script>
	function delClass(c_name){
		$("div[name='"+c_name+"']").removeClass("d-none");
	}
</script>