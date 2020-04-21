package controllers;

import models.Dictionary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.DictionaryService;

import java.util.List;

@Controller
public class DictionaryController {
    private DictionaryService dictionaryService = new DictionaryService();
    @GetMapping("/dictionary")
    public String search() {
        return "index";
    }
    @PostMapping("/dictionary")
    public String submit(@RequestParam String keyword, Model model) {
        List<Dictionary> dictionaries = dictionaryService.find();
        for (int i = 0; i < dictionaries.size(); i++) {
            if (keyword.equalsIgnoreCase(dictionaries.get(i).getEn())) {
                model.addAttribute("key", keyword);
                model.addAttribute("word", dictionaries.get(i).getVi());
                return "index";
            }
            else {
                model.addAttribute("error", "Not found");
            }
        }
        return "index";
    }

}
