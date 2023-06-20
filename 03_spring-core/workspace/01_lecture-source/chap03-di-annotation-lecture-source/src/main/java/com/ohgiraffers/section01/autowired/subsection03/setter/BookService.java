package com.ohgiraffers.section01.autowired.subsection03.setter;

import com.ohgiraffers.section01.autowired.common.Book;
import com.ohgiraffers.section01.autowired.common.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceSetter")
public class BookService {

    private BookDAO bookDAO;

    @Autowired
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> findAllBooks() {

        return bookDAO.findAllBooks();
    }

    public Book searchBookBySequence(int sequence) {

        return bookDAO.findBookBySequence(sequence);
    }
}
