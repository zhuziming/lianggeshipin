function wx_login(){
	var wx_url = "https://open.weixin.qq.com/connect/qrconnect";
	var appid = "wx9b8b52c9125199e4";
	var redirect_uri = "http%3A%2F%2Fwww.lianggeshipin.com%2FweixinRedirect.action";
	var response_type = "code";
	var scope = "snsapi_login";
	var state = "STATE#wechat_redirect";
	window.location.href=wx_url + "?appid=" + appid + "&redirect_uri=" + redirect_uri + "&response_type=" + response_type + "&scope=" + scope + "&state=" + state;
}