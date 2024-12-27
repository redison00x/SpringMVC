package ru.borovkov.springMVCcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        // System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodBye";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "a") int a,
                            @RequestParam(value = "b") int b,
                            @RequestParam(value = "choose") String choose,
                            Model model){

        double result;

        switch(choose){
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / b;
                break;
            case "addition":
                result = a + b;
                break;
            case "subtraction":
                result = a - b;
                break;
            default: result = Double.parseDouble(null);
        }

        model.addAttribute("result", result);

        return "/first/calculate";
    }
}
