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
	  <h1 class="display-4">编缉子集信息</h1>
	  <p class="lead">This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p>
	  <hr class="my-4">
	  <p>It uses utility classes for typography and spacing to space content out within the larger container.</p>
	  <a class="btn btn-primary btn-lg" href="${indexpath}" role="button">回前台首页</a>
	  <a class="btn btn-primary btn-lg" href="${indexpath}/manage/index.action" role="button">回后台首页</a>
	</div>
	
	<input type="hidden" id="plotID" value="${plot.id}">
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">中文视频名字</span>
	  </div>
	  <textarea id="plotNameCh_" class="form-control">${(plot.plotNameCh)!""}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">英文视频名字</span>
	  </div>
	  <textarea id="plotNameEn_" class="form-control">${(plot.plotNameEn)!""}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">第几集</span>
	  </div>
	  <textarea id="whichEpisode_" class="form-control">${(plot.whichEpisode)!""}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">中文视频地址</span>
	  </div>
	  <textarea id="videoUrlCh_" class="form-control">${(plot.videoUrlCh)!""}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">英文视频地址</span>
	  </div>
	  <textarea id="videoUrlEn_" class="form-control">${(plot.videoUrlEn)!""}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">图片地址</span>
	  </div>
	  <textarea id="imgUrl_" class="form-control">${(plot.imgUrl)!""}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">down</span>
	  </div>
	  <textarea id="down_" class="form-control">${(plot.down)!""}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">title</span>
	  </div>
	  <textarea id="title_" class="form-control">${(plot.title)!""}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">mate</span>
	  </div>
	  <textarea id="meta_" class="form-control">${(plot.meta)!""}</textarea>
	</div>
	<div class="input-group mb-3">
	  <div class="input-group-prepend">
	    <span class="input-group-text">html</span>
	  </div>
	  <textarea id="intro_" class="form-control">${(plot.intro)!""}</textarea>
	</div>
	
	<a class="btn btn-primary" href="javascript:editPlot();" role="button">更新</a>
</div>
</body>
</html>
<script>

function editPlot(){
	
	var plotNameCh_ = $("#plotNameCh_").val();
	var plotNameEn_ = $("#plotNameEn_").val();
	var whichEpisode_ = $("#whichEpisode_").val();
	var videoUrlCh_ = $("#videoUrlCh_").val();
	var videoUrlEn_ = $("#videoUrlEn_").val();
	var imgUrl_  = $("#imgUrl_").val();
	
	var down_  =  $("#down_").val();
	var title_ =  $("#title_").val();
	var meta_  =  $("#meta_").val();
	var intro_ =  $("#intro_").val();
	var plotID =  $("#plotID").val();
	
	$.ajax({
        type : "POST",
        url : "${indexpath}/manage/editPlot.action",
        data : {"plotID":plotID,"title":title_,"meta":meta_,"intro":intro_,"down":down_,
        "plotNameCh":plotNameCh_,"plotNameEn":plotNameEn_,"whichEpisode":whichEpisode_,"videoUrlCh":videoUrlCh_,"videoUrlEn":videoUrlEn_,"imgUrl":imgUrl_},
        success : function(result) {
            alert(result);
        }
    });
}

</script>