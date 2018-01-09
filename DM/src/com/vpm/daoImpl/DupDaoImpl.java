package com.vpm.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.vpm.dao.DupDao;
import com.vpm.entity.Dup;
import com.vpm.entity.Permissions;

@Repository
public class DupDaoImpl implements DupDao{
	@Autowired
	private HibernateTemplate hibernateTemplateMysql;
	@Override
	public void addDup(Object entity) {
		hibernateTemplateMysql.save(entity);
	}
	@Override
	public Object findByUD(int p_id, int d_id,int u_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from Dup where document.d_id=? and user.u_id=? and p_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, d_id);
			query.setParameter(1, u_id);
			query.setParameter(2, p_id);
			return query.list();
		});
	}
	@Override
	public Object findDup(int d_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from Dup where document.d_id=? group by u_id,p_id";
			Query query = session.createQuery(hql);
			query.setParameter(0, d_id);
			return query.list();
		});
	}
	@Override
	public void deleteDup(Object entity) {
		hibernateTemplateMysql.delete(entity);
	}
	@Override
	public Object findDupBydu(int d_id, int u_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from Dup where document.d_id=? and u_id=? and p_id is not null";
			Query query = session.createQuery(hql);
			query.setParameter(0, d_id);
			query.setParameter(1, u_id);
			return query.list();
		});
	}
	@Override
	public void updateDup(Object entity) {
		hibernateTemplateMysql.update(entity);
		
	}
	@Override
	public Object findDuplist(List<Integer> iList) {
		return hibernateTemplateMysql.execute((Session session) -> {
//		    hql1.append("from BlogCategory ");
//		    if(CId!=null){
//		        length=CId.size();
//		        parameter=new Object[length];
//		        for(int a=0;a<length;a++){
//		            if(CId.get(a)!=null){
//		                if(a==0){
//		                    hql1.append("where CId in(?,");
//		                    parameter[a]=CId.get(a);
//		                }
//		                hql1.append("?,");
//		                parameter[a]=CId.get(a);
//		                if(a==length-1){
//		                    hql1.append("?)");
//		                    parameter[a]=CId.get(a);
//		                }
//		            }
//		        }
//		    }
//		    String hql = hql1.toString();
//		    return blogCategory_h.blogCategoryList(hql,parameter);
//			
			StringBuffer hql1=new StringBuffer();
			 hql1.append("from Dup where d_id in("); //= "from Dup";// where document.d_id=? group by u_id,p_id";
			 int length=iList.size();
			 System.out.println(length);
			 int[] parameter=new int[length];
			 System.out.println(parameter);
			 if (iList!=null) {
				for (int a=0;a<length-1;a++) {
					if (iList.get(a)!=null) {
						if (a==length-1) {
							hql1.append("?) group by u_id,p_id");
							parameter[a]=iList.get(a);
						}
						//if (a==0) {
							hql1.append("?,");
							 parameter[a]=iList.get(a);
						//}
						
						
						//else {
						//	parameter[a]=iList.get(a);
						//	hql1.append("?,");	
						//}
						
					}
				}
			}
			 String hql =hql1.toString();
			 System.out.println(hql);
			 Query query = session.createQuery(hql);
				    for (int a = 0; a < parameter.length; a++) {
				         query.setParameter(a, parameter[a]);
				    }
			return query.list();
		});
	}
	@Override
	public Object findbyfid(int f_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from Dup where file.f_id=? group by u_id,p_id";
			Query query = session.createQuery(hql);
			query.setParameter(0, f_id);
			return query.list();
		});
	}
	@Override
	public List<Dup> findByPFU(int p_id, int f_id, int u_id1) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from Dup where file.f_id=? and user.u_id=? and p_id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, f_id);
			query.setParameter(1, u_id1);
			query.setParameter(2, p_id);
			return query.list();
		});
	}
	@Override
	public List<Dup> findDupByfu(int f_id, int u_id) {
		return hibernateTemplateMysql.execute((Session session) -> {
			String hql = "from Dup where file.f_id=? and u_id=? and p_id is not null";
			Query query = session.createQuery(hql);
			query.setParameter(0, f_id);
			query.setParameter(1, u_id);
			return query.list();
		});
	} 

}
