package Script;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Location {

	public static void main(String[] args) throws InterruptedException  {
		
        WebDriverManager.chromedriver().setup();
		
        askdefault();
        allow();
        block();
	}
	
	public static void askdefault() throws InterruptedException {
		// Scenario 1: Reset or ask default Geoloaction/Location permissions
        ChromeOptions Options = new ChromeOptions();
        
        HashMap<String, Object> Prefs = new HashMap<>();
        
        Prefs.put("profile.default_content_setting_values.geoloaction", 0);
        
        Options.setExperimentalOption("prefs", Prefs);

        generic_script(Options);
	}
	
	public static void allow() throws InterruptedException {
		// Scenario 2: Allow Geoloaction permissions
        ChromeOptions Options = new ChromeOptions();
        
        HashMap<String, Object> Prefs = new HashMap<>();
        
        Prefs.put("profile.default_content_setting_values.geoloaction", 1);
        
        Options.setExperimentalOption("prefs", Prefs);

        generic_script(Options);
	}
	
	public static void block() throws InterruptedException  {
		// Scenario 3: Block Geoloaction permissions
        ChromeOptions Options = new ChromeOptions();
        
        HashMap<String, Object> Prefs = new HashMap<>();
        
        Prefs.put("profile.default_content_setting_values.geoloaction", 2);
        
        Options.setExperimentalOption("prefs", Prefs);

        generic_script(Options);
	}
	
	public static void generic_script( ChromeOptions Options) throws InterruptedException {
		WebDriver driver = new ChromeDriver(Options);
        
        driver.manage().window().maximize();
        
        driver.get("https://permission.site/");
        
        driver.findElement(By.id("location")).click();
        
        Thread.sleep(2000);
        
        driver.quit();
	}
}
