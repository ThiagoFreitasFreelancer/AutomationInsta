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
        delay(6);

    }

    @Test
    public void createPublishTest() throws Exception {

        delay(3);
        insta.pressBtnCriar();
        delay(3);
        insta.pressBtnPostar();
        delay(3);
        insta.fillInputImagLocal();
        delay(3);
        insta.pressBtnNext();
        delay(3);
        insta.pressBtnNext();
        delay(3);
        insta.fillInputLegend();
        delay(3);
        insta.pressBtnPublish();
        delay(15);

    }

}