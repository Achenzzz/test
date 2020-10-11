package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBUtil.DBUtil;
import model.Download;
import model.T_resource;
import model.T_user;

public class PermissionDao {
	public ArrayList<T_resource> findResourceByUserName(String username) {
		ArrayList<T_resource> resources=new ArrayList<T_resource>();
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		 try {
	            connection = DBUtil.getConnection2();

	            String sql = "SELECT \r\n" + 
	            		"	            		*\r\n" + 
	            		"	            		FROM\r\n" + 
	            		"	            			t_resource\r\n" + 
	            		"	            		WHERE \r\n" + 
	            		"	            		resourceId IN (\r\n" + 
	            		"	            				SELECT\r\n" + 
	            		"	            					resourceId \r\n" + 
	            		"	            			FROM  \r\n" + 
	            		"	            					t_role_resource \r\n" + 
	            		"	            			WHERE \r\n" + 
	            		"	            				roleId IN ( \r\n" + 
	            		"	            						SELECT\r\n" + 
	            		"	            						roleId\r\n" + 
	            		"	            					FROM\r\n" + 
	            		"	            						t_user_role \r\n" + 
	            		"	            					WHERE \r\n" + 
	            		"	            					userName = ?))";
	            statement = connection.prepareStatement(sql);
	            statement.setString(1,username);
	            resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	            	T_resource resource=new T_resource();
	            	resource.setResourceId(resultSet.getInt("resourceId"));
	            	resource.setResourceName(resultSet.getString("resourceName"));
	            	resource.setUrl(resultSet.getString("url"));
	            	resources.add(resource);
	       
	            }
	        } catch (Exception e) {
	        	System.out.println("异常");
	            e.printStackTrace();
	        } finally {
	            DBUtil.closeALL(resultSet, statement, connection);
	        }
		return resources;
		
	}

}
