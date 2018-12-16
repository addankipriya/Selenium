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
			driver.get("file:\\"+System.getProperty("user.dir")+"\\SampleTable.html");
			
			WebElement webTable = driver.findElement(By.xpath("//table"));
			List<WebElement> tr = webTable.findElements(By.xpath("//table/tbody/tr"));
			int highestNum=0;
			int rowNo = 0;
				List<WebElement> td = tr.get(0).findElements(By.xpath("//table/tbody/tr/td[3]"));
				for(int r=0; r<td.size(); r++) {
					if(highestNum<Integer.parseInt(td.get(r).getText())) {
						highestNum=Integer.parseInt(td.get(r).getText());
						rowNo=r;
					}
				}
			
			System.out.println("highestNum:"+highestNum);
			System.out.println("Row No."+rowNo);
			driver.findElement(By.xpath("//table/tbody/tr["+(rowNo+2)+"]/td[4]/input")).click();
			Thread.sleep(5000);
		} catch (InterruptedException|WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}
}
