/**
 * 
 */
$.getParam = function(url, key) {

	//非空验证
	if(url == null || url == "" || key == null || key == "") {
		return null;
	}
	var params = url.split("&");
	for(var i = 0; i < params.length; i++) {
		var param = params[i].substring(params[i].indexOf("?") + 1, params[i].length);
		var ks = param.split("=");
		if(ks.length > 1) {
			var k = ks[0];
			if(k == key) {
				return param.split("=")[1];
			}
		} else {
			return null;
		}

	}
}