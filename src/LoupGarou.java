import java.util.*;

public class LoupGarou extends Personnage {

    public LoupGarou(String parNom) {
        super(parNom, Camps.Loup, 50, Camps.Loup);
    }

    public Personnage actionJour(){
        return getPersAleatoire((Set<Personnage>) chPartie.getJoueurDuCamp(Camps.Village));
    }


}
