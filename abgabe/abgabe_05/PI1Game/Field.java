/**
 * Diese Klasse repräsentiert ein Spielfeld. Ihr Konstruktor bekommt dieses als
 * String-Array übergeben.
 */
class Field
{
    final String[] field;
    
    //ToDo: Add docs:
    public Field(String[] field){
        this.field = field;
        //Testing:
        //System.out.println(field.length);
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
    
    
    //ToDo: Add docs
    private char getChar(int x, int y){
        if( x >= 9 || x < 0  || y >= 9 || y < 0){
            return ' ';
        }
        else {
            String row = field[y];
            return row.charAt(x);
        }
        //ToDo: Add option for errors outside of bounderies
    };
    
    private int getNeighborhood(int x, int y){
        System.out.println(x);
        System.out.println(y);
        int index = 0;
        //check right side:
        if (getChar(x, y+1) != ' '){
            System.out.println("right");
            System.out.println(getChar(x+1, y));
            index += 2;
        };
        //Check left side:
        if (getChar(x, y-1) != ' '){
            System.out.println("left");
            System.out.println(getChar(x-1, y));
            index += 8;
        };
        //check above:
        if (getChar(x-1, y) != ' '){
            System.out.println("above");
            System.out.println(getChar(x, y+1));
            index += 4;
        };
        //check down:
        if (getChar(x+1, y) != ' '){
            System.out.println("down");
            System.out.println(getChar(x, y-1));
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
        
        //test aufgabe 1:
        
        for(int i=0; i<9;i++){
            char selcetedChar = field.getChar(i, 1);
            System.out.println(selcetedChar);
        }
        //test aufgabe 2:
        //int selcetedNeighborhoodIndex = field.getNeighborhood(8, 8);
        //System.out.println(selcetedNeighborhoodIndex);
        //
        for (int x=0; x<9; x++) {
            for(int y=0; y<9; y++){
                if (field.getChar(x, y)==' '){
                    new GameObject(x, y, 0, "grass");
                } else{
                int selcetedNeighborhoodIndex = field.getNeighborhood(x, y);
                System.out.println(selcetedNeighborhoodIndex);
                String gameObject = neighborhoodToFilename[selcetedNeighborhoodIndex];
                System.out.println("----");
                System.out.println(x);
                System.out.println(y);
                System.out.println("----");
                new GameObject(x, y, 0, gameObject);
            }
            };
        };
        
    };
}
