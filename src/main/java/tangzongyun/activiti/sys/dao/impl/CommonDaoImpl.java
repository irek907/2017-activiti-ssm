package tangzongyun.activiti.sys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import tangzongyun.activiti.constants.Constants;
import tangzongyun.activiti.sys.dao.ICommonDao;
import tangzongyun.activiti.utils.ToolUtil;

/**
 * IBatis公共DAO层接口
 * 
 * @Title：CommonDaoImpl.java
 * @Description：Initialize
 * @Package com.isoftstone.dynamicform.dao
 * @author phYang
 * @date 2012-11-27
 * @version V1.0
 */
@SuppressWarnings("rawtypes")
@Repository("commonDao")
public class CommonDaoImpl<T> extends SqlSessionDaoSupport implements ICommonDao {

	/**
	 * 查询所有
	 * 
	 * @param obj
	 * @return List<T>
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<T> listObject(Object obj) throws SQLException {
		//org.activiti.demo.UserTask.listUserTask
		return this.getSqlSession().selectList(ToolUtil.getCommonDaoNodePath(Constants.IBATIS_OPT_LIST_KEY, obj), obj);
	}

	/**
	 * 获取总记录条数
	 * 
	 * @param obj
	 * @return count
	 * @throws SQLException
	 */
	public int listObjectCount(Object obj) throws SQLException {
		return Integer.parseInt(this.getSqlSession().selectOne(ToolUtil.getCommonDaoNodePath(Constants.IBATIS_OPT_LISTCOUNT_KEY, obj), obj).toString());
	}

	/**
	 * 取得下一个序列
	 * 
	 * @param obj
	 * @return sequence
	 * @throws SQLException
	 */
	public String getNextSequence(Object obj) throws SQLException {
		return String.valueOf(this.getSqlSession().selectOne(ToolUtil.getCommonDaoNodePath(Constants.IBATIS_OPT_FINDID_KEY, obj)));
	}

	/**
	 * 新增
	 * 
	 * @param obj
	 * @throws SQLException
	 */
	public void insertObject(Object obj) throws SQLException {
		this.getSqlSession().insert(ToolUtil.getCommonDaoNodePath(Constants.IBATIS_OPT_ADD_KEY, obj), obj);
	}

	/**
	 * 查找
	 * 
	 * @param obj
	 * @return T
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public T findObject(Object obj) throws SQLException {
		return (T) this.getSqlSession().selectOne(ToolUtil.getCommonDaoNodePath(Constants.IBATIS_OPT_FIND_KEY, obj), obj);
	}

	/**
	 * 修改
	 * 
	 * @param obj
	 * @throws SQLException
	 */
	public void updateObject(Object obj) throws SQLException {
		this.getSqlSession().update(ToolUtil.getCommonDaoNodePath(Constants.IBATIS_OPT_UPDATE_KEY, obj), obj);
	}

	/**
	 * 删除
	 * 
	 * @param obj
	 * @throws SQLException
	 */
	public void deleteObject(Object obj) throws SQLException {
		this.getSqlSession().delete(ToolUtil.getCommonDaoNodePath(Constants.IBATIS_OPT_DELETE_KEY, obj), obj);
	}

	/**
	 * 扩展查询所有(由调用者指定节点)
	 * 
	 * @param nodePath
	 * @param obj
	 * @return List<T>
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public List<T> listObjectExpand(String nodePath, Object obj) throws SQLException {
		return this.getSqlSession().selectList(nodePath, obj);
	}
}
