package com.habib.sdjpa.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.habib.sdjpa.domain.Book;
import com.habib.sdjpa.repositories.BookRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	private final BookRepository bookRepository;

	public DataInitializer(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Book book000 = new Book("Domain Driben Design", "123", "Random");
		Book saved000 = bookRepository.save(book000);

		Book book001 = new Book("Spring in Action", "245", "Oriely");
		Book saved001 = bookRepository.save(book001);

		bookRepository.findAll().forEach(book -> {
			System.out.println("Book Id: " + book.getId());
			System.out.println("Book Title: " + book.getTitle());
		});
	}

}
