package Main;

public class student implements Comparable<student> {
	private int ID;
	private String name, birDate;
	private boolean gender;
	student(){}
	student(int id, String name, String birDate, boolean gender) {
		this.ID = id;
		this.name = name;
		this.birDate = birDate;
		this.gender = gender;
	}
	public int compareTo(student rhs) {
		return this.ID - rhs.ID;
	}
	int getID() {
		return this.ID;
	}
	String getName() {
		return this.name;
	}
	String getBirDate() {
		return this.birDate;
	}
	boolean getGender() {
		return this.gender;
	}
	void setID(int id) {
		this.ID = id;
	}
	void setName(String name) {
		this.name = name;
	}
	void setBirDate(String date) {
		this.birDate = date;
	}
	void setGender(boolean gender) {
		this.gender = gender;
	}
}
