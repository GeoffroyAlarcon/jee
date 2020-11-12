package org.eclipse.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calcul")
public class CalculServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		int a = Integer.parseInt(request.getParameter("a"));
//		int b = Integer.parseInt(request.getParameter("b"));
//		String op = request.getParameter("op");
//		char operator; 
//		int resultat;
//		switch (op) {
//		case "plus":
//			resultat = a + b;
//			operator = '+';
//			break;
//		case "fois":
//			resultat = a * b;
//			operator = '*';
//			break;
//		case "moins":
//			resultat = a - b;
//			operator = '-';
//			break;
//		case "div":
//			resultat = a / b;
//			operator = '/';
//			break;
//		default:
//			resultat = 0;
//			operator = 'E';
//		}
//		request.setAttribute("op", operator);
//		request.setAttribute("resultat", resultat);
		this.getServletContext().getRequestDispatcher("/WEB-INF/calcul/calcul.jsp").forward(request, response);

	}

}
