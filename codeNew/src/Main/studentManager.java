package Main;

import java.util.Arrays;
import java.util.Scanner;

public class studentManager {
	final int maxn = 25; // 27 57
	final int limit = 20; // 27 57
	//student stu[] = new student[];
	student stu[] = new student[maxn]; // 57
	private int tot; //[0, tot) Total number of middle school students in the system 7
	
	studentManager() {
		this.tot = 0;
	}
	
	/**
	 * ${Determine whether the student has entered the system}
	 * @param id: the student's ID
	 * @return: false: has been deposited in; true: not has been deposited in
	 */
	public boolean check(int id) {
		for(int i = 0; i < tot; i++) {
			//if(stu[i].getID() == id) return false; 18
			if(stu[i].getID() == id) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * ${Insert a student's information into the system}
	 * @param id: the student's ID
	 * @param name: the student's name
	 * @param birDate: the student's birthday
	 * @param gender: the student's gender
     * @note: A successful operation outputs information
	 */
	public void insert(int id, String name, String birDate, boolean gender) {
		
		//stu[tot] = new student(id, name, birDate, gender);
		//tot++;
		// 49
		try {
			stu[tot] = new student(id, name, birDate, gender);
			tot++;
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} 
		
		//sort by ID
		Arrays.sort(stu, 0, tot);
		System.out.println("Note: Insert successfully");
	}
	
	/**
	 * ${Print the information of all the students in the system}
     * @note: There will be a prompt at the end of the print
	 */
	//public void output 1
	public void outPut() {
		for(int i = 0; i < tot; i++) {
			System.out.print(stu[i].getID() + " " + stu[i].getName() + " " + stu[i].getBirDate() + " ");
			boolean gd = stu[i].getGender(); //The gender of the i-th student 7
			//if(gd == false) System.out.println("female");
			//else System.out.println("male");
			// 18
			if(gd == false) {
				System.out.println("female");
			} else {
				System.out.println("male");
			}
		}
		System.out.println("Note: No more results");
	}
	
	/**
	 * ${Search students by name}
	 * @param name: the student's name
	 * @result: output every qualified students' information
     * @note: A successful or fail operation outputs information
	 */
	public void search(String nm) {
		System.out.println(nm + ":");
		for(int i = 0; i < tot; i++) {
			if(stu[i].getName().equals(nm)) {
				System.out.print(stu[i].getID() + " " + stu[i].getName() + " " + stu[i].getBirDate() + " ");
				boolean gd = stu[i].getGender(); //The gender of the i-th student 7
				//if(gd == false) System.out.println("female");
				//else System.out.println("male");
				// 18
				if(gd == false) {
					System.out.println("female");
				} else {
					System.out.println("male");
				}
			}
		}
		System.out.println("Note: No more results");
	}
	
	/**
	 * ${Exit from the system}
     * @note: There will be a prompt at the end of operation
	 */
	public void exit() {
		System.out.println("Note: The system will be quit");
		// 41
		stu = null; 
		
		System.exit(0);
	}
	
	/**
	 * ${Modify student's birthday}
	 * @param name: the student's name
	 * @param now: the student's new birthday
     * @note: A successful or fail operation outputs information
	 */
	public void modifyBir(String name, String now) {
		boolean flag = false; //Whether students' name is param:name in the system 7
		for(int i = 0; i < tot; i++) {
			if(stu[i].getName().equals(name)) {
				flag = true;
				stu[i].setBirDate(now);
			}
		}
		//if(flag) System.out.println("Note: operate successfully"); 
		//else System.out.println("Note: The student information was not found"); 
		// 18
		if(flag) {
			System.out.println("Note: operate successfully"); 
		} else {
			System.out.println("Note: The student information was not found");
		}
	}
	
	/**
	 * ${Modify student's gender}
	 * @param name: the student's name
	 * @param now: the student's new gender
     * @note: A successful or fail operation outputs information
	 */
	public void modifyGender(String name, boolean now) {
		boolean flag = false; //Whether students' name is param:name in the system 7
		for(int i = 0; i < tot; i++) {
			if(stu[i].getName().equals(name)) {
				flag = true;
				stu[i].setGender(now);
			}
		}
		//if(flag) System.out.println("Note: operate successfully"); 
		//else System.out.println("Note: The student information was not found"); 
		// 18
		if(flag) {
			System.out.println("Note: operate successfully"); 
		} else {
			System.out.println("Note: The student information was not found");
		}
	}
	
	/**
	 * ${Modify student's ID}
	 * @param name: the student's name
	 * @param now: the student's new ID
     * @note: A successful or fail operation outputs information
	 */
	public void modifyID(String name, int now) {
		boolean flag = false; //Whether students' name is param:name in the system 7
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
		else {
			System.out.println("Note: The student information was not found");
		}
	}
	
	/**
	 * ${Delete student information whose name is param: name}
	 * @param name: the student's name
     * @note: A successful or fail operation outputs information
	 */
	public void delete(String name) {
		System.out.println(name + ":");
		//student tmp[] = new student[25]; 57
		student tmp[] = new student[maxn];
		int r = 0; //The total number of students not on the deleted list 7
		boolean flag = false; // //Whether students' name is param:name in the system 7
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
		tmp = null; // 29
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
	
	/**
	 * ${Run the system}
     * @note: A successful or fail operation outputs information
	 */
	public void apply() {
		Scanner cin = new Scanner(System.in);
		manu();
		while(cin.hasNextInt()) {
			int op = cin.nextInt();
			if(op < 1 || op > 6) {
				System.out.println("Note: The number is illegal.");
				continue;
			}
			if(op == 1) {
				if(tot == limit) {
					System.out.println("Note: Exceed the limit of the number of students.");
					//continue; 60
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
						//if(gd == 0) insert(id, nm, bd, false);
						//else insert(id, nm, bd, true);
						// 18
						if(gd == 0) {
							insert(id, nm, bd, false);
						} else {
							insert(id, nm, bd, true);
						}
					} else {
						System.out.println("Note: This ID has been stored.");
					}
				}
			} else if(op == 2) {
				//Support for finding multiple names, results in input order
				System.out.println("Note: Please input the number of students to look for(don't exceed 20)");
				int t = cin.nextInt();
				//56
				if(t <= 0 || t > limit) {
					System.out.println("Error: the number is in the range.");
				} else {
					System.out.println("Note: Please input students' name who will be searched in turn");
					//String tmp[] = new String[25]; 57
					String tmp[] = new String[maxn];
					for(int i = 0; i < t; i++) {
						tmp[i] = cin.next();
					}
					for(int i = 0; i < t; i++) {
						search(tmp[i]);
					}
					tmp = null; // 29 41
				}
				
			} else if(op == 3) {
				//Support for deleting multiple names, results in input order
				System.out.println("Note: Please input the number of students to delete(don't exceed 20)");
				int t = cin.nextInt();
				// 56
				if(t <= 0 || t > limit) {
					System.out.println("Error: the number is in the range.");
				} else {
					System.out.println("Note: Please input students' name who will be deleted in turn");
				    //String tmp[] = new String[25]; 57
					String tmp[] = new String[maxn];
					for(int i = 0; i < t; i++) {
						tmp[i] = cin.next();
					}
					for(int i = 0; i < t; i++) {
						delete(tmp[i]);
					}
					tmp = null; // 29 41
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
				//output(); 1
				outPut();
			} else {
				exit();
			} // op = 1~6 end 6 36

			manu();
		} //while end 6
		cin.close(); //26 41
	} //apply() end 6
} //class end 6
