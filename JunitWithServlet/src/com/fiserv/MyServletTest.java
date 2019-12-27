/**
 *  26-Dec-2019
    2019
 */
package com.fiserv;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import junit.framework.TestCase;

/**
 * @author Anuj Pachauri
 *
 */
public class MyServletTest extends TestCase {

	@Mock
	HttpServletRequest request;

	@Mock
	HttpServletResponse response;

	@Override
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@SuppressWarnings("restriction")
	@Test
	public void testFullName() throws IOException, ServletException {

		when(request.getParameter("fn")).thenReturn("anuj");

		when(request.getParameter("ln")).thenReturn("pachauri");

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);

		MyServlet myServelt = new MyServlet();
		myServelt.doGet(request, response);
		String result = sw.getBuffer().toString().trim();

		assertEquals(result, new String("Full Name: anuj pachauri"));

	}

}
