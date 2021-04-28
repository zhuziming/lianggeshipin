// 禁用鼠标右键菜单
$('#my-video1').bind('contextmenu',function() { return false; });
$('#my-video2').bind('contextmenu',function() { return false; });
var myPlayer1 = videojs('my-video1',{ autoplay: true,fluid: true }, function () { });
var myPlayer2 = videojs('my-video2',{ autoplay: false,fluid: true }, function () { });
// 跳转时间
function turnTime(which){
	if("ch"==which){
		myPlayer1.currentTime(timeToSec(document.getElementById("video_ch").value));
	}else if("en"==which){
		myPlayer2.currentTime(timeToSec(document.getElementById("video_en").value));
	}
}
function timeToSec(time){
	var hour = time.split(':')[0];
	var min = time.split(':')[1];
	var sec = time.split(':')[2];
	var s = Number(hour * 3600) + Number(min * 60) + Number(sec);
	return s;
}
// 后退5秒
function backTime(which){
	if("ch"==which){
		myPlayer1.currentTime(myPlayer1.currentTime()-5);
	}else if("en"==which){
		myPlayer2.currentTime(myPlayer2.currentTime()-5);
	}
}
// 前进5秒
function frontTime(which){
	if("ch"==which){
		myPlayer1.currentTime(myPlayer1.currentTime()+5);
	}else if("en"==which){
		myPlayer2.currentTime(myPlayer2.currentTime()+5);
	}
}
// 同步时间
function togetherTime(which){
	if("ch"==which){
		myPlayer1.currentTime(myPlayer2.currentTime());
	}else if("en"==which){
		myPlayer2.currentTime(myPlayer1.currentTime());
	}
}

$(document).ready(function (){
	$.ajax({
	   type: "POST",
	   url: "http://localhost:8080/lianggeshipin/front/isVip.action",
	   dataType:"json",
	   success: function(msg){
		   	if(msg.success==2){
		   		$('#my-video1').append("<div style='position:absolute; top:50px; left:50px; font-size:30px; color:red; z-index:1000;'><a href='http://localhost:8080/lianggeshipin/vip.html' target='_Blank' style='color:red;'>你还不是会员，请先充值，会员1天1元，1月15元。<br>也可以免费获得会员，详情请点击...</a></div>");
		   		$('#my-video2').append("<div style='position:absolute; top:50px; left:50px; font-size:30px; color:red; z-index:1000;'><a href='http://localhost:8080/lianggeshipin/vip.html' target='_Blank' style='color:red;'>你还不是会员，请先充值，会员1天1元，1月15元。<br>也可以免费获得会员，详情请点击...</a></div>");
		   	}
	   }
	});
});