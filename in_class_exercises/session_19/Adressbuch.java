import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Eine Klasse zur Verwaltung einer beliebigen Anzahl von
 * Kontakten. Die Daten werden sowohl über den Namen
 * als auch über die Telefonnummer indiziert.
 *
 * @author David J. Barnes und Michael Kölling.
 * @version 31.07.2011
 */
class Adressbuch
{
    // Speicher für eine beliebige Anzahl von Kontakten.
    private final SortedMap<String, Kontakt> buch;
    private int anzahlEinträge;

    /**
     * Initialisiere ein neues Adressbuch.
     */
    Adressbuch()
    {
        buch = new TreeMap<String, Kontakt>();
        anzahlEinträge = 0;
    }

    /**
     * Schlage einen Namen oder eine Telefonnummer
     * nach und liefere den zugehörigen Kontakt.
     * @param schlüssel der Name oder die Nummer zum Nachschlagen.
     * @return den zum Schlüssel gehörenden Kontakt oder null,
     *         falls der Schlüssel nicht bekannt ist.
     * @throws IllegalArgumentException wenn schlüssel leer ist.
     */
    Kontakt gibKontakt(final String schlüssel)
    {
        if (schlüssel == null) {
            throw new IllegalArgumentException(
                    "Parameter in gibKontakt ist null.");
        }
        else if (schlüssel.trim().length() == 0) {
            throw new IllegalArgumentException(
                    "Leerer Schlüssel in gibKontakt.");
        }
        return buch.get(schlüssel);
    }

    /**
     * Ist der gegebene Schlüssel in diesem Adressbuch bekannt?
     * @param schlüssel der Name oder die Nummer zum Nachschlagen.
     * @return true wenn der Schlüssel eingetragen ist, false sonst.
     */
    boolean schlüsselBekannt(final String schlüssel)
    {
        return buch.containsKey(schlüssel);
    }

    /**
     * Füge einen neuen Kontakt in dieses Adressbuch ein.
     * @param kontakt der neue Kontakt.
     */
    void neuerKontakt(final Kontakt kontakt)
    {
        buch.put(kontakt.gibName(), kontakt);
        buch.put(kontakt.gibTelefon(), kontakt);
        ++anzahlEinträge;
    }

    /**
     * Ändere die Kontaktdaten, die bisher unter dem gegebenen
     * Schlüssel eingetragen waren.
     * @param alterSchlüssel einer der verwendeten Schlüssel.
     * @param daten die neuen Kontaktdaten.
     */
    void ändereKontakt(final String alterSchlüssel,
            final Kontakt daten)
    {
        entferneKontakt(alterSchlüssel);
        neuerKontakt(daten);
    }

    /**
     * Suche nach allen Kontakten mit einem Schlüssel, der mit dem
     * gegebenen Präfix beginnt.
     * @param präfix der Schlüsselpräfix, nach dem gesucht werden soll.
     * @return ein Array mit den gefundenen Kontakten.
     */
    Kontakt[] suche(final String präfix)
    {
        // Eine Liste für die Treffer anlegen.
        final List<Kontakt> treffer = new ArrayList<Kontakt>();
        // Finden von Schlüsseln, die gleich dem oder größer als
        // der Präfix sind.
        final SortedMap<String, Kontakt> rest = buch.tailMap(präfix);
        final Iterator<String> it = rest.keySet().iterator();
        // Stoppen bei der ersten Nichtübereinstimmung.
        boolean sucheBeendet = false;
        while (!sucheBeendet && it.hasNext()) {
            final String schlüssel = it.next();
            if (schlüssel.startsWith(präfix)) {
                treffer.add(buch.get(schlüssel));
            }
            else {
                sucheBeendet = true;
            }
        }
        final Kontakt[] ergebnisse = new Kontakt[treffer.size()];
        treffer.toArray(ergebnisse);
        return ergebnisse;
    }

    /**
     * Liefere die Anzahl der Einträge aktuell in diesem Adressbuch.
     * @return die Anzahl der Einträge.
     */
    int gibAnzahlEinträge()
    {
        return anzahlEinträge;
    }

    /**
     * Entferne den Eintrag mit dem gegebenen Schlüssel aus
     * diesem Adressbuch. Bei einem unbekannten Schlüssel
     * tue nichts.
     * @param schlüssel einer der Schlüssel des Eintrags,
     *                  der entfernt werden soll.
     * @return true, wenn der Kontakt erfolgreich entfernt wurde,
     * andernfalls false.
     */
    boolean entferneKontakt(final String schlüssel)
    {
        if (schlüsselBekannt(schlüssel)) {
            final Kontakt kontakt = buch.get(schlüssel);
            buch.remove(kontakt.gibName());
            buch.remove(kontakt.gibTelefon());
            --anzahlEinträge;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Liefere alle Kontaktdaten, sortiert nach der
     * Sortierreihenfolge, die die Klasse Kontakt definiert.
     * @return die sortierten Kontaktdaten.
     */
    String alleKontaktdaten()
    {
        // Weil jeder Satz unter zwei Schlüsseln eingetragen ist,
        // muss ein Set mit den Kontakten gebildet werden. Dadurch
        // werden Duplikate entfernt.
        final StringBuilder alleEinträge = new StringBuilder();
        final Set<Kontakt> sortierteDaten = new TreeSet<Kontakt>(buch.values());
        for (final Kontakt kontakt : sortierteDaten) {
            alleEinträge.append(kontakt);
            alleEinträge.append('\n');
            alleEinträge.append('\n');
        }
        return alleEinträge.toString();
    }
}
