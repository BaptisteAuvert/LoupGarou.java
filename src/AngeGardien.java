public class AngeGardien extends Personnage {
    private Personnage chJoueurProtegePrecedent = null;
    public AngeGardien(String parNom) {
        super(parNom, Camps.Village,90,Camps.Village);
        chJoueursAllies.add(this);
    }

    public void actionNuit() {
        Personnage joueurProtege = chPartie.getJoueurVivant().soustraire(this).soustraire(chJoueurProtegePrecedent).getValeurAleatoire();
        chPartie.afficheInfo("L'ange gardien protege "+joueurProtege+" cette nuit");
        if (chPartie.getVoteLoup()==joueurProtege){chPartie.resetVote();System.out.println("L'ange a sauve !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");}
    }

}

