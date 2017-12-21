package ssm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class HelloWordTest {
	@Autowired	ProcessEngine processEngine ;
	@Test//测试引擎
	public void creadProcessEndige(){
		System.out.println(processEngine);
	}
	//部署流程
	@Test
	public void deploy(){
		DeploymentBuilder deployBuilder = processEngine.getRepositoryService().createDeployment()//获取流程定义对象
		.name("流程部署2")//流程部署名称
		.addClasspathResource("diagrams/helloword.bpmn20.xml")//加载bpmn资源
		.addClasspathResource("diagrams/hellowordkey.png");//加载png资源
		Deployment  deployment = deployBuilder.deploy();//流程部署
		System.out.println(deployment.getId());//1
		System.out.println(deployment.getName());//流程名称
		System.out.println(deployment.getKey());
		System.out.println(deployment.getTenantId());
		System.out.println(deployment.getDeploymentTime());
		
	}
	//部署流程
	@Test
	public void deploy2() throws FileNotFoundException{
		ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("C:\\Users\\lenove1\\Desktop\\LeaveBill.zip"));
		DeploymentBuilder deployBuilder = processEngine.getRepositoryService().createDeployment()//获取流程定义对象
				.name("请假流程")//流程部署名称
				.addZipInputStream(zipInputStream);//
		Deployment  deployment = deployBuilder.deploy();//流程部署
		System.out.println(deployment.getId());//1
		System.out.println(deployment.getName());//流程名称
		System.out.println(deployment.getKey());
		System.out.println(deployment.getTenantId());
		System.out.println(deployment.getDeploymentTime());
		
	}
	
	//创建流程实例（开启一个流程实例）
	@Test
	public void startProcessInstance(){
		String processDefinitionKey = "hellowordid";//procdef  表中的id
		ProcessInstance processInstance=ProcessEngines.getDefaultProcessEngine()//
				.getRuntimeService()//
		.startProcessInstanceByKey(processDefinitionKey)  ;//通过流程定义表key来开启版本最高的流程
//		.startProcessInstanceById(processDefinitionId);//通过id来开启一个流程
		System.out.println("流程实例id:"+processInstance.getId());
		System.out.println("流程定义id:"+processInstance.getProcessDefinitionId());
	}
	
	//查询我的任务列表（正在执行的任务）
	@Test
	public void queryMyTest(){
		String assignee ="张三";//张三  李四  王五
		//// 查询任务的列表
		List<Task> tasks = ProcessEngines.getDefaultProcessEngine()//
				.getTaskService()//
				.createTaskQuery()//创建任务查询对象
				.taskAssignee(assignee)//指定个人任务办理人
				.list();
		// 遍历结合查看内容
		for (Task task : tasks) 
		System.out.println("taskId:" + task.getId()+",taskName:" + task.getName());
	}
	//4. 办理任务
	@Test
	public void completeTask() throws Exception {
	String taskId = "20002";
	// 获取流程引擎对象
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	// 完成任务
	processEngine.getTaskService()
		.complete(taskId);
	System.out.println("完成任务！");
	}

	
}
