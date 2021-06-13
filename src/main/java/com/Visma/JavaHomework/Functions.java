package com.Visma.JavaHomework;

import java.util.ArrayList;
import java.util.List;

public class Functions {
    private final List<Book> books = new ArrayList<Book>();
    private final List<Book> suitableBooks = new ArrayList<Book>();
    private final List<Book> takenBooks = new ArrayList<Book>();
    private final List<Book> filterResult = new ArrayList<Book>();
    private final List<Reader> readers = new ArrayList<Reader>();

    public List<Book> getTakenBooks() {
        return takenBooks;
    }

    public List<Book> getSuitableBooks() {
        return suitableBooks;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders(){
        return readers;
    }

    public void addBook(String name, String author, String category, String language, String pubDate, String isbn, String guid) {
        Book newBook = new Book(name, author, category, language, pubDate, isbn, guid);
        books.add(newBook);
        suitableBooks.add(newBook);
    }

    public Book findByGUID(String guid){
        for (Book book : books)
            if (book.getGuid().equals(guid)) {
                return book;
            }
        return null;
    }

    public void takeBook(String name, String guid, int period){
        if(period <= 2 && period > 0){
            boolean bookIsAvailable = true;

            for (Book book : takenBooks)
                if (book.getGuid().equals(guid)) {
                    bookIsAvailable = false;
                    break;
                }

            if(bookIsAvailable){
                Reader reader = null;

                for (Reader readers : readers)
                    if (readers.getName().equals(name)) {
                        reader = readers;
                        break;
                    }

                if (reader == null) {
                    Reader newReader = new Reader(name);
                    newReader.getTakenBooks().add(guid);
                    newReader.getBooksPeriods().add(period);
                    for (Book book : suitableBooks){
                        if(book.getGuid().equals(guid)){
                            suitableBooks.remove(book);
                            takenBooks.add(book);
                            break;
                        }
                    }
                    readers.add(newReader);

                } else {
                    if (reader.getTakenBooks().size() < 3) {
                        reader.getTakenBooks().add(guid);
                        reader.getBooksPeriods().add(period);

                        for (Book book : suitableBooks){
                            if(book.getGuid().equals(guid)){
                                suitableBooks.remove(book);
                                takenBooks.add(book);
                                break;
                            }
                        }
                    }
                }


            }
        }
    }

    public void filterBooks(String filter, String variable){
        filterResult.clear();
        switch (filter) {
            case "author":
                for (Book book : books)
                    if (book.getAuthor().equals(variable))
                        filterResult.add(book);
                break;
            case "category":
                for (Book book : books)
                    if (book.getCategory().equals(variable))
                        filterResult.add(book);
                break;
            case "language":
                for (Book book : books)
                    if (book.getLanguage().equals(variable))
                        filterResult.add(book);
                break;
            case "isbn":
                for (Book book : books)
                    if (book.getIsbn().equals(variable))
                        filterResult.add(book);
                break;
            case "name":
                for (Book book : books)
                    if (book.getName().equals(variable))
                        filterResult.add(book);
                break;
            case "taken":
                filterResult.addAll(takenBooks);
                break;
            case "available":
                filterResult.addAll(suitableBooks);
                break;
        }
    }

    public List<Book> getFilterRes(String filter, String variable){
        filterBooks(filter, variable);
        return filterResult;
    }

    public void deleteBook(String guid) {
        boolean bookExist = false;
        for (Book book : books)
            if (book.getGuid().equals(guid)) {
                bookExist = true;
                break;
            }

        if(bookExist){
            books.removeIf(book -> book.getGuid().equals(guid));

            suitableBooks.removeIf(suitableBook -> suitableBook.getGuid().equals(guid));

            takenBooks.removeIf(takenBook -> takenBook.getGuid().equals(guid));

            for (Reader reader: readers){
                for(int i = 0; i < reader.getTakenBooks().size(); i++){
                    if (reader.getTakenBooks().get(i).equals(guid)) {
                        reader.getTakenBooks().remove(i);
                        reader.getBooksPeriods().remove(i);
                    }
                }
            }
        }


    }
}
