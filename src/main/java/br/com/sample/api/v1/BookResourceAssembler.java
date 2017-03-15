package br.com.sample.api.v1;

import br.com.sample.domain.orm.Book;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class BookResourceAssembler extends ResourceAssemblerSupport<Book, BookResource> {

    public BookResourceAssembler() {
        super(BookRestService.class, BookResource.class);
    }

    @Override
    public BookResource toResource(Book book) {
        BookResource bookResource = createResourceWithId(book.getId(), book);
        bookResource.setAuthor(book.getAuthor());
        bookResource.setPages(book.getPages());
        bookResource.setTitle(book.getTitle());
        addLinks(bookResource);
        return bookResource;
    }

    public Book toDomain(BookResource bookResource) {
        return Book.builder()
                .author(bookResource.getAuthor())
                .pages(bookResource.getPages())
                .title(bookResource.getTitle())
                .build();
    }

    private void addLinks(BookResource bookResource) {
        //Links de exemplo você pode usar o linkTo(methodOn()) e apontar diretamente para seus serviços rest
        bookResource.add(new Link("http://localhost:8080/v1/foo", "foo"));
        bookResource.add(new Link("http://localhost:8080/v1/bar", "bar"));
    }
}
