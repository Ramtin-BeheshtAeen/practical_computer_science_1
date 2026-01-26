/**
 * Die Klasse definiert einen einfache Zähler, der durch einen
 * Methodenaufruf erhöht werden kann.
 */
class Counter
{
    private int value = 0;

    void inc()
    {
        final int v = value;
        value = v + 1;
    }

    int get()
    {
        return value;
    }
}
