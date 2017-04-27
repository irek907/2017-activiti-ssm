<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>文件上传</title>
		<jsp:include page="/resources/common/common.jsp" />
		<script src="<%=request.getContextPath()%>/resources/js/jquery-1.8.1.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/resources/js/jquery.json-2.2.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/resources/js/upload/ajaxfileupload.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/resources/js/upload/upload.js" type="text/javascript"></script>
	</head>
	<body>
	<div>
		<div>
			<h1>资源文件上传</h1>
			<img id="loading" src="../resources/images/loading.gif" style="display: none;">
			<form name="form" action="" method="POST" enctype="multipart/form-data">
				<table cellpadding="0" cellspacing="0" class="tableForm">
					<tbody>
						<tr>
							<td><input id="template" type="file" size="30" name="template"></td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td>
								<button class="button" id="buttonUpload" onclick="return ajaxFileUpload();">上传</button>
								<p style="color: red;font-size:13px;">
									允许文件后缀：(文件大小不超过5M)<br />
									1、xml <br />
									2、zip <br />
								</p>
							</td>
						</tr>
					</tfoot>
				</table>
			</form>
		</div>
	</div>
</body>
</html>