
// Importieren der VK_*-Tastenkonstanten
import static java.awt.event.KeyEvent.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Dies ist die Hauptklasse eines Spiels. Sie enthält die Hauptmethode, die zum
 * Starten des Spiels aufgerufen werden muss.
 *
 * @author Ramtin Behesht Aeen
 */
abstract class PI1Game extends Game
{
    /** Das Spiel beginnt durch Aufruf dieser Methode. */
    static void main()
    {
        // Das Spielfeld erzeugen
        final Field field = new Field(new String[] {
            "O-O-O-O",
            "    |",
            "O-O-O-O",
            "    |",
            "O-O-O-O-O",
            "    |",
            "O-O-O"
        });
        new GameObject(3, 0, 0, "goal");
        new GameObject(4, 0, 0, "bridge");
        new GameObject(4, 1, 3, "water-l");
        new GameObject(3, 3, 0, "water-l");
        new GameObject(4, 3, 0, "water-i");
        
        

        
        final Player player = new Player(0, 3, 0, field, "woman");
        final WalkerNPC walker1 = new WalkerNPC(1, 0, 2, field, "claudius", player);
        final WalkerNPC walker2 = new WalkerNPC(0, 1, 0, field, "laila", player);
        final WalkerNPC walker3 = new WalkerNPC(3, 2, 2, field, "child", player);
        final List<Actor> figures = new ArrayList<>(Arrays.asList(player, walker1, walker2, walker3));

        
        
        
        while (player.isVisible()) {
            for(final Actor figure : figures){
                figure.act();
            }
        }
    }
}
