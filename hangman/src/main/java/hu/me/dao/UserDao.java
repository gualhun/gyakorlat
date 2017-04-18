package hu.me.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.PropertyName;

import hu.me.entity.UserEntity;

@Repository
public class UserDao {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public UserDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public List<UserEntity> getUserOrderByFirtsNameDesc() {
		//előbb app properties, majd hangman applicationbe bean, majd itt a sessionfactory
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		
		cr.addOrder(Order.desc("firstName"));
		//http://localhost:8181/user/orderbyname
		
		return cr.list();
	}

	@Transactional
	public List<UserEntity> getUserFirstNameLikeNem() {
		//előbb app properties, majd hangman applicationbe bean, majd itt a sessionfactory
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserEntity.class);
		
		cr.add(Restrictions.like("firstName", "Nem%"));
		
		return cr.list();
	}
	
}
