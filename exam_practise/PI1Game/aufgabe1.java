import java.io.FileInputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.List;
/**
 * Write a description of class aufgabe1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class aufgabe1
{
    private String karte;
    
    public aufgabe1(){
        this.karte = karte;
        String fileName = "file.txt";
        try{
            final FileInputStream stream = new FileInputStream(fileName);
            try {
                Reader reader = new InputStreamReader(stream, "UTF-8");
                System.out.println(reader);
                BufferedReader buffer = new BufferedReader(reader);
                //****** Convert to String list *********//
                List<String> lines = buffer.lines().toList();
                System.out.println("\n print list line \n" + lines);
            }catch(final IOException e){
                System.out.println("Fehler beim lesen2");
                
            }
        }
        catch(final IOException e){
            System.out.println("Fehler beim lesen1" + e);
        }
    }
    
}