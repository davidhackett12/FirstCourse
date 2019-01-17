package com.firstcourse.FirstCourse.controllers;


import com.firstcourse.FirstCourse.UserService;
import com.firstcourse.FirstCourse.models.Profile;
import com.firstcourse.FirstCourse.models.User;
import com.firstcourse.FirstCourse.models.data.ProfileDao;
import com.firstcourse.FirstCourse.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProfileDao profileDao;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model){

//        model.addAttribute("user", new User());
        return "home/login";
    }

    @RequestMapping(value= "registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute(new User());
        return "home/registration";
    }



    @RequestMapping(value= "registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute @Valid User user, Errors errors, Model model){
        if(errors.hasErrors()){
            model.addAttribute("message","Failed!");
        } else{
            userService.saveUser(user);
            Profile profile = new Profile();
            profile.setUser(user);
            profile.setFirstName(user.getFirstName());
            profile.setLastName(user.getLastName());
            userDao.save(user);
            profileDao.save(profile);
            return "redirect:/profile";
        }
        return "home/registration";
    }

//    @RequestMapping(value = "login", method = RequestMethod.POST)
//    public String login(String email){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findUserByEmail(auth.getName());
//          User user = userService.findUserByEmail(email);
//        return "redirect:/profile";
//    }

    @RequestMapping(value = "/profile")
    public String profile(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        Profile profile = user.getProfile();
        model.addAttribute("profile", profile);
        return "home/profile";
    }

    @RequestMapping(value ="/profile/edit")
    public String editProfile(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        Profile profile = user.getProfile();
        model.addAttribute("profile", profile);
        return "home/editProfile";
    }


}
