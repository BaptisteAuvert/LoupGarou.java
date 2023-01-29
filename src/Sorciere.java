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
        if (chPotionSoin && (randomIndex==0 || chPartie.getMaxVote(chPartie.getChVoteLoup())==this)){
            System.out.println("Soin");
            chPartie.resetVoteLoup();
            chPotionSoin = false;
        }
        else if (chPotionMort && randomIndex==1){
            System.out.println("Poison");
            Set<Personnage> joueurs = chPartie.getJoueurVivant(this);
            chPartie.mort(getPersAleatoire(joueurs));
            chPotionMort = false;
        }
    }

    public Personnage actionJour(){
        return getPersAleatoire((chPartie.getJoueurVivant(this)));
    }

}

