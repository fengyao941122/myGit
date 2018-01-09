package com.vpm.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.vpm.dao.PermissDao;
import com.vpm.entity.Permissions;
@Repository
public class PermissDaoImpl implements PermissDao{
	@Autowired
	private HibernateTemplate hibernateTemplateMysql;
	@Override
	public void addPermiss(Object entity) {
		hibernateTemplateMysql.save(entity);
	}

	@Override
	public void deletePermiss(Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object findById(int p_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from Permissions where p_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, p_id);
			//List list = (List) query.uniqueResult();
			return query.uniqueResult();
		});
	}

	@Override
	public List<Permissions> findPermiss() {
		return (List<Permissions>) hibernateTemplateMysql.find("from Permissions");
	}

}
