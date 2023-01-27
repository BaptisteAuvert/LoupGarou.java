import java.util.*;
import java.util.function.*;

public abstract class Personnage implements Comparable<Personnage> {
    protected String chNom;
    protected Partie chPartie;
    protected Statut chStatut = Statut.Vivant;
    protected Camps chCamps;
    protected List<Personnage> chActionMort;
    protected int chPriorite;
    protected Camps chCampsVisible;

    public Personnage(String parNom,Camps parCamps,int parPriorite,Camps parCampsVisible){
        chNom = parNom;
        chCamps = parCamps;
        chActionMort = new ArrayList<>();
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

    public void addActionMort(Personnage parPerso){chActionMort.add(parPerso);}

    public void mort(){
        for (Iterator i=chActionMort.iterator();i.hasNext();){
            Personnage p = (Personnage) i.next();
            p.postMort();
        }
        chPartie.afficheInfo("  -"+chNom + " est mort,il etait "+ chCamps);
        chStatut = Statut.Mort;
    }

    public void postMort(){return;}

    public void actionNuit(){
        return;
    }
    public Personnage actionJour(){
        return null;
    }

    public int compareTo(Personnage parPersonnage){
        if (chPriorite > parPersonnage.chPriorite){return 1;}
        else{return -1;}
    }

    public String toString(){
        return "Joueur : "+ chNom + " est dans le camps : "+ chCamps+" ";
    }

}
