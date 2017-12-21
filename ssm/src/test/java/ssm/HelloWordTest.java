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
	@Test//��������
	public void creadProcessEndige(){
		System.out.println(processEngine);
	}
	//��������
	@Test
	public void deploy(){
		DeploymentBuilder deployBuilder = processEngine.getRepositoryService().createDeployment()//��ȡ���̶������
		.name("���̲���2")//���̲�������
		.addClasspathResource("diagrams/helloword.bpmn20.xml")//����bpmn��Դ
		.addClasspathResource("diagrams/hellowordkey.png");//����png��Դ
		Deployment  deployment = deployBuilder.deploy();//���̲���
		System.out.println(deployment.getId());//1
		System.out.println(deployment.getName());//��������
		System.out.println(deployment.getKey());
		System.out.println(deployment.getTenantId());
		System.out.println(deployment.getDeploymentTime());
		
	}
	//��������
	@Test
	public void deploy2() throws FileNotFoundException{
		ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("C:\\Users\\lenove1\\Desktop\\LeaveBill.zip"));
		DeploymentBuilder deployBuilder = processEngine.getRepositoryService().createDeployment()//��ȡ���̶������
				.name("�������")//���̲�������
				.addZipInputStream(zipInputStream);//
		Deployment  deployment = deployBuilder.deploy();//���̲���
		System.out.println(deployment.getId());//1
		System.out.println(deployment.getName());//��������
		System.out.println(deployment.getKey());
		System.out.println(deployment.getTenantId());
		System.out.println(deployment.getDeploymentTime());
		
	}
	
	//��������ʵ��������һ������ʵ����
	@Test
	public void startProcessInstance(){
		String processDefinitionKey = "hellowordid";//procdef  ���е�id
		ProcessInstance processInstance=ProcessEngines.getDefaultProcessEngine()//
				.getRuntimeService()//
		.startProcessInstanceByKey(processDefinitionKey)  ;//ͨ�����̶����key�������汾��ߵ�����
//		.startProcessInstanceById(processDefinitionId);//ͨ��id������һ������
		System.out.println("����ʵ��id:"+processInstance.getId());
		System.out.println("���̶���id:"+processInstance.getProcessDefinitionId());
	}
	
	//��ѯ�ҵ������б�����ִ�е�����
	@Test
	public void queryMyTest(){
		String assignee ="����";//����  ����  ����
		//// ��ѯ������б�
		List<Task> tasks = ProcessEngines.getDefaultProcessEngine()//
				.getTaskService()//
				.createTaskQuery()//���������ѯ����
				.taskAssignee(assignee)//ָ���������������
				.list();
		// ������ϲ鿴����
		for (Task task : tasks) 
		System.out.println("taskId:" + task.getId()+",taskName:" + task.getName());
	}
	//4. ��������
	@Test
	public void completeTask() throws Exception {
	String taskId = "20002";
	// ��ȡ�����������
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	// �������
	processEngine.getTaskService()
		.complete(taskId);
	System.out.println("�������");
	}

	
}
