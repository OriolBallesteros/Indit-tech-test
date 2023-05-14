package com.zara.technical.infrastructure.handler;

import com.zara.technical.domain.exception.NotFoundPriceException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@ResponseBody
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(NotFoundPriceException.class)
  protected ResponseEntity<Object> handleNotFoundPriceException(final NotFoundPriceException ex,
      final WebRequest request) {
    final Map<String, Object> body = new LinkedHashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("message", ex.getMessage());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }

}
