package com.Factorlab.Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PasswordTestCases {

	//This is the test case to verify that we are able to enter a valid password and click on the "Sign In" button.
	@Test (priority=1)
	public void ValidUserClickContinue() throws InterruptedException, IOException {
		File file=new File(System.getProperty("user.dir") + "\\UserData\\" + "User_Login_Data" + ".xlsx");
		FileInputStream inputstream=new FileInputStream(file);
		
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("LoginDetails");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://staging1.factorlablambdaapis.com/login");
		driver.manage().window().maximize();
		
		Row row = sheet.getRow(1);
		Cell cell = (Cell) row.getCell(0);
		Cell scell = (Cell) row.getCell(1);
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("login-password")).sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[3]/button[1]")).click();
		Thread.sleep(1000);
		
		String result=null;
		try
		{
			Boolean isLoggedIn=driver.findElement(By.xpath("//*[@id=\'navbarHeaderContent\']/ul/li[1]/a")).isDisplayed();
			if(isLoggedIn==true)
			{
				result="PASS";
			}
			System.out.println("Test Case 1: We are able to enter a valid password and click on the sign in button");
		}
		catch(Exception e)
		{
			Boolean isError=driver.findElement(By.xpath("//*[text()='Please enter a valid password.']")).isDisplayed();
			if(isError==true)
			{
				result="FAIL";
			}
			System.out.println("Test Case 1: We are unable to click on the sign in button as the login failed");
			Thread.sleep(1000);
		}
		driver.quit();
	}
	
	//This is the test case to verify that we are able to enter a valid password and hit the enter button.
	@Test (priority=2)
	public void ValidUserHitEnter() throws InterruptedException, IOException {
		File file=new File(System.getProperty("user.dir") + "\\UserData\\" + "User_Login_Data" + ".xlsx");
		FileInputStream inputstream=new FileInputStream(file);
				
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("LoginDetails");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://staging1.factorlablambdaapis.com/login");
		driver.manage().window().maximize();
				
		Row row = sheet.getRow(1);
		Cell cell = (Cell) row.getCell(0);
		Cell scell = (Cell) row.getCell(1);
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("login-username")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("login-password")).sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("login-password")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		String result=null;
		try
		{
			Boolean isLoggedIn=driver.findElement(By.xpath("//*[@id=\'navbarHeaderContent\']/ul/li[1]/a")).isDisplayed();
			if(isLoggedIn==true)
			{
				result="PASS";
			}
			System.out.println("Test Case 2: We are able to enter a valid password and hit the enter button");
		}
		catch(Exception e)
		{
			Boolean isError=driver.findElement(By.xpath("//*[text()='Please enter a valid password.']")).isDisplayed();
			if(isError==true)
			{
				result="FAIL";
			}
			System.out.println("Test Case 2: We are unable to click on the sign in button as the login failed");
			Thread.sleep(1000);
		}
		driver.quit();
	}
	
	//This is the test case to verify that we cannot login with a invalid password and click on the "Sign In" button.
	@Test (priority=3)
	public void InValidUserClickContinue() throws InterruptedException, IOException {
		File file=new File(System.getProperty("user.dir") + "\\UserData\\" + "User_Login_Data" + ".xlsx");
		FileInputStream inputstream=new FileInputStream(file);
				
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("LoginDetails");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://staging1.factorlablambdaapis.com/login");
		driver.manage().window().maximize();
			
		Row row = sheet.getRow(2);
		Cell cell = (Cell) row.getCell(0);
		Cell scell = (Cell) row.getCell(1);
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(2).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("login-password")).sendKeys(sheet.getRow(2).getCell(1).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[3]/button[1]")).click();
		Thread.sleep(1000);
		System.out.println("Test Case 3: We are unable to login with a invalid password and click on the sign in button");
		driver.quit();
	}
	
	//This is the test case to verify that we cannot login with a invalid password and hit the enter button.
	@Test (priority=4)
	public void InValidUserHitEnter() throws InterruptedException, IOException {
		File file=new File(System.getProperty("user.dir") + "\\UserData\\" + "User_Login_Data" + ".xlsx");
		FileInputStream inputstream=new FileInputStream(file);
						
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("LoginDetails");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://staging1.factorlablambdaapis.com/login");
		driver.manage().window().maximize();
					
		Row row = sheet.getRow(2);
		Cell cell = (Cell) row.getCell(0);
		Cell scell = (Cell) row.getCell(1);
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(2).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("login-username")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("login-password")).sendKeys(sheet.getRow(2).getCell(1).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("login-password")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		System.out.println("Test Case 4: We are unable to login with a invalid password and hit the enter button");
		driver.quit();
	}
	
	//This is the test case to verify the validation message when we try to login with a invalid password and click on the "continue" button.
	@Test (priority=5)
	public void InValidUserValidationMsgClickContinue() throws InterruptedException, IOException {
		File file=new File(System.getProperty("user.dir") + "\\UserData\\" + "User_Login_Data" + ".xlsx");
		FileInputStream inputstream=new FileInputStream(file);
					
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("LoginDetails");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://staging1.factorlablambdaapis.com/login");
		driver.manage().window().maximize();
				
		Row row = sheet.getRow(2);
		Cell cell = (Cell) row.getCell(0);
		Cell scell = (Cell) row.getCell(1);
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(2).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("login-password")).sendKeys(sheet.getRow(2).getCell(1).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[3]/button[1]")).click();
		Thread.sleep(1000);
			
		String result=null;
		try
		{
			Boolean isLoggedIn=driver.findElement(By.xpath("//*[@id=\'navbarHeaderContent\']/ul/li[1]/a")).isDisplayed();
			if(isLoggedIn==true)
			{
				result="PASS";
			}
			System.out.println("Test Case 5: We are unable to login with a invalid password and click on the sign in button");
		}
		catch(Exception e)
		{
			Boolean isError=driver.findElement(By.xpath("//*[text()='Please enter a valid password.']")).isDisplayed();
			if(isError==true)
			{
				result="FAIL";
			}
			System.out.println("Test Case 5: We are unable to click on the sign in button as we have entered wrong password");
			Thread.sleep(1000);
		}
		driver.quit();
	}
		
	//This is the test case to verify the validation message when we try to login with a invalid password and hit the enter button.
	@Test (priority=6)
	public void InValidUserValidationMsgHitEnter() throws InterruptedException, IOException {
		File file=new File(System.getProperty("user.dir") + "\\UserData\\" + "User_Login_Data" + ".xlsx");
		FileInputStream inputstream=new FileInputStream(file);
							
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("LoginDetails");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://staging1.factorlablambdaapis.com/login");
		driver.manage().window().maximize();
						
		Row row = sheet.getRow(2);
		Cell cell = (Cell) row.getCell(0);
		Cell scell = (Cell) row.getCell(1);
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(2).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("login-username")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.id("login-password")).sendKeys(sheet.getRow(2).getCell(1).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("login-password")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
			
		String result=null;
		try
		{
			Boolean isLoggedIn=driver.findElement(By.xpath("//*[@id=\'navbarHeaderContent\']/ul/li[1]/a")).isDisplayed();
			if(isLoggedIn==true)
			{
				result="PASS";
			}
			System.out.println("Test Case 6: We are unable to login with a invalid password and hit the enter button");
		}
		catch(Exception e)
		{
			Boolean isError=driver.findElement(By.xpath("//*[text()='Please enter a valid password.']")).isDisplayed();
			if(isError==true)
			{
				result="FAIL";
			}
			System.out.println("Test Case 6: We are unable to hit the enter button as we have entered wrong password");
			Thread.sleep(1000);
		}
		driver.quit();
	}
	
}














