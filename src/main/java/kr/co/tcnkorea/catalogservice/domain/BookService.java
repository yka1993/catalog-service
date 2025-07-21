package kr.co.tcnkorea.catalogservice.domain;

import org.springframework.stereotype.Service;

/**
 * Created by jhpark on 2025-07-17
 */
@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> viewBookList() {
        return bookRepository.findAll();
    }

    public Book viewBookDetails(String isbn) {
        return bookRepository.findByISbn(isbn).orElseThrow(()-> new BookNotFoundException(isbn));
    }
    public Book addBookToCatalog(Book book) {
        if(bookRepository.existsByISbn(book.isbn())) {
            throw new BookAlreadyExistsException(book.isbn());
        }
        return bookRepository.save(book);
    }
    public  void removeBookFromCatalog(String isbn) {
        bookRepository.deleteByISbn(isbn);
    }
    public Book editBookDetails(String isbn, Book book) {
        return bookRepository.findByISbn(isbn)
                .map(existingBook -> {
                    var bookToUpdate = new Book(
                            existingBook.isbn(),
                            book.title(),
                            book.author(),
                            book.price());
                            return bookRepository.save(bookToUpdate);
                }).orElseGet(() -> addBookToCatalog(book));
    }
}
