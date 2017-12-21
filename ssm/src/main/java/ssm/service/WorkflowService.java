package ssm.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

import org.activiti.engine.FormService;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ssm.dao.Dao;
import ssm.entity.Emp;
import ssm.entity.LeaveBill;
import ssm.utils.Utils;

@Service
public class WorkflowService {
	@Autowired private RepositoryService repositoryService;
	@Autowired private RuntimeService runtimeService;
	@Autowired private TaskService taskService;
	@Autowired private FormService formService;
	@Autowired private HistoryService historyService;
	@Autowired private Dao dao;
	
	
	//部署一个流程  通过Zip包
	public String createWorkFlow (MultipartFile file,String name){
		String msg="success";
		ZipInputStream zipInputStream =null;
		try{
		if(file.getOriginalFilename().endsWith(".zip")){
			zipInputStream = new ZipInputStream(file.getInputStream());
			repositoryService.createDeployment()//创建部署对象
			.name(name)//部署名称
			.addZipInputStream(zipInputStream)//
			.deploy();//完成部署
		}else
			msg = "is not zip file";
		}catch(IOException e){
			msg ="部署失败";
			e.printStackTrace();
		}finally{
			if(zipInputStream!=null)
				try {
					zipInputStream.close();
				} catch (IOException e) {
					System.out.println("流关闭失败");
				}
		}
		return msg;
	}
	
	//开启一个流程实例
	public String startWorkFlow(String key, LeaveBill leaveBill) {
		//2：更新请假单的请假状态从0变成1（初始录入-->审核中）
		leaveBill.setState(1);
		Emp user = Utils.getUser();
		leaveBill.setUser(user);
		dao.save(leaveBill);
		//流程变量
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("inputUser",user.getName());//设置办理人
//		variables.put("sss",user.getName());//设置办理人
		
		//开启一个流程实例
		runtimeService.startProcessInstanceByKey(key, variables);
		return "success";
	}
	/**2：使用当前用户名查询正在执行的任务表，获取当前任务的集合List<Task>*/
	public List<Task> queryMyTask(String username){
		return taskService.createTaskQuery().taskAssignee(username)//
				.orderByTaskCreateTime().asc()//
				.list();
	}
	
	//测试事物
	public void testTransaction() throws Exception{
		Emp e5 = new Emp("李晓燕",25,500,2,new Emp(2));
		dao.save(e5);
		throw new Exception();
	}
}
