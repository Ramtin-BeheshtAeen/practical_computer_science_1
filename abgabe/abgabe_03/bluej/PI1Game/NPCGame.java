// Importieren der VK_*-Tastenkonstanten
import static java.awt.event.KeyEvent.*;

/**
 * Dies ist die Hauptklasse eines Spiels. Sie enthält die Hauptmethode, die zum
 * Starten des Spiels aufgerufen werden muss.
 *
 * @author Ramtin
 */
abstract class NPCGame extends Game
{
    
    private static GameObject player;
    
    /** Das Spiel beginnt durch Aufruf dieser Methode. */
    static void main()
    
    {
        // Durch den eigentlichen Code ersetzen
        new GameObject(0, 0, 0, "path-t-0");
        new GameObject(1, 0, 0, "path-i-0");
        new GameObject(2, 0, 0, "path-i-0");
        new GameObject(3, 0, 0, "path-e-2");
        new GameObject(4, 0, 0, "bridge-0");
        //Zweite Rheie
        new GameObject(0, 1, 0, "path-t-0");
        new GameObject(1, 1, 0, "path-i-0");
        new GameObject(2, 1, 0, "path-e-2");
        new GameObject(2, 1, 0, "goal"); 
        //grass
        new GameObject(3, 1, 0, "grass");
        new GameObject(4, 1, 0, "grass");
        new GameObject(0, 2, 0, "grass");
        new GameObject(1, 2, 0, "grass");
        new GameObject(2, 2, 0, "grass");
        
        player = new GameObject(0, 0, 0, "claudius");
        
        boolean isOn = true;
        
        NPC child = new NPC(new GameObject(4,0,2, "child"), 4, 0 );
        NPC laila = new NPC(new GameObject(3,0,2, "laila"), 3, 0 );
    
        
        while(player.isVisible()){
            final int key = getNextKey();
            if ( key == VK_RIGHT || key == VK_LEFT ||key == VK_UP ||key == VK_DOWN ){
                if(key == VK_RIGHT) {
                    player.setLocation(player.getX()+1, player.getY());
                    player.setRotation(0);
                }
                if(key == VK_DOWN) {
                    player.setLocation(player.getX(), player.getY()+1);
                    player.setRotation(1);
                }
                if(key == VK_LEFT) {
                    player.setLocation(player.getX()-1, player.getY());
                    player.setRotation(2);
                }
                if(key == VK_UP) {
                    player.setLocation(player.getX(), player.getY()-1);
                    player.setRotation(3);
                }
                
                playSound("step");
            }
            else if (key == VK_SPACE){
                isOn = false;
                break;
            }
            else {
                playSound("error");
            }
            sleep(200);
            
            child.act();
            laila.act();
            laila.checkCollision(player);
            child.checkCollision(player);
            
        }
        
        
    }
    
    static void turn(final int direction){
        player.setRotation(player.getRotation() + direction);
        player.playSound("step");
    }
    
}  
        
