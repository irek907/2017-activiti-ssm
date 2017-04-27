package tangzongyun.activiti.sys.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import tangzongyun.activiti.sys.dao.ICommonDao;
import tangzongyun.activiti.sys.domain.User;
import tangzongyun.activiti.sys.service.IUserService;

/**
 * 
 * @Title: SysUserServiceImpl.java
 * @Description: org.activiti.demo.service
 * @Package org.activiti.demo.service
 * @author hncdyj123@163.com
 * @date 2013-3-7
 * @version V1.0
 * 
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Service("userService")
public class UserServiceImpl implements IUserService {
	@Resource(name = "commonDao")
	private ICommonDao commonDao;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void insertSysUser(User sysUser) throws Exception {
		commonDao.insertObject(sysUser);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void updateSysUser(User sysUser) throws Exception {
		commonDao.updateObject(sysUser);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public void deleteSysUser(User sysUser) throws Exception {
		commonDao.deleteObject(sysUser);
	}

	@Override
	public List<User> listSysUser(User sysUser) throws Exception {
		return commonDao.listObject(sysUser);
	}

	@Override
	public Integer listSysUserCount(User sysUser) throws Exception {
		return commonDao.listObjectCount(sysUser);
	}

	@Override
	public User findSysUserByID(User sysUser) throws Exception {
		return (User) commonDao.findObject(sysUser);
	}

	public void setCommonDao(ICommonDao commonDao) {
		this.commonDao = commonDao;
	}
}
