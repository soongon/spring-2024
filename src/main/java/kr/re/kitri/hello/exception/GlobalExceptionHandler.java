package kr.re.kitri.hello.exception;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BadSqlGrammarException.class)
    public ResponseEntity<Map<String, String>> handlePSQLException(PSQLException pe) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "PSQLException occurred");
        response.put("message", "PSQLException 이 발생했어요..");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public String handleUnknownException(Exception e) {
        return "알수없는 에러입니다." + e;
    }
}
