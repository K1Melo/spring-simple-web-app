package com.springframework.webapp.bootstrap;

import com.springframework.webapp.domain.Author;
import com.springframework.webapp.domain.Book;
import com.springframework.webapp.repositories.AuthorRepository;
import com.springframework.webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author("Eric", "Fernandes");
        Book ddd = new Book("Sapiens", "1234");

        Author ericSaved = authorRepository.save(eric);
        Book dddSaved = bookRepository.save(ddd);

        authorRepository.save(ericSaved);
        ericSaved.getBooks().add(dddSaved);

        System.out.println("In Bootstrapp \n_________\nAuthor Count: " + authorRepository.count() + "\nBook Count: " + bookRepository.count());
    }
}
