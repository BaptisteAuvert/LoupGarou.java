import java.util.*;

public class EnfantLoup extends Personnage {
    private boolean actionUnique = true;
    private Personnage chModel;

    public EnfantLoup(String parNom) {
        super(parNom, Camps.Village,40,Camps.Village);
        chJoueurGentils.add(this);
    }

    public void actionNuit(){
        if (actionUnique){
            ListPersonnage joueurs = chPartie.getJoueurVivant();
            joueurs.soustraire(this);
            chModel = getPersAleatoire(joueurs);
            chPartie.afficheInfo("L'enfant loup a pris comme modele :"+chModel.chNom);
            actionUnique = false;
        }
        if (chCamps == Camps.Loup){
            Personnage persoMange = getPersAleatoire(chPartie.getJoueurDuCamp(Camps.Village));
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
        if (chCamps == Camps.Loup){return getPersAleatoire(chPartie.getJoueurDuCamp(Camps.Village));}
        return super.actionJour();
    }
}

