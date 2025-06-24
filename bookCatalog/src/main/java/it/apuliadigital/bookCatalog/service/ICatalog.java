package it.apuliadigital.bookCatalog.service;

import java.util.List;

import it.apuliadigital.bookCatalog.model.BookDTO;
import it.apuliadigital.bookCatalog.model.BookDTOBase;

public interface ICatalog {

    public BookDTO addBook(BookDTOBase book);

    public List<BookDTO> bookCatalog();

    // public Book modifyBook(Book book);

    public BookDTO increaseQuantity(int quantityToChange, int isbn); //solo amministratore?

    public BookDTO decreaseQuantity(int quantityToChange, int isbn);

    public  List<BookDTO> findByTitle(String title);

    public List<BookDTO> findByAuthor(String author);

    public List<BookDTO> findByGenre(String genre);

    //inserimento dei libri da parte dell'amministratore
    //modifica libro da parte dell'amministratore
    
    //autentucazione Spring
}