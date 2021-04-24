<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="${csspath}/boots/bootstrap.min.css">
<link rel="stylesheet" href="${csspath}/video-js.css">
<link rel="shortcut icon" type="favicon.ico" href="${imgpath}/lianggeshipin.ico">
<script src="${jspath}/jquery.min.js"></script>
<script src="${jspath}/video.min.js"></script>
<script src="${jspath}/baidu.js"></script>
</head>
<style type="text/css">
    .aspect-ratio {
        position: relative;
        width: 100%;
        height: 0;
        padding-bottom: 75%;
    }

	.aspect-ratio iframe {
	    position: absolute;
	    width: 100%;
	    height: 100%;
	    left: 0;
	    top: 0;
	}
</style>
<body>
<div class="container-fluid">
	<div class="alert alert-success" role="alert">
	  	${course.name}
	</div>
	<div class="row">
		<div class="col-lg-9 col-md-12 col-sm-12 mb-3">
			<#if courseWhich.status==1>
				${courseWhich.freeUrl}
			<#elseif courseWhich.status==2>
				<video  id="my-video1" class="video-js" controls preload="auto"  poster="${indexpath}/courseImg/${course.plotID}/${course.id}.jpg">
					<source src="${indexpath}/front/getCourse.action?courseWhichID=${courseWhich.id}" type="video/mp4">
			  	</video>
			</#if>
		</div>
		<div class="col-lg-3 col-md-12 col-sm-12">
			<#list courseWhichList as which>
				<a href="${indexpath}/course/${course.plotID}/${course.id}/${which.whichEpisode}.html" type="button" class="btn ${(which.whichEpisode==courseWhich.whichEpisode)?string('btn-primary', 'btn-light')} btn-lg btn-block">
					${which.whichEpisode}.${which.name}
					<span class="float-right">${(which.status==2)?string('vip', '免费')}</span>
				</a>
			</#list>
		</div>
	</div>
	
</div>
</body>
</html>
<script type="text/javascript">
	var myPlayer = videojs('my-video1',{ autoplay: true,fluid: true }, function () { });
</script>
<script type="text/javascript">
	$(document).ready(function (){
		$.ajax({
		   type: "POST",
		   url: "${indexpath}/front/isCoursePlay.action",
		   data: {"courseWhichID":${courseWhich.id}},
		   dataType:"json",
		   success: function(msg){
			   	if(msg==false){
			   		$('#my-video1').append("<div style='position:absolute; top:50px; left:50px; font-size:30px; color:red; z-index:1000;'><a href='${indexpath}/vip.html' target='_Blank' style='color:red;'>你还不是会员，请先充值，会员1天1元，1月8元。<br>也可以免费获得会员，详情请点击...</a></div>");
			   	}
		   }
		});
	});
</script>