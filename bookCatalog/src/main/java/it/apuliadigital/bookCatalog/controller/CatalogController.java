package it.apuliadigital.bookCatalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import it.apuliadigital.bookCatalog.model.BookDTO;
import it.apuliadigital.bookCatalog.model.BookDTOBase;
import it.apuliadigital.bookCatalog.service.CatalogService;


@RestController

public class CatalogController {

    @Autowired
    private CatalogService service;

    @Operation(summary = "Aggiunta di un libro", description = "Aggiunta di un libro in formato JSON")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Aggiunta di un libro con successo"),
            @ApiResponse(responseCode = "400", description = "Richiesta non valida")
    })

    @PostMapping("/catalog")
    public ResponseEntity<BookDTO> catalog(@Validated @RequestBody BookDTOBase book) {

        if (book == null) {
            return ResponseEntity.noContent().build();
        }

        BookDTO book2 = service.addBook(book);

        return ResponseEntity.ok(book2);
    }

    @Operation(summary = "Visualizza catalogo libri", description = "Visualizza l'intero catalogo dei libri")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Catalogo visualizzato con successo!"),
            @ApiResponse(responseCode = "400", description = "Richiesta non valida")
    })

    // GET /Catalogo
    @GetMapping("/catalog")
    public ResponseEntity<List<BookDTO>> bookCatalog() {

        List<BookDTO> bookList = service.bookCatalog();

        if (bookList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(bookList);
    }

    @Operation(summary = "Filtro ricerca per titolo", description = "Ricerca di un libro filtrando per il titolo")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Libro trovato!"),
            @ApiResponse(responseCode = "400", description = "Richiesta non valida")
    })

    @GetMapping("/catalog/title/{title}")
    public ResponseEntity<List<BookDTO>> searchByTitle(@PathVariable String title) {
        return ResponseEntity.ok(service.findByTitle(title));

    }

    @Operation(summary = "Filtro ricerca per genere", description = "Ricerca di un libro filtrando per il genere")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Libro trovato!"),
            @ApiResponse(responseCode = "400", description = "Richiesta non valida")
    })

    @GetMapping("/catalog/genre/{genre}")
    public ResponseEntity<List<BookDTO>> searchByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(service.findByGenre(genre));

    }

    @Operation(summary = "Filtro ricerca per autore", description = "Ricerca di un libro filtrando per autore")
    @ApiResponses({ @ApiResponse(responseCode = "200", description = "Libro trovato!"),
            @ApiResponse(responseCode = "400", description = "Richiesta non valida")
    })

    @GetMapping("/catalog/author/{author}")
    public ResponseEntity<List<BookDTO>> searchByAuthor(@PathVariable String author) {
        return ResponseEntity.ok(service.findByAuthor(author));

    }

    

    // @PostMapping("path")
    // public Book changeQuantity(@RequestBody String quantityToChange, int isbn) {

    // return service.increaseQuantity(quantityToChange, isbn);
    // }

    // fare un unico metodo per increase e decrease

}