function submitform() {
	// 序列化表单
	var data = $("#LoginForm").serializeObject();
	//alert(data);
	//console.log(data);
	jQuery.ajax( {
		url : window.ctxPaths + "/activiti/user/login.action",
		type : "POST",
		cache : false,
		async : false,
		dataType : "json",
		data : data,
		success : function(json, textStatus) {
			console.log(json);
			if (json.success == true && json.msg == "") {
				window.open("index.html", "_self");
			} else if (json.success == true && json.msg != "") {
				setMessage(json.msg, "warn");
			} else {
				setMessage("服务器异常!", "error");
			}

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			setMessage("服务端异常！", "error");
		}
	});
}
