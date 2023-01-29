public class Villageois extends Personnage {

    public Villageois(String parNom) {
        super(parNom, Camps.Village,100,Camps.Village);
        chJoueurGentils.add(this);
    }

    public Personnage actionJour(){
        return getPersAleatoire(chPartie.getJoueurVivant().soustraire(this));
    }
}
