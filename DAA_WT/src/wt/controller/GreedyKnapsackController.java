package wt.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wt.model.GreedyKnapsackModel;
public class GreedyKnapsackController extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String count=request.getParameter("count");
		String profits=request.getParameter("profits");
		String weights=request.getParameter("weights"); 
		String weight=request.getParameter("weight"); 
		GreedyKnapsackModel g=new GreedyKnapsackModel(count,profits,weights,weight);
		request.setAttribute("final",g.totalValue);
		request.setAttribute("final1",g.totalValue01);
		request.setAttribute("selection",g.sel);
		request.setAttribute("selection1",g.sel01);
		request.setAttribute("count", g.n);
		request.setAttribute("profits", g.profits);
		request.setAttribute("weights", g.weights);
		RequestDispatcher rd = request.getRequestDispatcher("GreedyKnapsack.jsp");
		rd.forward(request, response);
	}
}
