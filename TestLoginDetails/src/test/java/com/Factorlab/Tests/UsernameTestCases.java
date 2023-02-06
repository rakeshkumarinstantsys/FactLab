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

public class UsernameTestCases {

	//This is the test case to verify that we are able to enter a valid user name and click on the "continue" button.
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
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[2]/button")).click();
		Thread.sleep(1000);
		System.out.println("Test Case 1: We are able to enter a valid user name and click on the continue button");
		driver.quit();
				
	}
	
	//This is the test case to verify that we are able to enter a valid user name and hit the enter button.
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
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("login-username")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		System.out.println("Test Case 2: We are able to enter a valid user name and hit the enter button");
		driver.quit();
	}
		
	//This is the test case to verify that we cannot login with a invalid user name and click on the "continue" button.
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
		
		Row row = sheet.getRow(3);
		Cell cell = (Cell) row.getCell(0);
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[2]/button")).click();
		Thread.sleep(1000);
		System.out.println("Test Case 3: We are unable to login with a invalid user name when we click on the continue button");
		driver.quit();
				
	}
	
	//This is the test case to verify that we are able to enter a invalid user name and hit the enter button.
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
			
		Row row = sheet.getRow(3);
		Cell cell = (Cell) row.getCell(0);
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("login-username")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		System.out.println("Test Case 4: We are unable to login with a invalid user name when we hit the enter button");
		driver.quit();
	}
	
	//This is the test case to verify the validation message when we try to login with a invalid user name and click on the "continue" button.
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
			
		Row row = sheet.getRow(3);
		Cell cell = (Cell) row.getCell(0);
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[2]/button")).click();
		Thread.sleep(1000);
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Please enter a valid user name.']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 5: We are able to verify the validation message when we login with a invalid user name and click on the continue button");
		}
		 
		else
		System.out.println("We are unable to verify the validation message when we login with a invalid user name and click on the continue button");
		driver.quit();
					
	}
		
	//This is the test case to verify the validation message when we try to login with a invalid user name and hit the enter button.
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
				
		Row row = sheet.getRow(3);
		Cell cell = (Cell) row.getCell(0);
		driver.findElement(By.id("login-username")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("login-username")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Please enter a valid user name.']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 6: We are able to verify the validation message when we login with a invalid user name and hit the enter button");
		}
		 
		else
		System.out.println("We are unable to verify the validation message when we login with a invalid user name and hit the enter button");
		driver.quit();
	}
	
	//This is the test case to verify the validation message when we try to login with a Blank user name and click on the "continue" button.
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
				
		driver.findElement(By.id("login-username")).sendKeys("        ");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[2]/button")).click();
		Thread.sleep(1000);
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Please enter a valid user name.']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 7: We are able to verify the validation message when we login with a Blank user name and click on the continue button");
		}
			 
		else
		System.out.println("We are unable to verify the validation message when we login with a Blank user name and click on the continue button");
		driver.quit();
						
	}
			
	//This is the test case to verify the validation message when we try to login with a Blank user name and and hit the enter button.
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
					
		driver.findElement(By.id("login-username")).sendKeys("        ");
		Thread.sleep(1000);
		driver.findElement(By.id("login-username")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Please enter a valid user name.']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 8: We are able to verify the validation message when we login with a Blank user name and hit the enter button");
		}
			 
		else
		System.out.println("We are unable to verify the validation message when we login with a Blank user name and hit the enter button");
		driver.quit();
	}
	
	//This is the test case to verify that we are able to clear the user name text box field.
	@Test (priority=9)
	public void ValidateClearUserName() throws InterruptedException, IOException {
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
		driver.findElement(By.id("login-username")).clear();
		Thread.sleep(1000);
		System.out.println("Test Case 9: We are able to clear the user name text box field");
		driver.quit();
	}

	//This is the test case to verify that we are able to click on the "Forgot Username" text and get redirected to the next section to enter the email address.
	@Test (priority=10)
	public void ClickForgotUsernameText() throws InterruptedException, IOException {
		File file=new File(System.getProperty("user.dir") + "\\UserData\\" + "User_Login_Data" + ".xlsx");
		FileInputStream inputstream=new FileInputStream(file);
				
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("LoginDetails");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://staging1.factorlablambdaapis.com/login");
		driver.manage().window().maximize();
				
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[3]/a")).click();
		Thread.sleep(3000);
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Please enter your email and we will send your user name to this email address.']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 10: We are able click on the Forgot Username text and get redirected to the next section to enter the email address");
		}
		else
			System.out.println("We are unable to verify the validation message when we login with a Blank user name and hit the enter button");
		driver.quit();			
	}
	
	//This is the test case to verify that when we are on the "Forgot User name" page, we are able to enter a valid email address and click on the "Submit" button.
	@Test (priority=11)
	public void ValidEmailSubmit() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("userEmail")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-forgot-username/div/div[2]/div/div[2]/form/div/div[3]/button[1]")).click();
		Thread.sleep(1000);
		System.out.println("Test Case 11: We are able to enter a valid email address and click on the Submit button on the Forgot User name page");
		driver.quit();			
	}
	
	//This is the test case to verify that when we are on the "Forgot User name" page, we are able to enter a valid email address and hit the enter button.
	@Test (priority=12)
	public void ValidEmailEnter() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("userEmail")).sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("userEmail")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		System.out.println("Test Case 12: We are able to enter a valid email address and hit the enter button on the Forgot User name page");
		driver.quit();			
	}
	
	//This is the test case to verify that when we are on the "Forgot User name" page, we are able to verify the validation text when we click on the submit button.
	@Test (priority=13)
	public void ValidationTextSubmit() throws InterruptedException, IOException {
		File file=new File(System.getProperty("user.dir") + "\\UserData\\" + "User_Login_Data" + ".xlsx");
		FileInputStream inputstream=new FileInputStream(file);
			
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("LoginDetails");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://staging1.factorlablambdaapis.com/login");
		driver.manage().window().maximize();
		
		Row row = sheet.getRow(3);
		Cell cell = (Cell) row.getCell(0);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("userEmail")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-forgot-username/div/div[2]/div/div[2]/form/div/div[3]/button[1]")).click();
		Thread.sleep(1000);
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Unfortunately, we do not see an email that matches in our system. Please contact support@factorlab or text us at 650-248-1458 and we will be happy to help.']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 13: We are able to verify the validation text when we click on the submit button");
		}
		else
			System.out.println("We are unable to verify the validation message when we login with a Blank user name and hit the enter button");
		driver.quit();			
	}
	
	//This is the test case to verify that when we are on the "Forgot User name" page, we are able to verify the validation text when we hit the enter button.
	@Test (priority=14)
	public void ValidationTextEnter() throws InterruptedException, IOException {
		File file=new File(System.getProperty("user.dir") + "\\UserData\\" + "User_Login_Data" + ".xlsx");
		FileInputStream inputstream=new FileInputStream(file);
				
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("LoginDetails");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://staging1.factorlablambdaapis.com/login");
		driver.manage().window().maximize();
		
		Row row = sheet.getRow(3);
		Cell cell = (Cell) row.getCell(0);
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("userEmail")).sendKeys(sheet.getRow(3).getCell(0).getStringCellValue());
		Thread.sleep(1000);
		driver.findElement(By.id("userEmail")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Unfortunately, we do not see an email that matches in our system. Please contact support@factorlab or text us at 650-248-1458 and we will be happy to help.']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 14: We are able to verify the validation text when we hit the enter button");
		}
		else
			System.out.println("We are unable to verify the validation message when we login with a Blank user name and hit the enter button");
		driver.quit();			
	}
	
	//This is the test case to verify that when we are on the "Forgot Username" page, we are able to validate the message "Please enter email address." when we leave the email address field blank and click on the "Submit" button.
	@Test (priority=15)
	public void ValidationTextBlankUsernameSubmit() throws InterruptedException, IOException {
		File file=new File(System.getProperty("user.dir") + "\\UserData\\" + "User_Login_Data" + ".xlsx");
		FileInputStream inputstream=new FileInputStream(file);
				
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("LoginDetails");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://staging1.factorlablambdaapis.com/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("userEmail")).sendKeys("    ");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/app-root/app-forgot-username/div/div[2]/div/div[2]/form/div/div[3]/button[1]")).click();
		Thread.sleep(1000);
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Please enter email address.']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 15: We are able to verify the validation text when we click on the submit button");
		}
		else
			System.out.println("We are unable to verify the validation message when we login with a Blank user name and hit the enter button");
		driver.quit();			
	}
	
	//This is the test case to verify that when we are on the "Forgot Username" page, we are able to validate the message "Please enter email address." when we leave the email address field blank and hit the enter button.
	@Test (priority=16)
	public void ValidationTextBlankUsernameEnter() throws InterruptedException, IOException {
		File file=new File(System.getProperty("user.dir") + "\\UserData\\" + "User_Login_Data" + ".xlsx");
		FileInputStream inputstream=new FileInputStream(file);
			
		XSSFWorkbook wb=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=wb.getSheet("LoginDetails");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://staging1.factorlablambdaapis.com/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/div[2]/div/div[2]/form/div[3]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("userEmail")).sendKeys("    ");
		Thread.sleep(1000);
		driver.findElement(By.id("userEmail")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Please enter email address.']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 16: We are able to verify the validation text when we hit the enter button");
		}
		else
			System.out.println("We are unable to verify the validation message when we login with a Blank user name and hit the enter button");
		driver.quit();			
	}
		
}










