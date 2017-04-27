package tangzongyun.activiti.initdb;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;

public class InitDB {

	public static void main(String[] args) {
		
		// 引擎配置  
	    ProcessEngineConfiguration pec=ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");  
	    // 获取流程引擎对象  
	    ProcessEngine processEngine2=pec.buildProcessEngine();  
		
		// TODO Auto-generated method stub
		ProcessEngineConfiguration processEngineConfiguration = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();


		processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
		processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/activiti-demo?useUnicode=true&characterEncoding=utf8");
		processEngineConfiguration.setJdbcUsername("root");
		processEngineConfiguration.setJdbcPassword("123456");
		/**
		    public static final String DB_SCHEMA_UPDATE_FALSE = "false";不能自动创建表，需要表存在
		     public static final String DB_SCHEMA_UPDATE_CREATE_DROP = "create-drop";先删除表再创建表
		     public static final String DB_SCHEMA_UPDATE_TRUE = "true";如果表不存在，自动创建表
		 */
		processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);


		ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
	}

}
