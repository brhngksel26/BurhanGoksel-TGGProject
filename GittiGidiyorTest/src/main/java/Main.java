import java.io.FileWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        long botCreateStart = System.currentTimeMillis();
        Bot bot = new Bot();
        long botCreateFinish = System.currentTimeMillis() - botCreateStart;
        long openDriverStart = System.currentTimeMillis();
        bot.openDriver();
        long openDriverFinish = System.currentTimeMillis() - openDriverStart;
        long loginStart = System.currentTimeMillis();
        bot.login();
        long loginFinish = System.currentTimeMillis() - loginStart;
        long searchAnd2pageStart = System.currentTimeMillis();
        bot.searchAnd2page();
        long searchAnd2pageFinish = System.currentTimeMillis() - searchAnd2pageStart;
        long selectProductStart = System.currentTimeMillis();
        bot.selectProduct();
        long selectProductFinish = System.currentTimeMillis() - selectProductStart;
        long goBasketStart = System.currentTimeMillis();
        bot.goBasket();
        long goBasketFinish = System.currentTimeMillis() - goBasketStart;

        String report = "openDriver = Firefox web tarayıcısını açmak için kullanılan fonksiyon \n" +
                        "login = GittiGidiyor sitesine giriş yapan fonksiyon \n" +
                        "searchAnd2page = Bilgisayar kelimesini gittigidiyor üzerinde arama yapmaktadır ve ikinci sayfaya geçer \n" +
                        "selectProduct = Tarayıcıda bulunan ürünler arasında rastgele bir ürün şeçer ve sepete ekler \n" +
                        "goBasket = Sepet sayfasına gelir önceki sayfadaki fiyat ile sepetteki fiyatı kontrol eder \n" +
                        "bot sınıfını oluşturma zamanı" + getSeconds(botCreateFinish) +"\n" +
                        "openDriver fonksiyonu çalışma zamanı" + getSeconds(openDriverFinish) +"\n" +
                        "login fonksiyonu çalışma zamanı" + getSeconds(loginFinish)+ "\n" +
                        "searchAnd2page fonksiyonu çalışma zamanı"+ getSeconds(searchAnd2pageFinish) + "\n" +
                        "selectProduct fonksiyonu çalışma zamanı" + getSeconds(selectProductFinish) + "\n"+
                        "goBasket fonksiyonu çalışma zamanı" + getSeconds(goBasketFinish);


        FileWriter writer = new FileWriter("C:/Users/burha/OneDrive/Desktop/test.txt");
        writer.write(report);
        writer.close();


    }

    public static double getSeconds(long finishTime){
        double seconds = (double)finishTime/1000;
        return seconds;
    }
}
