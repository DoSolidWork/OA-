/**
 * HandleStrUnit.java
 * 
 * 分類　　： spring自定义方法
 * 名称　　： HandleStrUnit.java
 * 説明　　：
 * 備考　　：
 * 作成　　：[日付]2019/10/10  [氏名] 胡庚
 * 履歴：
 * [NO]  [日付]		[Ver]（注１）　[更新者]	　　[内容]
 * 1	2019/10/10				胡庚		初版
 *
 */
package unit;

/**
 * 输入特殊字符处理类
 * 
 * @Author 胡庚
 * @version 1.0
 */
public class HandleStrUnit {

	/** 定义"/"字符串，将特殊字符进行分割 */
	public static String slantStr = "/";

	/**
	 * 
	 * 对前端输入进数据库语句的特殊字符串进行处理
	 * 
	 * @param String
	 *            要处理的字符串
	 * @return str 返回处理好的字符串
	 */
	public String HandleDate(String str) {

		// 遍历输入进来的字符串
		for (int i = 0; i < str.length(); i++) {

			// 判断字符串中有 %或者 _ 或者 /
			if (str.charAt(i) + 0 == 37 || str.charAt(i) + 0 == 95
					|| str.charAt(i) + 0 == 47) {

				StringBuilder stb = new StringBuilder(str);

				// 就在前面加/
				stb.insert(i, slantStr);

				str = stb.toString();

				i++;
			}
		}
		System.out.println("unit+处理后字符串：" + str);
		return str;

	}
}
