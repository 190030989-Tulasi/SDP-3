package com.klu.web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.klu.model.AddGrade;
import com.klu.service.StuGradeService;
@Controller
public class StuGradeController {
	@Autowired
	 private StuGradeService service;
	 @RequestMapping(path = {"/grade"})
	 public String grade(AddGrade shop, Model model) {
		 UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
String username = userDetails.getUsername();
	  if(username!=null) {
	   List<AddGrade> list = service.getByKeyword(username);
	   model.addAttribute("list", list);
	  }
	  return "stugrade";
	 }

}
