package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// 실제로 요청을 받는 .. url 에 매핑된 함수들이 정의
@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        // 네이버 페이지를 만들어서 보내줌..
        // ..... 만들어서 보내줌...
        return "Hello world";
    }

    // "/about" 요청하면 "copyright 2024 by kim" 응답하는 코드
    @GetMapping("/about")
    public String about() {
        return "copyright 2024 by kim";
    }

    // /profile 요청하면 사용자의 프로필이 응답이 이루어진다.
    @GetMapping("/profile")
    public Profile profile() {
        // 사용자 정보를 DB에서 가지고 온다.
        return new Profile(14, "kim soongon", "M", "VIP");
        // 사용자 정보를 JSON으로 변경해서 반환한다.
    }
}
