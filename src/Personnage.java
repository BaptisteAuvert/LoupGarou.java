import java.util.*;
import java.util.function.*;

public abstract class Personnage implements Comparable<Personnage> {
    protected String chNom;
    protected Partie chPartie;
    protected Statut chStatut = Statut.Vivant;
    protected Camps chCamps;
    protected Map<Personnage, Function> chActionMort;
    protected int chPriorite;
    protected Camps chCampsVisible;

    public Personnage(String parNom, Partie parPartie,Camps parCamps,int parPriorite,Camps parCampsVisible){
        chNom = parNom;
        chPartie = parPartie;
        chCamps = parCamps;
        chActionMort = new HashMap<>();
        chPriorite = parPriorite;
        chCampsVisible = parCampsVisible;
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

    public void addActionMort(Personnage parPerso, Function parFunction){chActionMort.put(parPerso,parFunction);}

    public void mort(){
        chPartie.afficheInfo(chNom + "est mort il était "+ chCamps);
        chStatut = Statut.Mort;
    }

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
