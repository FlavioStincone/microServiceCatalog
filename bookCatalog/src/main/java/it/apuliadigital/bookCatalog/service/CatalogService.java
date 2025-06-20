package it.apuliadigital.bookCatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.apuliadigital.bookCatalog.model.Book;
import it.apuliadigital.bookCatalog.repository.CatalogRepository;

@Service
public class CatalogService implements ICatalog {

    @Autowired
    private CatalogRepository repository;

    @Override
    public Book addBook(Book book) {
        
        return repository.save(book);
    }

    @Override
    public List<Book> bookCatalog() {
        
        return (List<Book>) repository.findAll();
    }

    @Override
    public  List<Book> findByTitle(String title)
    {
        return repository.findByTitle(title);
    }

    @Override
    public List<Book> findByAuthor(String author)
    {
        return repository.findByAuthor(author);
    }

    @Override
    public List<Book> findByGenre(String genre)
    {
        return repository.findByGenre(genre);
    }

    @Override
    public Book increaseQuantity(int quantityToChange, int isbn) {
        
        Book book = repository.findById(isbn).get();

        int quantity = book.getQuantity();

        if(quantityToChange < 0)
        {
            return null;
        }

        book.setQuantity(quantity + quantityToChange);

        repository.save(book);

        return book;

    }

    @Override
    public Book decreaseQuantity(int quantityToChange,int isbn) {

        Book book = repository.findById(isbn).get();

        int quantity = book.getQuantity();

        if(quantity < quantityToChange || quantityToChange < 0)
        {
           return  null;
        }

        book.setQuantity(quantity - quantityToChange);
        repository.save(book);

        return book;  
    }

}
