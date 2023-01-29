import java.util.*;

public class Voyante extends Personnage {
    private boolean actionUnique = true;
    private ListPersonnage  chMechants = new ListPersonnage();
    private ListPersonnage chRoleInconnu = new ListPersonnage();


    public Voyante(String parNom) {
        super(parNom, Camps.Village,90,Camps.Village);
        chJoueurGentils.add(this);
    }

    public void actionNuit(){
        System.out.println("Nuit");
        if (actionUnique){
            chRoleInconnu = chPartie.getJoueurVivant().soustraire(this);
            actionUnique = false;
        }

        Personnage joueursAlyse = getPersAleatoire(chRoleInconnu);
        chPartie.afficheInfo("La voyante analyse "+joueursAlyse.chNom+", il est "+joueursAlyse.chCampsVisible);
        if (joueursAlyse.chCampsVisible==Camps.Loup){chMechants.add(joueursAlyse);}
        else {chJoueurGentils.add(joueursAlyse);}
        chRoleInconnu = chRoleInconnu.soustraire(joueursAlyse);
        System.out.println("Inconnu : "+chRoleInconnu);
        System.out.println("Mechant : "+chMechants);
    }

    public Personnage actionJour(){
        if (chMechants.isEmpty()){
            System.out.println("no loup");
            return getPersAleatoire(chRoleInconnu);
        }
        else{
            System.out.println("loup");
            return getPersAleatoire(chMechants);
        }
    }

    public void informeMort(Personnage parPersonnage){
        if (chMechants.contains(parPersonnage)){chMechants = chMechants.soustraire(parPersonnage);}
        else if (chRoleInconnu.contains(parPersonnage)){chRoleInconnu = chRoleInconnu.soustraire(parPersonnage);}

    }
}

