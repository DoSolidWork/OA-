/**
 * ChangeHintUnit.java
 * 
 * 分類　　： spring自定义方法
 * 名称　　： ChangeHintUnit.java
 * 説明　　：
 * 備考　　：
 * 作成　　：[日付]2019/10/10  [氏名] 胡庚
 * 履歴：
 * [NO]  [日付]		[Ver]（注１）　[更新者]	　　[内容]
 * 1	2019/10/10				胡庚		初版
 * Copyright (C) 2019, MBP All Rights Reserved.
 */
package unit;

import java.util.List;
import model.IndexFunctionModel;

/**
 * html转义类
 * 
 * @Author 胡庚
 * @version 1.0
 */
public class ChangeHintUnit {
	/**
	 * 
	 * 对前端显示的html特殊字符进行转义显示
	 * 
	 * @param List
	 *            <BasicEmployeeInformationModel> 实体类对象
	 * @return list 返回集合
	 */
	public List<IndexFunctionModel> ChangeHtml(List<IndexFunctionModel> list) {
		System.out.println("ChangeHint---star:");
		// 判断集合是否为空
		if (list != null) {
			// 遍历集合
			for (IndexFunctionModel basicList : list) {
				// 判断部门是否为空
				if (basicList.getDeptName() != null) {
					basicList.setDeptName(basicList.getDeptName().replaceAll(
							"<", "&lt;"));
					basicList.setDeptName(basicList.getDeptName().replaceAll(
							">", "&gt;"));
				}
			}
		}
		System.out.println("ChangeHint---end:");
		// 返回集合
		return list;

	}
}
