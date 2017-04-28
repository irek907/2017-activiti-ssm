/**
 * @author yangjie
 * @date 2012-11-19
 */
var grid;
var params;
$(function() {
	// 获取URL中的参数
	params = getURLParameter();
	//initdata();
	init();
	initdata();
	/*
	
	var users = { result: [{ name: "Only", age: 24, sex: "boy" },  
                           { name: "for", age: 24, sex: "boy" },  
                           { name: "Olive", age: 23, sex: "girl" }  
                           ]  
    };  
    var template = "<div><table cellpadding=0 cellspacing=0 class='tb' ><tr><td>Name</td><td>Age</td><td>Sex</td></tr>{{#result}}<tr><td>{{name}}</td><td>{{age}}</td><td>{{sex}}</td></tr>{{/result}}</table><div>";  
    var views = Mustache.render(template, users);  
    $("#maingrid").html(views);  
    */
	
});
function initdata(){
	jQuery.ajax( {
		url : window.ctxPaths + "/activiti/process/listAllProcDef.action",
		type : "POST",
		cache : false,
		async : false,
		dataType : "json",
		data : null,
		success : function(json, textStatus) {
			console.log(json.rows);
			  var template = "<div><table cellpadding=0 cellspacing=0 class='tb' border='1'>" +
			  		"<tr><td>deploymentId</td>" +
			  		"<td>diagramResourceName</td>" +
			  		"<td>id</td>" +
			  		"<td>key</td>" +
			  		"<td>name</td>" +
			  		"<td>resourceName</td>" +
			  		"<td>version</td>" +
			  		"</tr>" +
			  		"{{#result}}" +
			  		"<tr>" +
			  		"<td>{{deploymentId}}</td>" +
			  		"<td>{{diagramResourceName}}</td>" +
			  		"<td>{{id}}</td>" +
			  		"<td>{{key}}</td>" +
			  		"<td>{{name}}</td>" +
			  		"<td>{{resourceName}}</td>" +
			  		"<td>{{version}}</td></tr>" +
			  		"{{/result}}" +
			  		"</table><div>";  
			  
			 // var t = JSON.stringify(json[0].rows);
			  
			 // t = "{ result:"+t+"}";
			  
			  var t = {
					  
					  result: json.rows
			  };
			 var views = Mustache.render(template,t );  
			 $("#maingrid2").html(views);
			/*if (json.success == true && json.msg == "") {


				 var views = Mustache.render(template, users);  
				 $("#maingrid").html(views);
				
			} else if (json.success == true && json.msg != "") {
				setMessage(json.msg, "warn");
			} else {
				setMessage("服务器异常!", "error");
			}*/

		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			setMessage("服务端异常！", "error");
		}
	});
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

/**
 * 打开模态窗口
 * 
 * @param ID
 * @param optStatus
 */
function optMgr(ID, optStatus) {
	if (ID != null) {
		window.open("leave-mgr.jsp?ID=" + ID + "&opt=" + optStatus, "_self");
		return;
	}
	window.open("leave-mgr.jsp?&opt=" + optStatus, "_self");
}

/**
 * 创建工具条
 * 
 * @returns Object
 */
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
	}
}
