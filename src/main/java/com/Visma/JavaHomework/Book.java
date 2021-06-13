package com.Visma.JavaHomework;

public class Book {
    private final String name;
    private final String author;
    private final String category;
    private final String language;
    private final String publicationDate;
    private final String isbn;
    private final String guid;

    public Book(String name, String author, String category, String language, String publicationDate, String isbn, String guid){
        this.name = name;
        this.author = author;
        this.category = category;
        this.language = language;
        this.publicationDate = publicationDate;
        this.isbn = isbn;
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getLanguage() {
        return language;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getGuid() {
        return guid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", language='" + language + '\'' +
                ", publicationDate='" + publicationDate + '\'' +
                ", isbn='" + isbn + '\'' +
                ", guid='" + guid + '\'' +
                '}';
    }
}
