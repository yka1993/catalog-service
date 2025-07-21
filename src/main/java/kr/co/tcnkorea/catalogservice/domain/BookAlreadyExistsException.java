package kr.co.tcnkorea.catalogservice.domain;

/**
 * Created by jhpark on 2025-07-17
 */
public class BookAlreadyExistsException extends RuntimeException {
    public BookAlreadyExistsException(String isbn) {
        super("A book with ISBN "+isbn+" already exists.");
    }
}
