package utils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import io.github.sukgu.Shadow;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.Browser.driver;

import java.io.File;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Set;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.function.Function;

public class BaseActionElement extends BaseTest {

    static int MAX_TIME = 10; // Define um tempo máximo de espera de 10 segundos.

    public static void pressWebElement(WebElement webElement) {

        Actions action = new Actions(driver);
        executeExplicitWaitElementVisibility(webElement);
        action.moveToElement(webElement).click().build().perform();

    }

    public static void fillInput(WebElement input, String text) {

        Actions action = new Actions(driver);
        executeExplicitWaitElementVisibility(input);
        action.moveToElement(input).build().perform();
        input.clear();
        input.sendKeys(text);

    }

    public static void fillInputOnlyText(String text) {

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .sendKeys(text)
                .build().perform();

    }

    public static String returnWebElementText(WebElement webElement) {
        return webElement.getText();
    }

    public static WebElement getWebElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public static void enterIframe(String text, WebElement xpathIframe, WebElement xpathTextArea)
            throws InterruptedException {

        driver.switchTo().frame(xpathIframe);
        xpathTextArea.clear();
        xpathTextArea.sendKeys(text);
        driver.switchTo().parentFrame();

    }

    public static String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String addDaysToDate(String dateStr, int daysToAdd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(dateStr, formatter);
        LocalDate newDate = date.plusDays(daysToAdd);
        return newDate.format(formatter);
    }

    public static String getCurrentTime() {
        LocalTime currentTime = LocalTime.now();
        return currentTime.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public static String formatDateTime(String dateStr, String timeStr) {
        String dateTimeStr = dateStr + " " + timeStr;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
        return dateTime.format(formatter);
    }

    /*
     * scroll down the page
     */
    public static void scrollDown(String value) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scrollBy(0," + value + ")", "");

    }

    /*
     * scroll até centralizar o elemnto na tela
     */
    public static void goToElement(WebElement element) {

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);

    }

    /*
     * Se determinado elemento estiver visível, método retorna true, se não, retorna
     * false.
     */
    public boolean isElementExisting(WebElement element) {

        try {

            element.isDisplayed();
            return true;

        } catch (NoSuchElementException e) {

            return false;

        }

    }

    /*
     * Confirma se a mensagem está contida em determinado elemento.
     */
    public boolean returnMessage(WebElement element, String message) {

        try {

            Assert.assertTrue(element.getText().contains(message));
            return true;

        } catch (NoSuchElementException e) {

            return false;

        }

    }

    /*
     * Confirma se determinada cadeia de caracteres está contigo na estrutura html.
     */
    public boolean returnElementExistingInHtml(String Element) {

        try {

            Assert.assertTrue(driver.getPageSource().contains(Element));
            return true;

        } catch (NoSuchElementException e) {

            return false;

        }
    }

    public void pressKeyboardTab() {

        Actions actionProvider = new Actions(driver);
        Action keydown = actionProvider.sendKeys(Keys.TAB).build();
        keydown.perform();

    }

    public void pressKeyOneDown() {

        Actions actionProvider = new Actions(driver);
        Action keydown = actionProvider.sendKeys(Keys.DOWN).build();
        keydown.perform();

    }

    public void pressKeyboardTabAsManyTimes(int times) throws InterruptedException {
        Actions actionProvider = new Actions(driver);
        for (int i = 0; i < times; i++) {
            actionProvider.sendKeys(Keys.TAB).perform();
            delay(1);
        }
    }

    public void pressKeyboardBackspace() {

        Actions actionProvider = new Actions(driver);
        Action keyDown = actionProvider.sendKeys(Keys.BACK_SPACE).build();
        keyDown.perform();

    }

    public void pressKeyboardText(String text) {

        Actions actionProvider = new Actions(driver);
        Action keydown = actionProvider.sendKeys(text).build();
        keydown.perform();

    }

    public void pressKeyboardEnter() {

        Actions actionProvider = new Actions(driver);
        Action keydown = actionProvider.sendKeys(Keys.ENTER).build();
        keydown.perform();

    }

    public void pressKeyboardSpace() {

        Actions actionProvider = new Actions(driver);
        Action keydown = actionProvider.sendKeys(Keys.SPACE).build();
        keydown.perform();

    }

    public void pressKeyboardArrowDownEnter() {

        Actions actionProvider = new Actions(driver);
        Action keyDown = actionProvider.sendKeys(Keys.ARROW_DOWN, Keys.ENTER).build();
        keyDown.perform();

    }

    public void pressKeyboardArrowUpEnter() {

        Actions actionProvider = new Actions(driver);
        Action keyDown = actionProvider.sendKeys(Keys.ARROW_UP, Keys.ENTER).build();
        keyDown.perform();

    }

    public void moveToPageUp() {

        Actions actionProvider = new Actions(driver);
        Action move = actionProvider.sendKeys(Keys.PAGE_UP).build();
        move.perform();

    }

    public void pressDisplay() {

        Actions action = new Actions(driver);
        Action esc = action.sendKeys(Keys.ESCAPE).build();
        esc.perform();

    }

    /*
     * essa função faz uma rolagem para baixo na página, muda para um iframe
     * específico,
     * clica em um elemento dentro desse iframe, insere um texto usando o teclado
     * simulado
     * e retorna ao contexto da página principal
     */
    public void fillInputJustification(String text) {

        // exemplo de mapeamento
        String inputJustification = "/html/body/app-root/main-app-component/body/main/div/app-challenge/div/div/app-add/div/div[2]/mat-stepper/div[2]/div[1]/app-add-information/form/div[9]/app-textarea-editor/tinymce/div/div/div[2]/iframe";
        String inputIframe = "/html/body/p";
        WebElement element = driver.findElement(By.xpath(inputIframe));

        scrollDown("300");
        driver.switchTo().frame(inputJustification);
        element.click();
        pressKeyboardText(text);
        driver.switchTo().defaultContent();

    }

    /*
     * Essa implementação permite encontrar um elemento na página da web usando um
     * link
     * XPath fornecido como argumento e retorna o texto contido nesse elemento.
     * Isso pode ser útil para extrair informações específicas de uma página da web
     * com base em seus links XPath correspondentes.
     */
    public String returnSearchResult(String link) {

        WebElement searchResult = driver.findElement(By.xpath(link));
        return searchResult.getText();

    }

    /*
     * essa função é usada para automatizar o preenchimento de formulários que
     * exigem
     * o envio de arquivos específicos
     */
    public void fileAttach() {
        String inputSelectFile = "//*[@id=\'fileDrop\']/input";
        WebElement element = driver.findElement(By.xpath(inputSelectFile));
        File file = new File("C:\\Users\\55779\\Documents\\Testes\\ARQUIVO_PARA_TESTE.pdf");
        element.sendKeys(file.getAbsolutePath());

    }

    /*
     * verifica se um arquivo com um determinado nome existe em um diretório
     * específico.
     * Ele percorre todos os arquivos no diretório e verifica se algum deles
     * corresponde
     * ao nome fornecido.
     */
    public boolean verifyDownload(String directory, String nameArq) {

        File pasteDownload = new File(directory);
        File[] arqDownload = pasteDownload.listFiles();

        for (File arq : arqDownload) {
            if (arq.isFile() && arq.getName().contains(nameArq)) {
                return true;
            }
        }

        return false;

    }

    /*
     * Ela pressiona as teclas de controle e rolagem para baixo,
     * liberando-as em seguida.
     */
    public void scrollPage() throws AWTException {

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_CONTROL);

    }

    /*
     * Implementação de Wait Commands
     * Observe qual método melhor atende a sua necessidade e aplique conforme
     * desejar
     */

    /* Comando usando Implicit Wait */
    public static void executeImplicitWait(int time) {

        // Define um tempo padrão de espera que o WebDriver irá aguardar ao procurar por
        // qualquer elemento na página
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    /* Comandos usando Explicit Wait */

    // Método que aguarda até que um botão seja clicável, passando um Id como
    // parâmetro
    public static void executeExplicitWaitButtonById(String id_button) {

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que um botão seja clicável
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.id(id_button)));
        button.click();

    }

    // Método que aguarda até que um botão seja clicável, passando um WebElement
    // como parâmetro
    public static void executeExplicitWaitButtonByWebElement(WebElement button) {

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que um botão seja clicável
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();

    }

    // Método que aguarda até que o elemento esteja presente no DOM, passando um Id
    // como parâmetro
    public static void executeExplicitWaitElementDOMById(String id_element) {

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que o elemento esteja presente no DOM
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id_element)));

    }

    // Método que aguarda até que o elemento esteja visível (não oculto e com
    // tamanho maior que 0), passando um WebElement como parâmetro
    public static void executeExplicitWaitElementVisibility(WebElement element) {

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que o elemento esteja visível (não oculto e com tamanho maior que
        // 0)
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    // Método que aguarda até que o elemento localizado esteja visível, passando um
    // Id como parâmetro
    public static void executeExplicitWaitElementLocatedVisibilityById(String id_element) {

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que o elemento localizado esteja visível
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id_element)));

    }

    // Método que aguarda até que um texto específico esteja presente no elemento,
    // passando um Id, WebElement e texto como parâmetro
    public static void executeExplicitWaitElementTextToBePresentInElement(WebElement element, String id_element,
                                                                          String text) {

        // Localiza o elemento que contém o texto dinâmico
        element = driver.findElement(By.id(id_element));

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que o 'text' passado por parâmetro esteja presente no elemento
        boolean textAppeared = wait.until(ExpectedConditions.textToBePresentInElement(element, text));

    }

    // Método que aguarda até que um texto esteja presente no elemento localizado,
    // passando um Id e texto como parâmetro
    public static void executeExplicitWaitElementTextToBePresentInElementLocated(String id_element, String text) {

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que o 'text' esteja presente no elemento localizado
        boolean textAppeared = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id(id_element), text));

    }

    // Método que aguarda até que um texto específico esteja presente no elemento,
    // passando um WebElement element e um texto como parâmetro
    public static void executeExplicitWaitElementTextToBePresentInElement(WebElement element, String text) {

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que um 'text' específico esteja presente no 'element'
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));

    }

    // Método que aguarda até que um atributo específico tenha um valor desejado,
    // passando um Id como parâmetro
    public static void executeExplicitWaitAttributeToBe(String id_element) {

        // Localiza o botão que terá seu atributo "disabled" alterado dinamicamente
        WebElement submitButton = driver.findElement(By.id(id_element));

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que o atributo "disabled" do botão seja removido ou alterado para
        // "false"
        wait.until(ExpectedConditions.attributeToBe(submitButton, "disabled", "false"));

    }

    // Método que aguarda até que um atributo contenha um valor específico, passando
    // um WebElement element, attribute e value como parâmetro
    public static void executeExplicitWaitAttributeContains(WebElement element, String attribute, String value) {

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que o atributo do elemento contenha a palavra passada no value
        wait.until(ExpectedConditions.attributeContains(element, attribute, value));

    }

    // Método que aguarda até que um elemento <select> seja selecionado, passando um
    // Id do elemento e a opção selecionada como parâmetro
    public static void executeExplicitWaitElementToBeSelected(String id_element, String option) {

        // Localiza o elemento <select> no DOM
        WebElement dropdown = driver.findElement(By.id(id_element));

        // Cria um objeto Select para manipular o dropdown
        Select select = new Select(dropdown);

        // Seleciona uma opção no dropdown
        select.selectByValue(option);

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que o 'dropdown' tenha uma opção selecionada
        wait.until(ExpectedConditions.elementToBeSelected(dropdown));

    }

    // Método que aguarda até que um elemento tenha o estado de seleção
    // especificado, passando um Id do elemento como parâmetro
    public static void executeExplicitWaitElementSelectionStateToBe(String id_element) {

        // Localiza o checkbox no DOM
        WebElement checkbox = driver.findElement(By.id(id_element));

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que o checkbox esteja selecionado (true)
        wait.until(ExpectedConditions.elementSelectionStateToBe(checkbox, true));

    }

    // Método que aguarda até que um alerta esteja presente na página, passando um
    // Id do elemento como parâmetro
    public static void executeExplicitWaitAlertIsPresent(String id_element) {

        // Localiza e clica no botão que dispara o alerta
        WebElement alertButton = driver.findElement(By.id(id_element));
        alertButton.click();

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que um alerta esteja presente na página
        wait.until(ExpectedConditions.alertIsPresent()).accept();

    }

    // Método que aguarda até que um 'iframe' esteja disponível e muda o foco para
    // ele, passando um Id do elemento como parâmetro
    public static void executeExplicitWaitFrameToBeAvailableAndSwitchToIt(String id_element) {

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que o 'iframe' esteja disponível e alterna para ele
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id(id_element)));

    }

    // Método que aguarda até que um elemento não esteja mais presente no DOM
    // (excluído ou atualizado), passando um Id do elemento como parâmetro
    public static void executeExplicitWaitStalenessOf(String id_element) {

        // Localiza o elemento que será removido
        WebElement loadingElement = driver.findElement(By.id(id_element));

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que o elemento seja removido do DOM
        wait.until(ExpectedConditions.stalenessOf(loadingElement));

    }

    // Método que aguarda até que um elemento esteja invisível, passando um Id do
    // elemento como parâmetro
    public static void executeExplicitWaitInvisibilityOf(String id_element) {

        // Localiza o elemento que será ocultado
        WebElement loadingElement = driver.findElement(By.id(id_element));

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que o elemento fique invisível
        wait.until(ExpectedConditions.invisibilityOf(loadingElement));

    }

    // Método que aguarda até que o elemento localizado esteja invisível, passando
    // um Id do elemento como parâmetro
    public static void executeExplicitWaitInvisibilityOfElementLocated(String id_element) {

        // Localiza o elemento que será ocultado
        WebElement loadingElement = driver.findElement(By.id(id_element));

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que o elemento fique invisível
        wait.until(ExpectedConditions.invisibilityOf(loadingElement));

    }

    // Método que aguarda até que um número específico de elementos esteja presente,
    // passando uma classe e um número de elemento como parâmetro
    public static void executeExplicitWaitNumberOfElementsToBe(String class_name, int number) {

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que exatamente 'number' elementos <div> com a classe 'class_name'
        // estejam presentes no DOM
        wait.until(ExpectedConditions.numberOfElementsToBe(By.className(class_name), number));

    }

    // Método que aguarda até que o número de elemento seja menor que um valor,
    // passando uma classe e um número de elemento como parâmetro
    public static void executeExplicitWaitNumberOfElementsToBeLessThan(String class_name, int number) {

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que existam menos de 'number' elementos <div> com a classe
        // 'class_name' no DOM
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.className(class_name), number));

    }

    // Método que aguarda até que o número de elemento seja maior que um valor,
    // passando uma classe e um número de elemento como parâmetro
    public static void executeExplicitWaitNumberOfElementsToBeMoreThan(String class_name, int number) {

        // Configura o WebDriverWait para aguardar até 'MAX_TIME' segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAX_TIME));

        // Aguarda até que existam mais de 'number' elementos <div> com a classe
        // 'class_name' no DOM
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className(class_name), number));

    }

    /* Comando usando Fluent Wait */

    // Método que aguarda a visibilidade de um elemento com verificação a cada
    // segundos de intervalo, passando o Id do elemento, o intervalo e tempo máximo
    // como parâmetro
    public static void executeFluentWait(String id_element, int max_time, int interval) {

        // Configura o Fluent Wait:
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(max_time)) // Tempo máximo de espera
                .pollingEvery(Duration.ofSeconds(interval)) // Intervalo entre verificações
                .ignoring(NoSuchElementException.class); // Ignora exceções enquanto espera

        // Aguarda até que o elemento com ID id_element esteja visível
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement el = driver.findElement(By.id(id_element));
                if (el.isDisplayed()) {
                    return el;
                } else {
                    return null;
                }
            }
        });
    }

    // método para selecionar uma opção de um select
    public void selectOptionByText(WebElement selectElement, String text) throws InterruptedException {
        Actions actionProvider = new Actions(driver);

        // Clica no elemento select para abrir as opções
        selectElement.click();

        // Digita o texto no campo ativo
        actionProvider.sendKeys(text).perform();

        // Aguarda um curto período para permitir o carregamento da opção correta
        delay(3);

        // Pressiona Enter para selecionar a opção
        actionProvider.sendKeys(Keys.ENTER).perform();
    }

}
