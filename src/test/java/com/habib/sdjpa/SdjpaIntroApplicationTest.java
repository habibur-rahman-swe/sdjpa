package com.habib.sdjpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.habib.sdjpa.domain.Book;
import com.habib.sdjpa.repositories.BookRepository;

@DataJpaTest
class SdjpaIntroApplicationTest {

	@Autowired
	BookRepository bookRepository;
	
	@Test
	void testJpaTestSplice() {
		
		long countBefore = bookRepository.count();
		
		bookRepository.save(new Book("My Book", "123456", "Hello"));
		
		long countAfter = bookRepository.count();
		
		assertThat(countBefore).isLessThan(countAfter);
	}

}
