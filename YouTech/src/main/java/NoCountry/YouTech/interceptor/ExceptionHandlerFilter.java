//package NoCountry.YouTech.interceptor;
//
//import io.jsonwebtoken.ClaimJwtException;
//import io.jsonwebtoken.JwtException;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@Order(1)
//public class ExceptionHandlerFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        try {
//            System.out.println("*******************1**************************");
//            filterChain.doFilter(request, response);
//        } catch (JwtException e) {
//
//            System.out.println("***********************2**********************");
//        }catch (RuntimeException exception){
//            System.out.println("***********************3**********************");
//
//        }
//    }
//}
