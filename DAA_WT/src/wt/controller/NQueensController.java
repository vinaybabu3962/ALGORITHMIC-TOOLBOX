package wt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wt.model.NQueensModel;

public class NQueensController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String count=request.getParameter("count");
		NQueensModel n=new NQueensModel(count);
		request.setAttribute("matrix", n.board);
		request.setAttribute("out", n.out);
		RequestDispatcher rd = request.getRequestDispatcher("NQueens.jsp");
		rd.forward(request, response);
	}
}
