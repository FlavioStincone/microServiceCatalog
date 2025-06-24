package it.apuliadigital.bookCatalog.model;

import jakarta.validation.constraints.NotBlank;

public class BookDTOBase {
    
    @NotBlank(message="non mettere null o vuoto")
    private String title;
    private String genre;
    private int pubblicationYear;
    private String author;
    private double price;
    private int quantity = 0;




    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPubblicationYear() {
        return this.pubblicationYear;
    }

    public void setPubblicationYear(int pubblicationYear) {
        this.pubblicationYear = pubblicationYear;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
  
}
