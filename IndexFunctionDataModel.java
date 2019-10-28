/**EntiretyDataModel.java
 * 
 * 分類　　：model
 * 名称　　：EntiretyDataModel
 * 説明　　：查询结果实体类
 * 備考　　：
 * 作成　　：[日付]2019/10/14  [氏名] 胡庚
 * 履歴：
 * [NO]  [日付]		[Ver]（注１）　[更新者]	　　[内容]
 * 1	2019/10/14				胡庚		初版
 */
package model;

import java.util.List;

/**
 * 中间实体类
 * 
 * @Author 胡庚
 * @version 1.0
 */
public class IndexFunctionDataModel {

	/** 查询得到的集合数据 */
	public List<IndexFunctionModel> basicList;

	/**
	 * get方法
	 * 
	 * @return BasicList
	 */
	public List<IndexFunctionModel> getBasicList() {
		return basicList;
	}

	/**
	 * set方法
	 * 
	 * @param basicList
	 *            设置basicList的值
	 */
	public void setBasicList(List<IndexFunctionModel> basicList) {
		this.basicList = basicList;
	}
}
