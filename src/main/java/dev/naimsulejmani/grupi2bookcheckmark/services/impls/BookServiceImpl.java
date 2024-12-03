package dev.naimsulejmani.grupi2bookcheckmark.services.impls;

import dev.naimsulejmani.grupi2bookcheckmark.models.Book;
import dev.naimsulejmani.grupi2bookcheckmark.repositories.BookRepository;
import dev.naimsulejmani.grupi2bookcheckmark.services.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Book book) {
        if (book.getId() > 0) {
            var existBook = repository.existsById(book.getId());
            if (existBook) {
                System.out.println("Book with id: " + book.getId() + " already exists");
                return;
            }
        }
        var existsIsbn = findByIsbn(book.getIsbn());
        if(existsIsbn != null) {
            System.out.println("Book with isbn: " + book.getIsbn() + " already exists");
            return;
        }

        repository.save(book);
    }

    @Override
    public void deleteById(long id) {
        var existBook = repository.existsById(id);
        if (!existBook) {
            System.out.println("Book with id: " + id + " does not exist");
            return;
        }
        repository.deleteById(id);
    }

    @Override
    public void modify(Book book) {
        var existBook = repository.existsById(book.getId());
        if (!existBook) {
            System.out.println("Book with id: " + book.getId() + " does not exist");
            return;
        }
        repository.save(book);
    }

    @Override
    public Book findById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Book> findAllByCategory(String category) {
        return repository.findAllByCategory(category);
    }

    @Override
    public Book findByIsbn(String isbn) {
        return repository.findByIsbn(isbn).orElse(null);
    }
}
