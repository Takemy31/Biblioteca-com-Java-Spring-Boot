package com.tsi.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tsi.library.model.Author;
import com.tsi.library.repository.AuthorRepository;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    // LISTAR
    @GetMapping
    public String listAuthors(Model model) {

        List<Author> authors = authorRepository.findAll();

        model.addAttribute("authors", authors);

        return "authors/index";
    }

    // FORMULÁRIO CREATE
    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("author", new Author());

        return "authors/create";
    }

    // SALVAR
    @PostMapping
    public String saveAuthor(@ModelAttribute Author author) {

        authorRepository.save(author);

        return "redirect:/authors";
    }

    // VISUALIZAR
    @GetMapping("/{id}")
    public String showAuthor(@PathVariable Long id, Model model) {

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Autor não encontrado"));

        model.addAttribute("author", author);

        return "authors/show";
    }

    // FORMULÁRIO EDIT
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {

        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Autor não encontrado"));

        model.addAttribute("author", author);

        return "authors/edit";
    }

    // UPDATE
    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable Long id,
                               @ModelAttribute Author author) {

        author.setId(id);

        authorRepository.save(author);

        return "redirect:/authors";
    }

    // DELETE
    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {

        authorRepository.deleteById(id);

        return "redirect:/authors";
    }
}