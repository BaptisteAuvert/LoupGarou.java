import java.util.*;
import java.util.function.*;

public abstract class Personnage implements Comparable<Personnage> {
    protected String chNom;
    protected Partie chPartie;
    protected Statut chStatut = Statut.Vivant;
    protected Camps chCamps;
    protected int chPriorite;
    protected Camps chCampsVisible;

    public Personnage(String parNom,Camps parCamps,int parPriorite,Camps parCampsVisible){
        chNom = parNom;
        chCamps = parCamps;
        chPriorite = parPriorite;
        chCampsVisible = parCampsVisible;
    }

    public void setPartie(Partie parPartie){
        chPartie = parPartie;
    }

    public String getNom(){ return chNom;}
    public Partie getPartie(){ return chPartie;}
    public Camps getCamps(){ return chCamps;}
    public Statut getStatut(){ return chStatut;}

    public Personnage getPersAleatoire(Set<Personnage> parList){
        Random random = new Random();
        int randomIndex = random.nextInt(parList.size());
        Iterator iterator = parList.iterator();
        for (int i=0;i<randomIndex-1;i++){
            iterator.next();
        }
        return (Personnage) iterator.next();
    }

    public void mort(){
        chPartie.afficheInfo("  -"+chNom + " est mort,il etait "+ chCamps);
        chStatut = Statut.Mort;
    }

    public void actionNuit(){
        return;
    }

    public Personnage actionJour(){
        return null;
    }

    public void informeMort(Personnage parPersonnage){
        return;
    }

    public int compareTo(Personnage parPersonnage){
        if (chPriorite > parPersonnage.chPriorite){return 1;}
        else{return -1;}
    }

    public boolean finDeParty(){
        if (chPartie.getJoueurVivant().size() == chPartie.getJoueurDuCamp(chCamps).size()){
            chPartie.addGagnant(this);
            return true;
        }
        return false;
    }

    public String toString(){
        return "Joueur : "+ chNom + " est dans le camps : "+ chCamps+" ";
    }

}
