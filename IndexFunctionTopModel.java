/**IndexFunctionTopModel.java
 * 
 * 分類　　：model
 * 名称　　：IndexFunctionTopModel
 * 説明　　：查询结果实体类
 * 備考　　：
 * 作成　　：[日付]2019/10/14  [氏名] 胡庚
 * 履歴：
 * [NO]  [日付]		[Ver]（注１）　[更新者]	　　[内容]
 * 1	2019/10/14				胡庚		初版
 */
package model;

/**
 * 输入内容实体类
 * 
 * @Author 胡庚
 * @version 1.0
 */
public class IndexFunctionTopModel {

	/** 工号 */
	private String jobNumber;
	/** 单选框后面填入的名称 */
	private String jobName;
	/** 按钮选择 */
	private String singleButton;

	public IndexFunctionTopModel() {
	}

	public IndexFunctionTopModel(String jobName, String jobNumber,
			String singleButton) {
		super();
		this.jobName = jobName;
		this.jobNumber = jobNumber;
		this.singleButton = singleButton;

	}

	/**
	 * get方法
	 * 
	 * @return jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * set方法
	 * 
	 * @param jobName
	 *            设置jobName的值
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * get方法
	 * 
	 * @return singleButton
	 */
	public String getSingleButton() {
		return singleButton;
	}

	/**
	 * set方法
	 * 
	 * @param singleButton
	 *            设置singleButton的值
	 */
	public void setSingleButton(String singleButton) {
		this.singleButton = singleButton;
	}

	/**
	 * get方法
	 * 
	 * @return jobNumber
	 */
	public String getJobNumber() {
		return jobNumber;
	}

	/**
	 * set方法
	 * 
	 * @param jobNumber
	 *            设置jobNumber的值
	 */
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	@Override
	public String toString() {
		return "TopIndexFunction [jobName=" + jobName + ", jobNumber="
				+ jobNumber + ", singleButton=" + singleButton + "]";
	}

}
