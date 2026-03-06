package com.MyKr.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter implements Filter {
    private static final Set<String> PUBLIC_PATHS = new HashSet<>(Arrays.asList(
            "/",
            "/login",
            "/register",
            "/resetPassword",
            "/logout",
            "/pages/login.html"
    ));

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String contextPath = httpRequest.getContextPath();
        String requestUri = httpRequest.getRequestURI();
        String path = requestUri.substring(contextPath.length());

        if (isPublicPath(path) || isStaticResource(path)) {
            chain.doFilter(request, response);
            return;
        }

        HttpSession session = httpRequest.getSession(false);
        boolean loggedIn = session != null && session.getAttribute("user") != null;
        if (loggedIn) {
            chain.doFilter(request, response);
            return;
        }

        if (isAjaxRequest(httpRequest, path)) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType("application/json;charset=UTF-8");
            httpResponse.getWriter().write("{\"success\":false,\"message\":\"未登录或登录已过期\"}");
            return;
        }

        httpResponse.sendRedirect(contextPath + "/pages/login.html");
    }

    private boolean isPublicPath(String path) {
        return PUBLIC_PATHS.contains(path);
    }

    private boolean isStaticResource(String path) {
        return path.startsWith("/css/")
                || path.startsWith("/js/")
                || path.startsWith("/images/")
                || path.startsWith("/lib/")
                || path.equals("/favicon.ico");
    }

    private boolean isAjaxRequest(HttpServletRequest request, String path) {
        String requestedWith = request.getHeader("X-Requested-With");
        String accept = request.getHeader("Accept");
        return "XMLHttpRequest".equalsIgnoreCase(requestedWith)
                || path.startsWith("/api/")
                || path.startsWith("/work/")
                || path.startsWith("/stats/")
                || path.equals("/getCurrentUser")
                || path.equals("/top/works")
                || path.equals("/importCsv")
                || path.equals("/exportCsv")
                || path.equals("/addWork")
                || path.equals("/updateWork")
                || path.equals("/deleteWork")
                || (accept != null && accept.contains("application/json"));
    }
}
