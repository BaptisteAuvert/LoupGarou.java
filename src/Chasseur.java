import java.util.*;

public class Chasseur extends Personnage {
    private boolean actionUnique = true;
    public Chasseur(String parNom) {
        super(parNom, Camps.Village,100,Camps.Village);
    }

    public void actionNuit(){
        if (actionUnique){
            super.addActionMort(this);
            actionUnique = false;
        }
    }

    public void postMort() {
        Set<Personnage> joueurs = super.chPartie.getJoueurVivant(this);
        Personnage persoAbattu = super.getPersAleatoire(joueurs);
        super.chPartie.afficheInfo("Le Chasseur est mort, il desside de tuer =>"+persoAbattu.chNom);
        super.chPartie.mort(persoAbattu);
    }

    public Personnage actionJour(){
        return super.getPersAleatoire((super.chPartie.getJoueurVivant(this)));
    }

}

