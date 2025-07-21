package kr.co.tcnkorea.catalogservice.persistence;

import kr.co.tcnkorea.catalogservice.domain.Book;
import kr.co.tcnkorea.catalogservice.domain.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by jhpark on 2025-07-17
 */
@Repository
public class InMemoryBookRepository implements BookRepository {
    private static final Map<String, Book> books = new ConcurrentHashMap<>();

    @Override
    public Iterable<Book> findAll() {
        return books.values();
    }

    @Override
    public Optional<Book> findByISbn(String isbn) {

        return existsByISbn(isbn)?Optional.of(books.get(isbn)) : Optional.empty();
    }

    @Override
    public boolean existsByISbn(String isbn) {
        return books.get(isbn) != null;
    }

    @Override
    public Book save(Book book) {
        books.put(book.isbn(), book);
        return book;
    }

    @Override
    public void deleteByISbn(String isbn) {
        books.remove(isbn);
    }
}
