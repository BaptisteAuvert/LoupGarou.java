import java.security.*;
import java.util.*;

public class EnfantLoup extends Personnage {
    private boolean actionUnique = true;
    private Personnage chModel;
    public EnfantLoup(String parNom) {
        super(parNom, Camps.Village,40,Camps.Village);
    }

    public void actionNuit(){
        if (actionUnique){
            Set<Personnage> joueurs = chPartie.getJoueurVivant(this);
            chModel = getPersAleatoire(joueurs);
            chPartie.afficheInfo("L'enfant loup a pris comme modele :"+chModel.chNom);
            actionUnique = false;
        }
        if (chCamps == Camps.Loup){
            Personnage persoMange = getPersAleatoire(chPartie.getJoueurDuCamp(Camps.Village));
            chPartie.addVoteLoup(persoMange);
        }
    }

    public void informeMort(Personnage parPersonnage){
        chCampsVisible =Camps.Loup;
        chCamps = Camps.Loup;
    }

    public Personnage actionJour(){
        return getPersAleatoire((chPartie.getJoueurVivant(this)));
    }

}

