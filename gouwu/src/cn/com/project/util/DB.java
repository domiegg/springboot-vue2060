package cn.com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * 数据库操作工具类 -普通jdbc版本
 * 
 * @author 
 * @ClassName: DB
 * @Version 2.1
 * @ModifiedBy
 * @Copyright 
 * @date 2012-8-7 上午11:51:47
 * @description
 */
public class DB {

	/**
	 * 驱动类位置 软件位置 
	 * mysql: com.mysql.jdbc.Driver
	 * oracle: oracle.jdbc.driver.OracleDriver
	 * 连接池：org.logicalcobwebs.proxool.ProxoolDriver
	 */
	private static final String driver = "com.mysql.jdbc.Driver";
	/**
	 * 数据库连接
	 * mysql连接: jdbc:mysql://localhost:3308/
	 * oracle连接: jdbc:oracle:thin:@localhost:1521:
	 * 连接池：proxool.datasource1
	 */
	private final String url = "jdbc:mysql://localhost:3306/";
	/** 数据库名称 */
	private final String databaseName = "gouwu";
	/** 用户名 */
	private final String userName = "root";
	/** 用户密码 */
	private final String password = "";
	/** 数据库连接对象 */
	private Connection con;
//	/** 执行sql语句的对象 */
//	private Statement st;
	/** 结果集，存放数据的对象 */
	private ResultSet rs;
	/**预编译的执行sql语句对象*/
	private PreparedStatement ps;

	// 第一步 加载驱动，静态模块只运行一次。
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建一个新的链接
	 * 
	 * @author Cris
	 * @title: createConnection
	 * @date 2012-3-31 下午10:10:33
	 * @return Connection
	 */
	private void createConnection() {
		try {
			con = (Connection) DriverManager.getConnection(url + databaseName, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭相关内容
	 * 
	 * @author  
	 * @title: close
	 * @date 2012-8-7 下午12:04:48 void
	 */
	private void close() {
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(ps != null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 根据sql语句获得一个List<List<String>>集合
	 * 
	 * @author  
	 * @title: queryList
	 * @date 2012-8-10 上午10:44:32
	 * @param sql
	 * @param newConnection 是否新创建一个链接对象
	 * @param params 参数集合
	 * @return List<List<String>>
	 */
	private List<List<String>> queryList(String sql, boolean newConnection, Object params) {
		List<List<String>> tableList = new ArrayList<List<String>>();
		
		if(sql == null) {
			return tableList;
		}
		
		if(newConnection == true) {
			createConnection();
		}
		
		try {
			ps = con.prepareStatement(sql);
			
			if(params != null){
				setParams(params);
			}
			
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			
			while (rs.next()) {
				List<String> list = new ArrayList<String>();
				for (int i = 1; i <= colCount; i++) {
					list.add(rs.getString(i));
				}
				tableList.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return tableList;
	}
	
	/**
	 * 根据sql语句获得一个List<Map<String, String>>集合
	 * @author  
	 * @title: queryMap
	 * @date 2012-8-10 上午10:45:36
	 * @param sql
	 * @param newConnection 是否新创建一个链接和Statement对象
	 * @param params 参数集合
	 * @return List<Map<String,String>>
	 */
	private List<Map<String, String>> queryMap(String sql, boolean newConnection, Object params) {
		List<Map<String, String>> tableList = new ArrayList<Map<String, String>>();
		
		if(sql == null) {
			return tableList;
		}
		
		if(newConnection == true) {
			createConnection();
		}
		
		try {
			ps = con.prepareStatement(sql);
			if(params != null){
				setParams(params);
			}
			
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int colCount = rsmd.getColumnCount();
			
			String[] names = new String[colCount];
			for (int i = 1; i <= colCount; i++) {
				names[i - 1] = rsmd.getColumnName(i);
			}
			while (rs.next()) {
				Map<String, String> rowMap = new HashMap<String, String>();
				for (int i = 1; i <= colCount; i++) {
					rowMap.put(names[i-1], rs.getString(i));
				}
				tableList.add(rowMap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return tableList;
	}
	
	/**
	 * 根据分页对象，获取最终的sql语句
	 * 
	 * @author  
	 * @title: getSql
	 * @date 2012-8-10 上午10:26:53
	 * @param sql 普通的sql语句
	 * @param params 参数集合
	 * @param page 分页对象
	 * @return String 最终的分页sql语句
	 */
	private String getPageSql(String sql, Object params, Page page) {
		String countSql = new StringBuilder("select count(*) from (").append(sql).append(") ShxtTable"). toString();
		try {
			ps = con.prepareStatement(countSql);
			if(params != null){
				setParams(params);
			}
			rs = ps.executeQuery();
			if (!rs.next()) {
				return null;
			}
			page.rows = rs.getInt(1);
		} catch (SQLException e1) {
			e1.printStackTrace();
			return null;
		}finally {
			
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (page.rows == 0) {
			return null;
		}

		page.pages = page.rows / page.size
				+ ((page.rows % page.size > 0 ? 1 : 0));

		if (page.index > page.pages) {
			page.index = page.pages;
		} else if (page.index < 1) {
			page.index = 1;
		}

		int first = (page.index - 1) * page.size;

		
		//分页例句Oracle：select * from (select rownum as r,t.* from(select tableName.* from tableName order by tableColum DESC) t where rownum<=endPos) where r>startPos 
		//select tableName.* from tableName order by tableColum DESC limit startPos
		// 最终的查询sql语句
		StringBuilder finalSql = new StringBuilder(sql)
		 		.append(" limit ").append(first).append(",").append(page.size);
		
		
		return finalSql.toString();
	}


	/**
	 * 设置用户的参数
	 * 
	 * @author  
	 * @title: setParams
	 * @date 2014-4-3 下午03:36:46
	 * @param params
	 * @throws SQLException void
	 */
	@SuppressWarnings("unchecked")
	private void setParams(Object params) throws SQLException {
		if(params instanceof String[]){
			String[] paramsArrays = (String[])params;
			for (int i = 0; i < paramsArrays.length; i++) {
				ps.setString(i + 1, paramsArrays[i]);
			}
		}else {
			List<String> paramsList = (List<String>)params;
			for (int i = 0; i < paramsList.size(); i++) {
				ps.setString(i + 1, paramsList.get(i));
			}
		}
	}
	
	
	/****************************************用户调用*********************************************************/
	
	/**
	 * 根据sql语句查询数据库
	 * 
	 * @author Cris
	 * @title: queryList
	 * @date 2012-3-31 下午10:25:28
	 * @param sql
	 * @return List<List<String>>
	 */
	public List<List<String>> queryList(String sql) {
		return queryList(sql, true, null);
	}
	
	/**
	 * 预编译模式,根据sql语句查询数据库
	 * 条件值用?代替。
	 * 
	 * @author  
	 * @title: queryList
	 * @date 2014-4-3 下午03:22:23
	 * @param sql 带?的sql语句
	 * @param params 参数数组
	 * @return List<List<String>>
	 */
	public List<List<String>> queryList(String sql, String[] params) {
		return queryList(sql, true, params);
	}
	
	/**
	 * 预编译模式,根据sql语句查询数据库
	 * 条件值用?代替。
	 * 
	 * @author  
	 * @title: queryList
	 * @date 2014-4-3 下午03:22:51
	 * @param sql 带?的sql语句
	 * @param params 参数集合
	 * @return List<List<String>>
	 */
	public List<List<String>> queryList(String sql, List<String> params) {
		return queryList(sql, true, params);
	}
	
	
	/**
	 * 根据sql语句查询数据库
	 * 
	 * @author Cris
	 * @title: queryList
	 * @date 2012-3-31 下午10:25:28
	 * @param sql
	 * @return List<List<Object>>
	 */
	public List<Map<String, String>> queryMap(String sql) {
		return queryMap(sql, true, null);
	}
	
	/**
	 * 预编译模式,根据sql语句查询数据库
	 * 条件值用?代替。
	 * 
	 * @author  
	 * @title: queryMap
	 * @date 2014-4-3 下午03:25:39
	 * @param sql 带?的sql语句
	 * @param params 参数数组
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> queryMap(String sql, String[] params) {
		return queryMap(sql, true,  params);
	}
	
	/**
	 * 预编译模式,根据sql语句查询数据库
	 * 条件值用?代替。
	 * 
	 * @author  
	 * @title: queryMap
	 * @date 2014-4-3 下午03:26:20
	 * @param sql 带?的sql语句
	 * @param params 参数数组
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> queryMap(String sql, List<String> params) {
		return queryMap(sql, true, params);
	}
	
	/**
	 * 根据sql语句查询数据库--分页查询
	 * 
	 * @author  
	 * @title: queryList
	 * @date 2012-8-7 下午12:42:00
	 * @param sql
	 * @param page 分页对象
	 * @return List<List<String>>
	 */
	public List<List<String>> queryList(String sql, Page page) {
		createConnection();
		
		String finalSql = getPageSql(sql,null, page);

		List<List<String>> tableList = queryList(finalSql, false, null);
		
		return tableList;
	}
	
	/**
	 * 预编译模式,根据sql语句查询数据库--分页查询
	 * 条件值用?代替。
	 * 
	 * @author  
	 * @title: queryList
	 * @date 2014-4-3 下午03:27:07
	 * @param sql 带?的sql语句
	 * @param params 参数数组
	 * @param page 分页对象
	 * @return List<List<String>>
	 */
	public List<List<String>> queryList(String sql,String[] params, Page page) {
		createConnection();
		
		String finalSql = getPageSql(sql,params, page);

		List<List<String>> tableList = queryList(finalSql, false, params);
		
		return tableList;
	}
	
	/**
	 * 预编译模式,根据sql语句查询数据库--分页查询
	 * 条件值用?代替。
	 * 
	 * @author  
	 * @title: queryList
	 * @date 2014-4-3 下午03:28:09
	 * @param sql 带?的sql语句
	 * @param params 参数集合
	 * @param page 分页对象
	 * @return List<List<String>>
	 */
	public List<List<String>> queryList(String sql,List<String> params, Page page) {
		createConnection();
		
		String finalSql = getPageSql(sql,params, page);

		List<List<String>> tableList = queryList(finalSql, false, params);
		
		return tableList;
	}
	
	/**
	 * 根据sql语句查询数据库--分页查询
	 * 
	 * @author  
	 * @title: queryMap
	 * @date 2012-8-10 上午10:13:09
	 * @param sql
	 * @param page 分页对象
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> queryMap(String sql, Page page) {
		createConnection();
		
		String finalSql = getPageSql(sql,null, page);
		
		List<Map<String, String>> tableList = queryMap(finalSql, false, null);
		
		return tableList;
	}
	
	/**
	 * 预编译模式,根据sql语句查询数据库--分页查询
	 * 条件值用?代替。
	 * 
	 * @author  
	 * @title: queryMap
	 * @date 2014-4-3 下午02:12:31
	 * @param sql 带?的sql语句
	 * @param params 参数数组
	 * @param page 分页对象
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> queryMap(String sql,String[] params, Page page) {
		createConnection();
		
		String finalSql = getPageSql(sql,params, page);
		
		List<Map<String, String>> tableList = queryMap(finalSql, false, params);
		
		return tableList;
	}
	
	/**
	 * 预编译模式,根据sql语句查询数据库--分页查询
	 * 条件值用?代替。
	 * 
	 * @author  
	 * @title: queryMap
	 * @date 2014-4-3 下午03:30:08
	 * @param sql 带?的sql语句
	 * @param params 参数数组
	 * @param page 分页对象
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> queryMap(String sql,List<String> params, Page page) {
		createConnection();
		
		String finalSql = getPageSql(sql,params, page);
		
		List<Map<String, String>> tableList = queryMap(finalSql, false, params);
		
		return tableList;
	}
	
	/**
	 * DML语句，数据更新
	 * 
	 * @author  
	 * @title: update
	 * @date 2014-3-15 上午10:16:19
	 * @param sql 有更新操作的sql语句
	 */
	public void update(String sql) {
		createConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
	}
	
	/**
	 * 预编译模式,DML语句，数据更新
	 * 数值用?代替。
	 * 
	 * @author  
	 * @title: update
	 * @date 2014-4-2 下午02:02:33
	 * @param sql 有更新操作的sql语句，其中的值用?代替
	 * @param params 需要设置的参数
	 */
	public void update(String sql,String[] params){
		createConnection();
		try {
			ps = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				ps.setString(i + 1, params[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
	}
	
	/**
	 * DML语句，数据更新-批量操作
	 * 
	 * @author  
	 * @title: update
	 * @date 2014-4-2 下午02:03:37
	 * @param sql 有更新操作的sql语句，其中的值用?代替
	 * @param paramList 需要设置的参数集合
	 */
	public void update(String sql,List<String[]> paramList){
		createConnection();
		try {
			ps = con.prepareStatement(sql);
			ps.clearBatch();
			for(String[] params : paramList){
				for (int i = 0; i < params.length; i++) {
					ps.setString(i + 1, params[i]);
				}
				ps.addBatch();
			}
			ps.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
	}
}
