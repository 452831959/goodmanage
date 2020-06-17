package net.hunau.goodsmanager.biz;

import net.hunau.goodsmanager.bean.User;
import net.hunau.goodsmanager.dao.UserDao;
import net.hunau.goodsmanager.exception.UserAuthException;

public class UserBiz {	
	private UserDao ud = new UserDao() ;
	//用户登陆
	public 	User userLogin(User u) throws UserAuthException{
		User tempUser =  ud.getUser(u.getUsername(), u.getPassword());
		if(tempUser != null){
			return u;
		}else {
			throw new UserAuthException("用户名或密码错误");
		}
	}
	/**
	 * 启用、注销
	 * @param userName
	 * @param flag
	 */
	public void iscancelUser(String userName,int flag){
		User user = ud.getUser(userName);
		if(user!=null){
			user.setValidateFlag(flag);
			ud.updateUservalidateFlag(user);
			
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserBiz ub  = new UserBiz();
		User user = new User();
		user.setUsername("peter");
		user.setPassword("123456");
		try {
			user = ub.userLogin(user);
			System.out.println(user);
		} catch (UserAuthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
