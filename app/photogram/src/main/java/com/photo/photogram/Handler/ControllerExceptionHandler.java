package com.photo.photogram.Handler;

import com.photo.photogram.DTO.RespDTO.RespDTO;
import com.photo.photogram.Handler.ex.CustomValidationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// Exception 예외처리 하는 핸들러

@ControllerAdvice
@RestController
public class ControllerExceptionHandler {
    @ExceptionHandler(CustomValidationException.class) // 모든 CustomValidationException 을 처리하는 핸들러
    public RespDTO<?> validtionException(CustomValidationException e){ // <?> 은 제네릭 추론가능 ? 인경우 추후 처리
        return new RespDTO<Map<String,String>>(-1,e.getMessage(),e.getErrorMap()); // 제네릭 처리를 위한 Map<string,String>
    }
}
