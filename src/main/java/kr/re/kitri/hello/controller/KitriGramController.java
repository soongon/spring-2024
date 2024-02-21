package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.model.Article;
import kr.re.kitri.hello.service.ArticleService;
import kr.re.kitri.hello.service.impl.ArticleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class KitriGramController {

    private final ArticleService articleService;

    public KitriGramController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // 전체 글 보기  GET :: /articles   List<Article>
    @GetMapping("/articles")
    public List<Article> articleList() {
        // 전체글을 조회해서 가져온다...
        // 서비스의 기능을 사용해서 전체글을 조회해서 가져온다.
        List<Article> articleList = articleService.getAllArticles();

        // List<Article> 을 리턴한다. --> 자동으로 JSON으로 변환해준다.
        return articleList;
    }

    // 상세 글 보기  GET :: /articles/{articleId}   Article
    @GetMapping("/articles/{articleId}")
    public Article articleDetail(@PathVariable Long articleId) {
        Article article = articleService.getArticleByArticleId(articleId);
        // Article 을 반환
        return article;
    }
    // 글 등록   POST :: /articles
    @PostMapping("/articles")
    public void registArticle(@RequestBody Article article) {
        // 프론트엔드에서 전달된 데이터를 확보..
        article.setCreatedAt(LocalDateTime.now());
        // article 객체(데이터가 채워진)를 서비스에 전달해서 기능을 수행..
        articleService.registArticle(article);
    }

    // 글 수정

    // 글 삭제

}
