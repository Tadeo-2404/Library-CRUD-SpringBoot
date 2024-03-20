package com.app.crud.controller;

import com.app.crud.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    BookService bookService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "home";
    }
}

