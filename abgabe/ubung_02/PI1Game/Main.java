// Importieren der VK_*-Tastenkonstanten
import static java.awt.event.KeyEvent.*;
//right 0
//down 1
//left 2
// up 3
//
/**
 * Dies ist die Hauptklasse eines Spiels. Sie enthält die Hauptmethode, die zum
 * Starten des Spiels aufgerufen werden muss.
 *
 * @author ramtin
 */
abstract class Main extends Game
{
    /** Das Spiel beginnt durch Aufruf dieser Methode. */
    static void main()
    {
        // Durch den eigentlichen Code ersetzen
        new GameObject(0, 0, 0, "path-e");
        new GameObject(1, 0, 0, "path-i");
        new GameObject(2, 0, 1, "path-t");
        new GameObject(3, 0, 0, "path-i");
        new GameObject(3, 0, 0, "goal");
        new GameObject(4, 0, 0, "bridge");
        new GameObject(0, 1, 0, "path-e");
        new GameObject(1, 1, 0, "path-i");
        new GameObject(2, 1, 0, "path-x");
        new GameObject(3, 1, 2, "path-e");
        new GameObject(4, 1, 3, "water-l");
        new GameObject(0, 2, 0, "path-e");
        new GameObject(1, 2, 0, "path-i");
        new GameObject(2, 2, 0, "path-x");
        new GameObject(3, 2, 0, "path-i");
        new GameObject(4, 2, 2, "path-e");
        new GameObject(0, 3, 0, "path-e");
        new GameObject(1, 3, 0, "path-i");
        new GameObject(2, 3, 2, "path-l");
        new GameObject(3, 3, 0, "water-l");
        new GameObject(4, 3, 0, "water-i");
        new GameObject(1, 0, 2, "claudius");
        new GameObject(0, 1, 0, "laila");
        new GameObject(3, 2, 2, "child");
        
        final GameObject player = new GameObject(0, 0, 0,"woman");
        while(true){
            final int key = getNextKey();
            if(key == VK_RIGHT) {
                
                player.setLocation(player.getX() + 1, player.getY());
                player.setRotation(0);
                playSound("step");
            } 
            else if(key == VK_DOWN) {
                
                player.setLocation(player.getX(), player.getY()+1);
                player.setRotation(1);
                playSound("step");
            } 
            else if(key == VK_LEFT) {
                
                player.setLocation(player.getX() - 1, player.getY());
                player.setRotation(2);
                playSound("step");
            } 
            else if(key == VK_UP) {
                
                player.setLocation(player.getX(), player.getY() - 1);
                player.setRotation(3);
                playSound("step");
            } 
            
            else {
            playSound("error");
            }
        }
    }
}