import java.util.*;

public abstract class Personnage implements Comparable<Personnage> {
    protected ListPersonnage chJoueursAllies = new ListPersonnage();
    protected String chNom;
    protected Partie chPartie;
    protected Statut chStatut = Statut.Vivant;
    protected int chPriorite;
    protected Camps chCamps;
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

    public Camps getCampsVisible(){ return chCampsVisible;}
    public Statut getStatut(){ return chStatut;}

    public void mort(){
        chPartie.afficheInfo("  -"+chNom + " est mort,il etait "+ chCamps);
        chStatut = Statut.Mort;
    }

    public void actionNuit(){}

    public Personnage actionJour(){
        return chPartie.getJoueurVivant().soustraire(chJoueursAllies).getValeurAleatoire();
    }

    public void informeMort(Personnage parPersonnage){}

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
        return "Joueur : "+ chNom +" il etais :"+chCamps;
    }
}
