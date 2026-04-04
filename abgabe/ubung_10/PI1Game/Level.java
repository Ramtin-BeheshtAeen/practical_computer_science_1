import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.Reader;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
 *  * Diese Klasse definiert den Level eines Spiels. Ein Level wird
 * aus einer Beschreibung erzeugt, die in einer Datei gespeichert ist.
 * Die Datei enthält Symbole für leere Zellen (' '), freie Gitterzellen
 * ('O'), Wasserzellen ('W'), Zellverbindungen ('|', '-'), die Spielfigur
 * ('p', 'P', 'q', 'Q' für die Rotationen 0-3), drei Sorten
 * Spaziergänger:innen ('l', 'L', 'i', 'I' für Laila, 'c', 'C', 'd', 'D'
 * für Clausius und 's', 'S', 'z', 'Z' für das Kind, jeweils für die
 * Rotationen 0-3) sowie das Ziel und zwei Brückensymbole ('G', 'b', 'B').
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Level
{
    private final Field field;
    
    
    
    
    public Level(final String fileName){
        
        final List<String> lines = new ArrayList<String>();
        
        try{
            final FileInputStream stream = new FileInputStream(fileName);
            try{
                final Reader reader = new InputStreamReader(stream, "UTF-8");
                final BufferedReader buffer = new BufferedReader(reader);
                //convert to string list:
                String line;
                while((line = buffer.readLine()) != null){
                    lines.add(line);
                }
            }
            catch(final FileNotFoundException e){
                System.out.println("Es gab Probleme beim Lesen der Datei.");
            }
        } catch (IOException e){
            System.out.println("Die Level-Datei wurde nicht gefunden.");
        }
    
        field = new Field(new String[lines.size()]);
        
        for(int y = 0; y < lines.size(); y +=2){
            
        }
    }
}