/**
 * <p>Title: UserServiceImpl.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>University: xidian.edu</p>
 * @author 胡有兵
 * @date 2017年11月10日下午3:52:52
 * @version 1.0
 */
package xidian.edu.wqmonitor.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xidian.edu.wqmonitor.dao.User;
import xidian.edu.wqmonitor.dao.UserExample;
import xidian.edu.wqmonitor.mapper.UserMapper;
import xidian.edu.wqmonitor.service.UserService;

/**
 * <p>Title: UserServiceImpl</p>
 * <p>Description: </p>
 * <p>University: xidian.edu</p> 
 * @author	胡有兵
 * @date	2017年11月10日下午3:52:52
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> getAllUser() {
		
		UserExample example = new UserExample();
		
		return userMapper.selectByExample(example);
	}
}
