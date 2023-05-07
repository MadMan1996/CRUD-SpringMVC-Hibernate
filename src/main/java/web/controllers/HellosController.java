package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.models.User;
import web.services.UserServiceImpl;

@Controller
public class HellosController {


    @GetMapping("/hello")
    public String hello(Model model){
        return "hello";
    }
}
