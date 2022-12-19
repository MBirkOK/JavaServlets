import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class DurationFilter implements Filter {

    protected FilterConfig filterConfig;

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long elapsed = System.currentTimeMillis() - startTime;
        String name = "servlet";
        if (servletRequest instanceof HttpServletRequest) {
            name = ((HttpServletRequest) servletRequest).getRequestURI();
        }

        filterConfig.getServletContext().log(name + " took " + elapsed + " ms");
        System.out.println(name + " took " + elapsed + " ms");
    }

    public void destroy() {
    }
}
