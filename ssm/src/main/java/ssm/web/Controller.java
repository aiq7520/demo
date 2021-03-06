package ssm.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.entity.Department;
import ssm.entity.Emp;
import ssm.service.Service;
import ssm.utils.Utils;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private Service service;
	@RequestMapping("/login")
    public String login(Model model) {
		model.addAttribute("msg", "��ӭ������¼ҳ��");
        return "login";
    }
	@RequestMapping("/activiti")
	public String loginSave(@ModelAttribute Emp e,Model model,HttpServletRequest request) {
		Emp user = service.login(e.getName(),e.getPwd());
		if(user==null){
			model.addAttribute("msg", "��¼ʧ��");
			return "login";
		}
		model.addAttribute("msg", "��ӭ��¼!!"+user.getName());
		Utils.setUser(user);
		return "activiti/demo";
	}
	
	@RequestMapping("/emps")
    public String helloWorld(Model model) {
        model.addAttribute("message", "Hello World!");
        List<Department> dlist = service.list();
        model.addAttribute("dlist",dlist);
        return "emps";
    }
	@ResponseBody
	@RequestMapping("/dlist")
	public List<Department> dlist() {
		List<Department> dlist = service.list();
		return dlist;
	}
	
	@ResponseBody
	@RequestMapping(value="/list")
	public List<Emp> list(Model model,Integer i){
		if(i==null)i=0;
		model.addAttribute("i",i);
		List<Emp> emps = service.list(i);
		return emps;
	}
	@ResponseBody
	@RequestMapping(value="/{id}/deleteEmp")
	public String delete(@PathVariable("id") Integer id){
		service.delete(id);
		return "ɾ���ɹ�";
	}
	
	@RequestMapping(value="save")
	public String add(@ModelAttribute Emp e,Model model){
		if(e==null||e.getName()==null||e.getName()==""){
			model.addAttribute("message", "save error:null name");
			return "emps";
		}
		if(e==null||e.getDepartment()==null){
			model.addAttribute("message", "save error:null Department");
			return "emps";
		}
		Integer id = e.getId();
		String name = e.getName();
		Integer age = e.getAge();
		Department department = e.getDepartment(); 
		double salary = e.getSalary();
		if(e.getId()!=null){
			e = service.getbyId(id);
			e.setName(name);
			e.setSalary(salary);
			e.setAge(age);
			e.setDepartment(department);
		}
		service.add(e);
		model.addAttribute("message", "save success");
		return "emps";
	}
	
}
