/**
 * 获取所有的流程信息
 */
function listFlow(flowID, recordID) {
	jQuery.ajax( {
		url : window.ctxPaths + "/activiti/process/listFlowLog.action",
		type : "POST",
		cache : false,
		async : false,
		dataType : "json",
		data : {
			// 当前流程ID
			"flowLog.flowID" : flowID,
			// 当前记录ID
			"flowLog.recordID" : recordID
		},
		success : function(json, textStatus) {
			if (json != null && json.length > 0) {
				addFlowRow(json);
			}
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			setMessage("服务端异常！", "error");
		}
	});
}

/**
 * 流程信息布局
 * 
 * @param json
 */
function addFlowRow(json) {
	var html = "";
	for ( var i = 0; i < json.length; i++) {
		html += "<tr>";
		html += "<td align='center' height='25'>" + (i + 1) + "</td>";
		html += "<td align='center' height='25'>" + json[i].userID + "</td>";
		var action = "";
		if (json[i].action == 1) {
			action = "提交成功";
		} else if (json[i].action == 2) {
			action = "审批通过";
		} else {
			action = "审批不通过";
		}
		html += "<td align='center' height='25'>" + action + "</td>";
		var opinion = json[i].opinion == null ? '' : json[i].opinion;
		html += "<td align='center' height='25'>" + opinion + "</td>";
		html += "</tr>";
	}
	$("#flow").append(html);
}

/**
 * 流程流转
 * 
 * @param ation
 */
function runProccess(action) {
	setWatting();
	jQuery.ajax( {
		url : window.ctxPaths + "/activiti/process/runPersonalTask.action",
		type : "POST",
		cache : false,
		async : false,
		dataType : "json",
		data : {
			"userTask.recordID" : $("#ID").val(),
			"userTask.formID" : $("#formID").val(),
			"userTask.action" : action,
			"userTask.opinion" : $("#opinion").val(),
			"userTask.ID" : $("#taskID").val(),
			"userTask.instanceId" : $("#flowID").val(),
			"userTask.definitionId" : $("#prodefID").val()
		},
		success : function(json, textStatus) {
			if (json.msg == null) {
				setWatting(true);
				setMessage("提交成功!", "success", true);
				return;
			}
			setWatting(true);
			var msg = "";
			if (action == "2") {
				msg = "审批";
			} else {
				msg = "拒绝";
			}
			var msg1 = "";
			if (json.msg == null || json.msg == "") {
				msg1 = "";
			} else {
				msg1 = ",等待" + json.msg + "审批!";
			}
			setMessage(msg + "成功!" + msg1, "success", true);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			setMessage("服务端异常!", "error");
			setWatting(true);
		}
	});
}

/**
 * 查看是否已经进入流程
 * 
 * @param ID
 *            记录ID
 */
function isEnterFlow(ID, formID) {
	var isFound = false;
	// 保存前查看数据是否进入流程
	jQuery.ajax( {
		url : window.ctxPaths + "/jsp/common/isEnterFlow.action",
		type : "POST",
		cache : false,
		async : false,
		dataType : "json",
		data : {
			"ID" : ID
		},
		success : function(json, textStatus) {
			$("#isUpSave").val(json.msg);
			isFound = true;
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			setMessage("服务端异常！", "error");
		}
	});
	return isFound;
}