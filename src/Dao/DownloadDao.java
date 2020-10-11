package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DBUtil.DBUtil;
import model.Download;

public class DownloadDao {
	public Download finddownloadByid(String id) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;
		Download download=null;
		 try {
	            connection = DBUtil.getConnection1();

	            String sql = "select * from t_downloadList where username=?";
	            statement = connection.prepareStatement(sql);
	            statement.setString(1,id);
	            resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	                download=new Download();
	                
	                download.setId(resultSet.getInt("id"));
	                download.setName(resultSet.getString("name"));
	                download.setPath(resultSet.getString("path"));
	                download.setDescription(resultSet.getString("description"));
	                download.setSize(resultSet.getInt("size"));
	                download.setStar(resultSet.getInt("star"));
	                download.setImage(resultSet.getString("image"));


	            }
	        } catch (Exception e) {
	        	System.out.println("异常");
	            e.printStackTrace();
	        } finally {
	            DBUtil.closeALL(resultSet, statement, connection);
	        }
		return download;
	}
	
	 public List<Download> findAll() {
	        ResultSet resultSet = null;
	        PreparedStatement statement = null;
	        Connection connection = null;
	        List<Download>  downloads = new ArrayList<>();
	        try {
	            connection = DBUtil.getConnection1();
	            String sql = "select * from t_downloadList";
	            statement = connection.prepareStatement(sql);

	            resultSet = statement.executeQuery();
	            
	            while (resultSet.next()) {
	                Download download = new Download();
	                download.setId(resultSet.getInt(1));
	                download.setName(resultSet.getString(2));
	                download.setPath(resultSet.getString(3));
	                download.setDescription(resultSet.getString(4));
	                download.setSize(resultSet.getInt(5));
	                download.setStar(resultSet.getInt(6));
	                download.setImage(resultSet.getString(7));
	                downloads.add(download);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            DBUtil.closeALL(resultSet, statement, connection);
	        }
	        return downloads;
	    }

}
