package Main;
import java.util.*;
class student implements Comparable<student> {
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
class studentManager {
	student stu[] = new student[25];
	private int tot; //[0, tot)
	studentManager() {
		this.tot = 0;
	}
	public boolean check(int id) {
		for(int i = 0; i < tot; i++) {
			if(stu[i].getID() == id) return false;
		}
		return true;
	}
	public void insert(int id, String name, String birDate, boolean gender) {
		stu[tot] = new student(id, name, birDate, gender);
		tot++;
		//sort by ID
		Arrays.sort(stu, 0, tot);
		System.out.println("Note: Insert successfully");
	}
	public void output() {
		for(int i = 0; i < tot; i++) {
			System.out.print(stu[i].getID() + " " + stu[i].getName() + " " + stu[i].getBirDate() + " ");
			boolean gd = stu[i].getGender();
			if(gd == false) System.out.println("famale");
			else System.out.println("male");
		}
		System.out.println("Note: No more results");
	}
	public void search(String nm) {
		System.out.println(nm + ":");
		for(int i = 0; i < tot; i++) {
			if(stu[i].getName().equals(nm)) {
				System.out.print(stu[i].getID() + " " + stu[i].getName() + " " + stu[i].getBirDate() + " ");
				boolean gd = stu[i].getGender();
				if(gd == false) System.out.println("famale");
				else System.out.println("male");
			}
		}
		System.out.println("Note: No more results");
	}
	public void exit() {
		System.out.println("Note: The system will be quit");
		System.exit(0);
	}
	public void modifyBir(String name, String now) {
		boolean flag = false;
		for(int i = 0; i < tot; i++) {
			if(stu[i].getName().equals(name)) {
				flag = true;
				stu[i].setBirDate(now);
			}
		}
		if(flag) System.out.println("Note: operate successfully"); 
		else System.out.println("Note: The student information was not found"); 
	}
	public void modifyGender(String name, boolean now) {
		boolean flag = false;
		for(int i = 0; i < tot; i++) {
			if(stu[i].getName().equals(name)) {
				flag = true;
				stu[i].setGender(now);
			}
		}
		if(flag) System.out.println("Note: operate successfully"); 
		else System.out.println("Note: The student information was not found"); 
	}
	public void modifyID(String name, int now) {
		boolean flag = false;
		for(int i = 0; i < tot; i++) {
			if(stu[i].getName().equals(name)) {
				flag = true;
				stu[i].setID(now);
			}
		}
		if(flag) {
			 System.out.println("Note: operate successfully"); 
			 Arrays.sort(stu, 0, tot);
		}
		else System.out.println("Note: The student information was not found"); 	
	}
	public void delete(String name) {
		student tmp[] = new student[25];
		int r = 0;
		boolean flag = false;
		for(int i = 0; i < tot; i++) {
			if(!stu[i].getName().equals(name)) {
				tmp[r] = new student(stu[i].getID(), stu[i].getName(), stu[i].getBirDate(), stu[i].getGender());
				r++;
			} else {
				flag = true;
			}
		}
		if(flag) {
			tot = r;
			for(int i = 0; i < r; i++) {
				stu[i] = tmp[i];
			}
			System.out.println("Note: operate successfully"); 
		} else {
			System.out.println("Note: The student information was not found"); 
		}
	}
	public static void manu() {
		System.out.println("Please choose an operation:");
		System.out.println("***********************************");
		System.out.println("*            1  insert            *");
		System.out.println("*            2  search            *");
		System.out.println("*            3  delete            *");
		System.out.println("*            4  modify            *");
		System.out.println("*            5  output            *");
		System.out.println("*            6   exit             *");
		System.out.println("***********************************");
	}
	public void app() {
		Scanner cin = new Scanner(System.in);
		manu();
		while(cin.hasNextInt()) {
			int op = cin.nextInt();
			if(op < 1 || op > 6) {
				System.out.println("Note: The number is illegal.");
				continue;
			}
			if(op == 1) {
				if(tot == 20) {
					System.out.println("Note: Exceed the limit of the number of students.");
					continue;
				} else {
					System.out.println("Note: Please input the student's ID, name, birDate, gender(1:male / 0:famale) in turn");
					int id = cin.nextInt();
					String nm = new String();
					String bd = new String();
					nm = cin.next();
					bd = cin.next();
					int gd = cin.nextInt();
					//check for presence
					if(check(id)) {
						if(gd == 0) insert(id, nm, bd, false);
						else insert(id, nm, bd, true);
					} else {
						System.out.println("Note: This ID has been stored.");
					}
					
				}
			} else if(op == 2) {
				//Support for finding multiple names, results in input order
				System.out.println("Note: Please input the number of students to look for(don't exceed 20)");
				int t = cin.nextInt();
				System.out.println("Note: Please input students' name who will be searched in turn");
				String tmp[] = new String[25];
				for(int i = 0; i < t; i++) {
					tmp[i] = cin.next();
				}
				for(int i = 0; i < t; i++) {
					search(tmp[i]);
				}
			} else if(op == 3) {
				//Support for deleting multiple names, results in input order
				System.out.println("Note: Please input the number of students to delete(don't exceed 20)");
				int t = cin.nextInt();
				System.out.println("Note: Please input students' name who will be deleted in turn");
				String tmp[] = new String[25];
				for(int i = 0; i < t; i++) {
					tmp[i] = cin.next();
				}
				for(int i = 0; i < t; i++) {
					delete(tmp[i]);
				}
			} else if(op == 4) {
				System.out.println("Note: Please input students' name who will be modified");
				String nm = new String();
				nm = cin.next();
				System.out.println("Note: Please input the type  1: ID, 2: birDate, 3: gender");
				int tp = cin.nextInt();
				if(tp == 1) {
					int nid = cin.nextInt();
					modifyID(nm, nid);
				}
				if(tp == 2) {
					String nbir = new String();
					nbir = cin.next();
					modifyBir(nm, nbir);
				}
				if(tp == 3) {
					int ngd = cin.nextInt();
					if(ngd == 0) modifyGender(nm, false);
					else modifyGender(nm, true);
				}
			} else if(op == 5) {
				output();
			} else if(op == 6) {
				exit();
			}
			
			manu();
		}
	}
}
public class Main {
	public static void main(String[] args) {
		studentManager sm = new studentManager();
		sm.app();
	}
}
/*

 */