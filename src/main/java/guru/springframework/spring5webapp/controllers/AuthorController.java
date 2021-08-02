package guru.springframework.spring5webapp.controllers;


import guru.springframework.spring5webapp.repos.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AuthorController {

    private final AuthorRepository authRepo;

    public AuthorController(AuthorRepository authRepo) {
        this.authRepo = authRepo;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute("authors",this.authRepo.findAll());
    return "authors";
    }
}
