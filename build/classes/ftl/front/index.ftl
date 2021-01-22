<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${csspath}/boots/bootstrap.min.css">
<link rel="stylesheet" href="${csspath}/lianggeshipin.css">
<link rel="shortcut icon" type="favicon.ico" href="${imgpath}/lianggeshipin.ico">
<link rel="icon" href="data:;base64,=">
<script src="${indexpath}/js/jquery.min.js"></script>
<script src="${indexpath}/js/baidu.js"></script>
<title>两个视频</title>
<meta name="keywords" content="两个视频,英文视频中文播放,外国视频中文播放">
<meta name="description" content="网站名称“两个视频”，所有的视频都会提供中文与英文两个版本，主要为学习英语的人准备，通过中英文对照观看可以更好的理解语言，祝每一个学子都能获得好成绩。">
</head>
<body>

<div class="container-fluid">
	<div class="jumbotron index-bgi">
	  <h1 class="display-4">两个视频</h1>
	  <p class="lead">本网站所有的页面都是两个视频，左边是中文，右边是英文。在学习英语的时候如果只看英文动漫，并不理解其中的意思。
	  	<br>如果能先看一遍中文的动漫，再看英文时就知道它在说什么，更好的理解语言。
	  	<br>下载链接  <p class="lead" style="word-break:break-all;">https://pan.baidu.com/s/1cHNs4gQb2zw9IXoJQMjHXw  提取码：xdhb</p> 
	  </p>
	  <hr class="my-4">
	  <a class="btn btn-primary btn-lg" target="_blank" href="${indexpath}/front/word1000Page.action?pageNum=1" role="button">英语4级，1000单词图片记忆</a>
	</div>
	
	<nav aria-label="breadcrumb">
	  	<ol class="breadcrumb">
	  		<#list animatedList as animated>
		    	<li class="breadcrumb-item active" aria-current="page">
		    		<a target="_blank" href="${indexpath}/${animated.url}">${(animated.animatedName)!""}</a>
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
					<div name="${animated.id}" class="col-xl-3 col-lg-4 col-md-6 col-sm-12 d-none">
				      	<a target="_blank" href="${indexpath}/${animated.id}/${plot.whichEpisode}.html">
				      		<img src="${animatedImgPath}/${animated.id}/${plot.imgUrl}" class="img-fluid" alt="${plot.plotName}">
				      		<p class="l-plot-sort">${(plot.plotName)!""}</p>
				      	</a>
				    </div>
				<#else>
					<div name="${animated.id}" class="col-xl-3 col-lg-4 col-md-6 col-sm-12">
				      	<a target="_blank" href="${indexpath}/${animated.id}/${plot.whichEpisode}.html">
				      		<img src="${animatedImgPath}/${animated.id}/${plot.imgUrl}" class="img-fluid" alt="${plot.plotName}">
				      		<p class="l-plot-sort">${(plot.plotName)!""}</p>
				      	</a>
				    </div>
				</#if>
		    
		    </#list>
			<div class="col-xl-3 col-lg-4 col-md-6 col-sm-12">
		      	<a href="javascript:delClass('${animated.id}');">
		      		<img src="${imgpath}/showMore.jpg" class="img-fluid">
		      	</a>
		    </div>
	  	</div>
  	</#list>
</div>
	<div class="jumbotron">
		  <h1 class="display-4">资源免责申明</h1>
		  <p class="lead">所有资源来自网友分享,本站只提供用户交互平台。</p>
		  <hr class="my-4">
		  <p>
		  	一.本站收录的各类视频与资料，大部分是网友从网上搜集分享而来，其版权均归原作者及其网站所有，本站虽力求保存原有的版权信息，但因很多视频资料经过多次转摘，已无法确定其真实来源，或者已将原有信息丢失，所以敬请原作者原谅。如果您对本站所载视频作品版权的归属存有异议，请立即通知我，我将在第一时间予以删除，同时向你表示歉意！
		  </p>
		  <p>
			二.本站仅转载网上现成的视频资料，很难对这些视频的可用性，准确性或可靠性作出任何承诺与保证。不论何种情形，本站都不对任何由于使用或无法使用本站提供的视频资料所造成的直接的和间接的损失负任何责任。
		  </p>
		  <p>
			三.本站提供的所有视频，均为网友私人收藏性质，未经原版权作者许可,任何人不得擅作它用！请在下载24小时内删除！为尊重作者版权，请购买原版作品,支持你喜欢的作者，谢谢！
		  </p>

	</div>
<footer class="blog-footer">
	  <p><a class="alert alert-light" target="_blank" href="http://beian.miit.gov.cn">豫ICP备2020033396</a></p>
</footer>
</body>
</html>
<script>
	function delClass(c_name){
		$("div[name='"+c_name+"']").removeClass("d-none");
	}
</script>