/**
 * IndexFunctionDao.java
 * 
 * 分類　　： springDAO层操作
 * 名称　　： IndexFunctionDao.java
 * 説明　　：
 * 備考　　：
 * 作成　　：[日付]2019/10/10  [氏名] 胡庚
 * 履歴：
 * [NO]  [日付]		[Ver]（注１）　[更新者]	　　[内容]
 * 1	2019/10/10				胡庚		初版
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import unit.ChangeHintUnit;
import unit.HandleStrUnit;
import model.IndexFunctionModel;
import model.IndexFunctionTopModel;

/**
 * 查询DAO类
 * 
 * @Author 胡庚
 * @version 1.0
 */
public class IndexFunctionDao {
	/** 声明输入字符串处理对象 */
	HandleStrUnit handleStrUnit = new HandleStrUnit();
	/** 声明html转义处理对象 */
	ChangeHintUnit changeHintUnit = new ChangeHintUnit();

	/**
	 * 检索员工号和名称，集合类型返回
	 * 
	 * 把服务器层传来的数据进行处理，将处理的数据返回给服务器层
	 * 
	 * @param Connection
	 *            数据库连接对象
	 * @param IndexFunctionTopModel
	 *            实体类对象
	 * @return List<BasicEmployeeInformation> 查询对应数据的集合
	 */
	public List<IndexFunctionModel> InformationAllStaff(Connection conn,
			IndexFunctionTopModel topIndex) throws Exception {
		System.out.println("--------DAO List InformationAllStaff   Star------");
		List<String> sqlParamList = new ArrayList<String>();
		// 数据库语句
		String strSQL = " SELECT ";
		// 员工表的员工号
		strSQL += " MDM.MEMBERNO, ";
		// 员工表的员工姓
		strSQL += " MDM.MEMBERFIRSTNAME, ";
		// 员工表的员工名
		strSQL += " MDM.MEMBERLASTNAME, ";
		// 员工表的员工职务
		strSQL += " MDM.JOB_LEVEL, ";
		// 员工表的员工年收
		strSQL += " MDM.ANNUAL_INCOME, ";
		// 员工表的员工部门编号
		strSQL += " MDM.DEPTCODE, ";
		// 部门表的部门名称
		strSQL += " MD.DEPTNAME ";
		// 员工表
		strSQL += " FROM M_DEPT_MEMBER MDM  ";
		// 部门表
		strSQL += " LEFT JOIN  M_DEPT MD ";
		// 部门表的部门码 = 员工表的部门码
		strSQL += " ON MDM.DEPTCODE = MD.DEPTCODE ";
		// 部门表的消除Flag
		strSQL += " AND MD.DELETEFLG = 0 ";
		// 员工表的消除Flag
		strSQL += " WHERE MDM.DELETEFLG = 0 ";

		// 从前台传来工号
		String jobNumber = topIndex.getJobNumber();
		// 从前台传来单选输入框值
		String jobName = topIndex.getJobName();
		// 从前台传来按钮选择
		String singleButton = topIndex.getSingleButton();

		if (jobNumber != null && !"".equals(jobNumber)) {
			// 不为空就加入sql语句，查询工号
			strSQL += " AND MDM.MEMBERNO = ? ";
			// 将工号存入集合中
			sqlParamList.add(jobNumber);
		}

		// 判断输入名称是否为空 并且按钮选择是否为员工
		if (singleButton.equals("1") && jobName != null && !"".equals(jobName)) {
			// 员工表的员工名和姓模糊查询
			strSQL += " AND CONCAT (MDM.MEMBERFIRSTNAME , MDM.MEMBERLASTNAME) LIKE ? ESCAPE ?  ";
			sqlParamList.add("%" + handleStrUnit.HandleDate(jobName) + "%");
			sqlParamList.add(HandleStrUnit.slantStr);
		}

		// 判断输入名称是否为空 并且按钮选择是否为部门
		if (singleButton.equals("0") && jobName != null && !"".equals(jobName)) {
			// 部门表部门名称模糊查询
			strSQL += " AND MD.DEPTNAME LIKE  ? ESCAPE ? ";
			// 将名称存入集合中
			sqlParamList.add("%" + handleStrUnit.HandleDate(jobName) + "%");
			sqlParamList.add(HandleStrUnit.slantStr);
		}

		System.out.println("打印strSQL语句：" + strSQL);
		PreparedStatement stms = conn.prepareStatement(strSQL);
		for (int i = 0; i < sqlParamList.size(); i++) {
			stms.setString(i + 1, sqlParamList.get(i));
		}
		ResultSet rs = stms.executeQuery();
		// 创建集合
		List<IndexFunctionModel> list = new ArrayList<IndexFunctionModel>();
		while (rs.next()) {
			// 声明一览表实体类对象
			IndexFunctionModel basicEmployeeInformation2 = new IndexFunctionModel();
			// 将查询得到的工号放入实体类中
			basicEmployeeInformation2.setEmpNumber(rs.getString("MEMBERNO"));
			// 将查询得到的部门ID放入实体类中
			basicEmployeeInformation2.setDeptCode(rs.getString("DEPTCODE"));
			// 将查询得到的员工名放入实体类中
			basicEmployeeInformation2.setEmpName(rs
					.getString("MEMBERFIRSTNAME")
					+ rs.getString("MEMBERLASTNAME"));
			// 将查询得到的职务放入实体类中
			basicEmployeeInformation2.setEmpJob(rs.getString("JOB_LEVEL"));
			// 将查询得到的年收放入实体类中 年收 ANNUAL_INCOME 并将其显示为小数后两位显示
			DecimalFormat dFormat = new DecimalFormat("0.00");
			basicEmployeeInformation2.setEmpSalary(dFormat.format(Double
					.parseDouble(rs.getString("ANNUAL_INCOME"))));
			// 将查询得到的部门名称放入实体类中
			basicEmployeeInformation2.setDeptName(rs.getString("DEPTNAME"));
			// 将实体类放入集合中
			list.add(basicEmployeeInformation2);
		}
		System.out.println("--------DAO List InformationAllStaff   end------");
		// 调用html转义方法返回集合
		return changeHintUnit.ChangeHtml(list);

	}

	/**
	 * 检索员工号和名称，int类型返回
	 * 
	 * 把服务器层传来的数据进行处理，将处理的数据返回给服务器层
	 * 
	 * @param Connection
	 *            数据库连接对象
	 * @param IndexFunctionTopModel
	 *            实体类对象
	 * @return int 查询对应数据有几条
	 */
	public int InformationAllStaff2(Connection conn,
			IndexFunctionTopModel topIndex) throws Exception {
		System.out.println("--------DAO int InformationAllStaff2   Star------");
		// 定义sql集合 存储字符串
		List<String> sqlParamList = new ArrayList<String>();
		// 数据库语句
		String strSQL = " SELECT  ";
		// 统计员工表中员工号的数量
		strSQL += " COUNT(MDM.MEMBERNO) AS ALLNUMBER  ";
		strSQL += " FROM ";
		// 员工表
		strSQL += "  M_DEPT_MEMBER MDM ";
		// 左连接部门表
		strSQL += " LEFT JOIN M_DEPT MD  ";
		// 连接 员工表员工ID=部门表员工ID
		strSQL += " ON MDM.DEPTCODE = MD.DEPTCODE ";
		// 员工表员工ID=部门表员工ID
		strSQL += " WHERE MD.DEPTCODE = MDM.DEPTCODE ";

		// 从前台传来工号
		String jobNumber = topIndex.getJobNumber();
		// 从前台传来单选输入框
		String jobName = topIndex.getJobName();
		// 从前台传来按钮选择
		String singleButton = topIndex.getSingleButton();

		// 判断工号是否为空
		if (jobNumber != null && !"".equals(jobNumber)) {
			// 不为空就加入sql语句，查询工号
			strSQL += " AND MDM.MEMBERNO = ? ";
			// 将工号存入集合中
			sqlParamList.add(jobNumber);
		}

		// 判断输入名称是否为空 并且按钮选择是否为员工
		if (singleButton.equals("1") && jobName != null && !"".equals(jobName)) {
			// 模糊查询员工表员工的姓和名
			strSQL += " AND  CONCAT (MDM.MEMBERFIRSTNAME , MDM.MEMBERLASTNAME)  LIKE ? ESCAPE ?  ";
			sqlParamList.add("%" + handleStrUnit.HandleDate(jobName) + "%");
			sqlParamList.add(HandleStrUnit.slantStr);
		}

		// 判断输入名称是否为空 并且按钮选择是否为员工
		if (singleButton.equals("0") && jobName != null && !"".equals(jobName)) {
			// 模糊查询部门表的部门名称
			strSQL += "  AND MD.DEPTNAME LIKE ? ESCAPE ? ";
			sqlParamList.add("%" + handleStrUnit.HandleDate(jobName) + "%");
			sqlParamList.add(HandleStrUnit.slantStr);
		}

		System.out.println("查看int+SQL语句：" + strSQL);
		PreparedStatement stms = conn.prepareStatement(strSQL);
		// 给sqlParamList赋值
		for (int i = 0; i < sqlParamList.size(); i++) {
			stms.setString(i + 1, sqlParamList.get(i));
		}
		ResultSet rs = stms.executeQuery();
		// 对返回值进行统计
		int countValue = 0;
		while (rs.next()) {
			// 得到统计数量
			countValue += rs.getInt("ALLNUMBER");
		}
		System.out.println("DAO+int列表返回值：" + countValue);
		System.out.println("--------DAO int InformationAllStaff2   end------");
		return countValue;
	}
}
