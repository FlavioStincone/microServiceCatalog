package it.apuliadigital.bookCatalog.service;

import java.util.List;

import it.apuliadigital.bookCatalog.model.Book;

public interface ICatalog {

    public Book addBook(Book book);

    public List<Book> bookCatalog();

    // public Book modifyBook(Book book);

    public Book increaseQuantity(int quantityToChange, int isbn); //solo amministratore?

    public Book decreaseQuantity(int quantityToChange, int isbn);

    public  List<Book> findByTitle(String title);

    public List<Book> findByAuthor(String author);

    public List<Book> findByGenre(String genre);

    //inserimento dei libri da parte dell'amministratore
    //modifica libro da parte dell'amministratore
    
    //autentucazione Spring
}