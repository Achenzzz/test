package DBUtil;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBUtil {  
	private static String driver;
	private static String url;
	private static String username;
	private static String password;

	/*
	 * static{ try { //实例化配置属性的对象 Properties properties = new Properties();
	 * //将配置文件加载进去 properties.load(new
	 * FileInputStream("test/WEB-INF/jdbc.properties")); //通过Key来获取Value driver =
	 * properties.getProperty("driverName"); url = properties.getProperty("url");
	 * username = properties.getProperty("username"); password =
	 * properties.getProperty("password"); Class.forName(driver); } catch
	 * (ClassNotFoundException | IOException e) { e.printStackTrace(); } }
	 */

	public static Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/zjgm?characterEncoding=utf-8&user=root&password=jiankang10086/");
        return connection;
    }
	
	public static Connection getConnection1() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/excise?characterEncoding=utf-8&user=root&password=jiankang10086/");
        return connection;
    }
	/*
	 * public static Connection getConnection2(){ Connection conn = null; try { conn
	 * = DriverManager.getConnection(url,username,password); } catch (SQLException
	 * e) { e.printStackTrace(); } return conn; }
	 */
	public static Connection getConnection2() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/rbac?characterEncoding=utf-8&user=root&password=jiankang10086/");
        return connection;
    }




    public static void closeALL(ResultSet resultSet, Statement statement,Connection connection){
        if (resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
