/**
 * Eine Ausnahme, die auftritt, wenn versucht wird, aus einem
 * leeren Puffer zu lesen.
 */
class EmptyBufferException extends RuntimeException
{
    EmptyBufferException()
    {
        super("Der Puffer ist leer");
    }
}
