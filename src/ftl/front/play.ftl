<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>${(animated.animatedName)!""}  第 ${(plot.whichEpisode)!""} 集 ${(plot.plotNameCh)!""} ${(plot.plotNameEn)!""} 中文 英文播放 台词字幕 下载${(plot.down)!""}</title>
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

	<div class="alert alert-success" role="alert">
	  	<p style="word-break:break-all; word-wrap:break-all;">
			${(animated.animatedName)!""}  第 ${(plot.whichEpisode)!""} 集 ${(plot.plotNameCh)!""} ${(plot.plotNameEn)!""} 
	  		中文 英文播放   下载${(plot.down)!""}
		</p>
	</div>
	<div class="row">
		<div class="col-lg-6 col-md-12 col-sm-12 mb-3">
			<div class="alert alert-primary" role="alert">
			  	中文 ${(plot.plotNameCh)!""}
			</div>
			<video  id="my-video1" class="video-js" controls preload="auto"  poster="${animatedImgPath}/${animated.id}/${plot.imgUrl}">
				<source src="${indexpath}/front/getPlay.action?type=ch&plotID=${(plot.id)!""}" type="video/mp4">
		  	</video>
		  	<form class="form-inline">
			  	<div class="form-group mx-sm-3 mb-2">
			    	<input style="width:100px;" type="text" class="form-control" id="video_ch" placeholder="00:00:00">
			  	</div>
			  	<button type="button" onclick="turnTime('ch')" class="btn btn-success mb-2">跳转时间</button>
			  	<button type="button" onclick="backTime('ch')" class="btn btn-primary mb-2">&lt;&lt;--后退5秒</button>
			  	<button type="button" onclick="frontTime('ch')" class="btn btn-primary mb-2">快进5秒--&gt;&gt;</button>
			  	<button type="button" onclick="togetherTime('ch')" class="btn btn-success mb-2">同步英文</button>
			</form>
		</div>
		<div class="col-lg-6 col-md-12 col-sm-12 mb-3">
			<div class="alert alert-primary" role="alert">
			  	英文 ${(plot.plotNameEn)!""}
			</div>
			<video  id="my-video2" class="video-js" controls preload="auto"  poster="${animatedImgPath}/${animated.id}/${plot.imgUrl}">
				<source src="${indexpath}/front/getPlay.action?type=en&plotID=${(plot.id)!""}" type="video/mp4">
		  	</video>
		  	<form class="form-inline">
			  	<div class="form-group mx-sm-3 mb-2">
			    	<input style="width:100px;" type="text" class="form-control" id="video_en" placeholder="00:00:00">
			  	</div>
			  	<button type="button" onclick="turnTime('en')" class="btn btn-success mb-2">跳转时间</button>
			  	<button type="button" onclick="backTime('en')" class="btn btn-primary mb-2">&lt;&lt;--后退5秒</button>
			  	<button type="button" onclick="frontTime('en')" class="btn btn-primary mb-2">快进5秒--&gt;&gt;</button>
			  	<button type="button" onclick="togetherTime('en')" class="btn btn-success mb-2">同步中文</button>
			</form>
		</div>
	</div>
	
	<#if courseList?? && (courseList?size gt 0) >
		<div class="alert alert-primary" role="alert">
	  		英语教程
		</div>
		<div class="row">
			<#list courseList as course>
			<div class="col-xl-3 col-lg-3 col-sm-4 col-6">
				<a href="${indexpath}/course/${course.plotID}/${course.id}/1.html">
					<img class="img-fluid" src="${indexpath}/courseImg/${course.plotID}/${course.id}.jpg"/>
					<p>${course.name}</p>
				</a>
			</div>
			</#list>
		</div>
	</#if>
	
	<div class="alert alert-primary" role="alert">
	  	选集
	</div>
	<div class="row">
		<#list plotList as plot_>
			<#if plot_.id == plot.id>
				<div class="col-xl-3 col-lg-3 col-sm-4 col-6">
					<a class="btn btn-secondary" href="${indexpath}/${animated.id}/${plot_.whichEpisode}.html" role="button">${(plot_.plotNameCh)!""}</a>
				</div>
			<#else>
				<div class="col-xl-3 col-lg-3 col-sm-4 col-6">
					<a class="btn btn-light" href="${indexpath}/${animated.id}/${plot_.whichEpisode}.html" role="button">${(plot_.plotNameCh)!""}</a>
				</div>
			</#if>
			
		</#list>
	</div>
	
	
	
	<div class="alert alert-primary" role="alert">
	  	台词字幕
	</div>
	<div class="jumbotron">
		  <h1 class="display-4">${(plot.plotNameCh)!""}</h1>
		  <p class="lead">${(plot.intro)!""}</p>
	</div>
	
</div>
</body>
</html>
<script src="${jspath}/play.js"></script>
<script type="text/javascript">
	$(document).ready(function (){
		$.ajax({
		   type: "POST",
		   url: "${indexpath}/front/isVip.action",
		   dataType:"json",
		   success: function(msg){
			   	if(msg.success==2){
			   		$('#my-video1').append("<div style='position:absolute; top:50px; left:50px; font-size:30px; color:red; z-index:1000;'><a href='${indexpath}/vip.html' target='_Blank' style='color:red;'>你还不是会员，请先充值，会员1天1元，1月8元。<br>也可以免费获得会员，详情请点击...</a></div>");
			   		$('#my-video2').append("<div style='position:absolute; top:50px; left:50px; font-size:30px; color:red; z-index:1000;'><a href='${indexpath}/vip.html' target='_Blank' style='color:red;'>你还不是会员，请先充值，会员1天1元，1月8元。<br>也可以免费获得会员，详情请点击...</a></div>");
			   	}
		   }
		});
	});
</script>