package tangzongyun.activiti.base;

import java.io.Serializable;

/**
 * 
 * @Title: BasePojo.java
 * @Description: 所有领域pojo基类.
 * @Package com.isoftstone.workflowplugin.base
 * @author hncdyj123@163.com
 * @date 2012-5-24
 * @version V1.0
 * 
 */
public class BasePojo implements Serializable {
	/** serialVersionUID. */
	private static final long serialVersionUID = -6040124023440584351L;
	/** 最大行数. */
	private static final int MAX_ROWS = 9999999;
	/** 起始行数（oracle物理行号从1开始）. */
	private int start = 1;
	/** 结束行数（如果不设置结束行，缺省查所有满足条件记录）. */
	private int end = MAX_ROWS;
	/** 结束行数（如果不设置结束行，缺省查所有满足条件记录）. */
	private int limit = 10;
	/** 排序字段(例sp.spCode). */
	private String sort;
	/** 正序|反序(例ASC). */
	private String order;

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
