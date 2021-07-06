package wt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wt.model.DijkstraModel;
import wt.model.FloydWarshallModel;

public class FloydWarshallController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String count=request.getParameter("count");
		String indices=request.getParameter("matrix");
		FloydWarshallModel f=new FloydWarshallModel(count,indices);
		request.setAttribute("matrix", f.graph);
		RequestDispatcher rd = request.getRequestDispatcher("FloydWarshall.jsp");
		rd.forward(request, response);
		
	}
}
