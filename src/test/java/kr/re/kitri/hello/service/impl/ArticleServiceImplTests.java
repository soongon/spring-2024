package kr.re.kitri.hello.service.impl;

import kr.re.kitri.hello.model.Article;
import kr.re.kitri.hello.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ArticleServiceImplTests {

    @Autowired
    private ArticleService articleService;

    @Test
    public void testGetAllArticles() {
        // 실행해서 결과 리스트의 사이즈가 0보다 크면 통과..
        List<Article> articleList = articleService.getAllArticles();
        assertFalse(articleList.isEmpty());
    }

    @Test
    public void testGetArticleByArticleId() {
        // 2번 아이디로 조회해서 결과가 null 이 아니면 통과
        Article article = articleService.getArticleByArticleId(2L);
        assertNotNull(article);
    }

    @Test
    public void testRegistArticle() {
        // mock Article을 만들어서 인서트를 수행하고 해당 article 상세보기 해서 null 아니면 통과
        Article article =
                new Article(9999999L, "kim", "kkkkk", "sdfsdf", LocalDateTime.now(), 0);
        articleService.registArticle(article);
        Article article1 = articleService.getArticleByArticleId(9999999L);
        assertNotEquals(null, article1);
    }

    @Test
    public void testUpdateArticle() {
        // 아이디가 123456 인 데이터의 이름을 '김순곤' --> '이순신'으로 수정하고
        // 해당 데이터를 조회를 해서 수정된 이름이 이순신인지 확인되면 통과
        Article article =
                new Article(123456L, "이순신", "", "", LocalDateTime.now(), 0);

        articleService.updateArticle(article);
        Article article1 = articleService.getArticleByArticleId(123456L);
        assertEquals("이순신", article1.getAuthor());
    }

    @Test
    public void testRemoveArticle() {
        // 아이디 123456 인 데이터 삭제 후 조회해서 해당 데이터가 null 이면 통과
        articleService.removeArticle(123456L);
        Article article = articleService.getArticleByArticleId(123456L);
        assertNull(article);
    }
}
