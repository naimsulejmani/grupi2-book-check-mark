package dev.naimsulejmani.grupi2bookcheckmark.controllers;

import dev.naimsulejmani.grupi2bookcheckmark.models.Author;
import dev.naimsulejmani.grupi2bookcheckmark.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("authors", authorService.findAll());
        return "authors/index";
    }

    @GetMapping("/new")
    public String newAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "authors/new";
    }

    @PostMapping("/new")
    public String newAuthor(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/{id}/edit")
    public String editAuthor(Model model,@PathVariable Long id) {
        var author = authorService.findById(id);
        model.addAttribute("author", author);
        return "authors/edit";
    }

    @PostMapping("/{id}/edit")
    public String editAuthor(@ModelAttribute Author author, @PathVariable Long id) {
        authorService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/{id}/details")
    public String details(Model model, @PathVariable Long id) {
        var author = authorService.findById(id);
        model.addAttribute("author", author);
        return "authors/details";
    }

    @GetMapping("/{id}/delete")
    public String delete(Model model, @PathVariable Long id) {
        var author = authorService.findById(id);
        model.addAttribute("author", author);
        model.addAttribute("deleteBtn",true);
//       return "authors/delete";
        return "authors/details";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        authorService.deleteById(id);
        return "redirect:/authors";
    }

}
