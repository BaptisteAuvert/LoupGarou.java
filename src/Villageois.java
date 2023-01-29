public class Villageois extends Personnage {

    public Villageois(String parNom) {
        super(parNom, Camps.Village,100,Camps.Village);
    }

    public void actionNuit(){
        return;
    }

    public Personnage actionJour(){
        return getPersAleatoire((chPartie.getJoueurVivant(this)));
    }

}
