public class LoupGarou extends Personnage {

    public LoupGarou(String parNom, Partie parPartie) {
        super(parNom, parPartie, Camps.Loup);
    }

    public void actionNuit(){
        System.out.println("Loup Garou");
    }

    public void actionJour(){
        return;
    }
}
