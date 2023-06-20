package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.autowired.common.Book;
import com.ohgiraffers.section01.autowired.common.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceConstructor")
public class BookService {

    private final BookDAO bookDAO;

    @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> findAllBooks() {

        return bookDAO.findAllBooks();
    }

    public Book searchBookBySequence(int sequence) {

        return bookDAO.findBookBySequence(sequence);
    }
}
