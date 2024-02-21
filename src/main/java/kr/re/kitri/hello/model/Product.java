package kr.re.kitri.hello.model;

import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@ToString
@Data
@AllArgsConstructor
public class Product {
    private long productId;
    private String title;
    private long price;
    private int discountRate;
    private double score;
}
