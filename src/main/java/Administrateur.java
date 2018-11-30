import java.util.List;

public class Administrateur extends Employe {


    public Administrateur(Agence agence, Entreprise entreprise) {
        super(agence, entreprise);
    }

    public boolean attribuerMateriel(Empruntable objet, Emprunteur emprun)
    {
        if((!(emprun instanceof Agence) && objet.isLimitationPretAuxAgences() )|| objet.isDefectueux())
        {
            return false;
        }
        emprun.ajouterAuStock(objet);


        return true;
    }

    public boolean recupererMateriel(Empruntable objet, Emprunteur emprun)
    {

        return emprun.perdreMateriel(objet);
    }
    public List<Empruntable> stockEntreprise()
    {
        return this.entreprise.listeMateriel();
    }

    public List<Empruntable> stockAgence()
    {
        return this.agence.listeMateriel();
    }

    public void transfererMateriel(Emprunteur pre, Empruntable objet, Emprunteur post)
    {
        if(pre.perdreMateriel(objet))
        {
            post.ajouterAuStock(objet);
        }
    }

    public void supprimerMateriel(Empruntable objet)
    {
        entreprise.perdreMateriel(objet);
        agence.perdreMateriel(objet);
        for (Employe empl: entreprise.getEmployes()) {
            empl.perdreMateriel(objet);

        }
    }

    public void supprimerMaterielDefectueuxEntreprise()
    {
        for (Empruntable e:entreprise.listeMateriel()) {
            if(e.isDefectueux())
            {
                entreprise.perdreMateriel(e);
            }
        }
    }

    public void supprimerMaterielDefectueuxAgence()
    {
        for (Empruntable e:agence.listeMateriel()) {
            if(e.isDefectueux())
            {
                agence.perdreMateriel(e);
            }
        }
    }

    public void supprimerMaterielDefectueuxDe(Emprunteur emprunteur)
    {
        for (Empruntable e:emprunteur.listeMateriel()) {
            if(e.isDefectueux())
            {
                emprunteur.perdreMateriel(e);
            }
        }
    }


}
