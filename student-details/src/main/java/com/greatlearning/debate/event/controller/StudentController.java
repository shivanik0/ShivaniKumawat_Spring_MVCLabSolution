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
	public ModelAndView ModelAndView (ModelAndView mav) {
		List<Student> students=studentService.displayStudents();
		mav.setViewName("student-info");
		mav.addObject("studentInfo",students);
		return mav;
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("Id") int studentId) {

		// delete the student record
		studentService.removeStudent(studentId);

		return "redirect:/Student/show-showdents";

	}
}
