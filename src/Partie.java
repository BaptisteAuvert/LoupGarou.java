import java.lang.reflect.*;
import java.util.*;

public class Partie {
    private List <Personnage> chListPerso;

    public Partie(){
        chListPerso = new ArrayList<>();
        for (int i=1;i<7;i++){
            chListPerso.add(new Villageois("J"+i,this));
        }
        for (int i=7;i<9;i++){
            chListPerso.add(new LoupGarou("J"+i,this));
        }
        nuit();


    }
    public void nuit() {
        System.out.println("Nuit : ");
        for (Iterator iterator = chListPerso.iterator(); iterator.hasNext(); ) {
            Personnage joueur = (Personnage) iterator.next();
            System.out.println(joueur);
            joueur.actionNuit();
        }
    }

    public void jour(){
        return;
    }

    public List <Personnage> getListJoueurVivant(){
        List <Personnage> listPersoVivant = new ArrayList<>();
        for (Iterator iterator = chListPerso.iterator();iterator.hasNext();){
            Personnage joueur = (Personnage) iterator.next();
            if (joueur.getStatut()== Statut.Vivant){
                listPersoVivant.add(joueur);
            }
        }
        return listPersoVivant;
    }

    public List <Personnage> getListJoueurDuCamp(Camps parCamps){
        List <Personnage> listPersoDuCamp = new ArrayList<>();
        for (Iterator iterator = getListJoueurVivant().iterator();iterator.hasNext();){
            Personnage joueur = (Personnage) iterator.next();
            if (joueur.getCamps()== parCamps){
                listPersoDuCamp.add(joueur);
            }
        }
        return listPersoDuCamp;
    }
}
