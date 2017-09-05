package pl.raziel.spring.data.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.raziel.spring.data.entities.Book;

import java.util.Date;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    /**
     * String operators
     */
    Book findByTitle(String title);

    List<Book> findByTitleLike(String title);

    List<Book> findByTitleContaining(String title);

    List<Book> findByTitleStartingWith(String title);

    List<Book> findByTitleEndingWith(String title);

    List<Book> findByTitleIgnoreCase(String title);

    /**
     * Relational operators
     */

    List<Book> findByPageCountEquals(int pageCount);

    List<Book> findByPageCountGreaterThan(int pageCount);

    List<Book> findByPageCountLessThan(int pageCount);

    List<Book> findByPageCountGreaterThanEqual(int pageCount);

    List<Book> findByPageCountLessThanEqual(int pageCount);

    List<Book> findByPageCountBetween(int min, int max);

    /**
     * Logical operators
     */

    List<Book> findByTitleContainingOrTitleContaining(String title, String title2);

    List<Book> findByTitleContainingAndPageCountGreaterThan(String title, int pageCount);

    List<Book> findByTitleNot(String title);

    /**
     * Date comparison
     */

    List<Book> findByPublishDateAfter(Date date);

    List<Book> findByPublishDateBefore(Date date);

    List<Book> findByPublishDateBetween(Date date, Date date2);

    /**
     * Ordering results
     */

    List<Book> findByTitleContainingOrderByTitleAsc(String title);

    List<Book> findByTitleContainingOrderByTitleDesc(String title);

    List<Book> findTopByOrderByPageCountDesc();

    List<Book> findFirstByOrderByPageCountAsc();

    List<Book> findTop5ByOrderByPriceDesc();

    List<Book> findTop5ByTitleOrderByPriceAsc(String title);

    /**
     * Transversing Nested Properties
     */
    List<Book> findByAuthorFirstName(String firstName);

    List<Book> findByAuthor_Country(String country);

    /**
     * @Query
     */

    List<Book> queryOne();

    List<Book> queryTwo(int pageCount);

    List<Book> queryThree(@Param("title") String title);

    /**
     * Paging
     */

    List<Book> findByPageCountGreaterThan(int pageCount, Sort sort);

    /**
     * Modifying
     */

    @Transactional
    @Modifying
    @Query("update Book b set b.pageCount = ?2 where b.title like ?1")
    int setPageCount(String title, int pageCount);
}


