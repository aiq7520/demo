package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ssm.dao.Dao;
import ssm.entity.Department;
import ssm.entity.Emp;

@org.springframework.stereotype.Service
public class Service {
	@Autowired
	private Dao dao;
	
	public void add(Department d){
		dao.save(d);
	}
	//////////
	public void add(Object o){
		dao.save(o);
	}
	public Emp login(String name ,String pwd){
		return dao.load(name,pwd);
	}
	public List<Emp> list(int i){
		return dao.list(i);
	}
	public void delete(Integer id){
		dao.delete(id);
	}
	public Emp getbyId(Integer id) {
		return dao.getbyId(id);
	}
	public List<Department> list() {
		return dao.getDeptList();
	}
	//////
	public <T> List<?>  listObj(Class<T> clazz){
		return dao.listObj(clazz);
	}
}
