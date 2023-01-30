import java.util.*;

public class ClientPartie {
    public static void main(String[] args) {
        ListPersonnage ListPerso = new ListPersonnage();

        for (int i = 1; i < 2; i++) {
            ListPerso.add(new Villageois("J" + i ));
        }
        for (int i = 7; i < 15; i++) {
            ListPerso.add(new LoupGarouBlanc("J" + i ));
        }
        //ListPerso.add(new Sorciere("Sorciere" ));
        //ListPerso.add(new Chasseur("Chasseur" ));
        //ListPerso.add(new EnfantLoup("EnfantLoup" ));
        //ListPerso.add(new Cupidon("Cupidon" ));
        //ListPerso.add(new Voyante("Voyante" ));
        ListPerso.add(new LoupGarouBlanc("Roger"));


        Partie partie = new Partie(ListPerso);
    }
}
