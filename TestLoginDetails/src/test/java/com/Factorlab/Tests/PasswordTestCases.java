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
	
	//This is the test case to verify the validation message when we try to login with a Blank password and click on the "Sign In" button.
	@Test (priority=7)
	public void BlankUserValidationMsgClickContinue() throws InterruptedException, IOException {
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
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(2).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("login-password")).sendKeys("        ");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[3]/button[1]")).click();
		Thread.sleep(1000);
		
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Please enter a valid password.']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 7: We are able to verify the validation message when we login with a Blank password and click on the sign in button");
		}
					 
		else
			System.out.println("We are unable to verify the validation message when we login with a Blank password and click on the sign in button");
		driver.quit();
	}
	
	//This is the test case to verify the validation message when we try to login with a Blank password and and hit the enter button.
	@Test (priority=8)
	public void BlankUserValidationMsgHitEnter() throws InterruptedException, IOException {
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
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(2).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("login-password")).sendKeys("        ");
		Thread.sleep(1000);
		driver.findElement(By.id("login-password")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Please enter a valid password.']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 8: We are able to verify the validation message when we login with a Blank password and hit the enter button");
		}
		else
			System.out.println("We are unable to verify the validation message when we login with a Blank password and hit the enter button");
		driver.quit();
	}
	
	//This is the test case to verify that we are able to clear the password text box field.
	@Test (priority=9)
	public void ValidateClearPassword() throws InterruptedException, IOException {
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
		driver.findElement(By.id("login-password")).clear();
		Thread.sleep(1000);
		System.out.println("Test Case 9: We are able to clear the password text box field");
		driver.quit();
	}
	
	//This is the test case to verify that we are able to click on the "Forgot Password" text and get redirected to the next section to enter the email address or username.
	@Test (priority=10)
	public void ClickForgotPasswordText() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		String result=null;
		try
		{
			Boolean isLoggedIn=driver.findElement(By.xpath("/html/body/app-root/app-forgot-password/div/div[2]/div/div[2]/div[1]/p")).isDisplayed();
			if(isLoggedIn==true)
			{
				result="PASS";
			}
			System.out.println("Test Case 10: We are able to click on the Forgot Password text and get redirected to the next section to enter the email address");
		}
		catch(Exception e)
		{
			Boolean isError=driver.findElement(By.xpath("//*[text()='Please enter a valid password.']")).isDisplayed();
			if(isError==true)
			{
				result="FAIL";
			}
			System.out.println("Test Case 10: We are unable to validate the Forgot Password text");
			Thread.sleep(1000);
		}
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to click on the "Email" radio button.
	@Test (priority=11)
	public void ClickEmailRadioButton() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("useremailradio")).click();
		System.out.println("Test Case 11: we are able to click on the Email radio button on the Forgot Password page");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to click on the "Email" radio button and enter a valid email address and click on the "Submit" button.
	@Test (priority=12)
	public void EmailRadioButtonValidEmailSubmit() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("useremailradio")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		System.out.println("Test Case 12: We are able to click on the Email radio button and enter a valid email address and click on the Submit button.");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to click on the "Email" radio button and enter a valid email address and hit the enter button.
	@Test (priority=13)
	public void EmailRadioButtonValidEmailEnter() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("useremailradio")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(Keys.ENTER);
		System.out.println("Test Case 13: We are able to click on the Email radio button and enter a valid email address and hit the enter button.");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to click on "Email" radio button and enter invalid email address and click on "Submit" button.
	@Test (priority=14)
	public void EmailRadioButtonInValidEmailSubmit() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("useremailradio")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		System.out.println("Test Case 14: We are able to click on the Email radio button and enter a invalid email address and click on the Submit button.");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to click on "Email" radio button and enter invalid email address and hit enter button.
	@Test (priority=15)
	public void EmailRadioButtonInValidEmailEnter() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("useremailradio")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(Keys.ENTER);
		System.out.println("Test Case 15: We are able to click on the Email radio button and enter a invalid email address and hit the enter button.");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to click on the "Email" radio button and leave the email address field blank and click on the "Submit" button.
	@Test (priority=16)
	public void EmailRadioButtonBlankEmailSubmit() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("useremailradio")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("    ");
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		System.out.println("Test Case 16: We are able to click on the Email radio button and leave the email address field blank and click on the Submit button");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to click on the "Email" radio button and leave the email address field blank and hit the enter button.
	@Test (priority=17)
	public void EmailRadioButtonBlankEmailEnter() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("useremailradio")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys(Keys.ENTER);
		System.out.println("Test Case 17: We are able to click on the Email radio button and leave the email address field blank and hit the enter button.");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to click on the "Username" radio button.
	@Test (priority=18)
	public void ClickUsernameRadioButton() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("useremailradio")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("usernameradio")).click();
		Thread.sleep(1000);
		System.out.println("Test Case 18: we are able to click on the Username radio button on the Forgot Password page");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to click on the "Username" radio button and enter valid username and click on the "Submit" button.
	@Test (priority=19)
	public void UsernameRadioButtonValidUsernameSubmit() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys(sheet.getRow(4).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		System.out.println("Test Case 19: We are able to click on the Username radio button and enter valid username and click on the Submit button.");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to click on the "Username" radio button and enter valid username and hit enter button.
	@Test (priority=20)
	public void UsernameRadioButtonValidUsernameEnter() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys(sheet.getRow(4).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		System.out.println("Test Case 20: We are able to click on the Username radio button and enter valid username and hit enter button.");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to validate the message "We've sent you an email with a link to reset your password. Please check your email." when we enter valid username and click on the "Submit" button.
	@Test (priority=21)
	public void UsernameRadioButtonValidUsernameValidateMsgSubmit() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys(sheet.getRow(4).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-forgot-password/div/div[2]/div/div[2]/form/div/div/button")).click();
		Thread.sleep(1000);
		System.out.println("Test Case 21: We are able to validate the message We've sent you an email with a link to reset your password. Please check your email. when we enter valid username and click on the Submit button.");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to validate the message "We've sent you an email with a link to reset your password. Please check your email." when we enter valid username and hit enter button.
	@Test (priority=22)
	public void UsernameRadioButtonValidUsernameValidateMsgEnter() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys(sheet.getRow(4).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-forgot-password/div/div[2]/div/div[2]/form/div/div/button")).click();
		Thread.sleep(1000);
		System.out.println("Test Case 22: We are able to validate the message We've sent you an email with a link to reset your password. Please check your email. when we enter valid username and hit enter button.");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to click on the "Username" radio button and enter invalid username and click on the "Submit" button.
	@Test (priority=23)
	public void UsernameRadioButtonInvalidusernameSubmit() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		System.out.println("Test Case 23: We are able to click on the Username radio button and enter invalid username and click on the Submit button.");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to click on the "Username" radio button and enter invalid username and hit enter button.
	@Test (priority=24)
	public void UsernameRadioButtonInvalidusernameEnter() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		System.out.println("Test Case 24: We are able to click on the Username radio button and enter invalid username and hit enter button");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to validate the message "This username does not exist" when we give invalid username and click on the "Submit" button.
	@Test (priority=25)
	public void UsernameRadioButtonValidateMsgSubmit() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='This username does not exist']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 25: We are able to validate the message This username does not exist when we give invalid username and click on the Submit button");
		}
		else
		System.out.println("We are unable to verify the validation message");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to validate the message "This username does not exist" when we give invalid username and hit the enter button.
	@Test (priority=26)
	public void UsernameRadioButtonValidateMsgEnter() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='This username does not exist']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 26: We are able to validate the message This username does not exist when we give invalid username and hit the enter button");
		}
		else
		System.out.println("We are unable to verify the validation message");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to click on the "Username" radio button and leave the username field blank and click on the "Submit" button.
	@Test (priority=27)
	public void UsernameRadioButtonBlankUserSubmit() throws InterruptedException, IOException {
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
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("    ");
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		System.out.println("Test Case 27: We are able to click on the Username radio button and leave the username field blank and click on the Submit button");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to click on the "Username" radio button and leave the username field blank and hit the enter button.
	@Test (priority=28)
	public void UsernameRadioButtonBlankUserEnter() throws InterruptedException, IOException {
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
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("    ");
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		System.out.println("Test Case 28: We are able to click on the Username radio button and leave the username field blank and hit the enter button.");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to validate the message "Username must not be empty" when we leave the username field blank and click on the "Submit" button.
	@Test (priority=29)
	public void UsernameRadioButtonBlankUserValidateMsgSubmit() throws InterruptedException, IOException {
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
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("    ");
		Thread.sleep(1000);
		driver.findElement(By.id("submit")).click();
		Thread.sleep(1000);
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Username must not be empty']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 29: We are able to validate the message Username must not be empty when we leave the username field blank and click on the Submit button.");
		}
		else
		System.out.println("We are unable to verify the validation message");
		driver.quit();
	}
	
	//This is the test case to verify that when we are on the "Forgot Password" page, we are able to validate the message "Username must not be empty" when we leave the username field blank and hit the enter button.
	@Test (priority=30)
	public void UsernameRadioButtonBlankUserValidateMsgEnter() throws InterruptedException, IOException {
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
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[2]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("    ");
		Thread.sleep(1000);
		driver.findElement(By.id("username")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Username must not be empty']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 30: We are able to validate the message Username must not be empty when we leave the username field blank and hit the enter button.");
		}
		else
		System.out.println("We are unable to verify the validation message");
		driver.quit();
	}
}














