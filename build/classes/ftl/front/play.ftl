<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${(plot.title)!""}</title>
<link rel="stylesheet" href="${csspath}/lianggeshipin.css">
<link rel="stylesheet" href="${csspath}/boots/bootstrap.min.css">
<link rel="stylesheet" href="${csspath}/video-js.css">
<title>Insert title here</title>
<script src="${jspath}/jquery.min.js"></script>
<script src="${jspath}/video.min.js"></script>
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
</div>
</body>
</html>
<script type="text/javascript">
	var myPlayer = videojs('my-video1',{ autoplay: true,fluid: true }, function () { });
	var myPlayer = videojs('my-video2',{ autoplay: false,fluid: true }, function () { });
</script>