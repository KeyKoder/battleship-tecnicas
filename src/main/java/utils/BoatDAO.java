package utils;

import barco.Boat;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BoatDAO {
	public void saveBoat(Boat boat) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(boat);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
}

