public class Villageois extends Personnage {

    public Villageois(String parNom, Partie parPartie) {
        super(parNom, parPartie, Camps.Village);
    }

    public void actionNuit(){
        System.out.println("Villageois");
    }

    public void actionJour(){
        return;
    }
}
