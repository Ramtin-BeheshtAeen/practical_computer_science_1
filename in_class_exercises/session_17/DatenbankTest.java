// Importiert assertEquals usw. sowie Test-Annotationen
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Diese Klasse definiert die Tests für die Klasse <Klasse ergänzen>.
 *
 * @author Thomas Röfer
 */
public class DatenbankTest
{
    private DVD dvd;
    private CD cd;
    private Datenbank datenbank;

    @BeforeEach
    public void setUp()
    {
        dvd = new DVD("Star Wars", "George Lucas", 125);
        cd = new CD("Thriller", "Michael Jackson", 9, 42);
        datenbank = new Datenbank();
        datenbank.erfasseMedium(cd);
        datenbank.erfasseMedium(dvd);
    }
}
