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
        return this.entreprise.listerMateriel();
    }

    public List<Empruntable> stockAgence()
    {
        return this.agence.listerMateriel();
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

    public void suppimerMaterielDefectueuxEntreprise()
    {
        for (Empruntable e:entreprise.listerMateriel()) {
            if(e.isDefectueux())
            {
                entreprise.listerMateriel().remove(e);
            }
        }
    }

    public void suppimerMaterielDefectueuxAgence()
    {
        for (Empruntable e:agence.listerMateriel()) {
            if(e.isDefectueux())
            {
                agence.listerMateriel().remove(e);
            }
        }
    }

    public void suppimerMaterielDefectueuxDe(Emprunteur emprunteur)
    {
        for (Empruntable e:emprunteur.listerMateriel()) {
            if(e.isDefectueux())
            {
                emprunteur.listerMateriel().remove(e);
            }
        }
    }


}
