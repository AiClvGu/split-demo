package com.example.demo.generator.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.common.ResultBean;
import com.example.demo.exception.MyException;
import com.example.demo.generator.domain.Book;
import com.example.demo.generator.mapper.BookMapper;
import com.example.demo.generator.service.BookService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
* @author ozzo
* @description 针对表【book】的数据库操作Service实现
* @createDate 2022-07-01 15:45:28
*/
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book>
    implements BookService {

    @Override
    public List<Book> getAllBook(String bookName) {
        return lambdaQuery()
                .like(StrUtil.isNotBlank(bookName),Book::getBookName,bookName)
                .list();
    }

    @Override
    public ResultBean<String> deleteBook(Long id) {
        boolean remove = lambdaUpdate().eq(Book::getId,id)
                .remove();
        if(remove){
            return ResultBean.ok();
        }else{
            throw new MyException("删除失败");
        }
    }

    @Override
    public ResultBean<String> updateOrSaveBook(Book book) {
        book.setUpdateTimeStamp(LocalDateTime.now());
        boolean b = saveOrUpdate(book);
        if(b){
            return ResultBean.ok();
        }else{
            throw new MyException("更新失败");
        }
    }

    @Override
    public ResultBean<Book> getBookDetail(Long id) {
        Book book = Optional.ofNullable(lambdaQuery().eq(Book::getId,id).one())
                .orElseThrow(() -> new MyException("找不到该书籍"));
        return ResultBean.ok(book);
    }
}




