package hu.me.modell;

public class User {
	private String name;
	private long id;
		
	public User(String name, long id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	
	public User() {
		
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

}
