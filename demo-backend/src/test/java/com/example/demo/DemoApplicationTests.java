package com.example.demo;

import com.example.demo.generator.domain.Book;
import com.example.demo.generator.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    BookService bookService;
    @Test
    void contextLoads() {
        Book book = new Book();
        book.setBookAuthor("test");
        book.setBookCatagory("helo");
        book.setBookName("ceshi");
        book.setCreateTimeStamp(LocalDateTime.now());
        book.setUpdateTimeStamp(LocalDateTime.now());
        book.setDescription("hello world");
        bookService.save(book);
    }

}
