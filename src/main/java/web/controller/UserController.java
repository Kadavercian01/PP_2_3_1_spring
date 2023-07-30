package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getListUsers(Model model) {
        model.addAttribute("users", userService.getListUsers());
        return "users";
    }

    @GetMapping("/{id}/get")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "get";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
