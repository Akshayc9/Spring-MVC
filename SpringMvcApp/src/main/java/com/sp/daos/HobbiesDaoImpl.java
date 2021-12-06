package com.sp.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sp.entities.HobbyEn;
import com.sp.entities.SkillEn;
import com.sp.utility.HibernateUtility;

@Repository
public class HobbiesDaoImpl implements HobbiesDao {

	@Autowired
	SessionFactory sFactory;
	Session session = null;
	Transaction tr = null;
	
	@Override
	public String saveHobby(HobbyEn hobbyEn) {
		session = sFactory.openSession();
		tr = session.beginTransaction();
		try {
			if (hobbyEn != null) {
				session.save(hobbyEn);
				return "Hobby Saved";
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			return "Problem in Saving Hobby";
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return null;
	}

	@Override
	public String deleteHobby(int hbId) {
		session = sFactory.openSession();
		HobbyEn hbEn = session.get(HobbyEn.class, hbId);
		try {
			if (hbId>0 && hbEn !=null) {
				tr = session.beginTransaction();
				session.delete(hbEn);
				return "Hobby with ID " +hbId+" Deleted";
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
			return "Problem in Deleting Hobby";
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return null;
	}

	@Override
	public String updateHobby(int hbId, HobbyEn hobbyEn) {
		session = sFactory.openSession();
		HobbyEn hbEn = session.get(HobbyEn.class, hbId);
		try {
			if (hbId>0 && hbEn !=null) {
				tr = session.beginTransaction();
				HobbyEn hb = new HobbyEn();
				hb.setHobbyName(hobbyEn.getHobbyName());
				session.update(hb);
				return "Hobby with ID " +hbId+" Updated";
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		return null;
	}

	@Override
	public HobbyEn getHobby(int hbId) {
		session = sFactory.openSession();
		try {
				tr = session.beginTransaction();
				HobbyEn hbEn = session.get(HobbyEn.class, hbId);
				return hbEn;
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			HibernateUtility.cleanUpResources(session, tr);
		}
		session.close();
		return null;
	}

	@Override
	public List<HobbyEn> getAllHobbies() {
		session = sFactory.openSession();
		tr = session.beginTransaction();
		List<HobbyEn> hobbies = session.createCriteria(HobbyEn.class).list();			
		if (hobbies.isEmpty()) {
			System.out.println("Nothing to display");
		}
		return hobbies;
	}

}
