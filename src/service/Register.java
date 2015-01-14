package service;
import java.util.List;

import hibernate.HibernateUtil;

import org.hibernate.Session;

import orm.Customer;
import orm.Route;
public class Register {
	@SuppressWarnings("unchecked")
	public boolean addUser(String id,String fname,String lname,String phone,String passport) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Customer> result = session.createQuery("from Customer cus where cus.cus_id=:id")
				.setParameter("id", id).list();
		if(!result.isEmpty())   //user already exists
			return false;
		
		Customer cus = new Customer();
		cus.setID(id);
		cus.setFname(fname);
		cus.setLname(lname);
		cus.setPassport(passport);
		cus.setPhone(phone);
		
		session.save(cus);
		session.getTransaction().commit();
		return true;
	}
	@SuppressWarnings("unchecked")
	public boolean login(String id,String phone) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Customer> result = session.createQuery("from Customer cus where cus.cus_id=:id and cus.cus_phone=:phone")
				.setParameter("id", id).setParameter("phone", phone).list();
		session.getTransaction().commit();
		if(result.isEmpty())   //no user, need to register
			return false;
		else
			return true;
	}
	@SuppressWarnings("unchecked")
	public List<Customer> getInfo(String id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<Customer> result = session.createQuery("from Customer c where c.cus_id=:id")
		.setParameter("id", id).list();
		session.getTransaction().commit();
		return result;
	}
	public static void main(String args[]) {
		Register r = new Register();
		//r.addUser("2011011277", "bb", "mm", "13051939399", "null");
		System.out.println(r.login("2011011278", "13051939399"));
		List<Customer> test = r.getInfo("2011011277");
		for(Customer t:test) {
			System.out.println(t.getPhone());
		}
	}
}
