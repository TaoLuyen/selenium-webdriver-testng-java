package javaTester;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Topic_01_Data_Type {
	
	public static void main(String[] args)
	{
		// Kiểu dữ liệu
		
		// Khai báo biến
		int studentNumber;
		studentNumber = 100;
		
		int teacherNumber = 20;
		boolean studentSex = true;
		byte bEmployee = 100;
		
		short sEmployee = 10;
		long lEmployee = 10000;
		
		float fEmployee = 7.5f;
		
		double dEmployee = 8.4d; 
		
		char c = '8';
		
		
		
		
		//I - Kiểu Nguyên thủy
		// bool
		
		// số nguyên
		
		// byte
		
		// short
		
		// int
		
		// long
		
		// Số thực float, double
		
		// float
		float fSalary = 7.5f;
		
		// double
		double dPoint = 8.4d; 
		// char - kí tự
		
		
		
		// II - Tham chiếu reference
		// kiểu 
		// Array
		int[] studentNumbers = {15, 50, -34, 19};
		String[] studentNames = {"Nguyen Van S", "Tran Van B"};
		// Class/ Interface
		//WebDriver driver = new ChromeDriver();
		
		//Actions action = new Actions(driver);
		
		// Collection: List(Arraylist, Linkedlist) / Set / Queue
		ArrayList<String> studentCountry = new ArrayList<String>();
		
		// Object
		// Ép kiểu dữ liệu: (ép kiểu ngầm định, và ép kiểu tường minh)
		Object phone;
		
		// String
		String studentName = "B";
		String companyName = "B 2022 @copyright";
		
		
		String a = "Hoang";
		System.out.println(a);
		System.out.println("//");
		
		
		String b= a;
		System.out.println(a);
		System.out.println(b);
		System.out.println("//");
		
		
		b= "An";
		a = b;
		System.out.println(a);
		System.out.println(b);
		
		
		List<Integer> istudentNumber = new ArrayList<Integer>();
		Set<Integer> setStudentNumber = new LinkedHashSet<>();
	}
	

	
	
	
}
