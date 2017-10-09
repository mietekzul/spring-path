package pl.raziel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import pl.raziel.entity.Article;
import pl.raziel.repositories.ArticleRepository;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private ArticleRepository articleRepository;

    @Secured({"ROLE_ADMIN"})
    public List<Article> getAllUserArticles() {
        return articleRepository.findAllByOrderByArticleIdDesc();
    }
}
