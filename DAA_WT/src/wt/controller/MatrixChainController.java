package wt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wt.model.MatrixChainModel;

public class MatrixChainController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String count=request.getParameter("count");
		String indices=request.getParameter("indices");
		MatrixChainModel m=new MatrixChainModel(count,indices);
		request.setAttribute("multiplications",m.result);
		request.setAttribute("seq",m.out);
		request.setAttribute("array",m.m);
		RequestDispatcher rd = request.getRequestDispatcher("MatrixChainMultiplication.jsp");
		rd.forward(request, response);
	}

}
