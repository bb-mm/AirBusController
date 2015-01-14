package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orm.Bus;
import orm.Payment;
import service.LineHandler;
import service.PaymentHandler;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		String id = (String) request.getSession().getAttribute("id");
		String card = request.getParameter("card");
		String ticket = request.getParameter("ticket");
		//System.out.println(ticket);
		String[] tickets = ticket.split("TT");
		Date d = new Date();
		LineHandler lh = new LineHandler();
		PaymentHandler oh = new PaymentHandler();
		//Timestamp tt = new Timestamp(d.getYear(),d.getMonth(),d.getDay(),d.getHours(),d.getMinutes(),d.getSeconds(), 0);
		for(int i=1;i<tickets.length;i++){
			//System.out.println(tickets[i]);
			Payment p = new Payment();
			p.setCN(card);
			p.setCI(id);
			String[] attr = tickets[i].split("[+]");
			
			p.setRI(attr[0]);
			p.setPP(Integer.parseInt(attr[3]));
			p.setPID(UUID.randomUUID().toString());
			p.setPD(new Timestamp(d.getTime()));
			List<Bus> res = lh.getBus(attr[2]);
			String businfo="";
			for(Bus b:res){
				businfo+=b.getBusID()+'/';
			}
			businfo = businfo.substring(0, businfo.length()-1);
			p.setBI(businfo);
			oh.savePayment(p);
			//response.getWriter().println("Your selected ticket(s) have been booked successfully! Thanks!");
		}
	}

}
