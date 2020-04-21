package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SandwichController {
    @GetMapping("/choice")
    public String choose() {
        return "index";
    }
    @PostMapping("/save")
    public String select(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("condiment", condiment);
        return "submit";
    }
}
