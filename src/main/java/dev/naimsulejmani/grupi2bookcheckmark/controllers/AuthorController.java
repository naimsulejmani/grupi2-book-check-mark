package dev.naimsulejmani.grupi2bookcheckmark.controllers;

import dev.naimsulejmani.grupi2bookcheckmark.models.Author;
import dev.naimsulejmani.grupi2bookcheckmark.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public String index(Model model) {
        Author author = new Author();
        author.setBio("This is a bio");
        int rnd = new Random().nextInt(1_000_000_000);
        author.setEmail("ce_" + rnd + "@example.com");
        author.setName("Name"+rnd);
        author.setSurname("Surname"+rnd);
        author.setMiddleName("MiddleName"+rnd);
        authorService.save(author);


        model.addAttribute("authors", authorService.findAll());
        return "authors/index";
    }
}
