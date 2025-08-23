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
        delay(3);

    }

    @Test
    public void createPublishTest() throws Exception {

        //insta.whileTab();
        delay(3);
        System.out.print("Passou pelos tabs\\n");
        insta.pressBtnCriar();
        delay(3);
        System.out.print("Entrou no Criar\\n");
        insta.pressBtnPostar();
        delay(3);
        System.out.print("Abril modal de criar post\\n");
        insta.fillInputImag();
        delay(3);
        System.out.print("Entro no tab bdo criar\\n");
        insta.pressBtnNext();
        delay(3);
        System.out.print("Entro no tab bdo criar\\n");
        insta.pressBtnNext();
        delay(5);
        System.out.print("Clicou no botao de proximo\\n");
        insta.pressBtnPublish();
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