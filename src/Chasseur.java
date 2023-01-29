import java.util.*;

public class Chasseur extends Personnage {
    private boolean actionUnique = true;

    public Chasseur(String parNom) {
        super(parNom, Camps.Village,100,Camps.Village);
        chJoueurGentils.add(this);
    }

    public void informeMort(Personnage parPersonnage){
        if (parPersonnage == this){
            ListPersonnage joueurs = chPartie.getJoueurVivant();
            Personnage persoAbattu = getPersAleatoire(joueurs);
            chPartie.afficheInfo("Le Chasseur est mort, il desside de tuer =>"+persoAbattu.chNom);
            chPartie.mort(persoAbattu);
        }
    }
}

