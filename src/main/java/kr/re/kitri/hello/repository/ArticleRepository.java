package kr.re.kitri.hello.repository;

import kr.re.kitri.hello.model.Article;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

// article 테이블을 바라보는 클래스
// article 테이블에 대한 CRUD를 수행..
@Repository
public class ArticleRepository {

    public List<Article> selectAllArticles() {
        // DB에서 전체글을 가져온다. select * from articles;
        // 데이터베이스의 타입을 모델(Article)타입으로 변환한다.
        List<Article> articleList = List.of(
                new Article(96066L, "Elizabeth Martinez", "우리의 최신 모험에서 자연의 아름다움을 탐험합니다.", "https://example.com/image10.jpg", LocalDateTime.of(2023, 5, 12, 11, 58), 853),
                new Article(66287L, "Elizabeth Martinez", "주식 시장 투자의 기초 이해하기.", "https://example.com/image1.jpg", LocalDateTime.of(2023, 9, 4, 11, 45), 814),
                new Article(97465L, "James Wilson", "세계 여행: 예산에 맞는 세계일주 가이드.", "https://example.com/image4.jpg", LocalDateTime.of(2023, 12, 21, 10, 58), 635),
                new Article(57364L, "Barbara Jones", "우리의 최신 모험에서 자연의 아름다움을 탐험합니다.", "https://example.com/image3.jpg", LocalDateTime.of(2023, 5, 13, 19, 57), 745),
                new Article(28305L, "Patricia Brown", "정신 건강을 위한 명상의 이점.", "https://example.com/image6.jpg", LocalDateTime.of(2023, 5, 3, 17, 49), 203)
        );
        return articleList;
    }
    public Article selectArticleByArticleId(Long id) {
        // DB에서 articleId로 글을 조회한다.
        // select * from articles where articleId == articleId
        // 하나(또는 0개)의 글이 조회된다고 예상.. 글을 Article 타입으로 변환
        Article article =
                new Article(id, "Barbara Jones", "우리의 최신 모험에서 자연의 아름다움을 탐험합니다.", "https://example.com/image3.jpg", LocalDateTime.of(2023, 5, 13, 19, 57), 745);

        return article;
    }
    public void insertArticle(Article article) {
        System.out.println(article + " 정상적으로 인서트 되었습니다.");
    }

    public void increaseLikes() {

    }
}
