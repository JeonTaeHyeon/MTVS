package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.autowired.common.Book;
import com.ohgiraffers.section01.autowired.common.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceField")
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    public List<Book> findAllBooks() {

        return bookDAO.findAllBooks();
    }

    public Book searchBookBySequence(int sequence) {

        return bookDAO.findBookBySequence(sequence);
    }
}
