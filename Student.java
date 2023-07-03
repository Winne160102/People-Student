package APIBaitap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends People {
	//constructor all attributes
	public Student(String idStudent, String course, String id, String name, String phoneNum, String birthday, String address) {
		super(id, name, phoneNum, birthday, address);
		this.idStudent = idStudent;
		this.course = course;
	}
	
	//constructor
	public Student() {
		super();
	}
	
	//attributes
	private String idStudent;
	private String course;
	
	//get&set attributes
	public String getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	//set all attributes
	public void setall(String idStudent, String course, String id, String name, String phoneNum, String birthday, String address) {
		super.setall(id, name, phoneNum, birthday, address);
		this.idStudent = idStudent;
		this.course = course;
	}
	
	//input 
	public void inputStudent() {
		Scanner sc = new Scanner(System.in);
		super.inputPeople();
		System.out.println("Enter ID Student: ");
		idStudent = sc.nextLine();
		System.out.println("Enter Course: ");
		course = sc.nextLine();
	}
	
	public void outputStudent() {
		super.outputPeople();
		System.out.println("ID Student: " + getIdStudent());
		System.out.println("Course: " + getCourse());
	}
	
	//input file
	public static ArrayList<Student> inputFileS(){
		ArrayList<Student> list = new ArrayList<Student>();
		try {
			FileReader fReader = new FileReader("C:\\\\Users\\\\Admin\\\\Desktop\\\\lib java\\\\Java\\\\StudentAPI.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			while(true) {
				String line = bReader.readLine();
				if(line == null || line == "") break;
				String[] temp = line.split("[;]");
				Student data = new Student(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
				list.add(data);
			}
			bReader.close();
			fReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//output file
	public static void outputFileS(ArrayList<Student> list){
		try {
			FileWriter fWriter = new FileWriter("C:\\\\Users\\\\Admin\\\\Desktop\\\\lib java\\\\Java\\\\StudentAPI1.txt");
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for(Student data : list) {
				bWriter.write(data.getId() + ";" + data.getName() + ";" + data.getBirthday() + ";" + data.getPhoneNum() + ";" + data.getAddress() + ";" + data.getIdStudent() + ";" + data.course);
				bWriter.newLine();
			}
			bWriter.close();
			fWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//output Monitor
			public void outputMonitor() {
				Scanner sc = new Scanner(System.in);
				boolean exit = false;
				ArrayList<Student> list = new ArrayList<Student>();
				while(!exit) {
					System.out.println("Enter your Choice: 1 - Input File , 2 - Output File, 3 - Input and Output from keyboard, 4 - exit");
					int choice = sc.nextInt();
					switch(choice) {
					case 1:
						list = inputFileS();
						System.out.println("Input file created. ");
						break;
					case 2:
						outputFileS(list);
						System.out.println("Output file created. ");
						break;
					case 3:
						System.out.println("Enter the infomation for Student: ");
						inputStudent();
						outputStudent();
						break;
					case 4:
						exit = true;
						break;
					default: 
						System.out.println("Invalid choice! ");
						break;
					}
				}
			}
}
