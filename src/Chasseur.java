public class Chasseur extends Personnage {
    private boolean actionUnique = true;

    public Chasseur(String parNom) {
        super(parNom, Camps.Village,100,Camps.Village);
        chJoueursAllies.add(this);
    }

    public void informeMort(Personnage parPersonnage){
        if (parPersonnage == this){
            ListPersonnage joueurs = chPartie.getJoueurVivant();
            Personnage persoAbattu = (joueurs).getValeurAleatoire();
            chPartie.afficheInfo("Le Chasseur est mort, il decide de tuer =>"+persoAbattu.chNom);
            chPartie.mort(persoAbattu);
        }
    }
}

