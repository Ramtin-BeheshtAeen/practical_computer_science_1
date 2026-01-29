class DVD extends MMedium{
    private final String regisseur;
    
    DVD(final String titel, final String regisseur, final int spielZeit){
        super(titel, spielZeit);
        this.regisseur = regisseur;
    }
}

