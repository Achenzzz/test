 package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import DBUtil.DBUtil;
import model.User;

public class UserDao {

	 public User finduserByusername(String username){
	        ResultSet resultSet = null;
	        PreparedStatement statement = null;
	        Connection connection = null;
	        User user=null;
	        try {
	            connection = DBUtil.getConnection();

	            //测试
	           // System.out.println(connection);
	            String sql = "select * from tb_user where username=?";
	            statement = connection.prepareStatement(sql);
	            statement.setString(1,username);
	            resultSet = statement.executeQuery();
	           // System.out.println(resultSet);

	            while (resultSet.next()) {
	                user=new User();
	                
	                user.setUsername(resultSet.getString("username"));
	                user.setPassword(resultSet.getString("password"));
	                //System.out.println("0000000");
	            }
	        } catch (Exception e) {
	        	System.out.println("异常");
	            e.printStackTrace();
	        } finally {
	            DBUtil.closeALL(resultSet, statement, connection);
	        }
	        return user;
	    }

	    public void insert(String username,String password) throws SQLException, ClassNotFoundException {
	        Connection connection = DBUtil.getConnection();
	        String sql = "insert into tb_user(username,password) VALUES (?,?)";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1,username);
	        statement.setString(2,password);
	        statement.executeUpdate();
	    }

	    public void delete(String username) throws SQLException, ClassNotFoundException {
	        Connection connection = DBUtil.getConnection();
	        String sql = "delete from tb_user where username=?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1,username);
	        statement.executeUpdate();
	    }

	    public void update(int id,String name,String author) throws SQLException, ClassNotFoundException {
	        Connection connection = DBUtil.getConnection();
	        String sql = "update tb_user set name=?,author=? where id=?";
	        PreparedStatement statement = connection.prepareStatement(sql);
	        statement.setString(1,name);
	        statement.setString(2,author);
	        statement.setInt(3,id);
	        statement.executeUpdate();
	    }
	    public List<User> findAll() {
	        ResultSet resultSet = null;
	        PreparedStatement statement = null;
	        Connection connection = null;
	        List<User>users = new ArrayList<>();
	        try {
	            connection = DBUtil.getConnection();
	            String sql = "select * from tb_user";
	            statement = connection.prepareStatement(sql);

	            resultSet = statement.executeQuery();
	            while (resultSet.next()) {
	                User user = new User();
	                user.setId(resultSet.getInt(1));
	                user.setUsername(resultSet.getString(2));
	                user.setPassword(resultSet.getString(3));
	                users.add(user);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.closeALL(resultSet, statement, connection);
	        }
	        return users;
	    }
}
