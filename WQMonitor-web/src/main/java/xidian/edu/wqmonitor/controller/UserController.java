/**
 * <p>Title: UserController.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>University: xidian.edu</p>
 * @author 胡有兵
 * @date 2017年11月10日下午4:08:44
 * @version 1.0
 */
package xidian.edu.wqmonitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xidian.edu.wqmonitor.dao.User;
import xidian.edu.wqmonitor.service.UserService;

/**
 * <p>Title: UserController</p>
 * <p>Description: </p>
 * <p>University: xidian.edu</p> 
 * @author	胡有兵
 * @date	2017年11月10日下午4:08:44
 * @version 1.0
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/user")
	@ResponseBody
	public List<User> getAllUser(){
		List<User> list = userService.getAllUser();
		
		System.out.println(list);
		return list;
	}
}
