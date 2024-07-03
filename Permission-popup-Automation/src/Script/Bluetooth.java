package Script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bluetooth {

	public static void main(String[] args) throws InterruptedException  {
		
        WebDriverManager.chromedriver().setup();
		
        allow();
        block();
	}
		
	public static void allow() throws InterruptedException {
		// Scenario 1: Allow Bluetooth permissions
        ChromeOptions Options = new ChromeOptions();
        
        Options.addArguments("enable-bluetooth");

        generic_script(Options);
	}
	
	public static void block() throws InterruptedException  {
		// Scenario 2: Block Bluetooth permissions
        ChromeOptions Options = new ChromeOptions();
        
        Options.addArguments("--disable-bluetooth");

        generic_script(Options);
	}
	
	public static void generic_script( ChromeOptions Options) throws InterruptedException {
		WebDriver driver = new ChromeDriver(Options);
        
        driver.manage().window().maximize();
        
        driver.get("https://permission.site/");
        
        driver.findElement(By.id("bluetooth")).click();
        
        Thread.sleep(2000);
        
        driver.quit();
	}
}
