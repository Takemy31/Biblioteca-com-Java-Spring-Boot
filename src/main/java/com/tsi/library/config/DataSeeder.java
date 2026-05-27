package com.tsi.library.config;

import com.tsi.library.model.Author;
import com.tsi.library.model.Book;
import com.tsi.library.repository.AuthorRepository;
import com.tsi.library.repository.BookRepository;

import com.github.javafaker.Faker;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
public class DataSeeder implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataSeeder(AuthorRepository authorRepository,
                      BookRepository bookRepository) {

        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Evita duplicar dados
        if (authorRepository.count() > 0) {
            return;
        }

        Faker faker = new Faker(new Locale("pt-BR"));

        // ===== AUTORES =====

        for (int i = 0; i < 30; i++) {

            Author author = new Author();

            author.setName(faker.book().author());

            author.setBirthYear(
                    faker.number().numberBetween(1900, 2000)
            );

            authorRepository.save(author);
        }

        List<Author> authors = authorRepository.findAll();

        Random random = new Random();

        // ===== LIVROS =====

        for (int i = 0; i < 50; i++) {

            Book book = new Book();

            // título aleatório
            book.setTitle(faker.book().title());

            // páginas aleatórias
            book.setPages(
                    faker.number().numberBetween(80, 900)
            );

            // ano publicação
            book.setPublishedYear(
                    faker.number().numberBetween(1950, 2010)
            );

            // autor aleatório
            Author randomAuthor =
                    authors.get(random.nextInt(authors.size()));

            book.setAuthor(randomAuthor);

            bookRepository.save(book);
        }

        System.out.println("Dados aleatórios criados!");
    }
}