package kr.re.kitri.hello.repository;

import kr.re.kitri.hello.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class ArticleRepositoryTests {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void testInsertArticle() {
        // 인서트 해보고 조회해서 데이터 있으면 통과
        Article article =
                new Article(99999991L, "kim", "kkkkk", "sdfsdf", LocalDateTime.now(), 0);

        articleRepository.insertArticle(article);
        Article article1 = articleRepository.selectArticleByArticleId(99999991L);
        assertNotNull(article1);
    }
}
