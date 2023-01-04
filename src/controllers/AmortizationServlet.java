package controllers;

import java.io.IOException;
import java.text.NumberFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Amortization;
import model.Loan;

/**
 * Servlet implementation class AmortizationServlet
 */
@WebServlet(
		description = "Takes in the loan values and calculates amortization", 
		urlPatterns = { 
				"/AmortizationServlet", 
				"/doAmortization"
		})
public class AmortizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmortizationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get input - principal, term, rate
		double principal = Double.parseDouble(request.getParameter("principal"));
		double rate = Double.parseDouble(request.getParameter("rate"));
		int term = Integer.parseInt(request.getParameter("term"));
		
		
		Loan loan = new Loan(principal, rate, term);
		Amortization amort = new Amortization(loan);
		String table = amort.doAmortization();
		
		
		//reformat the principal
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		cf.setMaximumFractionDigits(2);
		String formatPrincipal = cf.format(principal);
		
		
		//add values to request object to pass the destination
		request.setAttribute("principal", formatPrincipal);
		request.setAttribute("rate", rate);
		request.setAttribute("term", term);
		request.setAttribute("table", table);
	
		
		//initialize output (final view)
		String url = "/table.jsp";
		
		//send control to the next component
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
