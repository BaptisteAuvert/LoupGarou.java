public enum Camps {
    Village, Loup, Solo;

    public String toString() {
        switch (this) {
            case Village: return "Village";
            case Loup: return "Loup";
            case Solo:return  "Solo";
            default : return "unknow";
        }
    }
}