package tangzongyun.activiti.constants;

/**
 * 
 * @Title: Constants.java
 * @Description: 系统常量类
 * @Package org.activiti.demo.constants
 * @author hncdyj123@163.com
 * @date 2013-3-7
 * @version V1.0
 * 
 */
public class Constants {
	/***************** SQL组装相关 **********************/
	public static String IBATIS_SQL_PATH = "tangzongyun.activiti";
	public static String IBATIS_OPT_POINT = ".";
	public static String IBATIS_OPT_ADD_KEY = "add";
	public static String IBATIS_OPT_UPDATE_KEY = "update";
	public static String IBATIS_OPT_DELETE_KEY = "delete";
	public static String IBATIS_OPT_LIST_KEY = "list";
	public static String IBATIS_OPT_LISTCOUNT_KEY = "listcount";
	public static String IBATIS_OPT_FIND_KEY = "find";
	public static String IBATIS_OPT_FINDID_KEY = "id";
	public static String IBATIS_OPT_ADD_VALUE = "insert{0}";
	public static String IBATIS_OPT_UPDATE_VALUE = "update{0}";
	public static String IBATIS_OPT_DELETE_VALUE = "delete{0}";
	public static String IBATIS_OPT_LIST_VALUE = "list{0}";
	public static String IBATIS_OPT_LISTCOUNT_VALUE = "list{0}Count";
	public static String IBATIS_OPT_FIND_VALUE = "find{0}ByID";
	public static String IBATIS_OPT_FINDID_VALUE = "selectsequence";
	/***************** 流程变量相关 **********************/
	// 保存成功
	public static String FLOW_DOM_SAVE = "1";
	// 提交成功
	public static String FLOW_DOM_SUMBIT = "2";
	// 审核通过
	public static String FLOW_DOM_PASS = "3";
	// 审核不通过
	public static String FLOW_DOM_NOTPASS = "4";
	// 同意
	public static String FLOW_AGREE = "2";
	// 不同意
	public static String FLOW_DISAGREE = "3";
}
