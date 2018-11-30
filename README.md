# tpeval

les objets recuperer par l'admin sont ajouté a son stock, il doit avoir une grande armoire.

Etape 15:
b) Il faut ajouter un constructeur qui parse une chaine pour remplir repere
 public Groupe(String r) {
        repere = Integer.valueOf(r);
    }
    
c) 
public class Groupe<T> {
    private List<T> liste = new ArrayList<T>();
    private T repere;

    public Groupe(T r) {
        repere = r;
    }

    public void setMembre(T m) {
        liste.add(m);
    }

    public void afficher() {
        for (T membre : liste) {
            if (this.isCorrect(membre)) {
                System.out.println(membre);
            }
        }
    }

    private boolean isCorrect(T membre) {
        return ((membre != null) && membre.compareTo(repere) > 0);
    }
}

d)

e)artifactory sert a sauvegarde les sorties du programme.

PRoblemes rencontrés:
difficulté de compréhension du sujets
log4j vers un fichier