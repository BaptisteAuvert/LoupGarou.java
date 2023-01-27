import java.util.*;

public class LoupGarou extends Personnage {

    public LoupGarou(String parNom) {
        super(parNom, Camps.Loup, 50, Camps.Loup);
    }

    public void actionNuit() {
        Personnage persoMange = super.getPersAleatoire(super.chPartie.getJoueurDuCamp(Camps.Village));
        super.chPartie.addVoteLoup(persoMange);
    }
    public Personnage actionJour(){
        return super.getPersAleatoire((Set<Personnage>) super.chPartie.getJoueurDuCamp(Camps.Village));
    }


}
