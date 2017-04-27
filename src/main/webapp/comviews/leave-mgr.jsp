<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title></title>
		<jsp:include page="/resources/common/common.jsp" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.json-2.2.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/common/jquery-validata-1.0.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/common/process-common.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/comviews/leave-mgr.js"></script>
	</head>
	<body>
		<form id="proform" name="proform" method="post" style="padding: 20px 10px 20px 20px">
			<!-- 表单ID和当前记录主键 -->
			<input type="hidden" id="formID" name="formID"/>
			<input type="hidden" id="ID" name="leave.ID"/>
			<!-- 流程相关 -->
			<input type="hidden" id="taskID" name="taskID"/>
			<input type="hidden" id="flowID" name="flowID"/>
			<input type="hidden" id="proInstID" name="proInstID"/>
			<input type="hidden" id="prodefID" name="prodefID"/>
			<!-- dom状态和状态位 -->
			<input type="hidden" id="opt" name="opt"/>
			<input type="hidden" id="domStatus" name="leave.domStatus"/>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="protable tab">
				<tr height="30px">
					<td width="120" height="40" align="right" bgcolor="#f5f5f5"><span style="color:red;">*</span><label>请假人:</label></td>
					<td>
					<input id="leavePerson" name="leave.leavePerson" type="text" class="text"  maxlength="20"/>					&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr height="30px">
					<td width="120" height="40" align="right" bgcolor="#f5f5f5"><span style="color:red;">*</span><label>上级领导:</label></td>
					<td>
					<input id="superior" name="leave.superior" type="text" class="text"  maxlength="20"/>					&nbsp;</td>
				</tr>
				<tr height="30px">
					<td width="120" height="40" align="right" bgcolor="#f5f5f5"><span style="color:red;">*</span>开始时间:</td>
					<td>
					<input id="startTime" name="leave.startTime" type="text"  maxlength="20"/>					&nbsp;&nbsp;</td>
				</tr>
				<tr height="30px">
					<td width="120" height="40" align="right" bgcolor="#f5f5f5"><span style="color:red;">*</span>结束时间:</td>
					<td>
					<input id="endTime" name="leave.endTime" type="text"  maxlength="20"/>					&nbsp;</td>
				</tr>
				<tr height="30px">
					<td width="120" height="40" align="right" bgcolor="#f5f5f5"><span style="color:red;">*</span>请假原因:</td>
					<td valign="top">
						<textarea rows="5" cols="25" id="leaveReasons" name="leave.leaveReasons" class="text width300" ></textarea>
					</td>
				</tr>
				<tbody id="optBtn">
			    </tbody>
			</table>
		</form>
		<div id="appove" style="padding: 20px 10px 20px 20px">
			<br/>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" class="protable tab">
				<tr>
					<td height="30" colspan="4"><h4>审批意见</h4></td>
				</tr>
				<tr>
					<td align="right" valign="top" bgcolor="#f5f5f5" class="p-t"><label>审批意见</label></td>
					<td valign="top">
						<textarea rows="5" cols="25" id="opinion" name="opinion" class="text width300" ></textarea>
					</td>
				</tr>
			</table>
			<br/>
		</div>
		<div id="flowinfo" style="padding: 20px 10px 20px 20px">
			<table  width="100%" border="0" cellpadding="0" cellspacing="0" class="tab">
				<tr>
					<td height="30" colspan="4"><h4>流程信息</h4></td>
				</tr>
				<tr>
					<td align='center' height='25' bgcolor='#f5f5f5'>序号</td>
					<td align='center' height='25' bgcolor='#f5f5f5'>提交人</td>
					<td align='center' height='25' bgcolor='#f5f5f5'>操作</td>
					<td align='center' height='25' bgcolor='#f5f5f5'>审批意见</td>
				</tr>
				<tbody id="flow"></tbody>
				<tr height="10px"><td colspan="4"></td></tr>
				<tr>
					<td colspan="4" align="center">
						<a href="javascript:runProccess('2')" id="agree">同意</a>&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="javascript:runProccess('3')" id="disagree">拒绝</a>&nbsp;&nbsp;&nbsp;
			           	<a href="javascript:backMethod()" id="cancel">返回</a> 
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>