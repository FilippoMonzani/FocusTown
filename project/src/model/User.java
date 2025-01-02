// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package model;

import org.hibernate.Session;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import main.SessionUtil;

/************************************************************/
/**
 * 
 */
@Entity
@Table(name = "APP_USER")
public class User {

	@Id
	@Column(name = "username", nullable = false, updatable = false)
	private String username;
	@Column
	private String password;

	// empty constructor needed for Hibernate queries
	public User() {

	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Save this user in the database.
	 */
	public void save() {
		Session session = SessionUtil.startSession();
		session.persist(this);
		SessionUtil.endSession(session);
	}

	
	/**
	 * Read the user from the database that matches the username.
	 * @return The user, if the username matches.
	 */
	public User read() {
		Session session = SessionUtil.startSession();
		User retrievedUser = session.find(User.class, getUsername());
		SessionUtil.endSession(session);
		return retrievedUser;
	}
	
	/**
	 * Update this user in the database.
	 */
	public void update() {
		Session session = SessionUtil.startSession();
		session.merge(this);
		SessionUtil.endSession(session);
	}
	
	/**
	 * Delete this user from the database.
	 */
	public void delete() {
		Session session = SessionUtil.startSession();
		session.remove(this);
		SessionUtil.endSession(session);
	}
}
