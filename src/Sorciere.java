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
        if (chPotionSoin && (randomIndex==0 || chPartie.getVoteLoup()==this)){
            System.out.println("Soin");
            chPartie.resetVote();
            chPotionSoin = false;
        }
        else if (chPotionMort && randomIndex==1){
            System.out.println("Poison");
            ListPersonnage joueurs = chPartie.getJoueurVivant().soustraire(this);
            chPartie.mort(joueurs.getValeurAleatoire());
            chPotionMort = false;
        }
    }

    public Personnage actionJour(){
        return (chPartie.getJoueurVivant().soustraire(this).getValeurAleatoire());
    }

}

