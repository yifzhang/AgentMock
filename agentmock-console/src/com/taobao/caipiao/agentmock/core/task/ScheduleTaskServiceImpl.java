package com.taobao.caipiao.agentmock.core.task;

import com.alibaba.common.lang.StringUtil;
import com.taobao.caipiao.agentmock.core.AgentMockTask;
import com.taobao.caipiao.agentmock.logger.Logger;
import com.taobao.caipiao.agentmock.logger.LoggerFactory;
import com.taobao.caipiao.agentmock.util.PropUtil;

/**
 * @author youshan
 */
public class ScheduleTaskServiceImpl implements ScheduleTaskService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Override
	public void runScheduleTask() {
		logger.info("start running Daily Task");
		if(!StringUtil.isEmpty(PropUtil.getString("agentmock.setting.schedule.task"))){
			String name = PropUtil.getString("agentmock.setting.schedule.task");
			if(name != null){
				try{
					Object task = Class.forName(name).newInstance();
					if(task instanceof AgentMockTask){
						((AgentMockTask)task).execute(null,null);
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		logger.info("end running Daily Task");
	}

}

