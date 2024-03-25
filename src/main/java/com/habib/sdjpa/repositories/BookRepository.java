package com.habib.sdjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.habib.sdjpa.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
