package org.raydelto.models.helpers;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.raydelto.models.User;
import org.raydelto.util.PasswordUtil;

public class UserHelper {
	
	public static boolean login(String username, String password){
		Session session = PersistenceHelper.getHibernateSession();
		Transaction t = session.beginTransaction();
        Query query = session.createQuery("from User u WHERE u.username='" + username+ "' and password='" + PasswordUtil.hash(password)+"'" );
        List<User> list = query.list();
		return list.size() != 0;
	}
	

}
