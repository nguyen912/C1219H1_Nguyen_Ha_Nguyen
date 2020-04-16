package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DictionaryController {
    @GetMapping("/search")
    public String search() {
        return "search";
    }

    @PostMapping("result")
    public String returnResult() {
        return "result";
    }
}
