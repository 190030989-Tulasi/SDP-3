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

import com.klu.model.AddGrade;
import com.klu.model.Employee;
import com.klu.service.AddGradeService;

@Controller
public class AddGradeController {

    @Autowired
    private AddGradeService employeeService;

 // display list of employees
    @GetMapping("/addgrade")
    public String viewHomePage(Model model) {
        return findPaginated(1, "stuId", "asc", model);
    }
    
    @GetMapping("/showNewAddGradeForm")
    public String showNewAddGradeForm(Model model) {
        // create model attribute to bind form data
    	AddGrade employee = new AddGrade();
        model.addAttribute("addgrade", employee);
        return "new_addgrade";
    }
    
    @PostMapping("/saveAddGrade")
    public String saveAddGrade(@ModelAttribute("addgrade") AddGrade employee) {
        // save employee to database
        employeeService.saveAddGrade(employee);
        return "redirect:/addgrade";
    }
    
    @GetMapping("/showFormForGradeUpdate/{id}")
    public String showFormForGradeUpdate(@PathVariable ( value = "id") long id, Model model) {
     
     // get employee from the service
    	AddGrade employee = employeeService.getAddGradeById(id);
     
     // set employee as a model attribute to pre-populate the form
     model.addAttribute("addgrade", employee);
     return "update_addgrade";
    }
    
    @GetMapping("/deleteGrade/{id}")
    public String deleteGrade(@PathVariable (value = "id") long id) {
     
     // call delete employee method 
     this.employeeService.deleteGradeById(id);
     return "redirect:/addgrade";
    }
    
    @GetMapping("/addgradepage/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
        @RequestParam("sortField") String sortField,
        @RequestParam("sortDir") String sortDir,
        Model model) {
        int pageSize = 4;

        Page <AddGrade> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List <AddGrade > listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listEmployees", listEmployees);
        return "add_grade";
    }
}