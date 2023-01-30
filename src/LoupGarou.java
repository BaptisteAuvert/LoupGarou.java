import java.util.*;

public class LoupGarou extends Personnage {

    public LoupGarou(String parNom) {
        super(parNom, Camps.Loup, 50, Camps.Loup);
    }

    public void actionNuit() {
        Personnage persoMange = (chPartie.getJoueurDuCamp(Camps.Village).getValeurAleatoire());
        chPartie.addVoteLoup(persoMange);
    }

    public Personnage actionJour(){
        return (chPartie.getJoueurDuCamp(Camps.Village).getValeurAleatoire());
    }

}
