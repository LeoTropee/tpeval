import java.util.ArrayList;
import java.util.List;

public class Emprunteur {
    List<Empruntable> stock;

    public Emprunteur()
    {
        stock = new ArrayList<Empruntable>();
    }

    public void ajouterAuStock(Empruntable objet)
    {
        stock.add(objet);
    }

    public List<Empruntable> listeMateriel()
    {
        return stock;
    }

    public boolean perdreMateriel(Empruntable obj)
    {
        if(stock.contains(obj))
        {
            stock.remove(obj);
            return true;
        }
        else
        {
            return false;
        }
    }

}
