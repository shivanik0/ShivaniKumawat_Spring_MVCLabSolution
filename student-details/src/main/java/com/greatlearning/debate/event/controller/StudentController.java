package com.greatlearning.debate.event.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.debate.event.entity.Student;
import com.greatlearning.debate.event.service.IStudentService;

@Controller
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	private IStudentService studentService;

	@RequestMapping(method = RequestMethod.POST, path="/new-student")
	public String add(@RequestParam("name") String name, @RequestParam("department") String department, @RequestParam("country") String country) {
		Student student = new Student (name,department,country);
		studentService.addStudent(student);
		
		return "redirect:show-students";
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/show-students")
	public ModelAndView display (ModelAndView mav) {
		List<Student> students=studentService.displayStudents();
		mav.setViewName("student-info");
		mav.addObject("studentInfo",students);
		return mav;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/show-form")
	public String showFormToUser() {
		return "welcome";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/delete-student")
	public String deleteStudentDetails(@RequestParam("id") Integer id) {
		System.out.println("method called with id is: "+id);
		if (studentService.removeStudent(id)) {
			System.out.println("Student deleted");
		} else {
			System.out.println("Student not deleted");
		}

		return "redirect:show-students";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/update-student")
	public String updateStudentDetails(@RequestParam("id") Integer id) {
		System.out.println("method called with id is: "+id);
		if (studentService.modifyStudent(id)) {
			System.out.println("Student detail updated");
		} else {
			System.out.println("Student detail not updated");
		}

		return "redirect:show-students";
	}
}
