package br.com.sample;

import br.com.sample.domain.orm.Book;
import br.com.sample.domain.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InitDb implements CommandLineRunner {

    private BookRepository bookRepository;

    @Override
    public void run(String... strings) throws Exception {
        bookRepository.save(Book.builder().author("bla").pages(1).title("bli").build());
    }
}
