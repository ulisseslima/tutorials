package com.example;

import jakarta.servlet.http.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class StoreSessionServletTest {

    @Test
    void testUserStoredInSession() throws Exception {

        // Mock the request, response, and session
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        // When getSession() is called, return our mock session
        when(request.getSession()).thenReturn(session);

        // Run the servlet
        StoreSessionServlet servlet = new StoreSessionServlet();
        servlet.doPost(request, response);

        // Verify setAttribute was called with a User object
        verify(session).setAttribute(eq("loggedInUser"), any(User.class));
    }
}