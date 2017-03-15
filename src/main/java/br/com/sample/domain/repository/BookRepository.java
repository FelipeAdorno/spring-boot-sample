package br.com.sample.domain.repository;

import br.com.sample.domain.orm.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {}
