package it.apuliadigital.bookCatalog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.apuliadigital.bookCatalog.entity.Book;
import it.apuliadigital.bookCatalog.model.BookDTO;
import it.apuliadigital.bookCatalog.model.BookDTOBase;
import it.apuliadigital.bookCatalog.repository.CatalogRepository;

@Service
public class CatalogService implements ICatalog {

    @Autowired
    private CatalogRepository repository;

    @Override
    public BookDTO addBook(BookDTOBase book) {
        // Convert BookDTO to Book entity
        Book bookEntity = new Book();
       // bookEntity.setIsbn(book.getIsbn());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setPubblicationYear(book.getPubblicationYear());
        bookEntity.setPrice(book.getPrice());
        bookEntity.setGenre(book.getGenre());
        bookEntity.setQuantity(book.getQuantity());

        // Save the Book entity
        Book savedBookEntity = repository.save(bookEntity);

        // Convert the saved Book entity back to BookDTO
        BookDTO savedBookDTO = new BookDTO();
        savedBookDTO.setIsbn(savedBookEntity.getIsbn());
        savedBookDTO.setTitle(savedBookEntity.getTitle());
        savedBookDTO.setPubblicationYear(savedBookEntity.getPubblicationYear());
        savedBookDTO.setPrice(savedBookEntity.getPrice());
        savedBookDTO.setAuthor(savedBookEntity.getAuthor());
        savedBookDTO.setGenre(savedBookEntity.getGenre());
        savedBookDTO.setQuantity(savedBookEntity.getQuantity());

        return savedBookDTO;
    }

    @Override
    public List<BookDTO> bookCatalog() {

        List<Book> entities = (List<Book>) repository.findAll();


        List<BookDTO> bookDTOs = entities.stream()
                .map(book ->{
                    BookDTO bookDTO = new BookDTO();
                    bookDTO.setIsbn(book.getIsbn());
                    bookDTO.setTitle(book.getTitle());
                    bookDTO.setPubblicationYear(book.getPubblicationYear());
                    bookDTO.setPrice(book.getPrice());
                    bookDTO.setAuthor(book.getAuthor());
                    bookDTO.setGenre(book.getGenre());
                    bookDTO.setQuantity(book.getQuantity());
                    return bookDTO;
                    
                } )
                .toList();
        
        
        return bookDTOs;
    }

    @Override
    public  List<BookDTO> findByTitle(String title)
    {
        List<Book> books = repository.findByTitleContainingIgnoreCase(title);
        return books.stream()
                .map(book -> {
                    BookDTO bookDTO = new BookDTO();
                    bookDTO.setIsbn(book.getIsbn());
                    bookDTO.setTitle(book.getTitle());
                    bookDTO.setPubblicationYear(book.getPubblicationYear());
                    bookDTO.setPrice(book.getPrice());
                    bookDTO.setAuthor(book.getAuthor());
                    bookDTO.setGenre(book.getGenre());
                    bookDTO.setQuantity(book.getQuantity());
                    return bookDTO;
                })
                .toList();
    }

    @Override
    public List<BookDTO> findByAuthor(String author)
    {
        List<Book> books = repository.findByAuthorContainingIgnoreCase(author);
        return books.stream()
                .map(book -> {
                    BookDTO bookDTO = new BookDTO();
                    bookDTO.setIsbn(book.getIsbn());
                    bookDTO.setTitle(book.getTitle());
                    bookDTO.setPubblicationYear(book.getPubblicationYear());
                    bookDTO.setPrice(book.getPrice());
                    bookDTO.setAuthor(book.getAuthor());
                    bookDTO.setGenre(book.getGenre());
                    bookDTO.setQuantity(book.getQuantity());
                    return bookDTO;
                })
                .toList();
    }

    @Override
    public List<BookDTO> findByGenre(String genre)
    {
        List<Book> books = repository.findByGenreContainingIgnoreCase(genre);
        return books.stream()
                .map(book -> {
                    BookDTO bookDTO = new BookDTO();
                    bookDTO.setIsbn(book.getIsbn());
                    bookDTO.setTitle(book.getTitle());
                    bookDTO.setPubblicationYear(book.getPubblicationYear());
                    bookDTO.setPrice(book.getPrice());
                    bookDTO.setAuthor(book.getAuthor());
                    bookDTO.setGenre(book.getGenre());
                    bookDTO.setQuantity(book.getQuantity());
                    return bookDTO;
                })
                .toList();
    }

    @Override
    public BookDTO increaseQuantity(int quantityToChange, int isbn) {
        
        Book bookEntity = repository.findById(isbn).get();
        BookDTO book = new BookDTO();
        book.setIsbn(bookEntity.getIsbn());
        book.setTitle(bookEntity.getTitle());
        book.setPubblicationYear(bookEntity.getPubblicationYear());
        book.setPrice(bookEntity.getPrice());
        book.setAuthor(bookEntity.getAuthor());
        book.setGenre(bookEntity.getGenre());
        book.setQuantity(bookEntity.getQuantity());

        int quantity = book.getQuantity();

        if(quantityToChange < 0)
        {
            return null;
        }

        book.setQuantity(quantity + quantityToChange);

        // Convert BookDTO back to Book entity before saving
        Book updatedBookEntity = new Book();
        updatedBookEntity.setIsbn(book.getIsbn());
        updatedBookEntity.setTitle(book.getTitle());
        updatedBookEntity.setPubblicationYear(book.getPubblicationYear());
        updatedBookEntity.setPrice(book.getPrice());
        updatedBookEntity.setAuthor(book.getAuthor());
        updatedBookEntity.setGenre(book.getGenre());
        updatedBookEntity.setQuantity(book.getQuantity());

        repository.save(updatedBookEntity);

        return book;
    }
        


    @Override
    public BookDTO decreaseQuantity(int quantityToChange, int isbn) {

        Book bookEntity = repository.findById(isbn).get();
        BookDTO book = new BookDTO();
        book.setIsbn(bookEntity.getIsbn());
        book.setTitle(bookEntity.getTitle());
        book.setPubblicationYear(bookEntity.getPubblicationYear());
        book.setPrice(bookEntity.getPrice());
        book.setAuthor(bookEntity.getAuthor());
        book.setGenre(bookEntity.getGenre());
        book.setQuantity(bookEntity.getQuantity());

        int quantity = book.getQuantity();

        if(quantity < quantityToChange || quantityToChange < 0)
        {
            return null;
        }

        book.setQuantity(quantity - quantityToChange);

        // Convert BookDTO back to Book entity before saving
        Book updatedBookEntity = new Book();
        updatedBookEntity.setIsbn(book.getIsbn());
        updatedBookEntity.setTitle(book.getTitle());
        updatedBookEntity.setPubblicationYear(book.getPubblicationYear());
        updatedBookEntity.setPrice(book.getPrice());
        updatedBookEntity.setAuthor(book.getAuthor());
        updatedBookEntity.setGenre(book.getGenre());
        updatedBookEntity.setQuantity(book.getQuantity());

        repository.save(updatedBookEntity);

        return book;  
    }
}
