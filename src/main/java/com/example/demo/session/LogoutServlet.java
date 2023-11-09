package com.example.demo.session;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private void processSessionAndPrintMessage(HttpSession session, PrintWriter out) {
        Optional.ofNullable(session.getAttribute("user")).ifPresent(userAttribute -> {
            System.out.println("User=" + userAttribute);
            session.invalidate();
            out.println("Session invalidated. Welcome back, " + userAttribute + "!");
        });

        Optional.of(session).ifPresent(s -> out.println("Either user name or password is wrong!"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();

        Arrays.stream(cookies)
                .filter(cookie -> "JSESSIONID".equals(cookie.getName()))
                .map(Cookie::getValue)
                .findFirst().ifPresent(jsessionId -> System.out.println("JSESSIONID=" + jsessionId));

        HttpSession session = request.getSession(false);
        processSessionAndPrintMessage(session, response.getWriter());

    }

}
