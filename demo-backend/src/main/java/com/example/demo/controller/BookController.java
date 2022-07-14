package com.example.demo.controller;


import com.example.demo.common.ResultBean;
import com.example.demo.generator.domain.Book;
import com.example.demo.generator.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 图书CRUD
 * */
@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/list")
    public ResultBean<List<Book>> getAllBook(String bookName){
        List<Book> allBook = bookService.getAllBook(bookName);
        return ResultBean.ok(allBook);
    }

    @GetMapping("/delete/{id}")
    public ResultBean<String> deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }

    @PostMapping("/save")
    public ResultBean<String> updateBook(@RequestBody Book book){
        return bookService.updateOrSaveBook(book);
    }

    @GetMapping("/detail/{id}")
    public ResultBean<Book> idBook(@PathVariable Long id){
        return bookService.getBookDetail(id);
    }

}
