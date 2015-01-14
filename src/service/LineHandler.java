package service;

import hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Session;

import orm.*;
public class LineHandler {

	@SuppressWarnings("unchecked")
	public List<Line> getLine(String type) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Line> result = session.createQuery("from Line l where l.line_type=:type")
		.setParameter("type", type).list();
		session.getTransaction().commit();
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public List<Bus> getBus(String line) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Bus> result = session.createQuery("from Bus b where b.line_id=:line")
		.setParameter("line", line).list();
		session.getTransaction().commit();
		return result;
	}
	@SuppressWarnings("unchecked")
	public List<Route> getRoute(String line) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Route> result = session.createQuery("from Route r where r.line_id=:line")
		.setParameter("line", line).list();
		session.getTransaction().commit();
		return result;
	}
	public static void main(String args[]) {
		LineHandler l = new LineHandler();
		List<Bus> test = l.getBus("001");
		for(Bus line:test) {
			System.out.println(line.getData().toString());
		}
		List<Line> ltestl = l.getLine("TOCITY");
		for(Line tt:ltestl) {
			System.out.println(tt.getStart());
		}
		List<Route> route = l.getRoute("001");
		for(Route tt:route) {
			System.out.println(tt.getPrice());
		}
	}
}
