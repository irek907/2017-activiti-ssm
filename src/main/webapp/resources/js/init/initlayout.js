var tab = null;
var accordion = null;
$(function() {
	// 布局
	$("#layout1").ligerLayout( {
		leftWidth : 190,
		height : '100%',
		heightDiff : -34,
		space : 4,
		onHeightChanged : f_heightChanged
	});
	var height = $(".l-layout-center").height();
	// Tab
	$("#framecenter").ligerTab( {
		height : height
	});
	// 面板
	$("#accordion1").ligerAccordion( {
		height : height - 24,
		speed : null
	});
	$(".l-link").hover(function() {
		$(this).addClass("l-link-over");
	}, function() {
		$(this).removeClass("l-link-over");
	});
	tab = $("#framecenter").ligerGetTabManager();
	accordion = $("#accordion1").ligerGetAccordionManager();
	//initForm();
	$("#pageloading").hide();
});

function f_heightChanged(options) {
	if (tab)
		tab.addHeight(options.diff);
	if (accordion && options.middleHeight - 24 > 0)
		accordion.setHeight(options.middleHeight - 24);
}

function f_addTab(tabid, text, url) {
	tab.addTabItem( {
		tabid : tabid,
		text : text,
		url : url
	});
}

function initForm() {
	jQuery.ajax( {
		url : "/dycompile/jsp/table/listTable.action",
		type : "POST",
		cache : false,
		async : false,
		dataType : "json",
		data : {
			"formInfo.formType" : '1',
			"formInfo.formStatus" : '1'
		},
		success : function(json, textStatus) {
			var formList = json.rows;
			for(var i = 0;i<formList.length;i++){
				$("#formList").append('<a class="l-link" href="javascript:f_addTab(\''+formList[i].formName+'\',\''+formList[i].displayName+'\',\''+'comviews/'+formList[i].formUrl+'?className='+formList[i].formName+'&formID='+formList[i].ID+'\')">'+formList[i].displayName+'</a>');
			}
			
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			$.ligerDialog.alert("服务端异常！", "温馨提示", "error");
		}
	});
}
