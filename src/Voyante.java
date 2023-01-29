import java.util.*;

public class Voyante extends Personnage {
    private boolean actionUnique = true;
    private Set<Personnage>  chMechants = new HashSet();
    private Set<Personnage> chRoleInconnu = new HashSet<>();


    public Voyante(String parNom) {
        super(parNom, Camps.Village,90,Camps.Village);
    }

    public void actionNuit(){
        if (actionUnique){
            chRoleInconnu = chPartie.getJoueurVivant();
            actionUnique = false;
        }

        Personnage joueursAlyse = getPersAleatoire(chRoleInconnu);
        chPartie.afficheInfo("La voyante analyse "+joueursAlyse.chNom+", il est "+joueursAlyse.chCampsVisible);

        if (joueursAlyse.chCampsVisible==Camps.Loup){chMechants.add(joueursAlyse);}
        chRoleInconnu.remove(joueursAlyse);

        System.out.println("Inconnu : "+chRoleInconnu);
        System.out.println("Mechant : "+chMechants);
    }

    public Personnage actionJour(){
        if (chMechants.isEmpty()){
            return getPersAleatoire(chRoleInconnu);
        }
        else{
            return getPersAleatoire(chMechants);
        }
    }

    public void informeMort(Personnage parPersonnage){
        if (chMechants.contains(parPersonnage) != false){chMechants.remove(parPersonnage);}
        else if (chRoleInconnu.contains(parPersonnage) != false){chRoleInconnu.remove(parPersonnage);}

    }
}

