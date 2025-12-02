/**
 * Diese Klasse definiert <Zusammenfassung ergänzen>
 *
 * @author Ramtin
 */
class NPC
{
    // Aufgabe 1: Attribute
    final private GameObject character;
    final private int maxStep;
    private int startStep;
    
    public NPC(GameObject character, int maxStep, int startStep){
        this.character   = character;
        this.maxStep     = maxStep;
        this.startStep   = startStep;

    }
    
    public void act(){
        
        if(character.getRotation() == 2){
            // Schritt vorwärts machen
            int newX = character.getX() - 1; 
            character.setLocation(newX, character.getY());
        } else {
            int newX = character.getX() + 1; 
            character.setLocation(newX, character.getY());
        }
        
        // Schrittzähler erhöhen
        startStep++;
        
        // Prüfen, ob Maximalanzahl erreicht ist
        if (startStep >= maxStep){
            startStep = 0; // Schrittzähler zurücksetzen
            character.setRotation(character.getRotation() + 2); //// Richtung umdrehen
        }
        
    }
    
    public void checkCollision(GameObject player){
        //prufen NPC position mit Player position:
        if (character.getX() == player.getX() && character.getY() == player.getY()){
            player.setVisible(false);
        }
    }

    /**
     * Return the underlying GameObject representing the NPC so callers can inspect
     * position and rotation (used by the simple follower example).
     */
    public GameObject getCharacter() {
        return character;
    }
    
}