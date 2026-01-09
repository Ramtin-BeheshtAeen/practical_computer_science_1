/**
 * Die Kontaktdaten für einen Eintrag in einem
 * Adressbuch: Name, Adresse, Telefon.
 *
 * @author David J. Barnes und Michael Kölling.
 * @version 31.07.2011
 */
class Kontakt implements Comparable<Kontakt>
{
    private final String name;
    private final String telefon;
    private final String adresse;

    /**
     * Lege Kontaktdaten an. Bei allen Angaben werden umgebende
     * Leerzeichen entfernt. Entweder der Name oder die Telefonnummer
     * darf nicht leer sein.
     * @param name der Name.
     * @param telefon die Telefonnummer.
     * @param adresse die Adresse.
     * @throws IllegalArgumentException wenn name und telefon beide leer sind.
     */
    Kontakt(final String name, final String telefon, final String adresse)
    {
        // Leere Strings verwenden, wenn einer der Parameter null ist.
        this.name = name == null ? "" : name.trim();
        this.telefon = telefon == null ? "" : telefon.trim();
        this.adresse = adresse == null ? "" : adresse.trim();

        if (this.name.isEmpty() && this.telefon.isEmpty()) {
            throw new IllegalArgumentException(
                    "name und telefon dürfen nicht beide leer sein");
        }
    }

    /**
     * @return den Namen.
     */
    String gibName()
    {
        return name;
    }

    /**
     * @return die Telefonnummer.
     */
    String gibTelefon()
    {
        return telefon;
    }

    /**
     * @return die Adresse.
     */
    String gibAdresse()
    {
        return adresse;
    }

    /**
     * Teste dieses und jenes Objekt auf Datengleichheit.
     * @param jenes Das Objekt, das mit diesem verglichen
     *              werden soll.
     * @return true wenn das Parameterobjekt ein Kontakt ist
     *              und sich die Datenfelder paarweise gleichen.
     */
    @Override
    public boolean equals(final Object jenes)
    {
        return jenes instanceof Kontakt jenerKontakt
                && name.equals(jenerKontakt.gibName())
                && telefon.equals(jenerKontakt.gibTelefon())
                && adresse.equals(jenerKontakt.gibAdresse());
    }

    /**
     * @return einen mehrzeiligen String mit Name, Telefon und Adresse.
     */
    @Override
    public String toString()
    {
        return name + "\n" + telefon + "\n" + adresse;
    }

    /**
     * Vergleiche diesen Kontakt mit einem anderen, damit
     * sortiert werden kann. Kontakte werden nach Name,
     * Telefonnummer und Adresse sortiert.
     * @param jenerKontakt der Kontakt, mit dem verglichen werden soll.
     * @return einen negativen Wert, wenn dieser Kontakt vor dem Parameter
     *         liegt, Null, wenn sie gleich sind, und einen positiven Wert,
     *         wenn dieser Kontakt nach dem Parameter folgt.
     */
    @Override
    public int compareTo(final Kontakt jenerKontakt)
    {
        int vergleich = name.compareTo(jenerKontakt.gibName());
        if (vergleich != 0) {
            return vergleich;
        }
        vergleich = telefon.compareTo(jenerKontakt.gibTelefon());
        if (vergleich != 0) {
            return vergleich;
        }
        return adresse.compareTo(jenerKontakt.gibAdresse());
    }

    /**
     * Berechne einen Hashcode nach den Regeln des Buches
     * "Effektiv Java programmieren" von Joshua Bloch.
     * @return einen Hashcode für diesen Kontakt.
     */
    @Override
    public int hashCode()
    {
        int code = 17;
        code = 37 * code + name.hashCode();
        code = 37 * code + telefon.hashCode();
        code = 37 * code + adresse.hashCode();
        return code;
    }
}
