package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.models.Book;
import guru.springframework.spring5webapp.repos.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class BooksController {


    private final BookRepository bookRepo;

    @GetMapping
    @ResponseBody
    public String s(){
        return "hello World";
    }
    public BooksController(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public String getBooks(Model model){
        model.addAttribute("books",this.bookRepo.findAll());
        return "/books";
    }
}
