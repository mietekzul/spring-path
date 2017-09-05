package pl.raziel.spring.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.raziel.spring.data.audit.CustomAuditorAware;
import pl.raziel.spring.data.entities.Book;
import pl.raziel.spring.data.repositories.BookRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomAuditorAware customAuditorAware;

    @GetMapping
    private ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookRepository.findAll();
        System.out.println(customAuditorAware.getCurrentAuditor());

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("{title}")
    private ResponseEntity<Book> getBook(@PathVariable("title") String title) {
        Book byTitle = bookRepository.findByTitle(title);
        System.out.println(byTitle);
        if (byTitle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(byTitle, HttpStatus.OK);
    }

    @GetMapping("bookByTitleLike")
    private ResponseEntity<List<Book>> getBookByTitleLike(@PathVariable("title") String title) {

        return new ResponseEntity<>(bookRepository.findByTitleLike(title), HttpStatus.OK);
    }

    @GetMapping("bookByTitleContaining")
    private ResponseEntity<List<Book>> getBookByTitleContaining(@PathVariable("title") String title) {
        return new ResponseEntity<>(bookRepository.findByTitleContaining(title), HttpStatus.OK);
    }

    @GetMapping("bookByTitleStartingWith")
    private ResponseEntity<List<Book>> getBookByTitleStartingWith(@PathVariable("title") String title) {
        return new ResponseEntity<>(bookRepository.findByTitleStartingWith(title), HttpStatus.OK);
    }

    @GetMapping("bookByTitleEndingWith")
    private ResponseEntity<List<Book>> getBookByTitleEndingWith(@PathVariable("title") String title) {
        return new ResponseEntity<>(bookRepository.findByTitleEndingWith(title), HttpStatus.OK);
    }

    @GetMapping("bookByTitleIgnoreCase")
    private ResponseEntity<List<Book>> getBookByTitleIgnoreCase(@PathVariable("title") String title) {
        return new ResponseEntity<>(bookRepository.findByTitleIgnoreCase(title), HttpStatus.OK);
    }


    @GetMapping("pages")
    private ResponseEntity<List<Book>> findPages() {

        List<Book> books = new ArrayList<>();
        for (Book b : bookRepository.findAll(new PageRequest(0, 3))) {
            books.add(b);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("sort")
    private ResponseEntity<List<Book>> sort() {

        for (Book b : bookRepository.findAll(new Sort("pageCount"))) {
            System.out.println(b);
        }

        for (Book b : bookRepository.findAll(new Sort(Sort.Direction.DESC, "pageCount"))) {
            System.out.println(b);
        }

        for (Book b : bookRepository.findAll(new Sort(Sort.Direction.ASC, "author.lastName", "pageCount"))) {
            System.out.println(b);
        }

        for (Book b : bookRepository.findAll(new Sort(Sort.Direction.ASC, "author.lastName").and(new Sort(Sort.Direction.DESC, "pageCount")))) {
            System.out.println(b);
        }

        for (Book b : bookRepository.findByPageCountGreaterThan(220, new Sort("author.firstName"))) {
            System.out.println(b);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("addBook")
    Book addBook() {
        Book book = new Book("Title", new Date(), 128, new BigDecimal("107.25"));
        System.out.println(customAuditorAware.getCurrentAuditor());

        return bookRepository.save(book);
    }

    /**
     * MVC part
     */

    @GetMapping("/books")
    private String showBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "books";
    }

    @GetMapping("/books/{bookId}")
    private String showBook(@PathVariable("bookId") Book book, Model model) {
        model.addAttribute("book", book);
        return "book";
    }

}
