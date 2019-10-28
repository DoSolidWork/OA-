/**BasicEmployeeInformationModel.java
 * 
 * 分類　　：model
 * 名称　　：BasicEmployeeInformationModel
 * 説明　　：查询结果实体类
 * 備考　　：
 * 作成　　：[日付]2019/10/14  [氏名] 胡庚
 * 履歴：
 * [NO]  [日付]		[Ver]（注１）　[更新者]	　　[内容]
 * 1	2019/10/14				胡庚		初版
 */
package model;

/**
 * 查询结果实体类
 * 
 * @Author 胡庚
 * @version 1.0
 */
public class IndexFunctionModel {

	/** 员工工号 */
	private String empNumber;
	/** 员工姓名 */
	private String empName;
	/** 员工职务 */
	private String empJob;
	/** 员工年薪 */
	private String empSalary;
	/** 员工所属部门 */
	private String deptCode;
	/** 部门名称 */
	private String deptName;

	public IndexFunctionModel() {
	}

	public IndexFunctionModel(String empNumber, String empName, String empJob,
			String empSalary, String deptCode, String deptName) {
		this.empNumber = empNumber;
		this.empName = empName;
		this.empJob = empJob;
		this.empSalary = empSalary;
		this.deptCode = deptCode;
		this.deptName = deptName;
	}

	/**
	 * get方法
	 * 
	 * @return empNumber
	 */
	public String getEmpNumber() {
		return empNumber;
	}

	/**
	 * set方法
	 * 
	 * @param empNumber
	 *            设置empNumber的值
	 */
	public void setEmpNumber(String empNumber) {
		this.empNumber = empNumber;
	}

	/**
	 * get方法
	 * 
	 * @return empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * set方法
	 * 
	 * @param empName
	 *            设置empName的值
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * get方法
	 * 
	 * @return empJob
	 */
	public String getEmpJob() {
		return empJob;
	}

	/**
	 * set方法
	 * 
	 * @param empJob
	 *            设置empJob的值
	 */
	public void setEmpJob(String empJob) {
		this.empJob = empJob;
	}

	/**
	 * get方法
	 * 
	 * @return empSalary
	 */
	public String getEmpSalary() {
		return empSalary;
	}

	/**
	 * set方法
	 * 
	 * @param empSalary
	 *            设置empSalary的值
	 */
	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}

	/**
	 * get方法
	 * 
	 * @return deptCode
	 */
	public String getDeptCode() {
		return deptCode;
	}

	/**
	 * set方法
	 * 
	 * @param deptCode
	 *            设置deptCode的值
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * get方法
	 * 
	 * @return deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * set方法
	 * 
	 * @param deptName
	 *            设置deptName的值
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "BasicEmployeeInformation [empNumber=" + empNumber
				+ ", empName=" + empName + ", empJob=" + empJob
				+ ", empSalary=" + empSalary + ", deptCode=" + deptCode
				+ ", deptName=" + deptName + "]";
	}

}
