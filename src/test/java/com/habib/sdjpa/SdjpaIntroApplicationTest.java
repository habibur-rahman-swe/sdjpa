package com.habib.sdjpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;

import com.habib.sdjpa.domain.Book;
import com.habib.sdjpa.repositories.BookRepository;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.habib.sdjpa.bootstrap"})
class SdjpaIntroApplicationTest {

	@Autowired
	BookRepository bookRepository;
	
//	@Rollback(value = false)
	@Commit
	@Order(1)
	@Test
	void testJpaTestSplice() {
		
		long countBefore = bookRepository.count();
		
		bookRepository.save(new Book("My Book", "123456", "Hello"));
		
		long countAfter = bookRepository.count();
		
		assertThat(countBefore).isLessThan(countAfter);
	}

	@Order(2)
	@Test
	void testJpaTestSpliceTransaction() {
		
		long countBefore = bookRepository.count();
		assertThat(countBefore).isEqualTo(3);
		
	}
	
}
