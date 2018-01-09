package com.vpm.dao;

import java.util.List;

import com.vpm.entity.Document;

public interface DocumentDao {
	
	public void addDocument(Object entity);
	
	public void deleteDocument(Object entity);
	
	public List<Document> findDocument();

	public Object findById(int d_id);
	Object findByUid(int u_id);

	public Object findIdBYn(String d_name);

	public List<Document> findAllDoc();

	public List<Document> findDocumentS(int dd_id);

	public void updateDocument(Document document);

}
