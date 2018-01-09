package com.vpm.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.vpm.dao.UserDao;
import com.vpm.entity.User;
@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
	private HibernateTemplate hibernateTemplateMysql;
	@Override
	public void addUser(Object entity) {
		hibernateTemplateMysql.save(entity);
	}

	@Override
	public Object findUser(String u_name,String u_pword) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from User where u_name=? and u_pword=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, u_name);
			query.setParameter(1, u_pword);
			return query.uniqueResult();
		});
	}

	@Override
	public List<User> findAllUser() {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from User";
			Query query = session.createQuery(hql);
			return query.list();
		});
	}

	@Override
	public Object findByid(int u_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from User where u_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, u_id);
			return query.uniqueResult();
		});
	}

}
