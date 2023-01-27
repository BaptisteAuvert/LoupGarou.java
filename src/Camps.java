public enum Camps {
    Village, Loup, Amoureux;

    public String toString() {
        switch (this) {
            case Village: return "Village";
            case Loup: return "Loup";
            case Amoureux:return  "Amoureux";
            default : return "unknow";
        }
    }
}