package rodoviariapoa.testcases;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import rodoviariapoa.ressources.DriverSetUp;
import rodoviariapoa.tasks.BuscaTask;
import rodoviariapoa.validationpoints.BuscaVerificationPoint;

public class BuscaTestCase {
	private WebDriver driver;
	private BuscaTask buscaTask;
	private BuscaVerificationPoint buscaVerificationPoint;

	@Before
	public void setUp() { 
		this.driver = DriverSetUp.getDriverConfigForChrome("https://www.rodoviariaportoalegre.com.br/");
		this.driver.manage().window().maximize();
		this.buscaTask = new BuscaTask(driver);
		this.buscaVerificationPoint = new BuscaVerificationPoint(driver);		
	}
	
	@Test
	public void testMain() throws InterruptedException {
		this.buscaTask.preencharFormularioDeBusca("Porto Alegre", "Rio de Janeiro", "12/12/2018", "15/12/218");
		this.buscaTask.enviarBusca();
		this.buscaVerificationPoint.verificarMensagemDeSucesso();
	}
	
	@After
	public void tearDown(){
		this.driver.quit();
	}
}
