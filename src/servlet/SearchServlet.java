package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orm.Bus;
import orm.Customer;
import orm.Line;
import orm.Payment;
import orm.Route;
import service.LineHandler;
import service.PaymentHandler;
import service.Register;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = (String) request.getSession().getAttribute("id");
		String query = request.getParameter("query");
		String type = request.getParameter("type");
		
		if(query.equals("TOCITY") && type.equals("0")) {
			LineHandler lh = new LineHandler();
			List<Line> result = lh.getLine("TOCITY");
			StringBuilder sb = new StringBuilder();
			
			for(Line l:result) {
				sb.append("<tr>");
				
				sb.append("<td data-field=\"lineid\">");
				sb.append(l.getLineID());
				sb.append("</td>");
				
				sb.append("<td data-field=\"linename\">");
				sb.append(l.getLineName());
				sb.append("</td>");
				
				sb.append("<td data-field=\"linetype\">");
				sb.append(l.getLineType());
				sb.append("</td>");
				
				sb.append("<td data-field=\"start\">");
				sb.append(l.getStart().toString());
				sb.append("</td>");
				
				sb.append("<td data-field=\"end\">");
				sb.append(l.getEnd().toString());
				sb.append("</td>");
				
				sb.append("</tr>");
			}
			response.getWriter().println(sb.toString());
		}
		else if(query.equals("TOAIRPORT") && type.equals("0")) {
			LineHandler lh = new LineHandler();
			List<Line> result = lh.getLine("TOAIRPORT");
			StringBuilder sb = new StringBuilder();
			
			for(Line l:result) {
				sb.append("<tr>");
				
				sb.append("<td data-field=\"lineid\">");
				sb.append(l.getLineID());
				sb.append("</td>");
				
				sb.append("<td data-field=\"linename\">");
				sb.append(l.getLineName());
				sb.append("</td>");
				
				sb.append("<td data-field=\"linetype\">");
				sb.append(l.getLineType());
				sb.append("</td>");
				
				sb.append("<td data-field=\"start\">");
				sb.append(l.getStart().toString());
				sb.append("</td>");
				
				sb.append("<td data-field=\"end\">");
				sb.append(l.getEnd().toString());
				sb.append("</td>");
				
				sb.append("</tr>");
			}
			response.getWriter().println(sb.toString());
		}
		else if(type.equals("1")) {
			LineHandler lh = new LineHandler();
			List<Bus> result1 = lh.getBus(query);
			List<Route> result2 = lh.getRoute(query);
			String spliter = "|||";
			StringBuilder sb = new StringBuilder();
			for(Bus l:result1) {
				sb.append("<tr>");
				
				sb.append("<td data-field=\"id\">");
				sb.append(l.getBusID());
				sb.append("</td>");
				
				sb.append("<td data-field=\"num\">");
				sb.append(l.getBusNum());
				sb.append("</td>");
				
				sb.append("<td data-field=\"lineid\">");
				sb.append(l.getLineid());
				sb.append("</td>");
				
				sb.append("<td data-field=\"date\">");
				sb.append(l.getData().toString());
				sb.append("</td>");
				
				sb.append("<td data-field=\"seat1\">");
				sb.append(l.getTotalSeat());
				sb.append("</td>");
				
				sb.append("<td data-field=\"seat2\">");
				sb.append(l.getAvailableSeat());
				sb.append("</td>");
				
				sb.append("</tr>");
			}
			sb.append(spliter);
			for(Route l:result2) {
				sb.append("<tr>");
				
				sb.append("<td class='bs-checkbox'> <input class='inputcheck' type='checkbox' data-checked=0 value='"+l.getRouteID()+"+"
						+l.getStationName()+"+"+l.getLineID()+"+"+l.getPrice()+"'></td>");
				sb.append("<td data-field=\"id\">");
				sb.append(l.getRouteID());
				sb.append("</td>");
				
				sb.append("<td data-field=\"name\">");
				sb.append(l.getStationName());
				sb.append("</td>");
				
				sb.append("<td data-field=\"lineid\">");
				sb.append(l.getLineID());
				sb.append("</td>");
				
				sb.append("<td data-field=\"price\">$");
				sb.append(l.getPrice());
				sb.append("</td>");
				
				sb.append("</tr>");
			}
			response.getWriter().println(sb.toString());
		}
		else if(query.equals("CUSTOMER")) {
			Register reg = new Register();
			List<Customer> result = reg.getInfo(username);
			StringBuilder sb = new StringBuilder();
			
			for(Customer l:result) {
				sb.append("<tr>");
				
				sb.append("<td data-field=\"id\">");
				sb.append(l.getID());
				sb.append("</td>");
				
				sb.append("<td data-field=\"fname\">");
				sb.append(l.getFname());
				sb.append("</td>");
				
				sb.append("<td data-field=\"lname\">");
				sb.append(l.getLname());
				sb.append("</td>");
				
				sb.append("<td data-field=\"phone\">");
				sb.append(l.getPhone());
				sb.append("</td>");
				
				sb.append("<td data-field=\"passport\">");
				sb.append(l.getPassport());
				sb.append("</td>");
				
				sb.append("</tr>");
			}
			response.getWriter().println(sb.toString());
		}
		else {
			PaymentHandler ph = new PaymentHandler();
			List<Payment> result = ph.getPayment(username);	
StringBuilder sb = new StringBuilder();
			
			for(Payment l:result) {
				sb.append("<tr>");
				
				sb.append("<td data-field=\"payid\">");
				sb.append(l.getPID());
				sb.append("</td>");
				
				sb.append("<td data-field=\"price\">");
				sb.append(l.getPP());
				sb.append("</td>");
				
				sb.append("<td data-field=\"date\">");
				sb.append(l.getPD().toString());
				sb.append("</td>");
				
				sb.append("<td data-field=\"card\">");
				sb.append(l.getCN());
				sb.append("</td>");
				
				sb.append("<td data-field=\"userid\">");
				sb.append(username);
				sb.append("</td>");
				
				sb.append("<td data-field=\"routeid\">");
				sb.append(l.getRI());
				sb.append("</td>");
				
				sb.append("<td data-field=\"busid\">");
				sb.append(l.getBI());
				sb.append("</td>");
				
				sb.append("</tr>");
			}
			response.getWriter().println(sb.toString());
		}
	}

}
