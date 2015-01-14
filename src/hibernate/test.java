package hibernate;

import java.util.List;

import org.hibernate.Session;
//import orm.Accounts;
import orm.*;



public class test {
	public static void main(String args[]) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		Accounts user = new Accounts();
//		user.setPhone("1000000000");
//		user.setPasswd("bbmm");
//		user.setSex(1);
//		session.save(user);
//		session.getTransaction().commit();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		/*verify*/
		@SuppressWarnings("unchecked")
		List<Bus> result = session.createQuery("from Bus acc where acc.bus_id=:phone")
		.setParameter("phone", "0002").list();
		if(result.isEmpty()) {
			System.out.println("faild");
		}
		else {
			for(Bus test:result) {
				System.out.println(test.getBusID());
			}
			System.out.println("ok");
		}
		session.getTransaction().commit();
	}
}
