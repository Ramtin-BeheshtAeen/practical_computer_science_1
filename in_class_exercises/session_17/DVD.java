/**
 * Objekte dieser Klasse repräsentieren DVDs. Es werden
 * Informationen über eine DVD verwaltet, die wieder
 * abgefragt werden können.
 *
 * @author Michael Kölling und David J. Barnes
 * @version 2006.03.30
 */
class DVD extends Medium
{
    private final String regisseur;

    /**
     * Konstruktor für Objekte der Klasse DVD
     * @param titel     Der Titel dieser DVD.
     * @param regisseur Der Regisseur dieser DVD.
     * @param spielzeit Die Spielzeit des Hauptfilms.
     */
    DVD(final String titel, final String regisseur,
            final int spielzeit)
    {
        super(titel, spielzeit);
        this.regisseur = regisseur;
    }

    /**
     * Gib Details über diese DVD auf der Konsole aus.
     */
    @Override
    void ausgeben()
    {
        super.ausgeben();
        System.out.println("    " + regisseur);
    }
}
