package kr.re.kitri.hello.service.impl;

import kr.re.kitri.hello.model.Article;
import kr.re.kitri.hello.repository.ArticleRepository;
import kr.re.kitri.hello.service.ArticleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // 전체글을 조회해서 전달하는 기능
    @Override
    public List<Article> getAllArticles() {
        // 실제 repository의 DB조회하는 함수를 호출하여 기능을 수행한다.
        return articleRepository.selectAllArticles();
    }

    // articleId로 글을 조회하는 함수
    @Override
    public Article getArticleByArticleId(Long articleId) {
        // 레파지토리의 상세보기 기능을 호출
        return articleRepository.selectArticleByArticleId(articleId);
    }

    @Override
    public void registArticle(Article article) {
        // article(글)을 등록한다..  article 테이블에 인서트..
        articleRepository.insertArticle(article);
    }


    @Override
    public void increaseLikes() {

    }
}
