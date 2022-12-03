package sistemadetestes.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

	@FindBy(id = "email")
	public WebElement inputEmail;//variável de localização: id do elemento e o que ele simboliza
	
	@FindBy(id = "senha")
	public WebElement inputPassword;//variável de localização: id do elemento e o que ele simboliza
	
	@FindBy(id = "btn-entrar")
	public WebElement buttonLogin;//variável de localização: id do elemento e o que ele simboliza
	
	@FindBy(css = "form.form-login>div.alert>span")
	public WebElement spanMensagem;//obter mensagem pelo localizador do css
	
	
	public LoginPO(WebDriver driver) {//Criação de construtor e instanciação @param driver será o "bot" desta página//
		super(driver);
	}
	
	public String getMensage() {
		return this.spanMensagem.getText();
	}
	
	public void writeText(WebElement input, String text) {
		input.clear();
		input.sendKeys(text + Keys.TAB);
	}
	
	public String getTitlePage() {
		return driver.getTitle();
	}

	 //Metodo para execução de ação de login 
	public void login(String email, String password) {
		writeText(inputEmail, email);
		writeText(inputPassword, password);
		buttonLogin.click();
	}

}
