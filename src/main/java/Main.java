
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entities.Address;
import entities.Student;
import util.HibernateUtil;

public class Main {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address = new Address("Paris", "France", "Fr", "10000");

            session.save(address);
			Student student1 = new Student("Toto", address);
			Student student2 = new Student("Marc", address);
			session.save(student1);
			session.save(student2);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}