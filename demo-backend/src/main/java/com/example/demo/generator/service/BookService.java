package com.example.demo.generator.service;

import com.example.demo.common.ResultBean;
import com.example.demo.generator.domain.Book;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author ozzo
* @description 针对表【book】的数据库操作Service
* @createDate 2022-07-01 15:45:28
*/
public interface BookService extends IService<Book> {

    /**
     * 查找
     * @param  bookName 根据书名来进行模糊查询
     * @return 返回查找结果
     * */
    List<Book> getAllBook(String bookName);

    /**
     * 删除
     * @param id 根据主键删除
     * @return 统一返回
     * */
    ResultBean<String> deleteBook(Long id);

    /**
     * 新增或者修改书籍
     * @param book 需要修改或者新增书籍的名称
     * @return 统一返回
     * */
    ResultBean<String> updateOrSaveBook(Book book);

    /**
     * 根据id查询图书详细
     * @param id 主键查询
     * @return 详细书籍信息
     * */
    ResultBean<Book> getBookDetail(Long id);
}
