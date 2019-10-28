/**
 *SqlLinkDaoUnit.java
 * 
 * 分類　　：数据库的链接
 * 名称　　：链接数据库
 * 説明　　：链接数据库
 * 備考　　：
 * 作成　　：[日付]2019/10/10  [氏名] 胡庚
 * 履歴：
 * [NO]  [日付]		[Ver]（注１）　[更新者]	　　[内容]
 * 1	2019/10/10  				胡庚		初版
 *
 */
package unit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 链接数据库
 * 
 * @author MBP 胡庚
 * @see java.sql.Connection;
 * @see java.sql.DriverManager;
 * @version 1.0
 */
public class SqlLinkDaoUnit {

	/**
	 * 链接数据库
	 * 
	 * 链接数据库并返回链接
	 * 
	 * @return conn 返回链接
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		// 数据库驱动器
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:localhost:1521:ORCL";
		String userID = "YUTIAN2";
		String password = "123456";
		Connection conn = DriverManager.getConnection(url, userID, password);
		return conn;
	}

	/**
	 * 测试链接
	 * 
	 * 测试链接与数据库的链接是否成功
	 * 
	 */
	public void closeSqlbase(Connection sqlConnection) {
		// 关闭Connection
		if (sqlConnection != null) {
			try {
				sqlConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
