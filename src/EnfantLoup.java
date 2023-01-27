import java.util.*;

public class EnfantLoup extends Personnage {
    private boolean actionUnique = true;
    public EnfantLoup(String parNom) {
        super(parNom, Camps.Village,40,Camps.Village);
    }

    public void actionNuit(){
        if (actionUnique){
            Set<Personnage> joueurs = super.chPartie.getJoueurVivant(this);
            Personnage persoModele = super.getPersAleatoire(joueurs);
            persoModele.addActionMort(this);
            super.chPartie.afficheInfo("L'enfant loup a pris comme modele :"+persoModele.chNom);
            actionUnique = false;
        }
    }

    public void postMort() {
        super.chPartie.afficheInfo("L'enfant loup change de role");
        super.chCamps=Camps.Loup;
        super.chCampsVisible=Camps.Loup;
    }

    public Personnage actionJour(){
        return super.getPersAleatoire((super.chPartie.getJoueurVivant(this)));
    }

}

