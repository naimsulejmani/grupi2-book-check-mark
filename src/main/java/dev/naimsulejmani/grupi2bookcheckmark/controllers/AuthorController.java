package dev.naimsulejmani.grupi2bookcheckmark.controllers;

import dev.naimsulejmani.grupi2bookcheckmark.dtos.UserDto;
import dev.naimsulejmani.grupi2bookcheckmark.helpers.FileHelper;
import dev.naimsulejmani.grupi2bookcheckmark.models.Author;
import dev.naimsulejmani.grupi2bookcheckmark.services.AuthorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final FileHelper fileHelper;

    public AuthorController(AuthorService authorService, FileHelper fileHelper) {
        this.authorService = authorService;
        this.fileHelper = fileHelper;
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
    public String newAuthor(
            @Valid @ModelAttribute Author author,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
            , @RequestParam("file") MultipartFile file,
            HttpServletRequest request) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
            return "authors/new";
        }
//        if (file.isEmpty()) {
//            bindingResult.addError(new FieldError("author", "file", "File is required"));
//            return "authors/new";
//        }
//        try {
//            //Path path = Paths.get("c:\\images\\authors");
//
//
//
////            Path path = Paths.get("target/classes/static/assets/img/authors");
////
////
////            if (!Files.exists(path)) {
////                Files.createDirectories(path);
////            }
////
////            byte[] fileBytes = file.getBytes();
////
////            String fileName = UUID.randomUUID() + "-" + file.getOriginalFilename();
////
////            Path filePath = Paths.get(path.toString(), fileName);
////
////            // Store the relative path to the image
////            author.setImageUrl("/assets/img/authors/" + fileName);
//////            author.setImageUrl(filePath.toString().replace("src/main/resources/static",""));
////
////            Files.write(filePath, fileBytes);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }


        try {
            String fileName = fileHelper.uploadFile("target/classes/static/assets/img/authors"
                    , file.getOriginalFilename()
                    , file.getBytes());
            author.setImageUrl("/assets/img/authors/" + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        HttpSession session = request.getSession(false);
        if (session != null) {
            var user = (UserDto) session.getAttribute("user");
            if (user == null) {
                author.setCreatedBy("admin");
            } else {
                author.setCreatedBy(user.getUsername());
            }
        }


        var newAuthor = authorService.add(author);
        if (newAuthor == null) {
            bindingResult.rejectValue("email", "author.email", "EMAIL already exists");
            return "authors/new";
//            redirectAttributes.addFlashAttribute("errorMessage", "Author already exists");
//            return "redirect:/authors";
        }
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
    public String editAuthor(@Valid @ModelAttribute Author author, BindingResult bindingResult
            , @PathVariable Long id, RedirectAttributes redirectAttributes
            , @RequestParam("file") MultipartFile file
            , @SessionAttribute("user") UserDto userDto
    ) {
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
//
        if (file != null && !file.isEmpty()) {
            try {
                String fileName = fileHelper.uploadFile("target/classes/static/assets/img/authors"
                        , file.getOriginalFilename()
                        , file.getBytes());
                author.setImageUrl("/assets/img/authors/" + fileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

//        for (MultipartFile f : file) {
//            if (!f.isEmpty()) {
//                try {
//                    String fileName = fileHelper.uploadFile("target/classes/static/assets/img/authors"
//                            , f.getOriginalFilename()
//                            , f.getBytes());
//                    System.out.println("fileName: " + fileName);
//                } catch (Exception ex) {
//                    System.out.println(ex.getMessage());
//                }
//
//                // ruaje ne  databze kete fajlle
//            }
//        }

        if (!author.getCreatedBy().equals(userDto.getUsername())) {
            redirectAttributes.addFlashAttribute("errorMessage",
                    "You are not allowed to edit this author, because you didnt created it!");
            return "redirect:/authors";
        }

        authorService.add(author);
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
