package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.model.Article;
import kr.re.kitri.hello.service.ArticleService;
import kr.re.kitri.hello.service.impl.ArticleServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
public class KitriGramController {

//    private static final Logger logger =
//            LoggerFactory.getLogger(KitriGramController.class);

    private final ArticleService articleService;

    public KitriGramController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // 전체 글 보기  GET :: /articles   List<Article>
    @GetMapping("/articles")
    public ResponseEntity<List<Article>> articleList() {

        log.debug("전체보기 컨트롤러 함수 시작..");

        // 전체글을 조회해서 가져온다...
        // 서비스의 기능을 사용해서 전체글을 조회해서 가져온다.
        List<Article> articleList = articleService.getAllArticles();

        // List<Article> 을 리턴한다. --> 자동으로 JSON으로 변환해준다.
        return ResponseEntity.ok(articleList);
    }

    // 상세 글 보기  GET :: /articles/{articleId}   Article
    @GetMapping("/articles/{articleId}")
    public ResponseEntity<Article> articleDetail(@PathVariable Long articleId) {
        Article article = articleService.getArticleByArticleId(articleId);
        // Article 을 반환
        return ResponseEntity.ok(article);
    }
    // 글 등록   POST :: /articles
    @PostMapping("/articles")
    public ResponseEntity<Void> registArticle(@RequestBody Article article) {
        // 프론트엔드에서 전달된 데이터를 확보..
        article.setCreatedAt(LocalDateTime.now());
        // article 객체(데이터가 채워진)를 서비스에 전달해서 기능을 수행..
        articleService.registArticle(article);
        return ResponseEntity.ok().build();
    }

    // 글 수정   PUT :: /articles
    @PutMapping("/articles")
    public ResponseEntity<Void> updateArticle(@RequestBody Article article) {
        articleService.updateArticle(article);
        return ResponseEntity.ok().build();
    }

    // 글 삭제   DELETE :: /articles/{articleId}
    @DeleteMapping("/articles/{articleId}")
    public ResponseEntity<Void> removeArticle(@PathVariable Long articleId) {
        articleService.removeArticle(articleId);
        return ResponseEntity.ok().build();
    }

}
