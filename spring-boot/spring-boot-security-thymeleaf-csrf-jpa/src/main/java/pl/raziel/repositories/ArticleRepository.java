package pl.raziel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.raziel.entity.Article;

import java.util.List;

@Repository
@Transactional
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    List<Article> findAllByOrderByArticleIdDesc();
}
