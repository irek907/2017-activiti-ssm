package tangzongyun.activiti.sys.service;

import java.util.List;

import tangzongyun.activiti.sys.domain.User;

/**
 * 
 * @Title: SysUserService.java
 * @Description: org.activiti.demo.service
 * @Package org.activiti.demo.service
 * @author hncdyj123@163.com
 * @date 2013-3-7
 * @version V1.0
 * 
 */
public interface IUserService {
	/** 增加 **/
	public void insertSysUser(User sysUser) throws Exception;

	/** 修改 **/
	public void updateSysUser(User sysUser) throws Exception;

	/** 删除 **/
	public void deleteSysUser(User sysUser) throws Exception;

	/** 查询所有 **/
	public List<User> listSysUser(User sysUser) throws Exception;

	/** 查询记录总数 **/
	public Integer listSysUserCount(User sysUser) throws Exception;

	/** 根据id获取 **/
	public User findSysUserByID(User sysUser) throws Exception;
}
