package com.classwork4.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.classwork4.demo.service.ApiService;
import com.classwork4.demo.model.Student;

@RestController
public class ApiController {
@Autowired
ApiService eser;
	@PostMapping("addn")//adding n details
	public List<Student> addnstudents(@RequestBody List<Student> ee) {
		return eser.saveninfo(ee);
	}
	@GetMapping("disp")
	public List<Student> show(){
		return eser.showinfo();
	}
	@GetMapping("/student/{id}")
	public ResponseEntity<Student>showDetail(@PathVariable int id) {
	    Student student = eser.getStudentById(id);
	    
	    if (student != null) {
	        return new ResponseEntity<>(student, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	@PutMapping("updatebyid/{id}")
	public String modifybyid(@PathVariable int id,@RequestBody Student ee) {
		return eser.updateinfobyid(id,ee);
	}
	@DeleteMapping("delpar")//RequestParam
	public String deleteparid(@RequestParam int id) {
		eser.deleteid(id);
		return "id deleted";
	}
}
