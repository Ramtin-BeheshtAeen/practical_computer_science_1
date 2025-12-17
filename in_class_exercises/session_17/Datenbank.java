import java.util.ArrayList;

/**
 * Die Klasse Datenbank bietet Möglichkeiten zum Speichern
 * von Medien-Objekten. Eine Liste aller Medien kann auf
 * der Konsole ausgegeben werden.
 *
 * Diese Version speichert die Daten nicht im Dateisystem und
 * bietet keine Suchfunktion.
 *
 * @author Michael Kölling und David J. Barnes
 * @version 2006.03.30
 */
class Datenbank
{
    private final ArrayList<Medium> medien;

    /**
     * Erzeuge eine leere Datenbank.
     */
    Datenbank()
    {
        medien = new ArrayList<Medium>();
    }

    /**
     * Erfasse das gegebene Medium in dieser Datenbank.
     * @param medium das einzutragende Medium.
     */
    void erfasseMedium(final Medium medium)
    {
        medien.add(medium);
    }

    /**
     * Gib eine Liste aller aktuell gespeicherten Medien
     * auf der Konsole aus.
     */
    void auflisten()
    {
        // Liste der Medien ausgeben
        for (final Medium medium : medien) {
            medium.ausgeben();
            System.out.println();   // eine Leerzeile als Abstand
        }
    }
}
