package ssm.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.entity.Department;
import ssm.entity.Emp;
import ssm.service.Service;
import ssm.service.WorkflowService;

@ContextConfiguration("/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class DaoTest {
	@Autowired
	private Dao empDao;
	@Autowired
	private Service empService;
	@Autowired
	private WorkflowService workflowService;
	//@Autowired
	//private HibernateTemplate hibernateTemplate;
	
	
	@Test//创建员工
	public void testAspect(){
		empService.list();
	}
	@Test//创建员工
	public void testSave(){
		Emp e1 = new Emp("张三丰",65,10000.12,1,null);
		Emp e2 = new Emp("东方不败",35,2000.12,2,e1);
		Emp e3 = new Emp("杨过",32,1000,2,e2);
		Emp e4 = new Emp("郭静",25,1800,2,e2);
		Emp e5 = new Emp("黄蓉",25,8000,2,e2);
		empService.add(e1);
		//empService.add(e2);
		empService.add(e3);
		empService.add(e4);
		empService.add(e5);
	}
	@Test//事物边界
	public void testTransaction(){
		Emp e5 = new Emp("李晓燕",25,500,2,new Emp(2));
		empDao.save(e5);
	}
	@Test//事物边界
	public void testTransaction2(){
		Emp e5 = new Emp("徐祖子",25,500,2,new Emp(2));
		empService.add(e5);
	}
	@Test//事物边界
	public void testTransaction3() throws Exception{
		workflowService.testTransaction();
	}
	@Test//创建部门
	public void testSaveD(){
			Department d1= new Department("人事部");
			Department d2= new Department("开发部");
			Department d3= new Department("财务部");
			empService.add(d1);
			empService.add(d2);
			empService.add(d3);
	}
}
