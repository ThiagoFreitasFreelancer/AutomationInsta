package utils;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import static utils.Browser.*;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.util.Locale;
import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.validation.InvalidStateException;

public class BaseTest {

    /*
     * Generate random CNPJ valid
     */

    private final FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("pt-BR"), new RandomService());

    public String cnpj() {
        CNPJValidator validator = new CNPJValidator();
        CNPJFormatter formatter = new CNPJFormatter();
        Faker faker = new Faker();
        String raw;
        do {
            raw = faker.regexify("\\d{14}");
        } while (!isValidCnpj(raw, validator));
        return formatter.format(raw);
    }

    private boolean isValidCnpj(String raw, CNPJValidator validator) {
        try {
            validator.assertValid(raw);
            return true;
        } catch (InvalidStateException e) {
            return false;
        }
    }

    /*
     * Generate random CEP valid
     */

    public String cep() {
        return fakeValuesService.regexify("\\d{5}-\\d{3}");
    }

    /*
     * Generate random telefone valid
     */
    public String phone() {
        return fakeValuesService.regexify("\\d{11}");
    }
    /*
     * 
     * /*
     * Generate random CPF valid
     */

    public String randomString(int caracterSize) {

        String theAlphaNumericS;
        StringBuilder builder;
        theAlphaNumericS = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
        // create the StringBuffer
        builder = new StringBuilder(caracterSize);

        for (int m = 0; m < caracterSize; m++) {
            // generate numeric
            int myindex = (int) (theAlphaNumericS.length() * Math.random());
            // add the characters
            builder.append(theAlphaNumericS.charAt(myindex));
        }
        return builder.toString();
    }

    public String randomEmail() {

        String name = randomString(10);
        String suffix = "@gmail.com";
        String concatenation = name + randomNumber(1000000, 10000000) + suffix;
        return concatenation;
    }

    public String randomNumber(int min, int max) {

        Random num = new Random();
        int result = num.nextInt((max - min)) + min;
        // Casting int for string
        String resultCastingForString = String.valueOf(result);
        return resultCastingForString;
    }

    public int random(int min, int max) {

        Random num = new Random();
        int result = num.nextInt((max - min)) + min;
        // Casting int for string
        return result;
    }

    public String cpfValidGenerator() throws Exception {

        int type1 = 0, type2 = 0, rest = 0;
        String nDigResult;
        String concatenationNumber;
        String generateNumber;
        Random randomNumber = new Random();

        int n1 = randomNumber.nextInt(10);
        int n2 = randomNumber.nextInt(10);
        int n3 = randomNumber.nextInt(10);
        int n4 = randomNumber.nextInt(10);
        int n5 = randomNumber.nextInt(10);
        int n6 = randomNumber.nextInt(10);
        int n7 = randomNumber.nextInt(10);
        int n8 = randomNumber.nextInt(10);
        int n9 = randomNumber.nextInt(10);

        int sum = n9 * 2 + n8 * 3 + n7 * 4 + n6 * 5 + n5 * 6 + n4 * 7 + n3 * 8 + n2 * 9 + n1 * 10;

        int value = (sum / 11) * 11;

        type1 = sum - value;

        rest = (type1 % 11);

        if (type1 < 2) {
            type1 = 0;
        } else {
            type1 = 11 - rest;
        }

        int sum2 = type1 * 2 + n9 * 3 + n8 * 4 + n7 * 5 + n6 * 6 + n5 * 7 + n4 * 8 + n3 * 9 + n2 * 10 + n1 * 11;

        int value2 = (sum2 / 11) * 11;

        type2 = sum2 - value2;

        rest = (type2 % 11);

        if (type2 < 2) {
            type2 = 0;
        } else {
            type2 = 11 - rest;
        }

        // Concatenação com formatação pontos e traço
        /*
         * concatenationNumber = String.valueOf(n1) + String.valueOf(n2) +
         * String.valueOf(n3) +"." + String.valueOf(n4) +
         * String.valueOf(n5) + String.valueOf(n6) +"."+ String.valueOf(n7)
         * +String.valueOf(n8) +
         * String.valueOf(n9)+"-";
         */

        concatenationNumber = String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4) +
                String.valueOf(n5) + String.valueOf(n6) + String.valueOf(n7) + String.valueOf(n8) +
                String.valueOf(n9);

        nDigResult = String.valueOf(type1) + String.valueOf(type2);

        generateNumber = concatenationNumber + nDigResult;

        return generateNumber;
    }
    /*
     * apply delay in seconds
     */

    public void delay(int num) throws InterruptedException {
        TimeUnit.SECONDS.sleep(num);
    }

    /*
     * return day, month and year current
     */

    public String currentTime() {

        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy/MM/dd");
        return formatarDate.format(data);

    }

    /*
     * return day, month and year current in brazilian format
     */

    public String currentTimeBrazilianFormat() {

        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
        return formatarDate.format(data);

    }

    @Before
    public void startTest() {
        getCurrentDriver();
    }

    @After
    public void finishTest() {
        close();
    }

    public String getCurrentUrl() {
        return getCurrentDriver().getCurrentUrl();
    }

    public void pressTab() {

        Actions action = new Actions(driver);
        Action actions = action.sendKeys(Keys.TAB).build();
        actions.perform();

    }

    private static String shuffleString(String input) {

        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {

            int randomIndex = (int) (Math.random() * charArray.length);
            char temp = charArray[i];
            charArray[i] = charArray[randomIndex];
            charArray[randomIndex] = temp;

        }

        return new String(charArray);

    }

    public static String generateStrongPassword() {

        Faker faker = new Faker();

        String password = faker.regexify("[A-Za-z0-9]{8,}");
        password += faker.regexify("[!@#$%^&*()_-]");
        password += faker.regexify("[A-Z]");
        password += faker.regexify("[0-9]");
        password = shuffleString(password);

        return password;

    }

    public String getTimePerDays(int days) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime dateNow;

        if (days <= 0) {
            dateNow = LocalDateTime.now();
        } else {
            dateNow = LocalDateTime.now().plus(Period.ofDays(days));
        }

        return dateNow.format(formatter);

    }

    // método simples em Selenium para recarregar a página
    public void reloadPage() {
        driver.navigate().refresh();
    }

}
