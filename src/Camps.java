public enum Camps {
    Village, Loup;

    public String toString() {
        switch (this) {
            case Village: return "Village";
            case Loup: return "Loup";
            default : return "unknow";
        }
    }
}