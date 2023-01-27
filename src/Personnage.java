import java.util.*;
import java.util.function.*;

public abstract class Personnage {
    protected String chNom;
    protected Partie chPartie;
    protected Statut chStatut = Statut.Vivant;
    protected Camps chCamps;
    protected Map<Personnage, Function> chActionMort;
    protected int chPriorite;

    public Personnage(String parNom, Partie parPartie,Camps parCamps,int parPriorite){
        chNom = parNom;
        chPartie = parPartie;
        chCamps = parCamps;
        chActionMort = new HashMap<>();
        chPriorite = parPriorite;
    }

    public String getNom(){ return chNom;}
    public Partie getPartie(){ return chPartie;}
    public Camps getCamps(){ return chCamps;}
    public Statut getStatut(){ return chStatut;}

    public void addActionMort(Personnage parPerso, Function parFunction){chActionMort.put(parPerso,parFunction);}

    public void Mort(){
        chStatut = Statut.Mort;
    }

    public void actionNuit(){
        return;
    }
    public void actionJour(){
        return;
    }


    public String toString(){
        return "Joueur : "+ chNom + "est dans le camps : "+ chCamps+" ";
    }
}
