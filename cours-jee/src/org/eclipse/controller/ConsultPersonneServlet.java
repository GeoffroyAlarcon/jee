package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.service.PersonneService;

@WebServlet("/consultPersonne")
public class ConsultPersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneService personneService = new PersonneService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("participePasse", "consult");
		request.setAttribute("personnes", personneService.findAll());
		this.getServletContext().getRequestDispatcher("/WEB-INF/personne/confirmation.jsp").forward(request, response);
	}

}
