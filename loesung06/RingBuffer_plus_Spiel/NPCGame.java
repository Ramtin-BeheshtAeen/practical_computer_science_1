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
        
        //NPC child = new NPC(new GameObject(4,0,2, "child"), 4, 0 );
        //NPC laila = new NPC(new GameObject(3,0,2, "laila"), 3, 0 );
        FollowerNPC follower = new FollowerNPC(new GameObject(2,0,2, "laila"), 3);
    
        
        while(player.isVisible()){
            final int key = getNextKey();
            boolean moved = false;
            if ( key == VK_RIGHT || key == VK_LEFT ||key == VK_UP ||key == VK_DOWN ){
                if(key == VK_RIGHT) {
                    player.setLocation(player.getX()+1, player.getY());
                    player.setRotation(0);
                    moved = true;
                }
                if(key == VK_DOWN) {
                    player.setLocation(player.getX(), player.getY()+1);
                    player.setRotation(1);
                    moved = true;
                }
                if(key == VK_LEFT) {
                    player.setLocation(player.getX()-1, player.getY());
                    player.setRotation(2);
                }
                if(key == VK_UP) {
                    player.setLocation(player.getX(), player.getY()-1);
                    player.setRotation(3);
                    moved = true;
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
            // If moved, do the notify/startChase logic here
            if (moved) {
                final int chaseDistance = 3;
                //final int childDx = player.getX() >= child.getCharacter().getX() ? player.getX() - child.getCharacter().getX() : child.getCharacter().getX() - player.getX();
                //inal int childDy = player.getY() >= child.getCharacter().getY() ? player.getY() - child.getCharacter().getY() : child.getCharacter().getY() - player.getY();
                //final int lailaDx = player.getX() >= laila.getCharacter().getX() ? player.getX() - laila.getCharacter().getX() : laila.getCharacter().getX() - player.getX();
                //final int lailaDy = player.getY() >= laila.getCharacter().getY() ? player.getY() - laila.getCharacter().getY() : laila.getCharacter().getY() - player.getY();
                final int followerDx = player.getX() >= follower.getCharacter().getX() ? player.getX() - follower.getCharacter().getX() : follower.getCharacter().getX() - player.getX();
                final int followerDy = player.getY() >= follower.getCharacter().getY() ? player.getY() - follower.getCharacter().getY() : follower.getCharacter().getY() - player.getY();
                // We only use startChase/notify for the follower NPC. Basic NPCs (child, laila)
                // keep their existing behavior (they don't implement startChase/notify).
                if (followerDx <= chaseDistance && followerDy <= chaseDistance && !follower.isChasing()) follower.startChase(player);
                // push rotation to the follower only when it's chasing
                follower.notifyPlayerMove(player.getRotation());
            }
            
            //child.act();
            //laila.act();
            follower.act();
            //laila.checkCollision(player);
            //child.checkCollision(player);
            
        }
        
        
    }
    
    static void turn(final int direction){
        player.setRotation(player.getRotation() + direction);
        player.playSound("step");
    }
    
}  
        
