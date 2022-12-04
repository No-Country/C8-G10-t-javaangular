package NoCountry.YouTech.interceptor;


import NoCountry.YouTech.util.CustomResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
//public class ResponseInterceptor implements ResponseBodyAdvice {
    public class ResponseInterceptor  {
    @ExceptionHandler()
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CustomResponse processRuntimeException(RuntimeException e) {
        e.printStackTrace();
        return new CustomResponse(false, "An internal server error occurred.");
    }
//    @ExceptionHandler()
//    @ResponseStatus()
//    public CustomResponse captureException(Exception exception) {
//        System.out.println("------------");
//        return new CustomResponse(false, exception.getMessage());
//    }



//    @Override
//    public boolean supports(MethodParameter returnType, Class converterType) {
//        System.out.println("******");
//        return true;
//    }
//
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        System.out.println(selectedConverterType);
//        return new CustomResponse(true, body);
//    }


}
