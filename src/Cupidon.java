import java.util.*;

public class Cupidon extends Personnage {
    private boolean actionUnique = true;
    private Personnage[] chAmoureux = new Personnage[2];
    private boolean chAmoureuxMort = false;

    public Cupidon(String parNom) {
        super(parNom, Camps.Village,40,Camps.Village);
        chJoueurGentils.add(this);
    }

    public void actionNuit(){
        if (actionUnique){
            ListPersonnage joueurs = chPartie.getJoueurVivant().soustraire(this);
            chAmoureux[0] = getPersAleatoire(joueurs);
            chAmoureux[1] = getPersAleatoire(joueurs.soustraire(chAmoureux[0]));
            chPartie.afficheInfo("Cupidon a vise =>"+chAmoureux[0]+" - "+chAmoureux[1]);
            actionUnique = false;
        }
    }

    public void informeMort(Personnage parPersonnage){
        if (!(chAmoureuxMort)){
            chAmoureuxMort = true;
            if (parPersonnage == chAmoureux[0] ) {
                chPartie.mort(chAmoureux[1]);
            }
            else if (parPersonnage ==chAmoureux[1]){
                chPartie.mort(chAmoureux[0]);
            }
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
        return super.finDeParty() || false;
    }

    public Personnage actionJour(){
        return getPersAleatoire((chPartie.getJoueurVivant().soustraire(this)));
    }

}

