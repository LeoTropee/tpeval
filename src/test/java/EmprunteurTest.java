import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EmprunteurTest {
    Emprunteur e1;

    @Before
    public void setUp() {
        e1 = new Emprunteur();
    }

    @Test
    public void ajouterAuStock() {
        int stock = e1.listeMateriel().size();
        e1.ajouterAuStock(new UC());

        Assert.assertEquals("ajouterAuStock: fail", stock+1, e1.listeMateriel().size());
    }

    @Test
    public void listeMateriel() {
        e1.stock = new ArrayList<Empruntable>();
        int stock = e1.stock.size();
        e1.stock.add(new UC());

        int newStock = e1.listeMateriel().size();

        Assert.assertEquals("listeMateriel: fail", stock+1, newStock);
    }

    @Test
    public void perdreMateriel() {
        Empruntable emprunt1 = new UC();
        e1.listeMateriel().add(emprunt1);

        boolean result = e1.perdreMateriel(emprunt1);

        Assert.assertEquals("perdreMateriel: méthode fail", true, result);
        Assert.assertEquals("perdreMateriel: taille fail", 0, e1.listeMateriel().size());
    }
}
