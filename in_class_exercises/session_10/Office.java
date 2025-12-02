// Importieren der VK_*-Tastenkonstanten
import static java.awt.event.KeyEvent.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Dies ist die Hauptklasse für unsere Psychiaterin. Sie enthält die Methode,
 * die das Programm startet.
 *
 * @author Thomas Röfer
 */
abstract class Office extends Game
{
    /** Das Spiel beginnt durch Aufruf dieser Methode. */
    static void main()
    {
        // Hintergrundbild setzen
        new GameObject.Canvas(80, 100, 10, 4);
        new GameObject(40, 50, 0, "shrink.png");

        // Fläche für Text erzeugen
        final BufferedImage image = new BufferedImage(800, 100, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics = (Graphics2D) image.getGraphics();
        graphics.setBackground(new Color(0, 0, 0, 0));
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("SansSerif", Font.PLAIN, 24));
        graphics.drawString("What's on your mind?", 0, 24);
        final GameObject view = new GameObject(58, 28, image);

        // Eliza und Speicher für aktuellen Satz erzeugen
        final Eliza eliza = new Eliza();
        String sentence = "";

        while (true) {
            final int key = getNextKey();

            // Ersten Buchstaben im Satz und Leerzeichen übernehmen
            if (key >= VK_A && key <= VK_Z && sentence.isEmpty() || key == VK_SPACE) {
                sentence += (char) key;
            }
            // Weitere Buchstaben klein schreiben
            else if (key >= VK_A && key <= VK_Z) {
                sentence += (char) (key + 32);
            }
            // Letztes Zeichen löschen
            else if (key == VK_BACK_SPACE && sentence.length() > 0) {
                sentence = sentence.substring(0, sentence.length() - 1);
            }
            // Antwort bestimmen und ausgeben
            else if (key == VK_ENTER) {
                graphics.clearRect(0, 0, image.getWidth(), image.getHeight());
                graphics.drawString(eliza.respondTo(sentence), 0, 24);
                view.setImage(image);
                sentence = "";
                continue; // Erhalte die Darstellung von Elizas Antwort
            }
            // Alles andere ignorieren
            else {
                continue;
            }

            // Bisher eingegebenen Satz ausgeben
            graphics.clearRect(0, 0, image.getWidth(), image.getHeight());
            graphics.drawString(sentence + "_", 100, 90);
            view.setImage(image);
        }
    }
}
