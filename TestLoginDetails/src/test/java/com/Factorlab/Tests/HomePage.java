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

public class HomePage {

	//This is the test case to verify the "Start" button in the home page.
	@Test (priority=1)
	public void ValidateStartButton() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("/html/body/app-root/app-home/app-signals/div[1]/div/div[2]/ul/li/button")).click();
		Thread.sleep(1000);
		
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='New Observation']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 1: We are able to verify the start button");
		}
		else
			System.out.println("We are unable to verify the start button");
			Thread.sleep(1000);
		driver.quit();
	}
	
	//This is the test case to verify that we are able to click on the "Search" button at the top header bar in the home page.
	@Test (priority=2)
	public void ClickHeaderSearch() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("//*[@id=\"navbarHeaderContent\"]/ul/li[2]/a")).click();
		Thread.sleep(1000);
		
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Select observation for details']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 2: We are able to verify the search button at the top header bar");
		}
		else
			System.out.println("We are unable to verify the search button at the top header bar");
			Thread.sleep(1000);
		driver.quit();
	}
	
	//This is the test case to verify that we are able to click on the "Dashboards" button at the top header bar in the home page.
	@Test (priority=3)
	public void ClickHeaderDashboards() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("//*[@id=\"navbarHeaderContent\"]/ul/li[3]/a")).click();
		Thread.sleep(1000);
			
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Reports']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 3: We are able to verify the Dashboard button at the top header bar");
		}
		else
			System.out.println("We are unable to verify the Dashboard button at the top header bar");
			Thread.sleep(1000);
		driver.quit();
	}
	
	//This is the test case to verify that we are able to click on the "Account" button at the top header bar in the home page.
	@Test (priority=4)
	public void ClickHeaderAccount() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("//*[@id=\"navbarHeaderContent\"]/ul/li[4]/a")).click();
		Thread.sleep(1000);
				
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Account']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 4: We are able to verify the Account button at the top header bar");
		}
		else
			System.out.println("We are unable to verify the Account button at the top header bar");
			Thread.sleep(1000);
		driver.quit();
	}
	
	//This is the test case to verify that we are able to click on the "User" button at the top header bar in the home page.
	@Test (priority=5)
	public void ClickHeaderUser() throws InterruptedException, IOException {
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
		driver.findElement(By.xpath("//*[@id=\"navbarHeaderContent\"]/ul/li[5]/a")).click();
		Thread.sleep(1000);
				
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='User']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 5: We are able to verify the User button at the top header bar");
		}
		else
			System.out.println("We are unable to verify the User button at the top header bar");
			Thread.sleep(1000);
		driver.quit();
	}
		
	//This is the test case to verify that we are able to click on "Archive/Unarchive" button under "Admin" dropdown at the top header bar in the home page.
	@Test (priority=6)
	public void ClickArchiveUnderAdmin() throws InterruptedException, IOException {
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
		driver.findElement(By.id("navbarDropdownAdmin")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarHeaderContent\"]/ul/li[6]/div/a[1]")).click();
		Thread.sleep(1000);
				
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Action']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 6: We are able to verify the Archive/Unarchive button under Admin dropdown at the top header bar");
		}
		else
			System.out.println("We are unable to verify the Archive/Unarchive button under Admin dropdownat the top header bar");
			Thread.sleep(1000);
		driver.quit();
	}
	
	//This is the test case to verify that we are able to click on "Setup Dashboard" button under "Admin" dropdown at the top header bar in the home page.
	@Test (priority=7)
	public void ClickSetupDashboardUnderAdmin() throws InterruptedException, IOException {
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
		driver.findElement(By.id("navbarDropdownAdmin")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarHeaderContent\"]/ul/li[6]/div/a[2]")).click();
		Thread.sleep(1000);
				
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Safety coach limited dashboard']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 7: We are able to verify the Setup Dashboard button under Admin dropdown at the top header bar");
		}
		else
			System.out.println("We are unable to verify the Setup Dashboard button under Admin dropdownat the top header bar");
			Thread.sleep(1000);
		driver.quit();
	}
	
	//This is the test case to verify that we are able to click on "Transcription" button under "Admin" dropdown at the top header bar in the home page.
	@Test (priority=8)
	public void ClickTranscriptionUnderAdmin() throws InterruptedException, IOException {
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
		driver.findElement(By.id("navbarDropdownAdmin")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarHeaderContent\"]/ul/li[6]/div/a[3]")).click();
		Thread.sleep(10000);
				
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Videos List']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 8: We are able to verify the Transcription button under Admin dropdown at the top header bar");
		}
		else
			System.out.println("We are unable to verify the Transcription button under Admin dropdownat the top header bar");
			Thread.sleep(1000);
		driver.quit();
	}
	
	//This is the test case to verify that we are able to click on "Activity Triggers" button under "Admin" dropdown at the top header bar in the home page.
	@Test (priority=9)
	public void ClickActivityTriggersUnderAdmin() throws InterruptedException, IOException {
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
		driver.findElement(By.id("navbarDropdownAdmin")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarHeaderContent\"]/ul/li[6]/div/a[4]")).click();
		Thread.sleep(1000);
				
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Description']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 9: We are able to verify the Activity Triggers button under Admin dropdown at the top header bar");
		}
		else
			System.out.println("We are unable to verify the Activity Triggers button under Admin dropdown at the top header bar");
			Thread.sleep(1000);
		driver.quit();
	}
	
	//This is the test case to verify that we are able to click on "Feedback Trigger" button under "Admin" dropdown at the top header bar in the home page.
	@Test (priority=10)
	public void ClickFeedbackTriggerUnderAdmin() throws InterruptedException, IOException {
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
		Thread.sleep(3000);
		driver.findElement(By.id("navbarDropdownAdmin")).click();
		driver.findElement(By.xpath("//*[@id=\"navbarHeaderContent\"]/ul/li[6]/div/a[5]")).click();
		Thread.sleep(1000);
				
		WebElement validationtext = driver.findElement(By.xpath("//*[text()='Trigger Type']"));
		if(validationtext.isDisplayed())
		{
			System.out.println("Test Case 10: We are able to verify the Feedback Trigger button under Admin dropdown at the top header bar");
		}
		else
			System.out.println("We are unable to verify the Feedback Trigger button under Admin dropdown at the top header bar");
			Thread.sleep(1000);
		driver.quit();
	}
}
