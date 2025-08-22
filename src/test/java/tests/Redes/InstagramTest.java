package tests.Redes;

import org.junit.Before;
import utils.BaseTest;
import org.junit.Test;
import pageobjects.Redes.InstagramPage;

public class InstagramTest extends BaseTest {

    private final InstagramPage insta = new InstagramPage();

    @Before
    public void setupInitial() throws InterruptedException {

        insta.simplifiedLogin("INSTAGRAM_USER", "INSTAGRAM_PASSWORD");
        System.out.print("Efetuou o login com sucesso!");
        delay(6);

    }

    @Test
    public void createPublishTest() throws Exception {

        insta.whileTab();
        delay(2);
        System.out.print("Passou pelos tabs\\n");
        insta.pressKeyboardEnter();
        delay(2);
        System.out.print("Entrou no Criar\\n");
        insta.pressKeyboardTab();
        delay(2);
        System.out.print("Entro no tab bdo criar\\n");
        insta.pressKeyboardEnter();
        delay(20);
        System.out.print("Abril modal de criar post\\n");
        insta.fillInputImagLocal();
        delay(5);
        System.out.print("Preencheu o input de imagem\\n");
        insta.pressBtnNext();
        delay(5);
        System.out.print("Clicou no botao de proximo\\n");
        insta.pressBtnNext();
        delay(5);
        System.out.print("Clicou no botao de proximo novamente\\n");
        insta.fillInputLegend();
        delay(5);
        System.out.print("Preencheu o input de legenda\\n");
        insta.pressBtnPublish();
        delay(15);
        System.out.print("Clicou no botao de publicar\\n");

    }

}