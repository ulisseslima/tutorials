package com.example;

import jakarta.servlet.http.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class RemoveSessionServletTest {

    @Test
    void testUserRemovedFromSession() throws Exception {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(request.getSession(false)).thenReturn(session);
        when(session.getId()).thenReturn("TEST-SESSION-ID");

        // Run the servlet
        RemoveSessionServlet servlet = new RemoveSessionServlet();
        servlet.doPost(request, response);

        // Verify removeAttribute and invalidate were both called
        verify(session).removeAttribute("loggedInUser");
        verify(session).invalidate();
    }

    @Test
    void testNoSessionToRemove() throws Exception {

        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);

        // Simulate no active session
        when(request.getSession(false)).thenReturn(null);

        // Run the servlet — should handle null gracefully
        RemoveSessionServlet servlet = new RemoveSessionServlet();
        servlet.doPost(request, response);

        // No exception should be thrown
    }
}