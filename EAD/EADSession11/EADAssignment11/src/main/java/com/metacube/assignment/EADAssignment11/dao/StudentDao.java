package com.metacube.assignment.EADAssignment11.dao;


import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.metacube.assignment.EADAssignment11.model.Student;

@Transactional
@Component
public class StudentDao {

	@Autowired
	HibernateTemplate template;

	public StudentDao() {

	}

	@Autowired
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public boolean studentExist(String email) {
		Student student = new Student();
		student.setEmail(email);
		List<Student> list = template.findByExample(student);
		System.out.println(list.size());
		return (list.size() > 0 ? true : false);
	}

	public void add(Student student) {
	    template.save(student);

	}

	public List<Student> showAll() {
		return template.loadAll(Student.class);
	}

}
