function ajaxFileUpload() {

	$("#loading").ajaxStart(function() {
		$(this).show();
	}).ajaxComplete(function() {
		$(this).hide();
	});

	var file = $("#template").val();

	if (file == "") {
		alert("请选择您要上传的文件！");
		return false;
	}

	// 限制上传文件格式
	if (!checkFormat(file)) {
		alert("暂不支持上传此后缀的文件！");
		return false;
	}
    //cosole.log(window.ctxPaths + "/activiti/upload/upload.action");
	$.ajaxFileUpload( {
		url : window.ctxPaths + "/activiti/upload/upload.action",
		secureuri : false,
		fileElementId : 'template',
		dataType : 'json',
		success : function(data, status) {
			console.log(data);
			if (data.success == true && data.msg == "") {
				alert("上传成功！");
			} else {
				alert(data.msg);
			}
			$("#loading").hide();
		},
		error : function(data, status, e) {
			alert(e);
		}
	});

	return false;
}

/**
 * 验证资源文件格式
 * 
 * @param file
 */
function checkFormat(file) {
	if (/.(xml|zip)$/.test(file)) {
		return true;
	}
	return false;
}
