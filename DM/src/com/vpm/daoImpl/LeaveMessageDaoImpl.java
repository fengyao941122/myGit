package com.vpm.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.vpm.dao.LeaveMessageDao;
import com.vpm.entity.LeaveMessage;
@Repository
public class LeaveMessageDaoImpl implements LeaveMessageDao{

	@Autowired
	private HibernateTemplate hibernateTemplateMysql;
	@Override
	public void addLeaveMessage(Object entity) {
		hibernateTemplateMysql.save(entity);
	}

	@Override
	public List<LeaveMessage> findLeaveMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLeaveMessage(Object entity) {
		hibernateTemplateMysql.delete(entity);
	}

	@Override
	public Object findById(int l_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from LeaveMessage where l_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, l_id);
			return query.uniqueResult();
		});
	}

	@Override
	public Object findByDid(int d_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from LeaveMessage where d_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, d_id);
			return query.list();
		});
	}

	@Override
	public void updateLeaveMessage(Object entity) {
		//fillObject(entity);
		hibernateTemplateMysql.update(entity);
	}

	@Override
	public Object findbyfid(int f_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from LeaveMessage where f_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, f_id);
			return query.list();
		});
	}

}
