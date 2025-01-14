package model;

import org.hibernate.Session;

import main.SessionUtil;

public abstract class Persistable {

	public void save() {
		Session session = SessionUtil.startSession();
		session.persist(this);
		SessionUtil.endSession(session);
	}
	
	public abstract Persistable read();
	
	public void update() {
		Session session = SessionUtil.startSession();
		session.merge(this);
		SessionUtil.endSession(session);
	}
	
	public void delete() {
		Session session = SessionUtil.startSession();
		session.remove(this);
		SessionUtil.endSession(session);
	}
	
}

