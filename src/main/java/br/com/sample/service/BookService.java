package br.com.sample.service;

import br.com.sample.domain.orm.Book;

public interface BookService {

    Book getById(Integer id);
    Book save(Book book);
}
