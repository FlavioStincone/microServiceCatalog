package it.apuliadigital.bookCatalog.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.apuliadigital.bookCatalog.model.Book;

public interface CatalogRepository extends CrudRepository<Book, Integer> {
    
    public  List<Book> findByTitleContainingIgnoreCase(String title);

    public List<Book> findByAuthor(String author);

    public List<Book> findByGenre(String genre);
    
}
