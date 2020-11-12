 package org.eclipse.controller;
import java.io.IOException;


import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/multiplication")


public class MultiplicationChiffre extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int c = Integer.parseInt(request.getParameter("c"));
		int d = Integer.parseInt(request.getParameter("d"));
		int resultat = c * d;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\" />");
		out.println("<title>Projet JEE</title>");
		out.println("</head>");
		out.println("<body>");
		out.println(c + " x " + d + " = " + resultat);
		out.println("</body>");
		out.println("</html>");
	}
}