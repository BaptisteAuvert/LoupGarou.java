import java.util.*;

public class Sorciere extends Personnage {
    private boolean actionUnique = true;
    private boolean chPotionSoin  = true;
    private boolean chPotionMort  = true;

    public Sorciere(String parNom) {
        super(parNom, Camps.Village,90,Camps.Village);
    }

    public void actionNuit(){
        Random random = new Random();
        int randomIndex = random.nextInt(3);
        if (chPotionSoin && randomIndex==0){
            System.out.println("Soin");
            super.chPartie.resetVoteLoup();
        }
        else if (chPotionMort && randomIndex==1){
            System.out.println("Poison");
            Set<Personnage> joueurs = super.chPartie.getJoueurVivant(this);
            super.chPartie.mort(super.getPersAleatoire(joueurs));
        }
    }

    public Personnage actionJour(){
        return super.getPersAleatoire((super.chPartie.getJoueurVivant(this)));
    }

}

