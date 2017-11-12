/**
 * <p>Title: UserService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>University: xidian.edu</p>
 * @author 胡有兵
 * @date 2017年11月10日下午3:51:35
 * @version 1.0
 */
package xidian.edu.wqmonitor.service;

import java.util.List;

import xidian.edu.wqmonitor.dao.User;

/**
 * <p>Title: UserService</p>
 * <p>Description: </p>
 * <p>University: xidian.edu</p> 
 * @author	胡有兵
 * @date	2017年11月10日下午3:51:35
 * @version 1.0
 */
public interface UserService {
	
	public List<User> getAllUser();
}
