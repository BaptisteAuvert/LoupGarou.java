import java.util.*;

public class Partie {
    private  ListPersonnage chListPerso ;
    private Map <Personnage, Integer> chVote = new HashMap();
    private ListPersonnage chGagnants = new ListPersonnage();
    private int chNbJour = 1;

    public Partie(ListPersonnage parListPerso) {
        chListPerso = parListPerso;
        for (Iterator i=chListPerso.iterator();i.hasNext();){
            Personnage p = (Personnage) i.next();
            p.setPartie(this);
        }
        nuit();
    }

    public void nuit() {
        afficheInfo("-----------------------------------------------------------------------------------");
        afficheInfo("Debut de la Nuit n"+chNbJour+++" :");
        resetVote();
        for (Iterator iterator = getJoueurVivant().iterator(); iterator.hasNext(); ) {
            Personnage joueur = (Personnage) iterator.next();
            joueur.actionNuit();
        }
        mort(getMaxVote(chVote));
        if (finDePartie()){fin();}
        else {jour();}

    }

    public void jour(){
        afficheInfo("=============");
        afficheInfo("Debut du jour n"+chNbJour+":");
        resetVote();
        for (Iterator iterator = getJoueurVivant().iterator(); iterator.hasNext(); ) {
            Personnage joueur = (Personnage) iterator.next();
            Personnage persoVote = joueur.actionJour();
            chVote.put(persoVote,chVote.get(persoVote)+1);
        }
        mort(getMaxVote(chVote));

        if (finDePartie()){fin();}
        else {nuit();}
    }

    private boolean finDePartie(){
        boolean fin = false;
        for (Iterator i= chListPerso.iterator();i.hasNext();){
            Personnage joueur = (Personnage) i.next();
             fin = (fin||joueur.finDeParty());
        }
        return fin;
    }

    private void fin(){
        afficheInfo("Fin de la Partie");
    }

    public void mort(Personnage parPerso){
        if (parPerso !=null){
            for (Iterator i=chListPerso.iterator();i.hasNext();){
                Personnage p = (Personnage) i.next();
                p.informeMort(parPerso);
            }
            parPerso.mort();
        }
        else {
            afficheInfo("Personne n'est mort cette nuit");
        }
    }

    public Personnage getVoteLoup(){
        return getMaxVote(chVote);
    }

    public void resetVote(){
        chVote.clear();
        for (Iterator i = getJoueurVivant().iterator();i.hasNext();){
            chVote.put((Personnage) i.next(),0);
        }
    }


    public void addVoteLoup(Personnage parPerso){
        chVote.put(parPerso,chVote.get(parPerso)+1);
    }


    public ListPersonnage getJoueurDuCamp(Camps parCamps){
        ListPersonnage listPersoDuCamp = new ListPersonnage();
        for (Iterator iterator = getJoueurVivant().iterator();iterator.hasNext();){
            Personnage joueur = (Personnage) iterator.next();
            if (joueur.getCamps()== parCamps){
                listPersoDuCamp.add(joueur);
            }
        }
        return listPersoDuCamp;
    }

    public ListPersonnage getJoueurVivant(){
        ListPersonnage listPersoDuCamp = new ListPersonnage();
        for (Iterator iterator = chListPerso.iterator();iterator.hasNext();){
            Personnage joueur = (Personnage) iterator.next();
            if (joueur.getStatut()== Statut.Vivant){
                listPersoDuCamp.add(joueur);
            }
        }
        return listPersoDuCamp;
    }

    public Personnage getMaxVote(Map<Personnage,Integer> parMap){
        Personnage persoVoteMax = null;
        for (Iterator i = parMap.keySet().iterator();i.hasNext();){
            Personnage joueur = (Personnage) i.next();
            if ((persoVoteMax == null || parMap.get(joueur)>parMap.get(persoVoteMax)) && parMap.get(joueur)!=0){
                persoVoteMax = joueur;
            }
        }
        return persoVoteMax;
    }

    public void addGagnant(Personnage parPersonnage){
        chGagnants.add(parPersonnage);
    }

    public void afficheInfo(String parString){
        System.out.println(parString);
    }
}
