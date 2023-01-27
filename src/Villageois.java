public class Villageois extends Personnage {

    public Villageois(String parNom, Partie parPartie) {
        super(parNom, parPartie, Camps.Village,100,Camps.Village);
    }

    public void actionNuit(){
        return;
    }

    public Personnage actionJour(){
        return super.getPersAleatoire((super.chPartie.getJoueurVivant()));
    }

}
