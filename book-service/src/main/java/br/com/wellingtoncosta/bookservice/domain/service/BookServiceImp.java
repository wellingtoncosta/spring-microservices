package br.com.wellingtoncosta.bookservice.domain.service;

import br.com.wellingtoncosta.bookservice.data.entity.BookEntity;
import br.com.wellingtoncosta.bookservice.data.mapper.BookMapper;
import br.com.wellingtoncosta.bookservice.data.repository.BookEntityRepository;
import br.com.wellingtoncosta.bookservice.domain.exception.BookAlreadyExistsException;
import br.com.wellingtoncosta.bookservice.domain.exception.BookNotFoundException;
import br.com.wellingtoncosta.bookservice.domain.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static br.com.wellingtoncosta.bookservice.data.mapper.BookMapper.toDomain;
import static br.com.wellingtoncosta.bookservice.data.mapper.BookMapper.toEntity;
import static java.util.stream.Collectors.toList;

/**
 * @author Wellington Costa on 30/11/2018.
 */
@Service public class BookServiceImp implements BookService {

    private final BookEntityRepository repository;

    @Autowired public BookServiceImp(BookEntityRepository repository) {
        this.repository = repository;
    }

    @Override public List<Book> findAll() {
        Spliterator<BookEntity> spliterator = repository.findAll().spliterator();
        Stream<BookEntity> stream = StreamSupport.stream(spliterator, false);
        return stream.map(BookMapper::toDomain).collect(toList());
    }

    @Override public Book findById(Long id) {
        Optional<BookEntity> entity = repository.findById(id);

        if(!entity.isPresent()) {
            throw new BookNotFoundException(id);
        }

        return toDomain(entity.get());
    }

    @Override @Transactional public Book save(Book book) {
        List<BookEntity>hasEquals = repository
                .findByTitleAndAuthor(book.getTiile(), book.getAuthor());

        if(!hasEquals.isEmpty()) {
            throw new BookAlreadyExistsException(book.getTiile(), book.getAuthor());
        }

        BookEntity entity = repository.save(toEntity(book));
        return toDomain(entity);
    }

    @Override @Transactional public Book update(Long id, Book book) {
        BookEntity bookDb = toEntity(findById(id));
        book.setId(bookDb.getId());
        return toDomain(repository.save(toEntity(book)));
    }

    @Override @Transactional public void delete(Long id) {
        repository.delete(toEntity(findById(id)));
    }

}
