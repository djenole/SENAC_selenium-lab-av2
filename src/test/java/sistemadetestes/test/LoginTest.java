package sistemadetestes.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sistemadetestes.pageObject.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTest{
	
	private static LoginPO loginPage;
	
	@BeforeClass
	public static void prepararTestes() {
		loginPage = new LoginPO(driver);
	}
	
	@Test
	public void TC001_nãoDeveLogarNoSistemaComEmailESenhaVazios() {
		loginPage.login("", "");
		
		String mensagem = loginPage.getMensage();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void TC002_naoDeveLogarNoSistemaComEmailIncorretoESenhaVazia() {
		loginPage.writeText(loginPage.inputEmail, "teste");
		loginPage.inputPassword.sendKeys("");
		
		loginPage.buttonLogin.click();
		
		String mensagem = loginPage.getMensage();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaIncorreta() {
		loginPage.writeText(loginPage.inputEmail, "");
		loginPage.writeText(loginPage.inputPassword, "teste");
		
		loginPage.buttonLogin.click();
		
		String mensagem = loginPage.getMensage();
		
		assertEquals(mensagem, "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void TC007_deveLogarNoSistemaComEmailESenhaCorretos() {
		loginPage.login("admin@admin.com", "admin@123");
		
		assertEquals(loginPage.getTitlePage(), "Controle de Produtos");
	}
}