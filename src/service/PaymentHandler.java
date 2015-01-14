package service;

import hibernate.HibernateUtil;

import java.util.List;

import org.hibernate.Session;

import orm.Line;
import orm.Payment;

public class PaymentHandler {
	@SuppressWarnings("unchecked")
	public List<Payment> getPayment(String id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Payment> result = session.createQuery("from Payment p where p.cus_id=:id")
		.setParameter("id", id).list();
		session.getTransaction().commit();
		return result;
	}
	public void savePayment(Payment p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}
}
