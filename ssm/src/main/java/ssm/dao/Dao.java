package ssm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import ssm.entity.Department;
import ssm.entity.Emp;
import ssm.utils.HibernateCallbackImpl;

@Repository
public class Dao  {
	private final int SIZE = 20;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public void save(Department d){
		hibernateTemplate.saveOrUpdate(d);
	}
	/////////////////Ô±¹¤
	public void save(Object o){
		hibernateTemplate.saveOrUpdate(o);
	}
	
	public List<Emp> list(int i){
		int start = (i)*SIZE;
		String hql = "from Emp";
		return hibernateTemplate.execute(new HibernateCallbackImpl<List<Emp>>(hql,start));
	}
	
	public void delete(Integer id){
		hibernateTemplate.delete(hibernateTemplate.get(Emp.class, id));
	}

	public Emp getbyId(Integer id) {
		return hibernateTemplate.get(Emp.class, id);
	}
	
	
	


	@SuppressWarnings("unchecked")
	public List<Department> getDeptList() {
		return (List<Department>) hibernateTemplate.find("from Department");
	}
	@SuppressWarnings("unchecked")
	public Emp load(String name, String pwd) {
		List<Emp> list = (List<Emp>) hibernateTemplate.find("from Emp e where e.name=? and e.pwd=? ", name,pwd);
		if(list!=null&&list.size()!=1)
			return null;
		return list.get(0);
	}
	
	
	public List<? extends Object> listObj(Class<?> clazz){
		String hql ="from "+ clazz.getName();
		return hibernateTemplate.find(hql);
	}
}
