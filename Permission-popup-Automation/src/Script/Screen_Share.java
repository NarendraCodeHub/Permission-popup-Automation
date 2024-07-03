package Script;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screen_Share {

	public static void main(String[] args) throws InterruptedException  {
		
        WebDriverManager.chromedriver().setup();
        
        allow();
	}
		
	public static void allow() throws InterruptedException {
		// Scenario : Allow Screen share permissions
        ChromeOptions Options = new ChromeOptions();
        
        Options.addArguments("--auto-select-desktop-capture-source=Entire screen");
       
        generic_script(Options);
	}
		
	public static void generic_script( ChromeOptions Options) throws InterruptedException {
		WebDriver driver = new ChromeDriver(Options);
        
        driver.manage().window().maximize();
        
        driver.get("https://permission.site/");
        
        driver.findElement(By.id("screenshare")).click();
        
        Thread.sleep(2000);
        
        driver.quit();
	}
}
