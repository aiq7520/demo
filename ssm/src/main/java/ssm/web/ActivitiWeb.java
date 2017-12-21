package ssm.web;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ssm.entity.LeaveBill;
import ssm.service.WorkflowService;
import ssm.utils.Utils;

@Controller
@RequestMapping(value="/activiti",produces="text/html;charset=UTF-8")
public class ActivitiWeb {
	@Autowired private WorkflowService workflowService;
	//流程部署
	@RequestMapping("createWorkFlow")
	@ResponseBody
	public String createWorkFlow(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file){
		String msg ="";
		if (!file.isEmpty()) {
			 msg = workflowService.createWorkFlow(file, name);
		}else
			msg ="empty file";
		return msg;
	}
	//开启流程实例
	@RequestMapping("startWorkFlow")
	@ResponseBody
	public String startWorkFlow(@RequestParam("key") String key,
           @ModelAttribute LeaveBill leaveBill){
		if(leaveBill==null||StringUtils.isEmpty(key))
			return "表单没有填写";
		String msg  = workflowService.startWorkFlow(key ,leaveBill);
		return msg;
	}
	//查看我的任务
	@RequestMapping(value="myWorkFlow")
	@ResponseBody
	public String myWorkFlow(){
		List<Task> task =  workflowService.queryMyTask(Utils.getUser().getName());
		StringBuffer sb = new StringBuffer("[");
		Format f = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		for(Task t :task){
			sb.append("{'id':'").append(t.getId()).append("',")
			.append("'name':'").append(t.getName()).append("',")
			.append("'createTime':'").append(f.format(t.getCreateTime())).append("'},");
		}
		sb.deleteCharAt(sb.length()-1).append("]");
		return sb.toString();
	}
	
}
