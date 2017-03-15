package br.com.sample.api.v1;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(value="book", collectionRelation="books")
class BookResource extends ResourceSupport {

    private String title;
    private String author;
    private Integer pages;
}
