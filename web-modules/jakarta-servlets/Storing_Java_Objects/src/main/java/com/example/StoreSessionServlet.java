package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/store-session")
public class StoreSessionServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(StoreSessionServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Create a User object
        User user = new User("john_doe", "john@example.com");

        // Get or create the session
        HttpSession session = request.getSession();

        // Store the User object in the session
        session.setAttribute("loggedInUser", user);

        logger.info("User '{}' stored in session with ID: {}", 
            user.getUsername(), session.getId());
    }
}