<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
%>
<link href="<%=path%>/resources/ligerui/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
<script src="<%=path%>/resources/js/jquery-1.8.1.js" type="text/javascript"></script>
<script src="<%=path%>/resources/ligerui/js/ligerui.min.js" type="text/javascript"></script>
<script src="<%=path%>/resources/js/common/common.js" type="text/javascript"></script>
<script src="<%=path%>/resources/js/mustache.js" type="text/javascript"></script>
<link href="<%=path%>/resources/common/common.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">
	window.ctxPaths="<%=path%>";
	
	function getWidth(percent) {
    	return document.body.clientWidth*percent;
	}
	function getHeight(percent) {
    	return document.body.clientHeight*percent;
	}
</script>