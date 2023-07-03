package APIBaitap;

import java.awt.Choice;
import java.awt.im.InputContext;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class People {
	//attributes
	public String id;
	public String name;
	public String birthday;
	public String phoneNum;
	public String address;
	
	//constructor
	public People() {
	}
	
	//constructor all attributes
	public People(String id, String name, String birthday, String phoneNum, String address) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	
	//get&set attributes
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	//set all attributes
	public void setall(String id, String name, String birthday, String phoneNum, String address) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	
	//input People
	public void inputPeople() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ID: ");
		this.id = sc.nextLine();
		
		System.out.println("Enter Name: ");
		this.name = sc.nextLine();
		
		System.out.println("Enter Birthday: ");
		this.birthday = sc.nextLine();
		
		System.out.println("Enter Phone Number: ");
		this.phoneNum = sc.nextLine();
		
		System.out.println("Enter Address: ");
		this.address = sc.nextLine();
	}
	
	//input File
	public static ArrayList<People> inputFile() {
		ArrayList<People> list = new ArrayList<People>();
		try {
			FileReader fReader = new FileReader("C:\\Users\\Admin\\Desktop\\lib java\\Java\\Apibaitap.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			while(true) {
				String line = bReader.readLine();
				if(line == null || line == "") break;
				String[] temp = line.split("[;]");
				People data = new People(temp[0], temp[1], temp[2], temp[3], temp[4]);
				list.add(data);
			}
			bReader.close();
			fReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//output People
	public void outputPeople() {
		System.out.println("ID: " + getId());
		System.out.println("Name: " + getName());
		System.out.println("Birthday: " + getBirthday());
		System.out.println("Phone Number: " + getPhoneNum());
		System.out.println("Address: " + getAddress());
	}
	
	//output File
		public static void outputFile(ArrayList<People> list) {
			try {
				FileWriter fWriter = new FileWriter("C:\\Users\\Admin\\Desktop\\lib java\\Java\\Apibaitap1.txt");
				BufferedWriter bWriter = new BufferedWriter(fWriter);
				for(People data : list) {
					bWriter.write(data.getId() + ";" + data.getName() + ";" + data.getBirthday() + ";" + data.getPhoneNum() + ";" + data.getAddress());
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
			ArrayList<People> list = new ArrayList<People>();
			while(!exit) {
				System.out.println("Enter your Choice: 1 - Input File , 2 - Output File, 3 - Input and Output from keyboard, 4 - exit");
				int choice = sc.nextInt();
				switch(choice) {
				case 1:
					list = inputFile();
					System.out.println("Input file created. ");
					break;
				case 2:
					outputFile(list);
					System.out.println("Output file created. ");
					break;
				case 3:
					System.out.println("Enter the infomation for People: ");
					inputPeople();
					outputPeople();
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
		 //main
	    public static void main(String[] args) {
	    	  People pp = new People();
	    	  pp.outputMonitor();
	    }
}
