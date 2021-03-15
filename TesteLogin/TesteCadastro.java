package TesteLogin;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteCadastro{
	
WebDriver driver;

	@Before
	public void  setUp() throws Exception {	
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\msilva16\\AppData\\Local\\Temp\\7zOC3F364A9\\chromedriver.exe");
		  driver = new ChromeDriver();
	}

	
	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		java.util.Date date = new java.util.Date();
		return dateFormat.format(date);
		
	
	}
	
			@Test	
			public void test() throws IOException {
				driver.get("https://br.linkedin.com");
				driver.findElement(By.linkText("Cadastre-se agora")).click();
				driver.findElement(By.name("email-or-phone")).sendKeys("tt8601778@gmail.com");
				driver.findElement(By.name("password")).sendKeys("11111111");
				driver.findElement(By.id("join-form-submit")).click();
				

				//Screenshot
					TakesScreenshot ts=(TakesScreenshot)driver;
					File source =ts.getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(source, new File("./Screenshot/LinkedInCadastro.png"+getDate()));
					
					System.out.println("Screenshot taken");
					
					//Fechando o browser
					driver.quit();	
				
				
	
	
			}
	
}