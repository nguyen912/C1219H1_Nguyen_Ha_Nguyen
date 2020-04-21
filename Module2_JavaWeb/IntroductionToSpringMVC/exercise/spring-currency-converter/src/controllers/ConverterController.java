package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConverterController {
    @GetMapping("/convert")
    public String scan() {
        return "index";
    }
    @PostMapping("/convert")
    public String convert(@RequestParam String rate, String usd, Model model) {
        float result = Integer.parseInt(rate) * Integer.parseInt(usd);
        model.addAttribute("result", result);
        return "converter";
    }
}
