package rodoviariapoa.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import rodoviariapoa.ressources.DriverSetUp;
import rodoviariapoa.tasks.LoginTask;
import rodoviariapoa.validationpoints.LoginVerificationPoint;

public class LoginTestCaseWithFireFox {
	private WebDriver driver;
	private LoginTask loginTask;
	private LoginVerificationPoint loginVerificationPoint;

	@Before
	public void setUp() { 
		this.driver = DriverSetUp.getDriverConfigFirefox("https://www.rodoviariaportoalegre.com.br/");
		this.driver.manage().window().maximize();
		this.loginTask = new LoginTask(driver);
		this.loginVerificationPoint = new LoginVerificationPoint(driver);		
	}
	
	@Test
	public void testMain() throws InterruptedException {
		this.loginTask.abrirFormularioDeLogin();
		this.loginTask.preencherFormularioDeLogin("j332357@nwytg.com", "1234567a");
		this.loginTask.enviarLogin();
		Thread.sleep(10000);
		this.loginVerificationPoint.verificarMensagemDeSucesso();
	}
	
	@After
	public void tearDown(){
		this.driver.quit();
	}

}
