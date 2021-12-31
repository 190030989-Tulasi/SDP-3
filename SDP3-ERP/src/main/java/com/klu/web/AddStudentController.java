package com.klu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.klu.model.AddStudent;
import com.klu.service.AddStudentService;

@Controller
public class AddStudentController {

    @Autowired
    private AddStudentService addstudentService;
    
 // display list of employees
    @GetMapping("/addstudent")
    public String viewHomePage(Model model) {
     return findPaginated(1, model);  
    }
    
    @GetMapping("/showNewStudentForm")
    public String showNewStudentForm(Model model) {
        // create model attribute to bind form data
        AddStudent student = new AddStudent();
        model.addAttribute("student", student);
        return "new_addstudent";
    }
    
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") AddStudent student) {
        // save employee to database
        addstudentService.saveStudent(student);
        return "redirect:/addstudent";
    }
    
    @GetMapping("/showStudentFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
     
     // get employee from the service
     AddStudent student = addstudentService.getStudentById(id);
     
     // set employee as a model attribute to pre-populate the form
     model.addAttribute("student", student);
     return "update_addstudent";
    }
    
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable (value = "id") long id) {
     
     // call delete employee method 
     this.addstudentService.deleteStudentById(id);
     return "redirect:/addstudent";
    }
    
    @GetMapping("/studentpage/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page < AddStudent > page = addstudentService.findPaginated(pageNo, pageSize);
        List < AddStudent > listStudents = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listStudents", listStudents);
        return "addstudent";
    }
}