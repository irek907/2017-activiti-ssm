/**
 * @author yangjie
 * @date 2012-11-19
 */
var grid;
var params;
$(function() {
	// 获取URL中的参数
	params = getURLParameter();
	init();
});

function init() {
	grid = $("#maingrid").ligerGrid( {
		// 数据加载地址
		url : window.ctxPaths + "/activiti/process/queryPersonalTask.action",
		// 表头数据
		columns : [ {
			display : '任务ID',
			name : 'ID',
			hide : true,
			align : 'left',
			width : 220,
			minWidth : 30
		}, {
			display : '提交人',
			name : 'userName',
			align : 'left',
			width : 130,
			minWidth : 30
		}, {
			display : '提交时间',
			name : 'logTime',
			align : 'left',
			width : 150,
			minWidth : 30
		}, {
			display : '流程KEY',
			name : 'prodefId',
			align : 'left',
			width : 220,
			minWidth : 30
		}, {
			display : '处理人',
			name : 'assignee',
			align : 'left',
			width : 220,
			minWidth : 30
		}, {
			display : '操作',
			name : 'opt',
			align : 'left',
			width : 200,
			minWidth : 30,
			render : function(rowdata, rowindex, value) {
				var html = "";
				var href = 'leave-mgr.jsp?ID=' + rowdata.recordID + '&opt=' + 3 + '&executionId=' + rowdata.executionId + '&procinstId=' + rowdata.procinstId + '&prodefId=' + rowdata.prodefId + '&taskId=' + rowdata.ID;
				var href1 = "processimage.jsp?taskId="+rowdata.ID;
				html += '<a href="javascript:window.open(\'' + href + '\',\'' + "_self" + '\');">处理任务</a>&nbsp;&nbsp;';
				html += '<a href="javascript:window.open(\'' + href1 + '\',\'' + "_self" + '\');">查看流程图</a>&nbsp;&nbsp;';
				return html;
			}
		} ],
		pageSize : 30,
		width : getWidth(0.999),
		height : getHeight(0.85),
		enabledSort : false,
		// toolbar : createToolbar(),
		root : 'rows', // 数据源字段名
		record : 'total' // 数据源记录数字段名
	});
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
	};
}
