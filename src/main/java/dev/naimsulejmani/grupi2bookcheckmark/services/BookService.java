package dev.naimsulejmani.grupi2bookcheckmark.services;

import dev.naimsulejmani.grupi2bookcheckmark.models.Book;

import java.util.List;

public interface BookService {
    public void add(Book book);
    public void deleteById(long id);
    public void modify(Book book);
    public Book findById(long id);
    public List<Book> findAll();
    public List<Book> findAllByCategory(String category);
    public Book findByIsbn(String isbn);
}
