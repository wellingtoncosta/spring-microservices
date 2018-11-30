package br.com.wellingtoncosta.bookservice.data.repository;

import br.com.wellingtoncosta.bookservice.data.entity.BookEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Wellington Costa on 30/11/2018.
 */
@Repository public interface BookEntityRepository extends CrudRepository<BookEntity, Long> {

    @Query("from BookEntity book where book.title = :title and book.author = :author")
    List<BookEntity> findByTitleAndAuthor(
            @Param("title") String title,
            @Param("author") String author
    );

}
