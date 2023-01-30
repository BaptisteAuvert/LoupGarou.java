import java.util.*;

public class ListPersonnage extends TreeSet<Personnage>{

    public ListPersonnage(){
        super();
    }

    public ListPersonnage soustraire (ListPersonnage parListPersonnages){
        ListPersonnage listPersonnage = new ListPersonnage();
        for (Iterator i=this.iterator();i.hasNext();){
            Personnage p = (Personnage) i.next();
            if (!(parListPersonnages.contains(p))){
                listPersonnage.add(p);
            }
        }
        return listPersonnage;
    }

    public ListPersonnage soustraire (Personnage parPersonnage){
        ListPersonnage listPersonnage = new ListPersonnage();
        for (Iterator i=this.iterator();i.hasNext();){
            Personnage p = (Personnage) i.next();
            if (!(p == parPersonnage)){
                listPersonnage.add(p);
            }
        }
        return listPersonnage;
    }

    public boolean contains(Personnage parPersonnage){
        for (Iterator i=this.iterator();i.hasNext();){
            Personnage p = (Personnage) i.next();
            if (!(p == parPersonnage)){
                return true;
            }
        }
        return false;
    }

    public Personnage getValeurAleatoire() {
        Random random = new Random();
        if (this.size() > 0) {
            int randomIndex = random.nextInt(this.size());
            Iterator iterator = this.iterator();
            for (int i = 0; i < randomIndex - 1; i++) {
                iterator.next();
            }
            return (Personnage) iterator.next();
        }
        return null;
    }
}

/*
    public ListPersonnage soustraire (ListPersonnage parListPersonnages){
        for (Iterator i=this.iterator();i.hasNext();){
            Personnage p = (Personnage) i.next();
            if (parListPersonnages.contains(p)){
                this.remove(p);
            }
        }
        return this;
    }

    public ListPersonnage soustraire (Personnage parPersonnage){
        System.out.println(this.contains(parPersonnage));
        if (parPersonnage != null ){this.remove(parPersonnage);System.out.println("eee");}
        return this;
    }
    */
