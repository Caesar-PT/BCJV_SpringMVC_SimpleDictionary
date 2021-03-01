package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;


@Controller
public class SimpleDictionaryController {
    private static Map<String,String> dictionary=new HashMap<>();
    static {
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");
    }
    @GetMapping("dictionary")
    public String showForm(){
        return "dictionary";
    }

    @PostMapping("/dictionary")
    public ModelAndView getResult(@RequestParam String txt){
        String result=dictionary.get(txt);
        ModelAndView modelAndView = new ModelAndView("dictionary");
        modelAndView.addObject("result", result);
        return modelAndView;
    }
}
