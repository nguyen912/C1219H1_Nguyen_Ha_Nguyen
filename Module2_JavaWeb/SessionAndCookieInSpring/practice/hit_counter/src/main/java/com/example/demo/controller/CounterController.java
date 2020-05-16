package com.example.demo.controller;

import com.example.demo.model.MyCounter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
// lưu trữ model attribute trong session
@SessionAttributes("my_counter")
public class CounterController {
    /* add MyCounter in model attribute */
    // model attribute "mycounter"  sẽ được thêm vào session nếu tên attribute của @ModelAttribute và @SessionAttributes giống nhau.
    @ModelAttribute("my_counter")
    public MyCounter setUpCounter() {
        return new MyCounter();
    }

    @GetMapping("/")
    public String get (@ModelAttribute("my_counter") MyCounter myCounter) {
        myCounter.increment();
        return "index";
    }
}
