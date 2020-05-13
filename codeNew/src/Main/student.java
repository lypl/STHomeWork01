package Main;

public class student implements Comparable<student> {
	private int ID;
	//private String name, birDate; 10
	private String name;
	private String birDate;
	private boolean gender;
	
	student(){}
	
	/**
	 * ${A constructor with arguments}
	 * @param id: the student's ID
	 * @param name: the student's name
	 * @param birDate: the student's birthday
	 * @param gender: the student's gender
	 */
	student(int id, String name, String birDate, boolean gender) {
		this.ID = id;
		this.name = name;
		this.birDate = birDate;
		this.gender = gender;
	}
	
	/**
	 * ${Comparator, sorted by ID from small to large}
	 * @param rhs: another student
	 * @return: The difference between two IDs
	 */
	@Override
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
