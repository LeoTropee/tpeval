import java.util.ArrayList;

public class Entreprise extends Emprunteur{
    private ArrayList<Agence> agences;


    private ArrayList<Employe> employes;
    private String nom;



    public Entreprise(String nom) {
        this.nom = nom;
        agences = new ArrayList<Agence>();
        employes = new ArrayList<Employe>();
    }

    public ArrayList<Employe> getEmployes() {
        return employes;
    }

    public ArrayList<Agence> getAgences() {
        return agences;
    }
}
