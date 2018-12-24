package com.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try {
			driver.manage().window().maximize();
			driver.get("file:\\"+System.getProperty("user.dir")+"\\SampleTable.html");
			int highestNum=0;
			int rowNo = 0;
			List<WebElement> td = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
			for(int r=0; r<td.size(); r++) {
				if(highestNum<Integer.parseInt(td.get(r).getText())) {
					highestNum=Integer.parseInt(td.get(r).getText());
					rowNo=r;
				}
			}
			System.out.println("highestNum:"+highestNum);
			System.out.println("Row No."+rowNo);
			driver.findElement(By.xpath("//table/tbody/tr["+(rowNo+2)+"]/td[3]/a")).click();
			System.out.println(driver.findElement(By.xpath("//table/tbody/tr["+(rowNo+2)+"]/td[3]/a")).getText());
			Thread.sleep(5000);
		} catch (InterruptedException|WebDriverException e) {
			e.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}
}
