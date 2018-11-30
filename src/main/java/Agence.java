import java.util.ArrayList;

public class Agence extends Emprunteur implements Comparable{
    private String nom;
    private ArrayList<Employe> employes;

    public Agence(String nom) {
        this.nom = nom;
        employes = new ArrayList<Employe>();
    }
    public ArrayList<Employe> getEmployes() {
        return employes;
    }

    public int getNbMaterielDefectueux()
    {
        int nb = 0;

        for(Empruntable empruntable : listeMateriel())
        {
            if(empruntable.isDefectueux())
            {
                nb++;
            }
        }

        return nb;
    }
    public int compareTo(Object o)
    {
        return (getNbMaterielDefectueux() - ((Agence)o).getNbMaterielDefectueux());
    }

}
