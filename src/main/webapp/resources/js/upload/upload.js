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
var grid;
var params;
$(function() {
	// 获取URL中的参数
	params = getURLParameter();
	
	console.log(params);
	//init();
});
function listAllDef(){
	//listAllProcDef
	init();
}

function init() {
	grid = $("#maingrid").ligerGrid( {
		// 数据加载地址
		url : window.ctxPaths + "/activiti/process/listAllProcDef.action",
		// 表头数据
		columns : [ {
			display : 'deploymentId',
			name : 'deploymentId',
			hide : true,
			align : 'left',
			width : 220,
			minWidth : 30
		},{
			display : 'diagramResourceName',
			name : 'diagramResourceName',
			hide : false,
			align : 'left',
			width : 220,
			minWidth : 30
		},  {
			display : 'id',
			name : 'id',
			align : 'left',
			width : 130,
			minWidth : 30
		}, {
			display : 'key',
			name : 'key',
			align : 'left',
			width : 150,
			minWidth : 30
		}, {
			display : 'name',
			name : 'name',
			align : 'left',
			width : 150,
			minWidth : 30
		} , {
			display : 'resourceName',
			name : 'resourceName',
			align : 'left',
			width : 150,
			minWidth : 30
		} , {
			display : 'version',
			name : 'version',
			align : 'left',
			width : 150,
			minWidth : 30
		}  ],
		pageSize : 30,
		width : getWidth(0.999),
		height : getHeight(0.85),
		enabledSort : false,
		toolbar : createToolbar(),
		parms : {
			"className" : params.className
		},
		root : 'rows', // 数据源字段名
		record : 'total' // 数据源记录数字段名
	});
}
function createToolbar() {
	var items = [];
	items.push( {
		text : "增加",
		click : function() {
			optMgr(null, 0);
		},
		img : window.ctxPaths + "/resources/ligerui/skins/icons/add.gif"
	});
	return {
		items : items
	};
}