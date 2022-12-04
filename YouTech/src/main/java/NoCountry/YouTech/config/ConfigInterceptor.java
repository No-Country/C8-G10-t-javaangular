//package NoCountry.YouTech.config;
//
//import NoCountry.YouTech.interceptor.ExceptionHandlerFilter;
//import NoCountry.YouTech.interceptor.ResponseInterceptor;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@RequiredArgsConstructor
//@Component
//public class ConfigInterceptor extends WebMvcConfigurerAdapter {
//
//    private final ExceptionHandlerFilter exceptionHandlerFilter;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(exceptionHandlerFilter);
//    }
//
//}