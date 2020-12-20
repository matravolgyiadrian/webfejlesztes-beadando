package com.example.demo;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.entity.Publisher;
import com.example.demo.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Bean
	public CommandLineRunner initialCreate(BookService bookService) {
		return (args) -> {
			Book book = new Book("9789630788984", "Tíz kicsi néger", 2090, 266);
			Author author = new Author("Agatha Christe");
			Category category = new Category("Krimi");
			Publisher publisher = new Publisher("EURÓPA KÖNYVKIADÓ KFT.");

			book.addAuthors(author);
			book.addCategories(category);
			book.addPublishers(publisher);

			bookService.createBook(book);

			Book book2 = new Book("11111111111", "A biológia rövid története", 1200, 278);
			Author author2 = new Author("Asimov Isaac");
			Category category2 = new Category("Természettudomány");
			Publisher publisher2 = new Publisher("Gondolat Kiadó");

			book2.addAuthors(author2);
			book2.addCategories(category2);
			book2.addPublishers(publisher2);

			bookService.createBook(book2);


			Book book3 = new Book("9780201633610", "Design Patterns: Elements of Reusable Object-Oriented Software", 5980, 416);
			Author author3 = new Author("Gamma Erich");
			Category category3 = new Category("Informatika");
			Publisher publisher3 = new Publisher("Addison-Wesley Professional");

			book3.addAuthors(author3);
			book3.addCategories(category3);
			book3.addPublishers(publisher3);

			bookService.createBook(book3);
		};
	}
}