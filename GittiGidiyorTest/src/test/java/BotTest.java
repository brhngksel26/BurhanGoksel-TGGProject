import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BotTest {

    final static Logger logger = Logger.getLogger(Bot.class);

    @org.junit.jupiter.api.Test
    void openDriver() {
        if(logger.isDebugEnabled()){
            logger.debug("This is debug");
        }else{
            logger.error("This is error");
        }

    }

    @Test
    void login() {
        if(logger.isDebugEnabled()){
            logger.debug("This is debug");
        }else{
            logger.error("This is error");
        }
    }

    @Test
    void searchAnd2page() {
        if(logger.isDebugEnabled()){
            logger.debug("This is debug");
        }else{
            logger.error("This is error");
        }
    }

    @Test
    void selectProduct() {
        if(logger.isDebugEnabled()){
            logger.debug("This is debug");
        }else{
            logger.error("This is error");
        }
    }

    @Test
    void goBasket() {
        if(logger.isDebugEnabled()){
            logger.debug("This is debug");
        }else{
            logger.error("This is error");
        }
    }
}