package it.apuliadigital.bookCatalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import it.apuliadigital.bookCatalog.model.Book;
import it.apuliadigital.bookCatalog.service.CatalogService;

@RestController
public class CatalogController {

    @Autowired
    private CatalogService service;
    
    //POST /catalog
    @PostMapping("/catalog")
    public ResponseEntity<Book> catalog(Book book)
    {
        Book newBook = service.addBook(book);
        
        return ResponseEntity.ok(book);
    }
    
}
