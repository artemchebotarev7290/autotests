import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SophisticatedWelcomeSite {
    // Заполняю все поля формы данными
    @Test
    public void testHello1() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Петров Петр Петрович");
        driver.findElement(By.name("email")).sendKeys("test@mail.ru");
        driver.findElement(By.name("phone")).sendKeys("89135557766");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Петров Петр Петрович.\n" +
                "На вашу почту (test@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 89135557766.";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    // Заполняю все поля формы кроме поля "ФИО"
    @Test
    public void testHello2() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("email")).sendKeys("test@mail.ru");
        driver.findElement(By.name("phone")).sendKeys("89135557766");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту (test@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 89135557766.";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    // Заполняю все поля формы кроме поля E-mail
    @Test
    public void testHello3() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Петров Петр Петрович");
        driver.findElement(By.name("phone")).sendKeys("89135557766");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Петров Петр Петрович.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 89135557766.";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    // Заполняю все поля формы кроме поля телефон
    @Test
    public void testHello4() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Петров Петр Петрович");
        driver.findElement(By.name("email")).sendKeys("test@mail.ru");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, Петров Петр Петрович.\n" +
                "На вашу почту (test@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }

    // Оставляю все поля формы пустыми
    @Test
    public void testHello5() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        var actualResult = driver.findElement(By.className("start-screen__res")).getText();
        var expectedResult = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        Assert.assertEquals(expectedResult, actualResult);
        driver.quit();
    }
}
