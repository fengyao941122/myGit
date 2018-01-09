package com.vpm.serviceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vpm.dao.DocumentDao;
import com.vpm.dao.PermissDao;
import com.vpm.dao.UserDao;
import com.vpm.entity.Document;
import com.vpm.entity.Permissions;
import com.vpm.entity.User;
import com.vpm.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {
	@Autowired
	DocumentDao documentdao;
	@Autowired
	PermissDao permissdao;
	@Autowired
	UserDao userdao;

	@Override
	public Object addDocument(String d_name, int inherit) {
		Document document = new Document(d_name,inherit);
		documentdao.addDocument(document);
		document.setDd_id(document.getD_id()-1);
		documentdao.addDocument(document);
		return document;
	}

	@Override
	public Object updateDocument(List<Integer> listP, List<Integer> listU, int d_id) {
		// Document document = (Document) documentdao.findById(d_id);
		// //documentdao.addDocument(document);
		// Set<DocPer> docPers = new HashSet<DocPer>();
		// Set<UserPer> dPers = new HashSet<UserPer>();
		// for (Integer integer : listP) {
		// Permissions permissions = (Permissions) permissdao.findById(integer);
		// List<DocPer> docPer = docperdao.findByDid(d_id);
		// for (DocPer docPer2 : docPer) {
		// docPer2.setPermissions(permissions);
		// for (Integer integer2 : listU) {
		// User user = (User) userdao.findByid(integer2);
		// List<UserPer> userPer = userperdao.findByPid(integer);
		// for (UserPer userPer2 : userPer) {
		// userPer2.setUser(user);
		// userPer2.setPermissions(permissions);
		// userperdao.updateUserPer(userPer2);
		// dPers.add(userPer2);
		// }
		// }
		// docperdao.updateDocPer(docPer2);
		// docPers.add(docPer2);
		// }
		//
		// }
		// document.setDocPers(docPers);
		return null;
	}

	@Override
	public Boolean deleteDocument(int d_id) {
		Document document = (Document) documentdao.findById(d_id);
		if (document == null)
			return false;
		documentdao.deleteDocument(document);
		return true;
	}

	@Override
	public Object findIdBYn(String d_name) {

		return documentdao.findIdBYn(d_name);
	}

	@Override
	public List<Document> findAllDocument() {

		return documentdao.findAllDoc();
	}

	@Override
	public Object addDocumentSon(String d_name, int dd_id, int inherit) {
		Document document = new Document(dd_id, d_name,inherit);
		documentdao.addDocument(document);
		return document;
	}

	@Override
	public List<Document> findAllDocumentS(int dd_id) {
		
		return documentdao.findDocumentS(dd_id);
	}

	@Override
	public Document updateInherit(int d_id, int inherit) {
		Document document = (Document) documentdao.findById(d_id);
		document.setInherit(inherit);
		documentdao.addDocument(document);
		return document;
	}

	@Override
	public Document findFaDocument(int d_id) {
		return (Document) documentdao.findById(d_id);
	}

	@Override
	public void addupdated(Document document) {
		documentdao.updateDocument(document);
	}

}
