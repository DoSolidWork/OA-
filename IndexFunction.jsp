<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页</title>
<link rel="stylesheet" type="text/css" href="./css/IndexFunction.css">
<script type="text/javascript" src="./js/IndexFunction.js"></script>
</head>
<body>

<div align="center">

<form id="myform" action="" method="post">
<table border="1" width="800px" height="280px" cellspacing="0"
	cellpadding="0" class="SheetTip">

	<tr>
		<td colspan="7" width="280px" height="120px"
			style="text-align: center" valign="top"><label>检索</label></td>

		<td colspan="7" width="280px" height="120px">工号:<input
			name="jobNumber" value="${jobNumber}" type="text" maxlength="8"
			id="jobNumber" /></td>
		<td colspan="6" width="240px" height="120px"><img
			src="img/MBP.jpg" /></td>
	</tr>



	<tr>
		<td colspan="5" rowspan="3" height="160px" width="200px"
			style="text-align: left"><input id="buttonHidden" type="hidden"
			value="${toHidden}" /> <input type="radio" name="singleButton"
			id="deptName" value="0" checked />部门名<br />

		<input type="radio" name="singleButton" id="empName" value="1" />员工姓名

		</td>

		<td colspan="7" width="280px" height="120px" style="text-align: left"><label>
		<input name="jobName" value="${jobName}" type="text" maxlength="40"
			id="jobName" /> </label></td>

		<td colspan="8" width="320px" height="120px"><input type="button"
			value="检索" onclick="retrievalButton()" /> <input type="button"
			value="ＣＬＥＡＲ" onclick="clearButton()" /></td>
	</tr>

	<tr>
		<td colspan="15" width="600px" height="40px" style="color:red">
		
		<div id="errorHint">${hint}</div>
		</td>
	</tr>

</table>
</form>

<br />



<table border="1" width="800px" cellspacing="0" cellpadding="0"
	class="SheetTip">


	<tr>
		<td colspan="8" align="center" height="40px" width="320px"
			class="overstriking">员工信息</td>

		<td rowspan="2" align="center" height="80px" width="160px" colspan="4"
			class="overstriking">年收</td>

		<td rowspan="2" align="center" height="80px" width="120px" colspan="3"
			class="overstriking">所属部门<br />
		CODE</td>

		<td rowspan="2" align="center" height="80px" width="200px" colspan="5"
			class="overstriking">所属部门<br />
		名称</td>

	</tr>


	<tr>
		<td align="center" height="40px" colspan="2" width="80px"
			class="overstriking">工号</td>
		<td align="center" height="40px" colspan="3" width="120px"
			class="overstriking">姓名</td>
		<td align="center" height="40px" colspan="3" width="120px"
			class="overstriking">職務レベル</td>
	</tr>

	<c:forEach items="${fakeList}" var="list">
		<tr>
			<td height="40px" width="80px" colspan="2">${list.empNumber}</td>
			<td align="center" height="40px" width="120px" colspan="3">${list.empName
			}</td>
			<td align="center" height="40px" width="120px" colspan="3">${list.empJob
			}</td>
			<td align="right" height="40px" width="160px" colspan="4">${list.empSalary
			}</td>
			<td align="center" height="40px" width="120px" colspan="3">${list.deptCode
			}</td>
			<td colspan="5" height="40px" width="200px">${list.deptName }</td>
		</tr>
	</c:forEach>
</table>



</div>
</body>

</html>
