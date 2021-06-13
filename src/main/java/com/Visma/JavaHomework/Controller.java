package com.Visma.JavaHomework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    Functions functions = new Functions();

    @RequestMapping("/")
    public @ResponseBody String greeting() {
        return "Welcome to Book library";
    }

    // http://localhost:8080/show
    @RequestMapping("/show")
    public List<Book> getBooks() {
        return functions.getBooks();
    }

    // http://localhost:8080/add?{name}&{author}&{category}&{language}&{publicationDate}&{isbn}&{guid}
    @RequestMapping("/add")
    public void addBook(@RequestParam String name,
                        @RequestParam String author,
                        @RequestParam String category,
                        @RequestParam String language,
                        @RequestParam String publicationDate,
                        @RequestParam String isbn,
                        @RequestParam String guid) {

        functions.addBook(name, author, category, language, publicationDate, isbn, guid);
    }

    // http://localhost:8080/search/{guid}
    @GetMapping("search/{guid}")
    public Book bookByGUID(@PathVariable String guid){
        return functions.findByGUID(guid);
    }

    // http://localhost:8080/takeBook/{name}/{guid}/{period}
    @RequestMapping("takeBook/{name}/{guid}/{period}")
    public void takeBook(@PathVariable("name") String name, @PathVariable("guid") String guid, @PathVariable("period") Integer period){
        functions.takeBook(name, guid, period);
    }

    // http://localhost:8080/filter/{section}/{parameter}
    @GetMapping("filter/{section}/{parameter}")
    public List<Book> getFilterRes(@PathVariable("section") String section, @PathVariable("parameter") String parameter){
        return functions.getFilterRes(section, parameter);
    }

    // http://localhost:8080/remove/{guid}
    @RequestMapping("remove/{guid}")
    public void removeByGUID(@PathVariable String guid){
        functions.deleteBook(guid);
    }
}
