package com.example;

import jakarta.servlet.http.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class RetrieveSessionServletTest {

    @Test
    void testUserRetrievedFromSession() throws Exception {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);
        User mockUser = new User("john_doe", "john@example.com");

        // Return our mock session and user
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("loggedInUser")).thenReturn(mockUser);

        // Run the servlet
        RetrieveSessionServlet servlet = new RetrieveSessionServlet();
        servlet.doGet(request, response);

        // Verify getAttribute was called with the correct key
        verify(session).getAttribute("loggedInUser");
    }

    @Test
    void testNoSessionFound() throws Exception {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Simulate no active session
        when(request.getSession(false)).thenReturn(null);

        // Run the servlet — should handle null gracefully
        RetrieveSessionServlet servlet = new RetrieveSessionServlet();
        servlet.doGet(request, response);

        // No exception should be thrown
    }
}
