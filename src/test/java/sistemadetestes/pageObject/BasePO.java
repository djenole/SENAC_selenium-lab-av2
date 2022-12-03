package sistemadetestes.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//Está classe funciona como base para outras PO, logo as outras PO vão ter herança dessa
public abstract class BasePO {

	//Driver base 
	protected WebDriver driver;
	
	//Construtor base para a criação da fábrica de elementos (PageFactory)	 
	public BasePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}