package TesteLogin;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
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

public class TesteLogin {
	
	WebDriver driver;
	
	@Before
	//Iniciando acesso web
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
		//Teste de login
		driver.get("https://br.linkedin.com");
		driver.findElement(By.linkText("Entrar")).click();
		driver.findElement(By.name("session_key")).sendKeys("tt8601778@gmail.com");
		driver.findElement(By.name("session_password")).sendKeys("testeteste01");
		driver.findElement(By.cssSelector("button.btn__primary--large.from__button--floating")).click();
		
		//Screenshot
				TakesScreenshot ts=(TakesScreenshot)driver;
				File source =ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(source, new File("./Screenshot/LinkedInLogin.png"+getDate()));
				
				System.out.println("Screenshot taken");
				
				//Fechando o browser
				driver.quit();
			
		
	}

	
}