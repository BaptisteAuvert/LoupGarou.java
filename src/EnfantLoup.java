public class EnfantLoup extends Personnage {
    private boolean actionUnique = true;
    private Personnage chModel;

    public EnfantLoup(String parNom) {
        super(parNom, Camps.Village,40,Camps.Village);
        chJoueursAllies.add(this);
    }

    public void actionNuit(){
        if (actionUnique){
            ListPersonnage joueurs = chPartie.getJoueurVivant();
            joueurs.soustraire(this);
            chModel = (joueurs).getValeurAleatoire();
            chPartie.afficheInfo("L'enfant loup a pris comme modele :"+chModel.chNom);
            actionUnique = false;
        }
        if (chCamps == Camps.Loup){
            Personnage persoMange = chPartie.getJoueurDuCamp(Camps.Village).getValeurAleatoire();
            chPartie.addVoteLoup(persoMange);
        }
    }

    public void informeMort(Personnage parPersonnage){
        if (chModel == parPersonnage){
            chPartie.afficheInfo("L'enfant Loup Change de role");
            chCampsVisible =Camps.Loup;
            chCamps = Camps.Loup;
        }
    }

    public Personnage actionJour(){
        if (chCamps == Camps.Loup){return chPartie.getJoueurDuCamp(Camps.Village).getValeurAleatoire();}
        return super.actionJour();
    }
}

