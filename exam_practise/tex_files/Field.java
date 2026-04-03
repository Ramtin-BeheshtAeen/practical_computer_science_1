/**
 * Diese Klasse repräsentiert ein Spielfeld. Ihr Konstruktor bekommt dieses als
 * String-Array übergeben.
 */
class Field
{
    final String[] field;
    
    /**
    * Creates a new Field.
    * @param field the ASCII map as a String array
    */
   
    public Field(String[] field){
        this.field = field;
    }
    
    /**
     * Die Dateinamen der Bodengitterelemente, die direkt mit einer
     * Rotation 0 verwendet werden können. Der Index ergibt sich
     * aus der Summe der folgenden Zahlen:
     * 1: In Richtung 0 (+1, 0) gibt es eine Verbindung.
     * 2: In Richtung 1 (0, +1) gibt es eine Verbindung.
     * 4: In Richtung 2 (-1, 0) gibt es eine Verbindung.
     * 8: In Richtung 3 (0, -1) gibt es eine Verbindung.
     */
    private static final String[] neighborhoodToFilename = {
        "grass",
        "path-e-0",
        "path-e-1",
        "path-l-0",
        "path-e-2",
        "path-i-0",
        "path-l-1",
        "path-t-1",
        "path-e-3",
        "path-l-3",
        "path-i-1",
        "path-t-0",
        "path-l-2",
        "path-t-3",
        "path-t-2",
        "path-x"
    };
    
    
    /**
     * Returns the character at position (x, y), or a space if out of bounds.
     * @param x the column index
     * @param y the row index
     * @return the character at the given position
     */
    private char getChar(int x, int y){
        if( y >= field.length || y < 0  || x >= field[y].length() || x < 0){
            return ' ';
        }
        else {
            String row = field[y];
            return row.charAt(x);
        }
        
    };
    
    /**
     * Calculates a neighborhood index for position (x, y).
     * @param x the column index
     * @param y the row index
     * @return a number (0–15) describing the connections
    */
    
    private int getNeighborhood(int x, int y){
        int index = 0;
        
        if (getChar(x, y+1) != ' '){
            index += 2;
        };

        if (getChar(x, y-1) != ' '){
            index += 8;
        };
  
        if (getChar(x-1, y) != ' '){
            index += 4;
        };
 
        if (getChar(x+1, y) != ' '){
            index += 1;
        };
        return index;  
    };
    
    
    /** Ein Testfall, der alle Nachbarschaften enthält. */
    static void test()
    {
        new GameObject.Canvas(5, 5, 96, 96);
        
        // Einkommentieren, sobald Konstruktor vorhanden
        Field field = new Field(new String[] {
            "O-O-O-O  ",
            "|   |    ",
            "O O-O-O O",
            "| | | | |",
            "O-O-O-O-O",
            "| | | | |",
            "O O-O-O O",
            "    |   |",
            "O-O-O-O-O"
        });

        
        
        for (int y=0; y<field.field.length; y+=2 ) {
            for(int x=0; x<field.field[y].length(); x+=2 ){
                int selcetedNeighborhoodIndex = field.getNeighborhood(x, y);
                String gameObject = neighborhoodToFilename[selcetedNeighborhoodIndex];
                new GameObject(x/2, y/2, 0, gameObject);
            }
        };
        
    };
}
