/**
 * Eine einfache Demo der Klasse Adressbuch.
 * Testdaten werden in das Adressbuch eingetragen und
 * und dem Benutzer wird eine Interaktion über
 * eine GUI ermöglicht.
 *
 * @author David J. Barnes und Michael Kölling.
 * @version 31.07.2011
 */
class AdressbuchDemo
{
    private final Adressbuch buch;
    private final AdressbuchGUI interaktion;

    /**
     * Lege ein Adressbuch mit Testdaten an.
     *
     * Das Adressbuch wird an eine grafische Benutzungsschnittstelle
     * weitergegeben, um die interaktive Manipulation zu ermöglichen.
     */
    AdressbuchDemo()
    {
        final Kontakt[] testdaten = {
            new Kontakt("david",   "08459 100000", "adresse 1"),
            new Kontakt("michael", "08459 200000", "adresse 2"),
            new Kontakt("john",    "08459 300000", "adresse 3"),
            new Kontakt("heike",   "08459 400000", "adresse 4"),
            new Kontakt("emma",    "08459 500000", "adresse 5"),
            new Kontakt("simone",  "08459 600000", "adresse 6"),
            new Kontakt("chris",   "08459 700000", "adresse 7"),
            new Kontakt("axel",    "08459 800000", "adresse 8"),
        };
        buch = new Adressbuch();
        for (final Kontakt kontakt : testdaten) {
            buch.neuerKontakt(kontakt);
        }
        interaktion = new AdressbuchGUI(buch);
    }

    /**
     * Ermögliche dem Benutzer die Interaktion mit dem Adressbuch.
     */
    void zeigeSchnittstelle()
    {
        interaktion.setVisible(true);
    }

    /**
     * @return das Adressbuch mit den Testdaten.
     */
    Adressbuch gibAdressbuch()
    {
        return buch;
    }
}
