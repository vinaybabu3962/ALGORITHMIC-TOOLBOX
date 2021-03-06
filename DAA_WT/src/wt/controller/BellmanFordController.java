package wt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wt.model.BellmanFordModel;



public class BellmanFordController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String count=request.getParameter("count");
		String indices=request.getParameter("matrix");
		String start=request.getParameter("start");
		BellmanFordModel b=new BellmanFordModel(count,indices,start);
		request.setAttribute("out", b.out);
		request.setAttribute("cost", b.cost);
		RequestDispatcher rd = request.getRequestDispatcher("BellmanFord.jsp");
		rd.forward(request, response);
	}
}
