import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.Reader;

/** Demonstration von Java-Methoden zum Lesen von Datenströmen. */
class Streams
{
    /**
     * Ermittelt die Länge einer Datei, indem sie durchgelesen wird.
     * @param  filename              Der Name der Datei.
     * @return                       Die Länge der Datei in Bytes.
     * @throws FileNotFoundException Die Datei mit dem Namen wurde nicht gefunden.
     * @throws IOException           Es trat ein Fehler beim Einlesen auf.
     */
    static int length(final String filename) throws FileNotFoundException, IOException
    {
        final FileInputStream stream = new FileInputStream(filename);
        int bytes = 0;
        while (stream.read() != -1) {
            ++bytes;
        }
        return bytes;
    }

    /**
     * Ermittelt die Länge einer Datei, indem sie durchgelesen wird.
     * @param  filename Der Name der Datei.
     * @return          Die Länge der Datei in Bytes. -1, wenn die Datei
     *                  nicht gelesen werden konnte.
     */
    static int length2(final String filename)
    {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(filename);
            int bytes = 0;
            while (stream.read() != -1) {
                ++bytes;
            }
            return bytes;
        }
        catch (final IOException e) {
            return -1;
        }
        finally {
            if (stream != null) {
                try {
                    stream.close();
                }
                catch (final IOException e2) {
                }
            }
        }
    }

    /**
     * Ermittelt die Länge einer Datei, indem sie durchgelesen wird.
     * @param  filename Der Name der Datei.
     * @return          Die Länge der Datei in Bytes. -1, wenn die Datei
     *                  nicht gelesen werden konnte.
     */
    static int length3(final String filename)
    {
        try (final FileInputStream stream = new FileInputStream(filename)) {
            int bytes = 0;
            while (stream.read() != -1) {
                ++bytes;
            }
            return bytes;
        }
        catch (final IOException e) {
            return -1;
        }
   }

    /**
     * Gibt eine Textdatei in Abschnitten von 20 Zeilen aus.
     * @param  filename              Der Name der Datei.
     * @throws FileNotFoundException Die Datei mit dem Namen wurde nicht gefunden.
     * @throws IOException           Es trat ein Fehler beim Einlesen auf.
     */
    static void more(final String filename) throws FileNotFoundException, IOException
    {
        final InputStream stream = new FileInputStream(filename);
        final Reader reader = new InputStreamReader(stream, "UTF-8");
        final BufferedReader buffer = new BufferedReader(reader);
        System.out.print("\f");
        String line;
        int count = 1;
        while ((line = buffer.readLine()) != null) {
            System.out.println(count + ":\t" + line);
            if (++count % 20 == 1) {
                System.in.read();
                System.out.print("\f");
            }
        }
    }
}
