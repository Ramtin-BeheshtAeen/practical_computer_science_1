import static java.lang.Math.abs;
import static java.lang.Math.max;

/**
 * Write a description of class WalkerNPC here.
 *
 * @author Ramtin Behesht Aeen
 * @version 
 */
class WalkerNPC extends Actor
{
    private RingBuffer stepsToFollow = null;
    private final GameObject player;
    
    WalkerNPC(final int x, final int y, int rotaion, final Field field, String name, final GameObject player){
        super(x, y, rotaion, name, field);
        this.player = player;
    }
    
    @Override
    void act()
    {
        // Wenn im Verfolgermodus, dann Schritt aufzeichnen
        if (stepsToFollow != null) {
            stepsToFollow.push(player.getRotation());
        }

        // Vorwärts bewegen
        if (getRotation() == 0) {
            setLocation(getX() + 1, getY());
        }
        else if (getRotation() == 1) {
            setLocation(getX(), getY() + 1);
        }
        else if (getRotation() == 2) {
            setLocation(getX() - 1, getY());
        }
        else {
            setLocation(getX(), getY() - 1);
        }

        // Sound dazu abspielen
        playSound("step");

        // Wenn im Verfolgermodus und aufgezeichneter Schritt möglich,
        // dann diesen verwenden.
        if (stepsToFollow != null && canWalk(stepsToFollow.peek())) {
            setRotation(stepsToFollow.pop());
        }
        else {
            // Wir sind nicht (mehr) im Verfolgermodus
            stepsToFollow = null;

            // Umdrehen, wenn nächster Schritt nicht mehr ausführbar
            if (!canWalk( getRotation())) {
                setRotation(getRotation() + 2);
            }

            // Wenn Spielfigur vor dieser Figur
            if (getRotation() == 0
                        && player.getX() > getX()
                        && player.getY() == getY()
                    || getRotation() == 1
                        && player.getX() == getX()
                        && player.getY() > getY()
                    || getRotation() == 2
                        && player.getX() < getX()
                        && player.getY() == getY()
                    || getRotation() == 3
                        && player.getX() == getX()
                        && player.getY() < getY()) {
                // Entfernung zur Spielfigur bestimmen.
                final int distance = max(abs(player.getX() - getX()),
                        abs(player.getY() - getY()));

                // Wenn auch in Sichtweite, dann Puffer anlegen und Weg eintragen.
                if (distance <= 4) {
                    stepsToFollow = new RingBuffer(distance);
                    for (int i = 1; i < distance; ++i) {
                        stepsToFollow.push(getRotation());
                    }
                }
            }
        }

        // Wenn gleiche Position wie Spielfigur, lasse diese verschwinden
        if (getX() == player.getX()) {
            if (getY() == player.getY()) {
                player.setVisible(false);
                playSound("go-away");
            }
        }
    }
    
}