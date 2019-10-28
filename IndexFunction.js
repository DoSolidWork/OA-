/**
 * 检索按钮
 * 
 * 点击检索按钮，提交表单数据到服务器层
 * 
 */
function retrievalButton() {
	// 工号值
	var jobNumber = document.getElementById("jobNumber").value;
	// 员工名
	var jobName = document.getElementById("jobName").value;
	// 错误提示
	var errorHint = document.getElementById("errorHint");

	// 名称、工号输入框为空，报错
	if (jobNumber.length == "0" && jobName.length == "0") {
		errorHint.innerHTML = "请输入工号或者名称！";
		return false;
	}

	// 输入位数不足8位、报错
	if (jobName.length < 1 && jobNumber.length < 8) {

		errorHint.innerHTML = "请输入正确工号，不能小于8位！";
		return false;

	}

	// 整合jsp页面的from表单数据，提交到后台
	var myform = document.getElementById("myform");
	myform.action = "membercodeSel";
	myform.submit();
}

/**
 * 清空按钮
 * 
 * 点击清空按钮，把页面数据全部清空
 * 
 */
function clearButton() {
	// 得到表单的ID
	var myform = document.getElementById("myform");
	myform.action = "IndexFunction";
	myform.submit();
}

/**
 * 按钮保持
 * 
 * 选择单选按钮时，提交数据后单选按钮保持
 * 
 * @return 当前选择的单选按钮
 */
window.onload = function() {
	// 当隐藏按钮为0时
	if (document.getElementById("buttonHidden").value == "0") {
		// 选择ID为deptName的单选按钮
		document.getElementById("deptName").checked = true;
		return;
	}

	// 当隐藏按钮为1时
	if (document.getElementById("buttonHidden").value == "1") {
		// 选择ID为empName的单选按钮
		document.getElementById("empName").checked = true;
		return;
	}
};
