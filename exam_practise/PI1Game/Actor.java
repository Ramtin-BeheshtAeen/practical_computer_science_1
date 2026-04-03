/**
 * Diese Klasse definiert <Zusammenfassung ergänzen>
 *
 * @author Ramtin Behesht Aeen
 */
abstract class Actor extends GameObject
{
    private final Field field;
    public Actor(final int x, final int y, int rotation, final String fileName, final Field field){
        super(x, y, rotation, fileName);
        this.field = field;
    }
    
    boolean canWalk(final int direction){
        return field.hasNeighbor(getX(), getY(), direction);
    }
    
    abstract void act();
    
}