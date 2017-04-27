package tangzongyun.activiti.sys.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * IBatis公共DAO层接口
 * 
 * @Title：CommonDao.java
 * @Description：Initialize
 * @Package com.isoftstone.dynamicform.dao
 * @author phYang
 * @date 2012-11-27
 * @version V1.0
 */
public interface ICommonDao<T> {

	/**
	 * 查询所有
	 * 
	 * @param obj
	 * @return List<T>
	 * @throws Exception
	 */
	public List<T> listObject(Object obj) throws SQLException;

	/**
	 * 获取总记录条数
	 * 
	 * @param obj
	 * @return count
	 * @throws SQLException
	 */
	public int listObjectCount(Object obj) throws SQLException;

	/**
	 * 取得下一个序列
	 * 
	 * @param obj
	 * @return sequence
	 * @throws SQLException
	 */
	public String getNextSequence(Object obj) throws SQLException;

	/**
	 * 新增
	 * 
	 * @param obj
	 * @throws SQLException
	 */
	public void insertObject(Object obj) throws SQLException;

	/**
	 * 查找
	 * 
	 * @param obj
	 * @return T
	 * @throws SQLException
	 */
	public T findObject(Object obj) throws SQLException;

	/**
	 * 修改
	 * 
	 * @param obj
	 * @throws SQLException
	 */
	public void updateObject(Object obj) throws SQLException;

	/**
	 * 删除
	 * 
	 * @param obj
	 * @throws SQLException
	 */
	public void deleteObject(Object obj) throws SQLException;

	/**
	 * 扩展查询所有(由调用者指定节点)
	 * 
	 * @param nodePath
	 * @param obj
	 * @return List<T>
	 * @throws SQLException
	 */
	public List<T> listObjectExpand(String nodePath, Object obj) throws SQLException;
}
