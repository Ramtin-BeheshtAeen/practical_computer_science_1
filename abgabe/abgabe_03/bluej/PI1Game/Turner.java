/**
 * Diese Klasse definiert <Zusammenfassung ergänzen>
 *
 * @author Ramtin
 */
class Turner
{
    private final GameObject avatar;
    private final int maxCounter;
    private int counter;
    
    Turner(final GameObject avatar, final int maxCounter){
        this.avatar     = avatar;
        this.maxCounter = maxCounter;
        counter         = 0;
    }
    
    void act(){
        counter = counter + 1;
        if (counter == maxCounter / 2){
            turn(1);
            
        } else if (counter == maxCounter){
            turn(-1);
            counter = 0;
            avatar.playSound("step");
        }
        
    }
    
    private void turn (final int direction){
        avatar.setRotation(avatar.getRotation() + direction);
        avatar.playSound("step");
    }
}