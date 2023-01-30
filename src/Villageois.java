public class Villageois extends Personnage {

    public Villageois(String parNom) {
        super(parNom, Camps.Village,100,Camps.Village);
        chJoueursAllies.add(this);
    }

    public Personnage actionJour(){
        return chPartie.getJoueurVivant().soustraire(this).getValeurAleatoire();
    }
}
