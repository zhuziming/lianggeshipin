<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>${(animated.animatedName)!""}  第 ${(plot.whichEpisode)!""} 集 ${(plot.plotName)!""} 中文 英文播放</title>
${(plot.meta)!""}
<link rel="stylesheet" href="${csspath}/lianggeshipin.css">
<link rel="stylesheet" href="${csspath}/boots/bootstrap.min.css">
<link rel="stylesheet" href="${csspath}/video-js.css">
<link rel="shortcut icon" type="favicon.ico" href="${imgpath}/lianggeshipin.ico">
<link rel="icon" href="data:;base64,=">
<script src="${jspath}/jquery.min.js"></script>
<script src="${jspath}/video.min.js"></script>
<script src="${jspath}/baidu.js"></script>
</head>
<body>
<div class="container-fluid">
	
	<div class="jumbotron play-bgi">
		<h1 class="display-4">${(plot.plotName)!""}</h1>
		<p class="lead">${(plot.plotName)!""}</p>
		<hr class="my-4">
		<a class="btn btn-primary btn-lg" href="${indexpath}" role="button">回首页</a>
	</div>
	
	<div class="alert alert-success" role="alert">
	  	${(animated.animatedName)!""}  第 ${(plot.whichEpisode)!""} 集 ${(plot.plotName)!""} 中文 英文播放
	</div>
	<div class="row">
		<div class="col-lg-6 col-md-12 col-sm-12 mb-3">
			<div class="alert alert-primary" role="alert">
			  	中文 ${(plot.plotName)!""}
			</div>
			<video  id="my-video1" class="video-js" controls preload="auto"  poster="${animatedImgPath}/${animated.id}/${plot.imgUrl}">
				<source src="${webMp4Path}/${animated.id}/ch/${plot.videoUrl}" type="video/mp4">
		  	</video>
		</div>
		<div class="col-lg-6 col-md-12 col-sm-12 mb-3">
			<div class="alert alert-primary" role="alert">
			  	英文 ${(plot.plotName)!""}
			</div>
			<video  id="my-video2" class="video-js" controls preload="auto"  poster="${animatedImgPath}/${animated.id}/${plot.imgUrl}">
				<source src="${webMp4Path}/${animated.id}/en/${plot.videoUrl}" type="video/mp4">
		  	</video>
		</div>
	</div>
	
	<div class="alert alert-primary" role="alert">
	  	选集
	</div>
	<div class="row">
		<#list plotList as plot_>
			<#if plot_.id == plot.id>
				<div class="col-xl-3 col-lg-3 col-sm-4 col-6">
					<a class="btn btn-secondary" href="${indexpath}/${animated.id}/${plot_.whichEpisode}.html" role="button">${(plot_.plotName)!""}</a>
				</div>
			<#else>
				<div class="col-xl-3 col-lg-3 col-sm-4 col-6">
					<a class="btn btn-light" href="${indexpath}/${animated.id}/${plot_.whichEpisode}.html" role="button">${(plot_.plotName)!""}</a>
				</div>
			</#if>
			
		</#list>
	</div>
	<div class="alert alert-primary" role="alert">
	  	故事情节
	</div>
	<div class="jumbotron">
		  <h1 class="display-4">${(plot.plotName)!""}</h1>
		  <p class="lead">${(plot.intro)!""}</p>
	</div>
	
</div>
<footer class="blog-footer">
	  <p><a class="alert alert-light" target="_blank" href="http://www.miitbeian.gov.cn">豫ICP备2020033396</a></p>
</footer>
</body>
</html>
<script type="text/javascript">
	var myPlayer = videojs('my-video1',{ autoplay: true,fluid: true }, function () { });
	var myPlayer = videojs('my-video2',{ autoplay: false,fluid: true }, function () { });
</script>