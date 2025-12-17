/**
 * Objekte dieser Klasse repräsentieren CDs.
 * Sie speichern Informationen über eine CD, die
 * wieder abgefragt werden können.
 *
 * @author Michael Kölling und David J. Barnes
 * @version 2006.03.30
 */
class CD extends Medium
{
    private final String künstler;
    private final int titelanzahl;

    /**
     * Initialisierung einer CD.
     * @param titel       der Titel der CD.
     * @param künstler    der Kuenstler dieser CD.
     * @param titelanzahl die Anzahl der Stuecke auf der CD.
     * @param spielzeit   die Spielzeit der CD.
     */
    CD(final String titel, final String künstler,
            final int titelanzahl, final int spielzeit)
    {
        super(titel, spielzeit);
        this.künstler = künstler;
        this.titelanzahl = titelanzahl;
    }

    /**
     * Gib Details über diese CD auf der Konsole aus.
     */
    @Override
    void ausgeben()
    {
        super.ausgeben();
        System.out.println("    " + künstler);
        System.out.println("    " + titelanzahl);
    }
}
