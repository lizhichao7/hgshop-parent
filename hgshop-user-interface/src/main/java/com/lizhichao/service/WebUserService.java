package com.lizhichao.service;

import com.lizhichao.bean.User;

/**
 * 
 * @author 李志超
 *
 */
public interface WebUserService {
	
	//用户登录
	User login(String username,String pwd);
	
	//注册
	User register(User user);
	
}
