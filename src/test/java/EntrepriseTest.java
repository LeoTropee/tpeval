import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;



import static org.junit.Assert.*;

public class EntrepriseTest {

    private static final Logger logger =  LogManager.getLogger(Entreprise.class.getName());
    @Test
    public void Test() {

        logger.info("Start Entreprise Test");
        Entreprise entreprise = new Entreprise("Ensim");


    }
}