package kr.re.kitri.hello.repository;

import kr.re.kitri.hello.model.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

// article 테이블을 바라보는 클래스
// article 테이블에 대한 CRUD를 수행..
@Repository
@Mapper
public interface ArticleRepository {

    List<Article> selectAllArticles();
    Article selectArticleByArticleId(Long id);
    void insertArticle(Article article);
    void increaseLikes();
    void updateArticle(Article article);
    void deleteArticle(Long id);
}
