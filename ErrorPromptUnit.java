/**ErrorPromptUnit.java
 * 
 * 分類　　：Spring
 * 名称　　：ErrorPromptUnit
 * 説明　　：页面警告
 * 備考　　：
 * 作成　　：[日付]2019/10/16 [氏名] 胡庚
 * 履歴：
 * [NO]  [日付]		[Ver]（注１）　[更新者]	　　[内容]
 * 1	2019/10/16				胡庚		初版
 */
package unit;

import model.IndexFunctionDataModel;

import org.springframework.web.servlet.ModelAndView;

/**
 * 页面警告
 * 
 * @author 胡庚
 * @version 1.0
 */
public class ErrorPromptUnit {
	/**
	 * 该工号不存在
	 * 
	 * @return 返回页面需要输出警告:modelvView
	 */
	public ModelAndView Hint(IndexFunctionDataModel entiretyBean) {
		ModelAndView modelTarget = new ModelAndView();
		String errorInfo = "该工号不存在！";
		modelTarget.addObject("hint", errorInfo);
		modelTarget.setViewName("IndexFunction");
		modelTarget.addObject("entiretyBean", entiretyBean);
		return modelTarget;
	}

	/**
	 * 按检索条件搜索结果不存在
	 * 
	 * @return 返回页面需要输出警告:modelvView
	 */
	public ModelAndView Hint2(IndexFunctionDataModel entiretyBean) {
		ModelAndView modelTarget = new ModelAndView();
		String errorInfo = "按检索条件搜索结果不存在！";
		modelTarget.addObject("hint", errorInfo);
		modelTarget.setViewName("IndexFunction");
		modelTarget.addObject("entiretyBean", entiretyBean);
		return modelTarget;
	}

	/**
	 * 该数据已被删除
	 * 
	 * @return 返回页面需要输出警告:modelvView
	 */
	public ModelAndView Hint3(IndexFunctionDataModel entiretyBean) {
		ModelAndView modelTarget = new ModelAndView();
		String errorInfo = "该数据已被删除！";
		modelTarget.addObject("hint", errorInfo);
		modelTarget.setViewName("IndexFunction");
		modelTarget.addObject("entiretyBean", entiretyBean);
		return modelTarget;
	}

}
