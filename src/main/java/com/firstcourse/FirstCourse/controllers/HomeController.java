package com.firstcourse.FirstCourse.controllers;


import com.firstcourse.FirstCourse.UserService;
import com.firstcourse.FirstCourse.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model){

//        model.addAttribute("user", new User());
        return "home/login";
    }

    @RequestMapping(value= "registration", method = RequestMethod.GET)
    public String registration(User user){
        return "home/registration";
    }


//    @RequestMapping(value= "registration", method = RequestMethod.POST)
//    public String registration(User user){
//        userService.saveUser(user);
//        return "redirect:";
//    }

//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String login(String email){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByEmail(auth.getName());
//          User user = userService.findUserByEmail(email);
//        return "redirect:/profile";
//    }

    @RequestMapping(value = "/profile")
    public String profile(){
        return "home/profile";
    }


}
