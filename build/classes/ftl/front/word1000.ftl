<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${csspath}/boots/bootstrap.min.css">
<link rel="stylesheet" href="${csspath}/video-js.css">
<link rel="stylesheet" href="${csspath}/lianggeshipin.css">
<link rel="shortcut icon" type="favicon.ico" href="${imgpath}/lianggeshipin.ico">
<link rel="icon" href="data:;base64,=">
<title>英语4级，常用1000单词图片记忆</title>
<script src="${jspath}/jquery.min.js"></script>
<script src="${jspath}/video.min.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class="jumbotron play-bgi">
		<h1 class="display-4">英语4级，常用1000单词图片记忆</h1>
		<p>英语4级考试中要求考生领会掌气握4400个单词，但在实际的考试命题中能出题的词汇并不多，有些词太简单，出题没有意义，
		有些词不常用，出题也没有意义，而有些词又不便做成词汇题。因此常用来出题的词汇也就1000个词。考生只要熟记这些词，
		通过词汇方面的考试就没有多大问题。</p>
		<hr class="my-4">
		<a class="btn btn-primary btn-lg" href="${indexpath}" role="button">回首页</a>
	</div>
	<div style="position: fixed; right: 20px; bottom: 40px; width: 40px; z-index: 1040;">
		<button type="button" class="btn btn-success" onclick="start()">播放</button>
		<button type="button" class="btn btn-danger" onclick="stop()">暂停</button>
	</div>
	<#if pageNum lt 5>
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-end">
		    <li class="page-item">
		      <a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=1">首页</a>
		    </li>
		    <li class="page-item <#if pageNum == 1>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=1">1</a></li>
		    <li class="page-item <#if pageNum == 2>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=2">2</a></li>
		    <li class="page-item <#if pageNum == 3>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=3">3</a></li>
		    <li class="page-item <#if pageNum == 4>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=4">4</a></li>
		    <li class="page-item <#if pageNum == 5>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=5">5</a></li>
		    <li class="page-item <#if pageNum == 6>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=6">6</a></li>
		    <li class="page-item <#if pageNum == 7>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=7">7</a></li>
		    <li class="page-item <#if pageNum == 8>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=8">8</a></li>
		    <li class="page-item <#if pageNum == 9>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=9">9</a></li>
		    <li class="page-item">
		      <a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=42">末页</a>
		    </li>
		  </ul>
		</nav>
	<#elseif pageNum gt 38>
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-end">
		    <li class="page-item">
		      <a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=1">首页</a>
		    </li>
		    <li class="page-item <#if pageNum == 34>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=34">34</a></li>
		    <li class="page-item <#if pageNum == 35>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=35">35</a></li>
		    <li class="page-item <#if pageNum == 36>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=36">36</a></li>
		    <li class="page-item <#if pageNum == 37>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=37">37</a></li>
		    <li class="page-item <#if pageNum == 38>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=38">38</a></li>
		    <li class="page-item <#if pageNum == 39>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=39">39</a></li>
		    <li class="page-item <#if pageNum == 40>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=40">40</a></li>
		    <li class="page-item <#if pageNum == 41>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=41">41</a></li>
		    <li class="page-item <#if pageNum == 42>active</#if>"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=42">42</a></li>
		    <li class="page-item">
		      <a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=42">末页</a>
		    </li>
		  </ul>
		</nav>
	<#else>	
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-end">
		    <li class="page-item">
		      <a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=1">首页</a>
		    </li>
		    <li class="page-item"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=${pageNum-4}">${pageNum-4}</a></li>
		    <li class="page-item"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=${pageNum-3}">${pageNum-3}</a></li>
		    <li class="page-item"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=${pageNum-2}">${pageNum-2}</a></li>
		    <li class="page-item"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=${pageNum-1}">${pageNum-1}</a></li>
		    <li class="page-item active"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=${pageNum}">${pageNum}</a></li>
		    <li class="page-item"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=${pageNum+1}">${pageNum+1}</a></li>
		    <li class="page-item"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=${pageNum+2}">${pageNum+2}</a></li>
		    <li class="page-item"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=${pageNum+3}">${pageNum+3}</a></li>
		    <li class="page-item"><a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=${pageNum+4}">${pageNum+4}</a></li>
		    <li class="page-item">
		      <a class="page-link" href="${indexpath}/front/word1000Page.action?pageNum=42">末页</a>
		    </li>
		  </ul>
		</nav>
	</#if>

	<div class="row">
		<#list wordList as word_>
		
	    <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
	      	<img width="100%" src="${indexpath}/word1000Img/${(word_.word)!""}.${word_.img_format}" class="img-fluid rounded float-right">
	    </div>
	    <div class="col-xl-6 col-lg-6 col-md-12 col-sm-12">
	      	<table class="table">
			    <tbody>
			      <tr>
			        <td>
			        	<button type="button" class="btn btn-dark">${(word_.word)!""}</button>
			        	${(word_.description)!""}
			        </td>
			      </tr>
			      <tr>
			        <td>
				        <button type="button" class="btn btn-success">英文句1</button>
				        ${(word_.en_sentence_1)!""}
			        </td>
			      </tr>
			      <tr>
			        <td>
			        	<button type="button" class="btn btn-success">中文句1</button>
			        	${(word_.ch_sentence_1)!""}
			        </td>
			      </tr>
			      <tr>
			        <td>
			        	<button type="button" class="btn btn-info">英文句2</button>
			        	${(word_.en_sentence_2)!""}
			        </td>
			      </tr>
			      <tr>
			        <td>
			        	<button type="button" class="btn btn-info">中文句2</button>
			        	${(word_.ch_sentence_2)!""}
			        </td>
			      </tr>
			      <tr>
			        <td>
			        	<button onclick="document.getElementById('uk_${word_.word}').play()" type="button" class="btn btn-primary"><audio id="uk_${word_.word}" src="${indexpath}/mp3/word1000/uk/${word_.word}.mp3"  class="musicFlag"></audio>英语发音<svg viewBox="0 0 24 24" width="24" height="24" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1"><path d="M9 18V5l12-2v13"></path><circle cx="6" cy="18" r="3"></circle><circle cx="18" cy="16" r="3"></circle></svg></button>
			        	<button onclick="document.getElementById('us_${word_.word}').play()" type="button" class="btn btn-primary"><audio id="us_${word_.word}" src="${indexpath}/mp3/word1000/us/${word_.word}.mp3"></audio>美语发音<svg viewBox="0 0 24 24" width="24" height="24" stroke="currentColor" stroke-width="2" fill="none" stroke-linecap="round" stroke-linejoin="round" class="css-i6dzq1"><path d="M9 18V5l12-2v13"></path><circle cx="6" cy="18" r="3"></circle><circle cx="18" cy="16" r="3"></circle></svg></button>
			        </td>
			      </tr>
			    </tbody>
		  	</table>
	    </div>
	    </#list>
	</div>
</div>
</body>
</html>
<script>
	var pageNum=${pageNum}; // 当前第几页
	var fun_obj,count;
	count=0;
	
	function start(){
		$("html,body").animate({scrollTop:$("img:eq("+count+")").offset().top},1000);
		setTimeout(playMusic, 1000);
		fun_obj = setInterval("play()", 4000);
	}
	
	function play(){
		count++;
		$("html,body").animate({scrollTop:$("img:eq("+count+")").offset().top},1000);
		setTimeout(playMusic, 1000);
	}
	function stop(){
		clearInterval(fun_obj);
	}
	function playMusic(){
		$(".musicFlag:eq("+count+")")[0].play();
	}
	
	var loadOK = true; // 防止滚动事件触发太快
	$(window).scroll(function(){
		var winHei = $(window).height() //获取可见的窗口高度
		var winCro = $(window).scrollTop(); // 页面当前的高度
		var doHei  = $(document).height(); // 页面的总高度
		
	    var totalheight = parseFloat(winHei*3) + parseFloat(winCro); // 页面当前高度 + 3个屏幕的高度
	    if(doHei <= totalheight){
	       if(loadOK){
	       		loadOK = false; 
	       		$.ajax({
				   type: "POST",
				   url: "${indexpath}/front/getWord1000.action",
				   data: {"pageNum":parseInt(pageNum)+1},
				   dataType:"json",
				   success: function(msg){
					   	if(msg.success==1){
					   		$(".row").append(msg.ele);
					   		pageNum = parseInt(pageNum)+1
					   		loadOK = true;
					   	}else{
				   		
				   		}
				   }
				});
	       }
	    }
	});
</script>