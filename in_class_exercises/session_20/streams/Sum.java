import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/** Demonstration der Klasse Scanner. */
class Sum
{
    /**
     * Berechnet die Summe aller Zahlen in einer Textdatei.
     * @param  filename              Der Name der Textdatei.
     * @return                       Die Summe aller Zahlen, bis die erste Nichtzahl
     *                               in der Datei gefunden wurde.
     * @throws FileNotFoundException Die Datei mit dem Namen wurde nicht gefunden.
     */
    static int sum(final String fileName) throws FileNotFoundException, IOException
    {
        try (final FileInputStream stream = new FileInputStream(fileName);
                final Scanner scanner = new Scanner(stream)) {
            int sum = 0;
            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            }
            return sum;
        }
    }
}
