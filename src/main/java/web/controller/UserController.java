package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "usersPage")
public class UserController {

    @GetMapping()
    public String pageUsers () {
        return "usersPage";
    }
}
