package kr.co.tcnkorea.catalogservice.domain;

import java.util.Optional;

/**
 * Created by jhpark on 2025-07-17
 */
public interface BookRepository {
    Iterable<Book> findAll();
    Optional<Book> findByISbn(String isbn);
    boolean existsByISbn(String isbn);
    Book save(Book book);
    void deleteByISbn(String isbn);
}
