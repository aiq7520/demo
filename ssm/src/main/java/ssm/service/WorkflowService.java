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
	
	
	//����һ������  ͨ��Zip��
	public String createWorkFlow (MultipartFile file,String name){
		String msg="success";
		ZipInputStream zipInputStream =null;
		try{
		if(file.getOriginalFilename().endsWith(".zip")){
			zipInputStream = new ZipInputStream(file.getInputStream());
			repositoryService.createDeployment()//�����������
			.name(name)//��������
			.addZipInputStream(zipInputStream)//
			.deploy();//��ɲ���
		}else
			msg = "is not zip file";
		}catch(IOException e){
			msg ="����ʧ��";
			e.printStackTrace();
		}finally{
			if(zipInputStream!=null)
				try {
					zipInputStream.close();
				} catch (IOException e) {
					System.out.println("���ر�ʧ��");
				}
		}
		return msg;
	}
	
	//����һ������ʵ��
	public String startWorkFlow(String key, LeaveBill leaveBill) {
		//2��������ٵ������״̬��0���1����ʼ¼��-->����У�
		leaveBill.setState(1);
		Emp user = Utils.getUser();
		leaveBill.setUser(user);
		dao.save(leaveBill);
		//���̱���
		Map<String,Object> variables = new HashMap<String,Object>();
		variables.put("inputUser",user.getName());//���ð�����
//		variables.put("sss",user.getName());//���ð�����
		
		//����һ������ʵ��
		runtimeService.startProcessInstanceByKey(key, variables);
		return "success";
	}
	/**2��ʹ�õ�ǰ�û�����ѯ����ִ�е��������ȡ��ǰ����ļ���List<Task>*/
	public List<Task> queryMyTask(String username){
		return taskService.createTaskQuery().taskAssignee(username)//
				.orderByTaskCreateTime().asc()//
				.list();
	}
	
	//��������
	public void testTransaction() throws Exception{
		Emp e5 = new Emp("������",25,500,2,new Emp(2));
		dao.save(e5);
		throw new Exception();
	}
}
