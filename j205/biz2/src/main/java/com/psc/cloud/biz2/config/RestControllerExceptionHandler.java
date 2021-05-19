package com.psc.cloud.biz2.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class RestControllerExceptionHandler {


    @ExceptionHandler(Exception.class)
    public @ResponseBody
    HttpErrorInfo handleNotFoundExceptions(ServerHttpRequest request, Exception ex) {
        return createHttpErrorInfo(OK, request, ex);
    }


    private HttpErrorInfo createHttpErrorInfo(HttpStatus httpStatus, ServerHttpRequest request, Exception ex) {
        final String path = request.getPath().pathWithinApplication().value();
        final String message = ex.getMessage();
        log.debug("Returning HTTP status: {} for path: {}, message: {}", httpStatus, path, message);

        System.out.println(httpStatus.toString());
        return new HttpErrorInfo(httpStatus, path, message);
    }

}