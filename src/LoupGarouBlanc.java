import java.util.*;

public class LoupGarouBlanc extends Personnage {

    public LoupGarouBlanc(String parNom) {
        super(parNom, Camps.Solo, 50, Camps.Loup);
    }

    public void actionNuit() {
        Personnage persoMange = chPartie.getJoueurDuCamp(Camps.Village).getValeurAleatoire();
        chPartie.addVoteLoup(persoMange);
        if (chPartie.getJour()%2==1){
            Personnage joueurDevore = chPartie.getJoueurVivant().soustraire(this).soustraire(persoMange).getValeurAleatoire();
            chPartie.afficheInfo("Le loup blanc decide de manger : "+joueurDevore);
            chPartie.mort(joueurDevore);
        }
    }

    public boolean finDeParty(){
        if (chPartie.getJoueurVivant().size() == 1 && chStatut == Statut.Vivant){
            chPartie.addGagnant(this);
            return true;
        }
        return false;
    }
}
