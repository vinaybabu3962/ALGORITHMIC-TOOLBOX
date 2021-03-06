package wt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wt.model.DijkstraModel;

public class DijkstraController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String count=request.getParameter("count");
		String indices=request.getParameter("matrix");
		String start=request.getParameter("start");
		DijkstraModel d=new DijkstraModel(count,indices,start);
		request.setAttribute("start", d.start);
		request.setAttribute("out", d.out);
		request.setAttribute("distance",d.distance); 
		RequestDispatcher rd = request.getRequestDispatcher("Dijkstra.jsp");
		rd.forward(request, response);
		
	}
}
