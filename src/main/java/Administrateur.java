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

        boolean perdu = emprun.perdreMateriel(objet);
        if(perdu)
        {
            this.ajouterAuStock(objet);
        }
        return perdu;
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
        if(pre.listeMateriel().contains(objet) && ((post instanceof Agence) == objet.isLimitationPretAuxAgences()))
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
        int i=0;
        while(i<entreprise.listeMateriel().size())
        {
            if(entreprise.listeMateriel().get(i).isDefectueux())
            {
                entreprise.perdreMateriel(entreprise.listeMateriel().get(i));
            }
            i++;
        }
    }

    public void supprimerMaterielDefectueuxAgence()
    {
        int i=0;
        while(i<agence.listeMateriel().size())
        {
            if(agence.listeMateriel().get(i).isDefectueux())
            {
                agence.perdreMateriel(agence.listeMateriel().get(i));
            }
            i++;
        }
    }

    public void supprimerMaterielDefectueuxDe(Emprunteur emprunteur)
    {
        int i=0;
        while(i<emprunteur.listeMateriel().size())
        {
            if(emprunteur.listeMateriel().get(i).isDefectueux())
            {
                emprunteur.perdreMateriel(emprunteur.listeMateriel().get(i));
            }
            i++;
        }
    }


    public void achatMateriel(Empruntable e)
    {
        entreprise.ajouterAuStock(e);
    }

}
