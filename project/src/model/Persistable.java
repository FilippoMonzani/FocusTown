package model;

public interface Persistable {

	public void save();
	public Persistable read();
	public void update();
	public void delete();
	
}

