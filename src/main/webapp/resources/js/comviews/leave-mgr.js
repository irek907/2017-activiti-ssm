/**
 * @author yangjie
 * @date 2012-12-17
 * @see opt=0(新增) opt=1（修改） opt=2（查看详情） opt=3（查看流程）
 */
var params = null;
$(function() {
	// 获取URL中的参数
	params = getURLParameter();
	init();
});

/**
 * 初始化界面方法
 */
function init() {
	var opt = params.opt;
	initLayout(params.ID, opt);
}

/**
 * 初始化界面布局
 * 
 * @param ID
 *            主键
 * @param opt
 *            操作类型
 */
function initLayout(ID, opt) {
	// 表单ID
	$("#formID").val(params.formID);
	var curDate = (new Date()).getCurDateString("yyyy-MM-dd HH:mm");
	$("#startTime").ligerDateEditor( {
		showTime : true,
		format : "yyyy-MM-dd hh:mm",
		width : 180,
		labelAlign : 'left',
		initValue : curDate
	});
	$("#startTime").attr("readonly", "readonly");
	$("#endTime").ligerDateEditor( {
		showTime : true,
		format : "yyyy-MM-dd hh:mm",
		width : 180,
		labelAlign : 'left',
		initValue : curDate
	});
	$("#endTime").attr("readonly", "readonly");
	// 审批意见
	$("#appove").hide();
	// 流程信息
	$("#flowinfo").hide();
	if (opt != 2) {
		$("#optBtn").append('<tr><td height="40" colspan="2" align="center"><a href="javascript:saveObj(\'' + 1 + '\')" id="save">保存</a>&nbsp;&nbsp;<a href="javascript:saveObj(\'' + 2 + '\')" id="save">提交</a>&nbsp;&nbsp;<a href="javascript:backMethod()" id="cancel">返回</a></td></tr>');
	}
	if (opt == 0) {
		return;
	}
	jQuery.ajax( {
		url : window.ctxPaths + "/activiti/process/getByIDLeave.action",
		type : "POST",
		cache : false,
		async : false,
		dataType : "json",
		data : {
			"leave.ID" : ID
		},
		success : function(json, textStatus) {
			$("#ID").val(json.ID);
			$("#leaveDate").val(json.leaveDate);
			$("#leaveMoney").val(json.leaveMoney);
			$("#leavePerson").val(json.leavePerson);
			$("#remark").val(json.remark);
			$("#superior").val(json.superior);
			$("#startTime").val(json.startTime);
			$("#endTime").val(json.endTime);
			$("#leaveReasons").val(json.leaveReasons);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			setMessage("服务端异常！", "error");
		}
	});
	// 查看详情
	if (opt == '2') {
		$("#flowinfo").show();
		// 隐藏按钮
		$("#leaveReasons").attr("readonly", "readonly");
		$("#agree,#disagree").hide();
		$("form input,form textarea").attr("readonly", "readonly");
		disableDate("startTime", "endTime");
		listFlow(params.executionId,params.ID);
	}
	// 流程信息
	if (opt == '3') {
		$("#appove").show();
		$("#flowinfo").show();
		$("#optBtn").hide();
		$("#taskID").val(params.taskId);
		$("#flowID").val(params.executionId);
		$("#proInstID").val(params.proInstId);
		$("#prodefID").val(params.prodefId);
		$("form input,form textarea").attr("readonly", "readonly");
		disableDate("startTime", "endTime");
		listFlow(params.executionId,params.ID);
	}
}

/**
 * 新增保存 修改保存
 */
function saveObj(domStatus) {
	var opt = params.opt;
	var url = window.ctxPaths + "/activiti/process/";
	if (opt == 0) {
		url += "insertLeave.action";
	} else {
		url += "updateLeave.action";
	}
	// 表单验证
	var isValid = checkForm();
	if (!isValid) {
		return;
	}
	// dom状态
	$("#domStatus").val(domStatus);
	// 流程ID
	$("#flowID").val(params.executionId);
	// taskID
	$("#taskID").val(params.taskId);
	// proInstID
	$("#proInstID").val(params.proInstId);
	// 序列化表单
	var data = $("#proform").serializeObject();
	setWatting();
	jQuery.ajax( {
		url : url,
		type : "POST",
		cache : false,
		async : false,
		dataType : "json",
		data : data,
		success : function(json, textStatus) {
			setWatting(true);
			if (json.msg == null || json.msg == "") {
				setMessage("保存成功!", "success", true);
				return;
			}
			setMessage("提交成功!等待" + json.msg + "审批!", "success", true);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			setMessage("服务端异常！", "error");
			setWatting(true);
		}
	});
}

/**
 * 检查表单
 * 
 * @returns
 */
function checkForm() {
	return $.checkForm( {
		ctrls : [ {
			id : "leavePerson",
			type : "mustInput",
			par : "",
			msg : "请输入请假人！"
		}, {
			id : "superior",
			type : "mustInput",
			par : "",
			msg : "请输入上级领导！"
		}, {
			id : "leavePerson",
			type : "mustLessThan",
			par : "20",
			msg : "请假人输入过长！"
		}, {
			id : "superior",
			type : "mustLessThan",
			par : "20",
			msg : "上级领导输入过长！"
		}, {
			id : "endTime",
			type : "compareDate",
			par : "startTime",
			msg : "请假开始时间不能大于或等于结束时间！"
		}, {
			id : "leaveReasons",
			type : "mustInput",
			par : "",
			msg : "请输入请假原因！"
		}, {
			id : "leaveReasons",
			type : "mustLessThan",
			par : "200",
			msg : "请假原因输入过长！"
		} ],
		failed : function(msg) {
			setMessage(msg, "warn");
		}
	});
}