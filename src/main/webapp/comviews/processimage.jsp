<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看流程图</title>
<jsp:include page="/resources/common/common.jsp" />
<script type="text/javascript">
	$(function(){
		var params = getURLParameter();
		var url = "<%=request.getContextPath()%>/activiti/process/getProessImage.action?userTask.ID="+params.taskId;
		console.log(url);
		$("#image").attr("src",url);
	});
</script>
</head>
<body>
	<img id="image" alt="流程图" src="">
</body>
</html>