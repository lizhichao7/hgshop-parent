package com.lizhichao.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.lizhichao.config.AdminProperties;
import com.lizhichao.service.UserService;

@Service(interfaceClass=UserService.class,version="1.0.0")
public class UserServiceImpl implements UserService{

	// 得到管理员的信息
		@Autowired
		AdminProperties adminPro;

		public boolean login(String userName, String passWord) {
			
			// TODO Auto-generated method stub
			//判断用户和密码是否与配置文件一致
			return (adminPro.getAdminName().equals(userName) 
					&& adminPro.getPassword().equals(passWord));
			
			
		}
}
