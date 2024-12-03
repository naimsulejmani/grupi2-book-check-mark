package dev.naimsulejmani.grupi2bookcheckmark.controllers;

import dev.naimsulejmani.grupi2bookcheckmark.models.Author;
import dev.naimsulejmani.grupi2bookcheckmark.services.AuthorService;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("")
    public String index(Model model, @RequestParam(required = false) String errorId) {
//        if(errorId != null){
//            switch(errorId) {
//                case "ERR101" :
//            }
//        }
        model.addAttribute("authors", authorService.findAll());
        return "authors/index";
    }

    @GetMapping("/new")
    public String newAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "authors/new";
    }

    @PostMapping("/new")
    public String newAuthor(@Valid @ModelAttribute Author author, BindingResult bindingResult, RedirectAttributes redirectAttributes
            , @RequestParam("file") MultipartFile file) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
            return "authors/new";
        }


        authorService.save(author);
        redirectAttributes.addFlashAttribute("successMessage", "Author created successfully");
        return "redirect:/authors";
    }

    @GetMapping("/{id}/edit")
    public String editAuthor(Model model, @PathVariable Long id) {
        var author = authorService.findById(id);
        model.addAttribute("author", author);
        return "authors/edit";
    }

    @PostMapping("/{id}/edit")
    public String editAuthor(@Valid @ModelAttribute Author author, BindingResult bindingResult, @PathVariable Long id, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
//            bindingResult.addError(new FieldError("author", "id", "Id is not valid"));
            return "authors/edit";
        }
        if (author.getId() != id) {
            //paso parameterin si query string @RequestParam
            //http://localhost:8080/authors?errorId=ERR101
            redirectAttributes.addAttribute("errorId", "ERR101");
            // paso parametrin si object
            redirectAttributes.addFlashAttribute("errorMessage", "Author id does not match");
            return "redirect:/authors";
        }
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
        model.addAttribute("deleteBtn", true);
//       return "authors/delete";
        return "authors/details";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        authorService.deleteById(id);
        return "redirect:/authors";
    }

}
