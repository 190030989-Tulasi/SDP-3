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

import com.klu.model.Announcements;
import com.klu.service.AnnouncementsService;

@Controller
public class AnnouncementsController {

    @Autowired
    private AnnouncementsService employeeService;
    
    @GetMapping("/ann")
    public String viewHomePage(Model model) {
     return findPaginated(1, model);  
    }
    
    @GetMapping("/showNewAnnForm")
    public String showNewAnnForm(Model model) {
        // create model attribute to bind form data
        Announcements employee = new Announcements();
        model.addAttribute("annou", employee);
        return "new_ann";
    }
    
    @PostMapping("/saveAnnouncements")
    public String saveAnnouncements(@ModelAttribute("annou") Announcements employee) {
        // save employee to database
        employeeService.saveAnnouncements(employee);
        return "redirect:/ann";
    }
    
    @GetMapping("/showAnnFormForUpdate/{id}")
    public String showAnnFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
     
     // get employee from the service
    	Announcements annou = employeeService.getAnnouncementsById(id);
     
     // set employee as a model attribute to pre-populate the form
     model.addAttribute("annou", annou);
     return "update_ann";
    }
    
    @GetMapping("/deleteAnnouncements/{id}")
    public String deleteAnnouncements(@PathVariable (value = "id") long id) {
     
     // call delete employee method 
     this.employeeService.deleteAnnouncementsById(id);
     return "redirect:/ann";
    }
    
    @GetMapping("/annpage/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;

        Page < Announcements > page = employeeService.findPaginated(pageNo, pageSize);
        List < Announcements > listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listann", listEmployees);
        return "ann";
    }
}