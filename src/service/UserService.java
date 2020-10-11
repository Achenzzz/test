package service;

import java.util.List;

import Dao.UserDao;
import model.User;

public class UserService {
	UserDao userDao=new UserDao();
    public int login(String username,String password){
        User user=userDao.finduserByusername(username);
        //System.out.println(user.getUsername());
        if(null==user) {
            return 0;//用户名不正确
        }else if(!password.equals(user.getPassword())){
            return 1;//密码不正确
        }else{
            return 2;//都正确
        }
        }
    public List<User> findAll(){return userDao.findAll();}

}
