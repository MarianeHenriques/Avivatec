package TesteLogin;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.hamcrest.Description;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestWatchman;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestePerfilUsuario {
	
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
	public void Perfiltest() throws IOException {
		driver.get("https://br.linkedin.com");
		driver.findElement(By.linkText("Entrar")).click();
		driver.findElement(By.name("session_key")).sendKeys("tt8601778@gmail.com");
		driver.findElement(By.name("session_password")).sendKeys("testeteste01");
		driver.findElement(By.cssSelector("button.btn__primary--large.from__button--floating")).click();
		driver.get("https://www.linkedin.com/in/antonio-miranda-14a19b209/");
		Assert.assertEquals("https://www.linkedin.com/in/antonio-miranda-14a19b209/", driver.getCurrentUrl());
	
	//Screenshot
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshot/LinkedInPerfil.png"+getDate()));
		
		System.out.println("Screenshot taken");
		
		//Fechando o browser
		driver.quit();
	
	
	}


}
