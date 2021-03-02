package ensta.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ensta.service.FilmService;

@WebServlet("/")
public class Servlet extends HttpServlet {

    FilmService filmService = new FilmService();

 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getServletPath();
    switch (action) {
	// case "/new":
	// 	showAddForm(request, response);
	// 	break;
	// case "/insert":
	// 	insert(request, response);
	// 	break;
	// case "/delete":
	// 	delete(request, response);
	// 	break;
	// case "/edit":
	// 	showEditForm(request, response);
	// 	break;
	// case "/update":
	// 	update(request, response);
	// 	break;
	case "/list":
		showAllFilm(request, response);
		break;
}
 }
 
 private void showAllFilm(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/View/FilmForm.jsp");
    request.setAttribute("listFilm", filmService.findAll());
    dispatcher.forward(request, response);
    
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
 }
}