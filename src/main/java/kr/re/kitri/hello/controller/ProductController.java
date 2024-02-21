package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    // 전체 상품 목록 보기
    @GetMapping("/products")
    public List<Product> productList() {
        // DB(외부)에서 상품목록을 갖고온다.
        // 상품목록을 모델클래스로 매핑을 해준다.
        List<Product> products = List.of(
                new Product(1L, "청정원 순창 고추장", 12000, 10, 4.5),
                new Product(2L, "삼성 갤럭시 S21 스마트폰", 990000, 15, 4.7),
                new Product(3L, "애플 아이패드 에어 4세대", 790000, 5, 4.8),
                new Product(4L, "닥터지 브라이트닝 업 선크림", 23000, 20, 4.6),
                new Product(5L, "LG 트롬 스타일러", 1250000, 25, 4.4),
                new Product(6L, "투썸플레이스 딸기 케이크", 35000, 5, 4.9),
                new Product(7L, "나이키 에어맥스 운동화", 89000, 30, 4.3),
                new Product(8L, "캐논 EOS M50 미러리스 카메라", 600000, 10, 4.7),
                new Product(9L, "이케아 포엠 사무용 의자", 110000, 15, 4.2),
                new Product(10L, "다이슨 V11 플러피 무선 청소기", 720000, 20, 4.8)
        );

        return products;
    }

    // 상품상세보기
    // 경로변수(path variable)를 활용해서 상세보기 구현(표준..)
    // 예) localhost:8080/products/1
    @GetMapping("/products/{productId}")
    public Product productDetail(@PathVariable long productId) {
        // productId 파라미터를 이용해서 상품의 상세를 조회한다.
        return new Product(productId, "다이슨 V11 플러피 무선 청소기", 720000, 20, 4.8);
    }
}
