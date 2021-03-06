package wt.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wt.model.KnapsackDPModel;
public class KnapsackDPController extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String count=request.getParameter("count");
		String profits=request.getParameter("profits");
		String weights=request.getParameter("weights"); 
		String weight=request.getParameter("weight"); 
		KnapsackDPModel g=new KnapsackDPModel(count,profits,weights,weight);
		request.setAttribute("final",g.total);
		request.setAttribute("array", g.k);
		request.setAttribute("count", g.n);
		request.setAttribute("profits", g.val);
		request.setAttribute("weights", g.wt);
		request.setAttribute("selection", g.sel);
		RequestDispatcher rd = request.getRequestDispatcher("KnapsackDP.jsp");
		rd.forward(request, response);

		
	}
}
