package com.swaglabs.selenium.login;

import java.util.concurrent.TimeUnit;
import java.util.Random;

//Selenium Package import
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import co.edureka.selenium.basic.basic1;

import org.openqa.selenium.chrome.ChromeDriver;

public class login {
	
	WebDriver driver;
	
	//Select a random user
	public static String getRandomUser(String[] array) {
	        int rndIndex = new Random().nextInt(array.length);
	        return array[rndIndex];
	    }
	
	public void invokeBrowser() {
		
		try {
			
			//Please replace the  location with Chrome driver path
			System.setProperty("webdriver.chrome.driver", "C:\\Saheeda\\107\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.get("https://www.saucedemo.com");
			driver.manage().window().maximize();
			
			//given user list
			String[] usernameArray = new  String[]{"standard_user", "locked_out_user" ,"problem_user"};
		    String userPassword = "secret_sauce";
		    
			//find the username element and set username from above list
			WebElement userName= driver.findElement(By.id("user-name"));
			String selectedUser =getRandomUser(usernameArray);
			System.out.println("Seelcted User:"+ selectedUser );
			userName.sendKeys(selectedUser);
			
			//find the password element and set password value
			WebElement password= driver.findElement(By.id("password"));
			password.sendKeys(userPassword);
			WebElement login= driver.findElement(By.name("login-button"));
			login.click();
			System.out.println("Login");
			
			String redirectUrl= driver.getCurrentUrl();
			System.out.println("Redirected Url:"+redirectUrl);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		login myObj = new login();
		myObj.invokeBrowser();

	}

}
