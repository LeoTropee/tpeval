import java.util.ArrayList;

public class Agence {
    private String nom;
    private ArrayList<Employe> employes;

    public Agence(String nom) {
        this.nom = nom;
        employes = new ArrayList<Employe>();
    }
}