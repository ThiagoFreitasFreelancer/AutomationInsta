package pageobjects.Redes;

import utils.Browser;
import utils.BaseActionElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utils.Browser.driver;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

public class InstagramPage extends BaseActionElement {

    public String gerarImagemComOpenAI(String prompt) throws Exception {
        String apiKey = System.getenv("API_KEY"); // Coloque sua chave da OpenAI aqui
        URL url = new URL("https://api.openai.com/v1/images/generations");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + apiKey);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);

        JSONObject body = new JSONObject();
        body.put("model", "dall-e-2");
        body.put("prompt", prompt);
        body.put("n", 1);
        body.put("size", "1024x1024");

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = body.toString().getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"))) {
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            JSONObject jsonResponse = new JSONObject(response.toString());
            String imageUrl = jsonResponse.getJSONArray("data").getJSONObject(0).getString("url");
            return imageUrl; // URL da imagem gerada
        } catch (IOException e) {
            // Lê a resposta de erro da API
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"));
            StringBuilder errorResponse = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                errorResponse.append(responseLine.trim());
            }
            throw new IOException("Erro da API OpenAI: " + errorResponse.toString());
        }
    }

    private final String text = "A futuristic and modern Instagram-style image promoting a software house called 'Punk Code Solution'. The design should feature a tech-futuristic or cyberpunk aesthetic, with bold neon colors (purple, black, blue, and magenta), and elements such as digital code, sleek user interfaces, computer screens, and a creative team of developers working together. The logo or brand name 'Punk Code Solution' should be prominently displayed in a bold, tech-style font.\r\n" + //
                "\r\n" + //
                "Incorporate catchy text like:\r\n" + //
                "\r\n" + //
                "\"Transforming Ideas into Code. Ready to Build the Future with Us?\"\r\n" + //
                "\r\n" + //
                "\"Innovative Solutions for a Digital World – Visit punkcodesolution.com.br\"\r\n" + //
                "\r\n" + //
                "\"Let's Create the Next Big Thing. Join Us at punkcodesolution.com.br\"\r\n" + //
                "\r\n" + //
                "\"Where Cutting-Edge Tech Meets Creative Minds. Discover More at punkcodesolution.com.br\"\r\n" + //
                "\r\n" + //
                "The overall vibe should feel innovative, edgy, and high-tech — perfect for a startup tech company. Include a call-to-action to visit the website. Format: square (1:1), Instagram post style.";

    private final String[] textLegend = {"Acesse nosso site: punkcodesolution.com.br",
            "Transformando Ideias em Código. Pronto para Construir o Futuro Conosco?",
            "Soluções Inovadoras para um Mundo Digital – Visite punkcodesolution.com.br",
            "Vamos Criar a Próxima Grande Coisa. Junte-se a Nós em punkcodesolution.com.br",
            "Onde Tecnologia de Ponta Encontra Mentes Criativas. Descubra Mais em punkcodesolution.com.br"};

    

    @FindBy( css = "input[name='username']" )
    private WebElement inputUser;

    @FindBy( css = "input[name='password']" )
    private WebElement inputPasswd;

    @FindBy( css = "button[type='submit']" )
    private WebElement btnLogin;

    @FindBy( css = "button[data-testid=\"close-button\"]" )
    private WebElement btnClose;

    @FindBy( css = "div[style=\"--chat-container-height: 687;\"]" )
    private WebElement inputQuest;

    @FindBy( css = "input[accept=\"image/avif,image/jpeg,image/png,image/heic,image/heif,video/mp4,video/quicktime\"]" )
    private WebElement inputImage;

    @FindBy( css = "div[class=\"html-div xdj266r x14z9mp xat24cr x1lziwak x9f619 x16ye13r xjbqb8w x78zum5 x15mokao x1ga7v0g x16uus16 xbiv7yw xyamay9 xv54qhq x1l90r2v xf7dkkf x1n2onr6 x1plvlek xryxfnj x1c4vz4f x2lah0s xdt5ytf xqjyukv x1qjc9v5 x1oa3qoh xl56j7k\"]" )
    private WebElement btnNext;;

    @FindBy( css = "div[aria-placeholder=\"Escreva uma legenda...\"]" )
    private WebElement inputTexLegend;

    @FindBy( css = "div[class=\"html-div xdj266r x14z9mp xat24cr x1lziwak x9f619 x16ye13r xjbqb8w x78zum5 x15mokao x1ga7v0g x16uus16 xbiv7yw xyamay9 xv54qhq x1l90r2v xf7dkkf x1n2onr6 x1plvlek xryxfnj x1c4vz4f x2lah0s xdt5ytf xqjyukv x1qjc9v5 x1oa3qoh xl56j7k\"]" )
    private WebElement btnPublish;

    public InstagramPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public void pressBtnPublish(){
        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(btnPublish).click().build();
        action.perform();
    }

    public void fillInputLegend() {
        inputTexLegend.sendKeys(textLegend[(int) random(0, textLegend.length - 1)]);
    }

    public void pressBtnNext() {
        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(btnNext).click().build();
        action.perform();
    }

    public void fillInputUser( String text ) { inputUser.sendKeys( text ); }

    public void fillInputPasswd( String text ) { inputPasswd.sendKeys( text ); }

    public void pressBtnLogin() { btnLogin.click(); }

    public void simplifiedLogin( String user, String pass ) throws InterruptedException {
        
        fillInputUser( System.getenv( user ) );
        fillInputPasswd( System.getenv( pass ) );
        pressBtnLogin();
        delay( 10 );

    }

    public void whileTab( ) {
        int i = 0;
        while ( i < 26 ) {
            pressKeyboardTab();
            i++;
        }
    }

    public void fillInputImag() throws Exception {
    // URL da imagem
    //String imageUrl = "https://images.unsplash.com/photo-1506748686214-e9df14d4d9d0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=800&q=60";
    // Caminho local temporário
    String imageUrl = gerarImagemComOpenAI(text);
    // String imageUrl = "https://example.com/path/to/your/image.jpg"; // Substitua pela URL da imagem que você deseja enviar
    String localPath = System.getProperty("java.io.tmpdir") + "upload_instagram.jpg";

    // Baixa a imagem para o disco
    try (InputStream in = new URL(imageUrl).openStream()) {
        Files.copy(in, Paths.get(localPath), StandardCopyOption.REPLACE_EXISTING);
    }

    // Aguarda o input estar visível/interagível (opcional, se necessário)
    // new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(inputImage));

    // Envia o caminho local para o input
    inputImage.sendKeys(localPath);
}

}