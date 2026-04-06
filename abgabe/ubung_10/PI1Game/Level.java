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
    private final List<Actor> actors          = new ArrayList<>();
    private final List<GameObject> gameObjects = new ArrayList<>();
    
    public Level(final String fileName){
         
        final List<String> lines = new ArrayList<String>();
        
        String symbols = "pPqQlLiIcCdDsSzZGbBWO ";
        
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
        
        field = new Field(lines.toArray(new String[lines.size()]));
        //initializing the player
        Player player = new Player(-1,0,0, field, "woman");
        
        /* 0 1 2 3
         * p P q Q
         * ----------
         * 
         * 4 5 6 7
         * l L i I
         * 
         * 8 9 10 11
         * c C d  D
         * 
         * 12 13 14 15
         * s  S  z  Z
         * ------------
         * 16 17 18 19  20
         * G  b  B  W   O 
         * 
         * index:  0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
         * char:   p  P  q  Q  l  L  i  I  c  C  d  D  s  S  z  Z
         *                      |----laila----|--claudius--|---child--|
         *                      
         *  index % 4:        // rotation:  0,1,2,3 , 0,1,2,3 , 0,1,2,3
         *  index / 4 - 1:   // image:      0,0,0,0 , 1,1,1,1 , 2,2,2,2                    
         */
        
        for(int y = 0; y < lines.size(); y +=2){
            for(int x = 0; x < lines.get(y).length(); x+=2){
                char c = lines.get(y).charAt(x);
                final int indexOfCharInSymbols = symbols.indexOf(c);
                
                if (indexOfCharInSymbols == -1) {
                // Kein erlaubtes Symbol gefunden
                    throw new IllegalArgumentException("Unbekanntes Symbol '" + lines.get(y).charAt(x)
                        + "' in Level '" + fileName + "', Zeile " + (y + 1) + ", Spalte " + (x + 1)
                        + " gefunden.");
                }
                
                else if(indexOfCharInSymbols < 4){
                    //checling if there is just one player:
                    if(player.getX()!= -1){
                        throw new IllegalArgumentException("Zweite Spielfigur in Level '"
                            + fileName + "', Zeile " + (y + 1) + ", Spalte " + (x + 1)
                            + " gefunden.");
                    }
                     // Existierende Spielfigur platzieren.
                    player.setLocation(x / 2, y / 2);
                    player.setRotation(indexOfCharInSymbols);
                    actors.add(player);
                    gameObjects.add(player);
                }
                
                else if (indexOfCharInSymbols < 16){
                    final String[] images = {"laila", "claudius", "child"};
                    final Actor actor     = new  WalkerNPC(x/2, y/2, indexOfCharInSymbols % 4, field, images[( indexOfCharInSymbols / 4) -1], player);
                    actors.add(actor);
                    gameObjects.add(actor);
                    
                }
                else if (indexOfCharInSymbols < 19){
                    final String[] images  = {"goal", "bridge-0", "bridge-1"};
                    //bucket = (n - min)/ bucket size
                    //[16, 17, 18], buckets = 3 , bucketSize = 3 / 3 = 1
                    //bucket = (n - 16) / 1 = n - 16
                    new GameObject(x/2, y/2, 0 , images[indexOfCharInSymbols - 16]);
                    
                    
                }
            }
        }
        // Wurde die Spielfigur nicht bewegt, wurde keine gefunden.
        if(player.getX() == -1) {
            throw new IllegalArgumentException("Keine Spielfigur in Level '" + fileName + "' gefunden");
        }
    }
    
    List<Actor> getActors(){
        return actors;
    }
}