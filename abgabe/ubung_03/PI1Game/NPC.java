// Importieren der VK_*-Tastenkonstanten
import static java.awt.event.KeyEvent.*;

/**
 * Dies ist die Hauptklasse eines Spiels. Sie enthält die Hauptmethode, die zum
 * Starten des Spiels aufgerufen werden muss.
 *
 * @author ramtin
 */
abstract class NPC extends Game
{
    private int number_steps;
    private final int step_length;
    private final GameObject npc;
    
    NPC(final GameObject npc, final int step_length, final int number_steps){
    
        // Durch den eigentlichen Code ersetzen
        this.npc = npc;
        this.step_length = step_length;
        this.number_steps = number_steps;
    }
}