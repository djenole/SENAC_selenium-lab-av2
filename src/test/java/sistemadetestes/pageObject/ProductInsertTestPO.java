package sistemadetestes.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductInsertTestPO extends BasePO {

    @FindBy(xpath = "/html/body/div/div[2]/table/thead/tr")
    public WebElement tableHeader;

    @FindBy(xpath = "//*[@id=\"btn-adicionar\"]")
    public WebElement buttonCriar;

    @FindBy(xpath = "//*[@id=\"btn-salvar\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"btn-sair\"]")
    public WebElement exitButton;

    @FindBy(xpath = "//*[@id=\"mensagem\"]")
    public WebElement spanMensagem;

    @FindBy(xpath = "//*[@id=\"codigo\"]")
    public WebElement inputCodigo;

    @FindBy(xpath = "//*[@id=\"nome\"]")
    public WebElement inputNome;

    @FindBy(xpath = "//*[@id=\"quantidade\"]")
    public WebElement inputQuantidade;

    @FindBy(xpath = "//*[@id=\"valor\"]")
    public WebElement inputValor;

    @FindBy(xpath = "//*[@id=\"data\"]")
    public WebElement inputData;

    @FindBy(xpath = "/html/body/div/div[2]/table/tbody/tr")
    public WebElement insertedData;

    @FindBy(xpath = "//*[@id=\"cadastro-produto\"]/div/div/div[1]/h4")
    public WebElement modalTitle;

   
     //metodo de cadastro de produto
    public void cadastrarProduto(String codigo, String nome, String quantidade, String valor, String data){
        this.selectProduct();
        this.writeText(inputCodigo, data); //codigo do produto
        this.writeText(this.inputNome, nome); //nome do produto a ser cadastrado
        this.writeText(this.inputQuantidade, quantidade);//quantidade do produto a ser cadastrada
        this.writeText(this.inputValor, valor);//valor do produto cadastrado
        this.writeText(this.inputData, data);//data de cadastro do produto
        this.saveButton.click();
        this.exitButton.click();
    }

     //Construtor modelo para criação de uma nova instância da página de cadastro do produto
    public ProductInsertTestPO(WebDriver driver){
        super(driver);
    }

     //Método para capturar a primeira coluna de cabeçalho da tabela de cadastro de produto
    public String getFirstHeaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[1]")).getText();
    }


    
    public String getSecondHeaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[2]")).getText();
    }

    ////Método para se capturar a segunda coluna 'Quantidade' cabeçalho da tabela de cadastro de produto
    public String getThirdHeaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[3]")).getText();
    }

    ////Método para se capturar a segunda coluna 'VALUE' cabeçalho da tabela de cadastro de produto
    public String getFourtheaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[4]")).getText();
    }

    //Método para se capturar a segunda coluna 'CREATE DATE' cabeçalho da tabela de cadastro de produto
    public String getFifthHeaderColumn(){
        return tableHeader.findElement(By.xpath("/html/body/div/div[2]/table/thead/tr/th[5]")).getText();
    }

    //Construtor padrão para criação de uma nova instância da página de cadastro do produto
    public void writeText(WebElement input, String text) {
		input.clear();
		input.sendKeys(text);
	}


     //Método responsável por abrir o modal de cadastro de produto
    public void selectProduct(){
        buttonCriar.click();
        buttonCriar.click();
    }

     //Método que captura a mensagem de erro casoo usuário tenta cadastrar um produto com algum valor inválido
    public String getMessage(){
        return spanMensagem.getText();
    }


}
