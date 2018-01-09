package com.vpm.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.vpm.dao.FileDao;
import com.vpm.entity.File;
@Repository
public class FileDaoImpl implements FileDao{
	@Autowired
	private HibernateTemplate hibernateTemplateMysql;
	@Override
	public void addFile(Object entity) {
		hibernateTemplateMysql.save(entity);
	}

	@Override
	public Object findById(int f_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from File where f_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, f_id);
			return query.uniqueResult();
		});
	}

	@Override
	public Object findallFile(int dd_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from File where dd_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, dd_id);
			return query.list();
		});
	}

	@Override
	public void deleteFile(Object entity) {
		hibernateTemplateMysql.delete(entity);
	}

}
