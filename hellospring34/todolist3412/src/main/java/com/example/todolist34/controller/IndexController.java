package com.example.todolist34.controller;

import com.example.todolist34.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@AllArgsConstructor
@Controller
public class IndexController {
    private final TodoService todoService;
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("responses", todoService.findAll());
        //데이터가 넘어가야함
        return "index";
    }
}
