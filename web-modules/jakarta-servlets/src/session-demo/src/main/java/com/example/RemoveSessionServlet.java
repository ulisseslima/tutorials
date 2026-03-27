package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.*;

@WebServlet("/remove-session")
public class RemoveSessionServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(RemoveSessionServlet.class);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the existing session without creating a new one
        HttpSession session = request.getSession(false);

        if (session != null) {
            String sessionId = session.getId();

            // Remove only a specific attribute
            session.removeAttribute("loggedInUser");
            logger.info("User attribute removed from session ID: {}", sessionId);

            // Invalidate the entire session (e.g., on logout)
            session.invalidate();
            logger.info("Session '{}' has been invalidated.", sessionId);

        } else {
            logger.warn("No active session found to remove.");
        }
    }
}