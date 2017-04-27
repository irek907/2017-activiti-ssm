package tangzongyun.activiti.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import tangzongyun.activiti.sys.domain.result.Dataflow;
import tangzongyun.activiti.sys.domain.result.Datagrid;
import tangzongyun.activiti.sys.domain.result.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @Title: BaseAction.java
 * @Description: 门户的action基类.
 * @Package com.isoftstone.workflowplugin.base
 * @author hncdyj123@163.com
 * @date 2012-5-24
 * @version V1.0
 * 
 */
public class BaseAction extends ActionSupport {

	/** serialVersionUID */
	private static final long serialVersionUID = 674009933155016747L;

	/** 缺省页行数 */
	private static final int DEFAULT_PAGE_LIMIT = 20;

	/** action执行结果（json插件返回客户端） */
	private Datagrid datagrid = new Datagrid();

	/** action执行结果 (返回审批界面数据) **/
	private Dataflow dataflow = new Dataflow();

	/** action执行结果 (后台验证类型) **/
	private Result result = new Result();// ajax请求返回信息

	@SuppressWarnings("rawtypes")
	private List msgList = new ArrayList();

	/** 起始行号 */
	private int start = 0;

	/** 行数 */
	private int rows = DEFAULT_PAGE_LIMIT;

	/** 排序字段 */
	private String sort;

	/** 正序|反序（例ASC） */
	private String order;

	/** 页码（默认为第一页） **/
	private int page = 1;

	/** 每页显示条数 **/
	private int pagesize = 10;

	public final Map getSession() {
		ActionContext context = ActionContext.getContext();
		return context.getSession();
	}

	public final HttpServletRequest getHttpServletRequest() {
		ActionContext context = ActionContext.getContext();
		return (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);
	}

	public final HttpServletResponse getHttpServletResponse() {
		ActionContext context = ActionContext.getContext();
		return (HttpServletResponse) context.get(ServletActionContext.HTTP_RESPONSE);
	}

	/**
	 * 设置分页属性.
	 * 
	 * @param domain
	 *            (输入DO对象
	 */
	public void setPagination(BasePojo pojo) {
		// 设置分页属性: start,end,sort,order
		int start = (getPage() - 1) * getPagesize() + 1;
		pojo.setStart(start);
		int end = getPage() * getPagesize();
		pojo.setEnd(end);
		pojo.setSort(getSort());
		pojo.setOrder(getOrder());
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setTotal(int total) {
		datagrid.setTotal(total);
	}

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

	/**
	 * 设置输出接果.
	 * 
	 * @param key
	 *            (键
	 * @param value
	 *            (值
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setList(List list) {
		datagrid.setRows(list);
	}

	public void setMap(String pram, Object o) {
		dataflow.putMap(pram, o);
	}

	public void setSuccess(boolean success) {
		result.setSuccess(success);
	}

	public void setMessage(String msg) {
		result.setMsg(msg);
	}

	public Datagrid getDatagrid() {
		return datagrid;
	}

	public void setDatagrid(Datagrid datagrid) {
		this.datagrid = datagrid;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Dataflow getDataflow() {
		return dataflow;
	}

	public void setDataflow(Dataflow dataflow) {
		this.dataflow = dataflow;
	}

	@SuppressWarnings("rawtypes")
	public List getMsgList() {
		return msgList;
	}

	@SuppressWarnings("rawtypes")
	public void setMsgList(List msgList) {
		this.msgList = msgList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

}
