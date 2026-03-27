package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/retrieve-session")
public class RetrieveSessionServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(RetrieveSessionServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the existing session without creating a new one
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Retrieve the User object from the session
            User user = (User) session.getAttribute("loggedInUser");

            if (user != null) {
                logger.info("Retrieved user: {}, Email: {}", 
                    user.getUsername(), user.getEmail());
            } else {
                logger.warn("No user found in session.");
            }
        } else {
            logger.warn("No active session found.");
        }
    }
}