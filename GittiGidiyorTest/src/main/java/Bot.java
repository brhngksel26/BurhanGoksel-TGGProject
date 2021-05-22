import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Random;


public class Bot {
    WebDriver driver;
    String price;
    String basketPrice;

    public void openDriver(){
        System.setProperty("webdriver.firefox.driver","C:/Users/burha/IdeaProjects/GittiGidiyorProjec");
        driver = new FirefoxDriver();
        driver.get("https://www.gittigidiyor.com/");
    }

    public void login()  {
        String username = "your_username";
        String password = "your_password";
        try{
            driver.findElement(By.xpath("//*[@class='gekhq4-4 egoSnI']")).click();
            driver.findElement(By.xpath("//*[@class='sc-12t95ss-3 fDarBX']")).click();
            driver.findElement(By.id("L-UserNameField")).sendKeys(username);
            driver.findElement(By.id("L-PasswordField")).sendKeys(password);
            driver.findElement(By.id("gg-login-enter")).click();
            Thread.sleep(1500);
        }catch (InterruptedException exception) {
            exception.printStackTrace();
        }

    }

    public void searchAnd2page()  {
        try {
            driver.findElement(By.xpath("//*[@class='sc-4995aq-0 sc-14oyvky-0 gHqOYK']")).sendKeys("bilgisayar");
            Thread.sleep(1500);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@class='qjixn8-0 sc-1bydi5r-0 hKfdXF']")).click();
        String url = driver.getCurrentUrl();
        url = url + "&sf=2";
        driver.get(url);
    }


    public void selectProduct(){
        List<WebElement> page2products;
        page2products = driver.findElements(By.cssSelector(".catalog-view.products-container > li"));

        Random random = new Random();
        int randomSelect  = random.nextInt(page2products.size());
        page2products.get(randomSelect).click();
        price = driver.findElement(By.id("sp-price-highPrice")).getText();
        System.out.println(price);
      //  driver.findElement(By.xpath("//*[@class='control-button gg-ui-button plr10 gg-ui-btn-default']")).click();
        driver.findElement(By.id("add-to-basket"));
    }
    public void goBasket(){

        try {
            driver.get("https://www.gittigidiyor.com/sepetim");
            Thread.sleep(1500);
            basketPrice = driver.findElement(By.cssSelector(".total-price")).getText();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }


        if(basketPrice.equals(price)){System.out.println("Fiyatlar Eşit");}
        else{System.out.println("Fiyatlar Eşit Değil");}


        try {
            driver.findElement(By.tagName("select")).click();
            driver.findElement(By.cssSelector("option[value='2']")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//*[@class='btn-delete btn-update-item']")).click();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }


        if (driver.findElement(By.xpath("//*[@class='gg-w-24 gg-d-21 gg-t-24 gg-m-24']]")).getText() != null){
            System.out.println("Sepet Boşaltıldı");
        }

        driver.close();

    }



}
