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
import org.springframework.web.bind.annotation.RequestParam;

import com.klu.model.AddCourse;
import com.klu.service.AddCourseService;

@Controller
public class AddCourseController {
	@Autowired
    private AddCourseService addcourseService;
    
 // display list of employees
    @GetMapping("/addcourse")
    public String viewHomePage(Model model) {
    	return findPaginated(1, "stuId", "asc", model); 
    }
    
    @GetMapping("/showAddCourseForm")
    public String showNewCourseForm(Model model) {
        // create model attribute to bind form data
        AddCourse course = new AddCourse();
        model.addAttribute("course", course);
        return "new_course";
    }
    
    @PostMapping("/saveCourse")
    public String saveCourse(@ModelAttribute("course") AddCourse course) {
        // save employee to database
        addcourseService.saveCourse(course);
        return "redirect:/addcourse";
    }
    
    @GetMapping("/showFormForCourseUpdate/{id}")
    public String showFormForCourseUpdate(@PathVariable(value = "id") Long id, Model model) {

        // get employee from the service
        AddCourse course = addcourseService.getCourseById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("course", course);
        return "update_course";
    }
    
    @GetMapping("/deleteCourse/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete employee method 
        this.addcourseService.deleteCourseById(id);
        return "redirect:/addcourse";
    }
    
    @GetMapping("/coursepage/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
        @RequestParam("sortField") String sortField,
        @RequestParam("sortDir") String sortDir,
        Model model) {
        int pageSize = 5;

        Page < AddCourse > page = addcourseService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List < AddCourse > listCourses = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listCourses", listCourses);
        return "course";
    }
    
    
}
