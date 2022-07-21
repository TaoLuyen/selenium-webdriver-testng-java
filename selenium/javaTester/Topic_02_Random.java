package javaTester;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Topic_02_Random {
	
	public static void main(String[] args)
	{
		Random rand = new Random();
		
		rand.nextInt();
		
		
		System.out.println(rand.nextInt(9999999));
		System.out.println(rand.nextInt(9999999));
		System.out.println(rand.nextInt(9999999));
		System.out.println(rand.nextInt(9999999));
		System.out.println(rand.nextInt(9999999));
	}
	

	
	
	
}
