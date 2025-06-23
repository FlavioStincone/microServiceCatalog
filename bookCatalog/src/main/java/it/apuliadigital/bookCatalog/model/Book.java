package it.apuliadigital.bookCatalog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Book {

    @Id
    @GeneratedValue
    
    private int isbn;
    @NotBlank(message="non mettere null o vuoto")
    private String title;
    private String genre;
    private int pubblicationYear;
    private String author;
    
    private double price;
    
    private int quantity = 0;

    public Book() {
    }

    // getters/setters
    // isbn
    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    // title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // pubblicationYear
    public int getPubblicationYear() {
        return pubblicationYear;
    }

    public void setPubblicationYear(int pubblicationYear) {
        this.pubblicationYear = pubblicationYear;
    }

    // author
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    // price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // quantity
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Methods
    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", genre=" + genre + ", pubblicationYear=" + pubblicationYear
                + ", author=" + author + ", price=" + price + ", quantity=" + quantity + ", disponibility="
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + isbn;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + pubblicationYear;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + quantity;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (isbn != other.isbn)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (genre == null) {
            if (other.genre != null)
                return false;
        } else if (!genre.equals(other.genre))
            return false;
        if (pubblicationYear != other.pubblicationYear)
            return false;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        return true;
    }

}
