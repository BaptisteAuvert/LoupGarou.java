import java.util.*;

public class LoupGarou extends Personnage {

    public LoupGarou(String parNom) {
        super(parNom, Camps.Loup, 50, Camps.Loup);
    }

    public void actionNuit() {
        Personnage persoMange = getPersAleatoire(chPartie.getJoueurDuCamp(Camps.Village));
        chPartie.addVoteLoup(persoMange);
    }

    public Personnage actionJour(){
        return getPersAleatoire(chPartie.getJoueurDuCamp(Camps.Village));
    }


}
