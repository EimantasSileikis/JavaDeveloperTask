package com.Visma.JavaHomework;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JavaHomeworkApplicationTests {

	static Functions functions = new Functions();
	static Functions functions1 = new Functions();
	static Functions functions2 = new Functions();
	static Functions functions3 = new Functions();
	static Book bookNr1 = new Book("The Lord of the Rings", "J.R.R. Tolkien","High Fantasy","English", "1954-07-29", "9781526604287", "1");
	static Book bookNr2 = new Book("Gydytojai miršta kitaip", "Vilius Kočiubaitis", "Short Story","Lithuanian", "2021-02-15", "9786094802348", "2");
	static Book bookNr3 = new Book("To Kill a Mockingbird", "Harper Lee", "Southern Gothic","English", "1960-07-11", "9780060935467", "3");
	static Book bookNr4 = new Book("Harry Potter and the Philosopher's Stone", "J.K. Rowling", "Fantasy","English", "2001-12-21", "9781526602381", "4");

	static List<Book> test = new ArrayList<>();


	@BeforeAll
	static void start() {
		functions.getBooks().add(bookNr1);
		functions.getBooks().add(bookNr2);
		functions.getSuitableBooks().add(bookNr1);
		functions.getSuitableBooks().add(bookNr2);
	}


	@Test
	void listCompare() {
		test.clear();
		test.add(bookNr1);
		test.add(bookNr2);
		assertEquals(test, functions.getBooks());
	}

	@Test
	void filteringName() {
		test.clear();
		test.add(bookNr1);
		assertEquals(test, functions.getFilterRes("name", "The Lord of the Rings"));
	}

	@Test
	void filteringAuthor() {
		test.clear();
		test.add(bookNr1);
		assertEquals(test, functions.getFilterRes("author", "J.R.R. Tolkien"));
	}

	@Test
	void filteringCategory() {
		test.clear();
		test.add(bookNr1);
		assertEquals(test, functions.getFilterRes("category", "High Fantasy"));
	}

	@Test
	void filteringLanguage() {
		test.clear();
		test.add(bookNr1);
		assertEquals(test, functions.getFilterRes("language", "English"));
	}

	@Test
	void filteringISBN() {
		test.clear();
		test.add(bookNr1);
		assertEquals(test, functions.getFilterRes("isbn", "9781526604287"));
	}

	@Test
	void deleteBook() {
		test.clear();
		test.add(bookNr1);
		functions.deleteBook("2");
		assertEquals(test, functions.getBooks());
	}

	@Test
	void findBook() {
		test.clear();
		test.add(bookNr2);
		assertEquals(test.get(0), functions.findByGUID("2"));
	}

	@Test
	void takeLongerThan2Months() {
		test.clear();
		test.add(bookNr1);
		test.add(bookNr2);
		functions.takeBook("Eimantas","1", 3);
		assertEquals(test, functions.getFilterRes("available", "null"));
	}

	@Test
	void filteringAvailable() {
		test.clear();
		test.add(bookNr1);
		functions1.getBooks().add(bookNr1);
		functions1.getBooks().add(bookNr2);
		functions1.getSuitableBooks().add(bookNr1);
		functions1.getSuitableBooks().add(bookNr2);
		functions1.takeBook("Eimantas","2", 1);
		assertEquals(test, functions1.getFilterRes("available", "null"));
	}

	@Test
	void filteringTaken() {
		test.clear();
		test.add(bookNr1);
		functions2.getBooks().add(bookNr1);
		functions2.getBooks().add(bookNr2);
		functions2.getSuitableBooks().add(bookNr1);
		functions2.getSuitableBooks().add(bookNr2);
		functions2.takeBook("Eimantas","1", 1);
		assertEquals(test, functions2.getFilterRes("taken", "null"));
	}

	@Test
	void takeMoreThan3Books(){
		test.clear();
		test.add(bookNr4);
		functions3.getBooks().add(bookNr1);
		functions3.getBooks().add(bookNr2);
		functions3.getBooks().add(bookNr3);
		functions3.getBooks().add(bookNr4);
		functions3.getSuitableBooks().add(bookNr1);
		functions3.getSuitableBooks().add(bookNr2);
		functions3.getSuitableBooks().add(bookNr3);
		functions3.getSuitableBooks().add(bookNr4);

		functions3.takeBook("Eimantas","1", 1);
		functions3.takeBook("Eimantas","2", 1);
		functions3.takeBook("Eimantas","3", 1);
		functions3.takeBook("Eimantas","4", 1);
		assertEquals(test, functions3.getFilterRes("available", "null"));
	}
}
