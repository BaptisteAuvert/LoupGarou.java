import java.util.*;

public class Partie {
    private List <Personnage> chListPerso ;
    private Map <Personnage, Integer> chVoteLoup = new HashMap();
    private Map <Personnage, Integer> chVoteJour = new HashMap();
    private List <Personnage> chGagnants = new ArrayList<>();
    private int chNbJour = 1;

    public Partie(List<Personnage> parListPerso) {
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
        resetVoteLoup();
        for (Iterator iterator = getJoueurVivant().iterator(); iterator.hasNext(); ) {
            Personnage joueur = (Personnage) iterator.next();
            joueur.actionNuit();
        }
        mort(getMaxVote(chVoteLoup));
        if (finDePartie()){fin();}
        else {jour();}

    }

    public void jour(){
        afficheInfo("=============");
        afficheInfo("Debut du jour n"+chNbJour+":");
        resetVoteVillage();
        for (Iterator iterator = getJoueurVivant().iterator(); iterator.hasNext(); ) {
            Personnage joueur = (Personnage) iterator.next();
            Personnage persoVote = joueur.actionJour();
            chVoteJour.put(persoVote,chVoteJour.get(persoVote)+1);
        }
        mort(getMaxVote(chVoteJour));

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
            parPerso.mort();
        }
        else {
            afficheInfo("Personne n'est mort cette nuit");
        }
    }

    public void resetVoteLoup(){
        chVoteLoup.clear();
        for (Iterator i = getJoueurDuCamp(Camps.Village).iterator();i.hasNext();){
            chVoteLoup.put((Personnage) i.next(),0);
        }
    }

    public void resetVoteVillage(){
        chVoteJour.clear();
        for (Iterator i = getJoueurVivant().iterator();i.hasNext();){
            chVoteJour.put((Personnage) i.next(),0);
        }
    }

    public void addVoteLoup(Personnage parPerso){
        chVoteLoup.put(parPerso,chVoteLoup.get(parPerso)+1);
    }


    public Set <Personnage> getJoueurDuCamp(Camps parCamps){
        Set <Personnage> listPersoDuCamp = new HashSet<>();
        for (Iterator iterator = getJoueurVivant().iterator();iterator.hasNext();){
            Personnage joueur = (Personnage) iterator.next();
            if (joueur.getCamps()== parCamps){
                listPersoDuCamp.add(joueur);
            }
        }
        return listPersoDuCamp;
    }

    public Set <Personnage> getJoueurVivant(){
        Set <Personnage> listPersoDuCamp = new TreeSet<>();
        for (Iterator iterator = chListPerso.iterator();iterator.hasNext();){
            Personnage joueur = (Personnage) iterator.next();
            if (joueur.getStatut()== Statut.Vivant){
                listPersoDuCamp.add(joueur);
            }
        }
        return listPersoDuCamp;
    }

    public Set <Personnage> getJoueurVivant(Personnage parPersonnage){
        Set <Personnage> listPersoDuCamp = new TreeSet<>();
        for (Iterator iterator = chListPerso.iterator();iterator.hasNext();){
            Personnage joueur = (Personnage) iterator.next();
            if (joueur.getStatut()== Statut.Vivant && joueur != parPersonnage){
                listPersoDuCamp.add(joueur);
            }
        }
        return listPersoDuCamp;
    }

    public Map<Personnage, Integer> getChVoteLoup() {return chVoteLoup;}

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
