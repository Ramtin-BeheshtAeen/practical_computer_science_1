/**
 * Objekte dieser Klasse repräsentieren Medien.
 * Sie speichern Informationen über ein Medium, die
 * wieder abgefragt werden können.
 *
 * @author Michael Kölling und David J. Barnes
 * @version 2006.03.30
 */
class Medium
{
    private final String titel;
    private final int spielzeit;
    private boolean habIch;
    private String kommentar;

    /**
     * Initialisierung eines Mediums.
     * @param titel     der Titel des Mediums.
     * @param spielzeit die Spielzeit des Mediums.
     */
    Medium(final String titel, final int spielzeit)
    {
        this.titel = titel;
        this.spielzeit = spielzeit;
        habIch = false;
        kommentar = "<kein Kommentar>";
    }

    /**
     * Setze einen Kommentar für dieses Medium.
     * @param kommentar der einzutragende Kommentar.
     */
    void setzeKommentar(final String kommentar)
    {
        this.kommentar = kommentar;
    }

    /**
     * @return den Kommentar für dieses Medium.
     */
    String gibKommentar()
    {
        return kommentar;
    }

    /**
     * Setze, ob wir dieses Medium in unserer Sammlung haben.
     * @param vorhanden true, wenn wir das Medium haben, false sonst.
     */
    void setzeVorhanden(final boolean vorhanden)
    {
        habIch = vorhanden;
    }

    /**
     * @return true, wenn wir dieses Medium in
     *         unserer Sammlung haben.
     */
    boolean gibVorhanden()
    {
        return habIch;
    }

    /**
     * Gib Details über dieses Medium auf der Konsole aus.
     */
    void ausgeben()
    {
        System.out.print(titel + " (" + spielzeit + " Min)");
        if (habIch) {
            System.out.println("*");
        }
        else {
            System.out.println();
        }
        System.out.println("    " + kommentar);
    }
}
