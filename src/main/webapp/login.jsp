<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工作流Demo</title>
<jsp:include page="/resources/common/common.jsp" />
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.json-2.2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/login/login-mgr.js"></script>
</head>
<body>
	<form id="LoginForm">
		<div style="position: absolute; width: 300px;height:160px; top: 50%; left: 50%; margin-left: -150px; margin-top: -100px">
			<table width="300px" height="160px" border="0" cellpadding="0" cellspacing="0">
				<tr height="40px">
					<td align="center" width="80px">用户名:</td>
					<td width="200px"><input type="text" name="user.username" value="wo"/></td>
				</tr>
				<tr height="40px">
					<td align="center">密&nbsp;&nbsp;码:</td>
					<td><input type="password" name="user.password" value="1"/></td>
				</tr>
				<tr height="40px">
					<td align="center">验证码:</td>
					<td>
						<input type="text" name="validataCode" style="width: 50px"/>
			      		<!-- <img alt="" src="<%=request.getContextPath()%>/validateimage.action" onclick="this.src=this.src+'?dd='+Math.random()" /> -->
					</td>
				</tr>
				<tr height="40px">
					<td colspan="2" align="center">
						<input type="button" onclick="javascript:submitform()" value="登录" style="width: 60px"/>
						&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" value="取消" style="width: 60px"/>	
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>