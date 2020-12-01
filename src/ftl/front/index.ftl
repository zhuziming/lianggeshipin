<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${csspath}/boots/bootstrap.min.css">
<link rel="stylesheet" href="${csspath}/lianggeshipin.css">
<link rel="shortcut icon" type="favicon.ico" href="${imgpath}/lianggeshipin.ico">
<script src="${indexpath}/js/jquery.min.js"></script>
<script src="${indexpath}/js/baidu.js"></script>
<title>小猪佩奇 Peppa Pig 中文 英文 播放 下载</title>
<meta name="keywords" content="小猪佩奇中文播放,小猪佩奇英文播放,小猪佩奇中文英文下载">
<meta name="description" content="网站名称“两个视频”，所有的视频都会提供中文与英文两个版本，主要为学习英语的人准备，通过中英文对照观看可以更好的理解语言，祝每一个学子都能获得好成绩。">
</head>
<body>

<div class="container-fluid">
	<div class="jumbotron index-bgi">
	  <h1 class="display-4">小猪佩奇</h1>
	  <p class="lead">本网站所有的页面都是两个视频，左边是中文，右边是英文。在学习英语的时候如果只看英文动漫，并不理解其中的意思。
	  	<br>如果能先看一遍中文的动漫，再看英文时就知道它在说什么，更好的理解语言。
	  	<br>下载链接  https://pan.baidu.com/s/1cHNs4gQb2zw9IXoJQMjHXw  提取码：xdhb
	  </p>
	  <hr class="my-4">
	  <a class="btn btn-primary btn-lg" target="_blank" href="https://www.bilibili.com/video/BV117411P7uh?from=search&seid=6919481798513345043" role="button">
	  		最棒的英语语法介绍
	  </a>
	  <a class="btn btn-primary btn-lg" href="#" role="button">网站名称：两个视频</a>
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

<footer class="blog-footer">
	  <p><a class="alert alert-light" target="_blank" href="http://www.miitbeian.gov.cn">豫ICP备2020033396</a></p>
</footer>
</body>
</html>
<script>
	function delClass(c_name){
		$("div[name='"+c_name+"']").removeClass("d-none");
	}
</script>