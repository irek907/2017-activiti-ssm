package tangzongyun.activiti.sys.domain.result;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Title: Datagrid.java
 * @Description: 返回json对象/用于jquery ui datagrid
 * @Package com.isoftstone.workflowplugin.utils
 * @author hncdyj123@163.com
 * @date 2012-5-24
 * @version V1.0
 *
 */
public class Datagrid  implements Serializable{
	/** 总记录 */
	private int total;
	/** 数组 */
	private List<Object> rows;

	public Datagrid() {
		total = 0;
		rows = new ArrayList<Object>();
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Object> getRows() {
		return rows;
	}

	public void setRows(List<Object> rows) {
		this.rows = rows;
	}

}
