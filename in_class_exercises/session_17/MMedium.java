class MMedium{
    private final String titel;
    private final int spielZeit;
    private boolean habIch;
    private String kommentar;

    MMedium(final String titel, final int spielZeit){
        this.titel     = titel;
        this.spielZeit = spielZeit;
        habIch         = false;
        kommentar = "<kein Kommentar>";
    }
    
    void setzeKommentar(final String kommentar){
        this.kommentar = kommentar;
    }
    
    String gibKommentar(){
        return kommentar;
    }
    
    void setzeVorhanden(final boolean vorhanden){
        this.habIch = vorhanden;
    }
    
    boolean gibVorhanden(){
        return habIch;
    }
    
    /**
     * Gib Details über dieses Medium auf der Konsole aus.
     */
    void ausgeben()
    {
        System.out.print(titel + " (" + spielZeit + " Min)");
        if (habIch) {
            System.out.println("*");
        }
        else {
            System.out.println();
        }
        System.out.println("    " + kommentar);
    }
    
}