/**
 * IndexFunctionService.java
 * 
 * 分類　　： spring服务器层操作
 * 名称　　： IndexFunctionService.java
 * 説明　　：
 * 備考　　：
 * 作成　　：[日付]2019/10/10  [氏名] 胡庚
 * 履歴：
 * [NO]  [日付]		[Ver]（注１）　[更新者]	　　[内容]
 * 1	2019/10/10				胡庚		初版
 * Copyright (C) 2019, MBP All Rights Reserved.
 */
package service;

import java.sql.Connection;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

import unit.ChangeHintUnit;
import unit.ErrorPromptUnit;
import unit.SqlLinkDaoUnit;
import model.IndexFunctionModel;
import model.IndexFunctionDataModel;
import model.IndexFunctionTopModel;
import dao.IndexFunctionDao;

/**
 * 查询服务器类
 * 
 * @Author 胡庚
 * @version 1.0
 */
public class IndexFunctionService {
	/**
	 * 检索员工，以模型的形式返回结果
	 * 
	 * 把控制器层得到的数据传入DAO层处理，将DAO层处理的数据返回到控制器层
	 * 
	 * @param IndexFunctionTopModel
	 *            实体类对象
	 * @return modelAndView2 返回模型和视图
	 */
	public ModelAndView InformationAllStaffService(
			IndexFunctionTopModel topIndex) {
		System.out
				.println("--------服务器 InformationAllStaffService  Star------");
		// 声明数据库连接类对象
		SqlLinkDaoUnit sqlLinkDaoUnit = new SqlLinkDaoUnit();
		Connection conn = null;
		// 声明ModelAndView对象
		ModelAndView modelTarget = new ModelAndView();
		// 声明中间实体类
		IndexFunctionDataModel entiretyBean = new IndexFunctionDataModel();
		// 声明Dao层的对象
		IndexFunctionDao daoTarget = new IndexFunctionDao();
		// 声明错误信息提示类
		ErrorPromptUnit errorTarget  = new ErrorPromptUnit();
		// 转义类声明
		ChangeHintUnit changeTarget = new ChangeHintUnit();
		// 从前台传来工号
		String jobNumber = topIndex.getJobNumber();
		// 从前台传来单选输入框值
		String jobName = topIndex.getJobName();

		try {
			// 调用DAO层对象中的方法 得到Connection对象
			conn = sqlLinkDaoUnit.getConnection();

			// 调用DAO层对象中的方法 得到记录数量
			int countValue = daoTarget.InformationAllStaff2(conn,
					topIndex);

			// 当填入工号 并且没有填入姓名 并且 查询不到数据时
			if (!jobNumber.isEmpty() && jobName.isEmpty() && countValue == 0) {
				// 报错 工号不存在
				return errorTarget.Hint(entiretyBean);
			}

			// 当数据库有数据时并且单选按钮后的文本框有值时
			if (countValue == 0 && !jobName.isEmpty()) {
				// 检索条件不存在
				return errorTarget.Hint2(entiretyBean);
			}

			// 调用DAO层对象中的方法 得到List对象
			List<IndexFunctionModel> fakeList = daoTarget
					.InformationAllStaff(conn, topIndex);

			// 当数据库查不到数据，并且数据库没有数据
			if (fakeList.size() == 0 && countValue != 0) {
				System.out.println("LISTSIZE++" + fakeList.size());
				// 报错 数据被删除
				return errorTarget.Hint3(entiretyBean);
			}

			// 将输出进行转义
			changeTarget.ChangeHtml(fakeList);
			modelTarget.addObject("fakeList", fakeList);
			modelTarget.setViewName("IndexFunction");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭conn
			sqlLinkDaoUnit.closeSqlbase(conn);
		}
		System.out.println("------服务器 InformationAllStaffService   end------");
		return modelTarget;
	}
}
