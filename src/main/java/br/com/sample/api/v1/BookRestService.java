package br.com.sample.api.v1;

import br.com.sample.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("v1/books")
public class BookRestService {

    private final BookService bookService;
    private final BookResourceAssembler bookResourceAssembler;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public BookResource getById(@PathVariable Integer id) {
        return bookResourceAssembler.toResource(bookService.getById(id));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public BookResource save(@RequestBody BookResource bookResource) {
        return bookResourceAssembler.toResource(bookService.save(bookResourceAssembler.toDomain(bookResource)));
    }

}
