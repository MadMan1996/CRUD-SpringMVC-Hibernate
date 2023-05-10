package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.models.User;
import web.services.UserService;

@Controller
public class UsersController {
    private UserService userService;
    @Autowired
    public void setUserDao(UserService userService) {
        this.userService = userService;

    }

    @GetMapping("/users/{id}")
    public String userProfile(@PathVariable(name = "id") Long id, Model model){
       model.addAttribute(userService.getById(id));
       return "userProfile";
    }
    @GetMapping("/users/new")
    public String newUserForm(Model model) {
        model.addAttribute("user", new User());
        return("newUserForm");
    }

    @GetMapping("/users")
    public String listOfUsers(Model model) {
        System.out.println(userService.getAllUsers().size());
        model.addAttribute("users", userService.getAllUsers());
        return "listOfUsers";
    }

    @PostMapping("/users/delete/{id}")
    public String deleteUserProfile(@PathVariable(name = "id") Long id) {
        userService.removeUserById(id);
        return "redirect:/users";
    }

     @PostMapping("/users")
    public String createNewUserProfile(@ModelAttribute("user") User user){
         System.out.println(user.getLastName());
         userService.saveNewUserProfile(user);
        return "redirect:/users";
     }

     @PostMapping("users/update/{id}")
     public String updateUserProfile(@ModelAttribute(name = "user") User user){
        userService.updateUserProfile(user);
        return"redirect:/users";
     }
    @GetMapping("/users/{id}/edit")
    public String editUserProfile(@PathVariable(name="id") Long id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "editUserForm";
    }
}
