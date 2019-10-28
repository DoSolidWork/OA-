/**
 * IndexFunctionController.java
 * 
 * 分類　　： spring控制器层操作
 * 名称　　： IndexFunctionController.java
 * 説明　　：
 * 備考　　：
 * 作成　　：[日付]2019/10/10  [氏名] 胡庚
 * 履歴：
 * [NO]  [日付]		[Ver]（注１）　[更新者]	　　[内容]
 * 1	2019/10/10				胡庚		初版
 * Copyright (C) 2019, MBP All Rights Reserved.
 */
package controller;

import javax.servlet.http.HttpServletRequest;
import model.IndexFunctionTopModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import service.IndexFunctionService;

/**
 * 查询控制器类
 * 
 * @Author 胡庚
 * @version 1.0
 */
@Controller
public class IndexFunctionController {

	/**
	 * IndexFunction.jsp页面的路径映射
	 * 
	 * 为IndexFunction.jsp页面映射一个路径，以便在ModelAndView中运用
	 * 
	 * @return 返回到页面IndexFunction.jsp
	 */
	// 定义映射路径到IndexFunction以便后面使用
	@RequestMapping(value = "/IndexFunction")
	public String toText() {
		return "IndexFunction";
	}

	/**
	 * 检索员工，以模型的形式返回结果
	 * 
	 * 把前端提供的数据放入服务器层处理，将服务器层处理的数据返回到页面显示
	 * 
	 * @param IndexFunctionTopModel
	 *            实体类对象
	 * @param IndexFunctionService
	 *            服务器层对象
	 * @param HttpServletRequest
	 *            公共接口对象
	 * @return modelAndView2 返回模型和视图
	 */
	// 定义映射路径以便后面使用
	@RequestMapping(value = "/membercodeSel")
	public ModelAndView membercodeSelect(HttpServletRequest request,
			ModelAndView modelAndView) throws Exception {
		System.out
				.println("------控制器 ModelAndView membercodeSelect Star------");
		// 得到Service对象
		IndexFunctionService serviceTarget = new IndexFunctionService();
		// 得到topIndex对象
		IndexFunctionTopModel topIndexTarget = new IndexFunctionTopModel();
		// 从前台得到工号
		String jobNumber = request.getParameter("jobNumber");
		// 从前台得到用户名称 改变编码格式
		String jobName = new String(request.getParameter("jobName").getBytes(
				"ISO-8859-1"), "UTF-8");
		// 从前台得到按钮选择
		String selectButton = request.getParameter("singleButton").toString();
		// 把前台工号、姓名、 按钮选择 放入实体类
		topIndexTarget.setSingleButton(selectButton);
		topIndexTarget.setJobName(jobName);
		topIndexTarget.setJobNumber(jobNumber);

		System.out.println("控制器+select的按钮：" + selectButton);
		System.out.println("控制器+jobName后填入的'值'：" + jobName);
		System.out.println("控制器+前台得到的工号：" + jobNumber);
		System.out.println("------控制器 ModelAndView membercodeSelect end------");

		// 调用服务器方法
		modelAndView = serviceTarget
				.InformationAllStaffService(topIndexTarget);
		// 保持内容输入
		modelAndView.addObject("jobNumber", HtmlUtils.htmlEscape(jobNumber));
		modelAndView.addObject("jobName", HtmlUtils.htmlEscape(jobName));
		// 按钮保持
		modelAndView.addObject("toHidden", selectButton);

		return modelAndView;
	}
}
