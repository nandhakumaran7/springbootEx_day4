package com.classwork4.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classwork4.demo.model.Student;
import com.classwork4.demo.repository.StudentRepo;


@Service
public class ApiService {
@Autowired
StudentRepo er;
	public List<Student> saveninfo(List<Student> ee) {
		return (List<Student>)er.saveAll(ee);//POST	
	}
	public List<Student> showinfo() {
		// TODO Auto-generated method stub
		return er.findAll();//GET
	}
	public Student getStudentById(int id) {
		Optional<Student> studentOptional = er.findById(id);
        return studentOptional.orElse(null);
	}
	public String updateinfobyid(int id,Student ee) {
		if(er.existsById(id)) {
			er.saveAndFlush(ee);
			return "Updated";
		}
		else {
			return "Enter valid id";
		}
	}
	public void deleteid(int  id) {
		er.deleteById(id);
	}
}
