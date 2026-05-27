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

import com.tsi.library.model.Book;
import com.tsi.library.repository.AuthorRepository;
import com.tsi.library.repository.BookRepository;

// Controlador para gerenciar as rotas relacionadas aos livros
@Controller
// Define a rota base para os livros
@RequestMapping("/books")
public class BookController {

    // Injeta o repositório de livros para acessar os dados
    @Autowired
    private BookRepository bookRepository;
    private  AuthorRepository authorRepository;

    public BookController(BookRepository bookRepository,
                      AuthorRepository authorRepository) {
    this.bookRepository = bookRepository;
    this.authorRepository = authorRepository;
}
    // LISTAR LIVROS
    @GetMapping
    public String listBooks(Model model) {

        List<Book> books = bookRepository.findAll();

        model.addAttribute("books", books);

        return "books/index";
    }

    // FORMULÁRIO DE CRIAÇÃO
    @GetMapping("/create")
public String showCreateForm(Model model) {
    model.addAttribute("book", new Book());
    model.addAttribute("authors", authorRepository.findAll());

    return "books/create";
}

    // SALVAR LIVRO
    @PostMapping
    public String saveBook(@ModelAttribute Book book) {

        bookRepository.save(book);

        return "redirect:/books";
    }

     // VISUALIZAR LIVRO
    @GetMapping("/{id}")
    public String showBook(@PathVariable Long id, Model model) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));

        model.addAttribute("book", book);

        return "books/show";
    }

     // FORMULÁRIO DE EDIÇÃO
    @GetMapping("/edit/{id}")
public String showEditForm(@PathVariable Long id, Model model) {
    Book book = bookRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Livro inválido"));

    model.addAttribute("book", book);
    model.addAttribute("authors", authorRepository.findAll());

    return "books/edit";
}

     // ATUALIZAR LIVRO
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id,
                             @ModelAttribute Book book) {

        book.setId(id);

        bookRepository.save(book);

        return "redirect:/books";
    }

        // EXCLUIR LIVRO
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {

        bookRepository.deleteById(id);

        return "redirect:/books";
    }
}