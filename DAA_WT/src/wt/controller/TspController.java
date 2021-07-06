package wt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wt.model.TspModel;

public class TspController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{ 
		String count=request.getParameter("count");
		String indices=request.getParameter("matrix");
		TspModel t=new TspModel(count,indices);
		request.setAttribute("cost",t.final_res);
		request.setAttribute("finalpath", t.final_path);
		RequestDispatcher rd = request.getRequestDispatcher("Tsp.jsp");
		rd.forward(request, response);;
		
	}
}
