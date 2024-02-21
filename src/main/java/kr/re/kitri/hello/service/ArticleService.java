package kr.re.kitri.hello.service;

import kr.re.kitri.hello.model.Article;

import java.time.LocalDateTime;
import java.util.List;

public interface ArticleService {
    public List<Article> getAllArticles();
    // articleId로 글을 조회하는 함수
    public Article getArticleByArticleId(Long articleId);
    public void registArticle(Article article);
    public void increaseLikes();
    void updateArticle(Article article);
    void removeArticle(Long articleId);
}
