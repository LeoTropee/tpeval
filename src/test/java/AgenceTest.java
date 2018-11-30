
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

public class AgenceTest {
final static Logger logger =  LogManager.getLogger(Agence.class.getName());
    @Test
    public void compareTo() {
        logger.info("entrer ici");
        Agence a = new Agence(" a1");
        Agence b = new Agence(" a2");
        Ecran ec = new Ecran();
        Ecran def = new Ecran();
        def.declarerDefectueux();
        a.ajouterAuStock(ec);
        b.ajouterAuStock(def);
        assertEquals(-1,a.compareTo(b));


    }
}

