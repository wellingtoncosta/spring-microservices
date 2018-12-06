package br.com.wellingtoncosta.bookservice.data.mapper;

import br.com.wellingtoncosta.bookservice.data.entity.BookEntity;
import br.com.wellingtoncosta.bookservice.domain.model.Book;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * @author Wellington Costa on 30/11/2018.
 */
public final class BookMapper {

    private BookMapper() {
        throw new NotImplementedException();
    }

    public static Book toDomain(BookEntity bookEntity) {
        Book book = new Book();
        book.setId(bookEntity.getId());
        book.setTiile(bookEntity.getTitle());
        book.setAuthor(bookEntity.getAuthor());
        book.setDescription(bookEntity.getDescription());
        book.setReleaseDate(bookEntity.getReleaseDate());
        return book;
    }

    public static BookEntity toEntity(Book book) {
        BookEntity bookEntity = new BookEntity();
        book.setId(book.getId());
        book.setTiile(book.getTiile());
        book.setAuthor(book.getAuthor());
        book.setDescription(book.getDescription());
        book.setReleaseDate(book.getReleaseDate());
        return bookEntity;
    }

}
