
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
       
        
        Level level = new Level("./levels/1.lvl");

        //final List<Actor> figures = level.getActors();
        
        
        
        
        while (level.getActors().get(0).isVisible()) {
            for(final Actor figure : level.getActors()){
                figure.act();
            }
        }
    }
}
