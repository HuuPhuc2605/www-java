package com.example.libraryapp.controller;

import com.example.libraryapp.model.Book;
import com.example.libraryapp.repository.BookRepository;
import com.example.libraryapp.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepo;
    private final CategoryRepository cateRepo;

    public BookController(BookRepository bookRepo, CategoryRepository cateRepo) {
        this.bookRepo = bookRepo;
        this.cateRepo = cateRepo;
    }

    @GetMapping
    public String view(Model model) {
        model.addAttribute("list", bookRepo.findAll());
        model.addAttribute("book", new Book());
        model.addAttribute("categories", cateRepo.findAll());
        return "books";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Book book) {
        bookRepo.save(book);
        return "redirect:/books?success";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        bookRepo.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookRepo.findById(id).orElse(null));
        model.addAttribute("categories", cateRepo.findAll());
        return "edit-book";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Book book) {
        bookRepo.save(book);
        return "redirect:/books";
    }

    @GetMapping("/search")
    public String search(String keyword, Model model) {
        model.addAttribute("list",
                bookRepo.findByTitleContainingOrAuthorContaining(keyword, keyword));
        model.addAttribute("categories", cateRepo.findAll());
        model.addAttribute("book", new Book());
        return "books";
    }

    @GetMapping("/filter")
    public String filter(String name, Model model) {
        model.addAttribute("list", bookRepo.findByCategory_Name(name));
        model.addAttribute("categories", cateRepo.findAll());
        model.addAttribute("book", new Book());
        return "books";
    }
}