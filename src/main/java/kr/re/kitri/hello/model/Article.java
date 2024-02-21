package kr.re.kitri.hello.model;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Article {
    private Long id;
    private String author;
    private String content;
    private String imageUrl;
    private LocalDateTime createdAt;
    private int likes;
}
