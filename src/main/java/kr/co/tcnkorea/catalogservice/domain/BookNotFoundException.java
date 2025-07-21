package kr.co.tcnkorea.catalogservice.domain;

/**
 * Created by jhpark on 2025-07-17
 */
public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String isbn) {
        super("The book with ISBN "+isbn+ "was not found.");
    }
}
