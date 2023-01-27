import java.util.*;

public class ClientPartie {
    public static void main(String[] args) {
        List<Personnage> chListPerso = new ArrayList<>();

        for (int i = 1; i < 7; i++) {
            chListPerso.add(new Villageois("J" + i ));
        }
        for (int i = 7; i < 9; i++) {
            chListPerso.add(new LoupGarou("J" + i ));
        }

        chListPerso.add(new EnfantLoup("Denis" ));
        chListPerso.add(new Chasseur("Mathys" ));
        chListPerso.add(new Sorciere("Forsong" ));


        Partie partie = new Partie(chListPerso);
    }
}
