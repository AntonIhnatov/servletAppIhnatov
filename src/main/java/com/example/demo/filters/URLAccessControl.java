package com.example.demo.filters;

import java.util.HashSet;
import java.util.Set;

public class URLAccessControl {
    private static final Set<String> allowedURLs = new HashSet<>();

     static {
        allowedURLs.add("/demo/saveServlet");
        allowedURLs.add("/demo/deleteServlet");
        allowedURLs.add("/demo/putServlet");
        allowedURLs.add("/demo/viewByIDServlet");
        allowedURLs.add("/demo/loginServlet");
        allowedURLs.add("/demo/viewServlet");
        allowedURLs.add("/demo/LogoutServlet");
    }

    public static boolean isAllowedURL(String url) {
        return allowedURLs.contains(url);
    }
}
