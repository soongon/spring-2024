package kr.re.kitri.hello.service.impl;

import kr.re.kitri.hello.model.Article;
import kr.re.kitri.hello.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ArticleServiceImplTests {

    @Autowired
    private ArticleService articleService;

    @Test
    public void testGetAllArticles() {
        // 실행해서 결과 리스트의 사이즈가 0보다 크면 통과..
        List<Article> articleList = articleService.getAllArticles();
        assertTrue(articleList.size() > 0);
    }

    @Test
    public void testGetArticleByArticleId() {
        // 2번 아이디로 조회해서 결과가 null 이 아니면 통과
        Article article = articleService.getArticleByArticleId(2L);
        assertNotNull(article);
    }

}
