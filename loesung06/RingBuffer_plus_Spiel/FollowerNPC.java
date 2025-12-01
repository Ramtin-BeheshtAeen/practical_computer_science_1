/*
 * 
 * it only records rotations in a RingBuffer and replays them
 * later. No threading or advanced patterns are used.
 * 
 * @author Ramtin
 */
class FollowerNPC {

    private final GameObject character;
    private RingBuffer rotBuffer;
    private boolean chasing = false;

    /**
     * Create a simple follower NPC.
     * @param character the GameObject representing the NPC
     * @param initialBufferCapacity initial buffer capacity 
     */
    FollowerNPC(final GameObject character, final int initialBufferCapacity) {
        this.character = character;
        this.rotBuffer = new RingBuffer(initialBufferCapacity);
    }

    /**
     * Minimal getter for GameObject,for distance checks from the game.
     */
    public GameObject getCharacter() {
        return character;
    }

    /**
     * Initialize chase mode using the player position.
     * We size the buffer based on the number of single-step moves that
     * are needed to reach the player's position
     * and prefill it with the NPC's rotation so the
     * NPC follows with a delay.
     */
    public void startChase(final GameObject player) {
        // calculate dx and dy 
        final int dx = player.getX() >= character.getX() ? player.getX() - character.getX() : character.getX() - player.getX();
        final int dy = player.getY() >= character.getY() ? player.getY() - character.getY() : character.getY() - player.getY();
        final int cap = dx + dy;
        rotBuffer = new RingBuffer(cap);
        final int r = character.getRotation();
        for (int i = 0; i < cap; ++i) {
            rotBuffer.push(r);
        }
        chasing = true;
    }

    /**
     * When the player moves, call this with the player's rotation.
     * The NPC stores the rotation so it can replay it later.
     */
    public void notifyPlayerMove(final int playerRotation) {
        if (!chasing) {
            return;
        }
        rotBuffer.push(playerRotation);
    }

    /**
     * Called every game tick; when chasing it will read one rotation from the
     * buffer and move the NPC in that direction.
     */
    public void act() {
        if (!chasing) {
            return; // nothing to do
        }
        if (rotBuffer.size() <= 0) {
            return; // the buffer is empty
        }
        final int next = rotBuffer.pop();
        character.setRotation(next);
        moveByRotation(next);
        character.playSound("step");
    }

    /** Simple helper to move the NPC by a rotation value. */
    private void moveByRotation(final int rot) {
        switch (rot) {
            case 0:
                character.setLocation(character.getX() + 1, character.getY());
                break;
            case 1:
                character.setLocation(character.getX(), character.getY() + 1);
                break;
            case 2:
                character.setLocation(character.getX() - 1, character.getY());
                break;
            case 3:
                character.setLocation(character.getX(), character.getY() - 1);
                break;
            default:
                //do nothing
        }
    }

    public boolean isChasing() {
        return chasing;
    }

}
