package author.publisher.nexus.backendpro.controller;

import author.publisher.nexus.backendpro.model.Book;
import author.publisher.nexus.backendpro.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    private Object String;

    @GetMapping
    public List<Book> getBooks() {

        return bookRepository.findAll();
    }

    @DeleteMapping("{name}")
    public String deleteBookByName(@PathVariable("name") String name) {
        Book a = bookRepository.findByName(name);
        bookRepository.delete(a);
        return "Delete Successful";
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable("id") String id) {

        return bookRepository.findById(id).get();
    }

    @GetMapping("file/{file}")
    public Book getBookByFile(@PathVariable("file") String file) {
        return bookRepository.findByFile(file);
    }

    @PostMapping
    public Book getBookByName(@RequestBody Book book) {
        if (book.getName()==null) {
            System.out.println("Need name");
        } else if (book.getFile()==null) {
            System.out.println("Need file");
        } else if (bookRepository.findByName(book.getName())!=null) {
            System.out.println("Try different username");
        } else if (bookRepository.findByFile(book.getFile())!=null) {
            System.out.println("Try different password");
        } else {
            return bookRepository.save(book);
        }

        return book;
    }

    @PutMapping
    public Book UpdateBook(@RequestBody Book book) {
        if (book.getName()==null) {
            System.out.println("Need name");
        } else if (book.getFile()==null) {
            System.out.println("Need file");
        } else {
            return bookRepository.save(book);
        }

        return book;
    }
}
