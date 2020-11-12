package org.eclipse.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.service.PersonneService;
@WebServlet("/SearchPersonne")
public class SearchPersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonneService personneService = new PersonneService();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String resultat = "valide";
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		response.setContentType("text/xml");
		if (nom != null) {
			boolean result = personneService.findByNom(nom);
			response.setContentType("text/xml");
			if (result) {
				resultat = "invalide";
			}
		} else {
			boolean result = personneService.findByPrenom(prenom);
			response.setContentType("text/xml");
			if (result) {
				resultat = "invalide";
			}
		}
		response.getWriter().write("<message>" + resultat + "</message>");
	}
	}






