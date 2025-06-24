package it.apuliadigital.bookCatalog.model;


public class BookDTO extends BookDTOBase {
    
    private int isbn;


    public int getIsbn() {
        return this.isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

}