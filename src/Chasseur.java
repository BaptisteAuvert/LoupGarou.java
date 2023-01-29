import java.util.*;

public class Chasseur extends Personnage {
    private boolean actionUnique = true;
    public Chasseur(String parNom) {
        super(parNom, Camps.Village,100,Camps.Village);
    }

    public void actionNuit(){

    }

    public void informeMort(Personnage parPersonnage){
        if (parPersonnage == this){
            Set<Personnage> joueurs = chPartie.getJoueurVivant(this);
            Personnage persoAbattu = getPersAleatoire(joueurs);
            chPartie.afficheInfo("Le Chasseur est mort, il desside de tuer =>"+persoAbattu.chNom);
            chPartie.mort(persoAbattu);
        }
    }


    public Personnage actionJour(){
        return getPersAleatoire((chPartie.getJoueurVivant(this)));
    }

}

