package com.klu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.klu.model.Announcements;
import com.klu.service.StuannService;

@Controller
public class StuannController {
	 @Autowired
	    private StuannService employeeService;
	    
	    @GetMapping("/stuann")
	    public String viewHomePage(Model model) {
	     return findPaginated(1, model);  
	    }
	    
	    
	    @GetMapping("/stuannpage/{pageNo}")
	    public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
	        int pageSize = 5;

	        Page < Announcements > page = employeeService.findPaginated(pageNo, pageSize);
	        List < Announcements > listEmployees = page.getContent();

	        model.addAttribute("currentPage", pageNo);
	        model.addAttribute("totalPages", page.getTotalPages());
	        model.addAttribute("totalItems", page.getTotalElements());
	        model.addAttribute("listann", listEmployees);
	        return "stuann";
	    }
}
