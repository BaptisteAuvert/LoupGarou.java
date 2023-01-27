public enum Statut {
    Mort, Vivant;

    public String toString() {
        switch (this) {
            case Mort: return "Mort";
            case Vivant: return "Vivant";
            default : return "unknow";
        }
    }
}