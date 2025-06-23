package it.apuliadigital.bookCatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.apuliadigital.bookCatalog.model.Book;
import it.apuliadigital.bookCatalog.service.CatalogService;

@RestController
public class CatalogController {

    @Autowired
    private CatalogService service;

    // POST /catalog
    @PostMapping("/catalog")
    public ResponseEntity<Book> catalog(@RequestBody Book book) {

        if (book == null) {
            return ResponseEntity.noContent().build();
        }

        service.addBook(book);

        return ResponseEntity.ok(book);
    }

    // GET /Catalogo
    @GetMapping("/catalog")
    public ResponseEntity<List<Book>> bookCatalog() {

        return ResponseEntity.ok(service.bookCatalog());
    }

    @GetMapping("/catalog/title/{title}")
    public ResponseEntity<List<Book>> searchByTitle(@PathVariable String title) {
        return ResponseEntity.ok(service.findByTitle(title));

    }

    @GetMapping("/catalog/genre/{genre}")
    public ResponseEntity<List<Book>> searchByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(service.findByGenre(genre));

    }

    @GetMapping("/catalog/author/{author}")
    public ResponseEntity<List<Book>> searchByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(service.findByAuthor(author));

    }

    // @PostMapping("path")
    // public Book changeQuantity(@RequestBody String quantityToChange, int isbn) {
        
    //     return service.increaseQuantity(quantityToChange, isbn);
    // }

    // fare un unico metodo per increase e decrease
    

}