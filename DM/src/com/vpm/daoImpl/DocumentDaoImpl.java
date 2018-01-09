 package com.vpm.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.vpm.dao.DocumentDao;
import com.vpm.entity.Document;
@Repository
public class DocumentDaoImpl implements DocumentDao{

	@Autowired
	private HibernateTemplate hibernateTemplateMysql;
	@Override
	public void addDocument(Object entity) {
		hibernateTemplateMysql.save(entity);
	}

	@Override
	public void deleteDocument(Object entity) {
		hibernateTemplateMysql.delete(entity);
	}

	@Override
	public List<Document> findDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findById(int d_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from Document where d_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, d_id);
			return query.uniqueResult();
		});
	}

	@Override
	public Object findByUid(int u_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from Document where u_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, u_id);
			return query.list();
		});
	}

	@Override
	public Object findIdBYn(String d_name) {
		return  hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from Document where d_name like ?";
			Query query = session.createQuery(hql);
			query.setParameter(0, d_name);
			return query.uniqueResult();
		});
	}

	@Override
	public List<Document> findAllDoc() {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from Document where inherit = 0";
			Query query = session.createQuery(hql);
			return query.list();
		});
	}

	@Override
	public List<Document> findDocumentS(int dd_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from Document where dd_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, dd_id);
			return query.list();
		});
	}

	@Override
	public void updateDocument(Document document) {
		hibernateTemplateMysql.update(document);
	}

}
