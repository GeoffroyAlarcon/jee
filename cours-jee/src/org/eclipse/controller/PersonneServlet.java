package org.eclipse.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.model.Personne;
import org.eclipse.service.PersonneService;

@WebServlet({ "/addPerson", "/removePerson", "/editPerson" })
public class PersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneService personneService = new PersonneService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getServletPath();
		String action = url.substring(1);
		System.out.println(url);
		String operation = "";
		switch (url) {
		case "/addPerson":
			operation = "Ajouter";
			break;
		case "/editPerson":
			operation = "Modifier";
			break;
		case "/removePerson":
			operation = "Supprimer";
			break;
		}
		request.setAttribute("action", action);
		request.setAttribute("operation", operation);
		this.getServletContext().getRequestDispatcher("/WEB-INF/personne/personne.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();
		switch (url) {
		case "/addPerson":
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			Personne personne = new Personne(nom, prenom);
			request.setAttribute("personne", personne);
			personneService.save(personne);
			request.setAttribute("participePasse", "ajoutée");
			break;
		case "/editPerson":
			int num = Integer.parseInt(request.getParameter("num"));
			nom = request.getParameter("nom");
			prenom = request.getParameter("prenom");
			personne = new Personne(num, nom, prenom);
			request.setAttribute("personne", personne);
			personneService.update(personne);
			request.setAttribute("participePasse", "modifiée");
			break;
		case "/removePerson":
			num = Integer.parseInt(request.getParameter("num"));
			personne = personneService.findById(num);
			request.setAttribute("personne", personne);
			personneService.remove(num);
			request.setAttribute("participePasse", "supprimée");
			break;
		}
		// redirection vers une Servlet
		response.sendRedirect("consultPersonne");
//		request.setAttribute("personnes", personneService.findAll());
		// appel à une vue
//		this.getServletContext().getRequestDispatcher("/WEB-INF/personne/confirmation.jsp").forward(request, response);

	}

}
