package pl.coderslab.studentsproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.studentsproject.service.ParentService;
import pl.coderslab.studentsproject.service.StudentService;

@Controller
public class ParentController {


    @Autowired
    private ParentService parentService;

    @GetMapping("/list/parents")
    public String getHomeView (Model model) {
        model.addAttribute("parents", parentService.getAllParents());
        return "parentslist";
    }

}