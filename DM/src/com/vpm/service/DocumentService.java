package com.vpm.service;

import java.util.List;

import com.vpm.entity.Document;

public interface DocumentService {
	
	public Object addDocument(String d_name, int inherit);
	public Object addDocumentSon(String d_name,int dd_id, int inherit);
	public Boolean deleteDocument(int d_id);
	public Object findIdBYn(String d_name);
	public List<Document> findAllDocument();

	public Object updateDocument(List<Integer> listP, List<Integer> listU, int d_id);
	public List<Document> findAllDocumentS(int dd_id);
	public Document updateInherit(int d_id, int inherit);
	public Document findFaDocument(int d_id);
	public void addupdated(Document document);

}
