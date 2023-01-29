import java.util.*;

public class Cupidon extends Personnage {
    private boolean actionUnique = true;
    private Personnage[] chAmoureux = new Personnage[2];
    public Cupidon(String parNom) {
        super(parNom, Camps.Village,40,Camps.Village);
    }

    public void actionNuit(){
        if (actionUnique){
            Set<Personnage> joueurs = chPartie.getJoueurVivant(this);
            chAmoureux[0] = getPersAleatoire(joueurs);
            joueurs.remove(chAmoureux[0]);
            chAmoureux[1] = getPersAleatoire(joueurs);
        }
        System.out.println("Amoureux : " + chAmoureux[0].chNom+" - "+chAmoureux[1].chNom);
    }

    public void informeMort(Personnage parPersonnage){
        if (parPersonnage == chAmoureux[0] ) {
            chPartie.mort(chAmoureux[1]);
        }
        else if (parPersonnage ==chAmoureux[1]){
            chPartie.mort(chAmoureux[0]);
        }
    }

    public boolean finDeParty(){
        Set<Personnage> joueurVivant = chPartie.getJoueurVivant();
        if (chPartie.getJoueurVivant().size() == 2){
            if (joueurVivant.contains(chAmoureux[0])){
                chPartie.addGagnant(chAmoureux[0]);
                chPartie.addGagnant(chAmoureux[1]);
                return true;
            }
        }
        return false;
    }

    public Personnage actionJour(){
        return getPersAleatoire((chPartie.getJoueurVivant(this)));
    }

}

