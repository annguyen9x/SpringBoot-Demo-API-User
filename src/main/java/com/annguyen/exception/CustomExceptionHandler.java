package com.annguyen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice// Trả về một Json
//Hoặc dùng @ControllerAdvice trả về một view (thay vì Json như @RestControllerAdvice)
public class CustomExceptionHandler {

    //Ứng với một Exception thì có một ExceptionHandler riêng

    @ExceptionHandler(NotFoundException.class)
    //Chỉ rõ (Mapping) method này xử lý Exception nào
    //Cụ thể là khi có "throw new NotFoundException("...")" thì nó sẽ vào đây để trả kết quả về cho client
    //Có thể trả về view khi dùng @ControllerAdvice thay vì trả về Json (ở đây do dùng @RestControllerAdvice)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    //Định nghĩa HttpStatus trả về cho người dùng
    public ErrorResponse handlerNotFoundException(NotFoundException ex, WebRequest request){
        // Log err - In ra lỗi để xem

        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    // Xử lý tất cả các exception chưa được khai báo
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handlerException(Exception ex, WebRequest req) {
        // Log err- In ra lỗi để xem

        return new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }
}
