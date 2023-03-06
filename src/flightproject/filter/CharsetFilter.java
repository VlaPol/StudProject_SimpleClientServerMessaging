package flightproject.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebFilter(value = "/*"                              // url - pattern for all requests
//        ,servletNames = {                            // filter will work with next servlets (names)
//                "RegistrationServlet"               // not work if use value = "/*". Or value or servletNames!!!!!
//        }
        )
public class CharsetFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(StandardCharsets.UTF_8.name());
        servletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println();
    }

}
