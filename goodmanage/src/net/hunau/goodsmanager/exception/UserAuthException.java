package net.hunau.goodsmanager.exception;

public class UserAuthException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAuthException() {
		System.out.println("用户名或者密码错误！");
	}

	public UserAuthException(String message) {
		super(message);
		
	}
	
	
	

}
