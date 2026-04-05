
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own
    public Test(){
        TestindexOf();
        TestGrid();
    }

   
    public void TestindexOf()
    {
        String symbols = "p P q Q l L ";
        char c = 'q';
        
        int index = symbols.indexOf(c);
        System.out.println("index of " + c + "  = " + index); //4
        
        //unknowm symbol:
        char unknown = 'X';
        System.out.println("index of 'X' " + " =  " + symbols.indexOf(unknown)); //-1
    }
    
    public void TestGrid()
    {
        String[] lines = {
            "p . G",   // y=0
            ". . .",   // y=1 (skip)
            "l . ."    // y=2
        };
        
        for (int y =0; y < lines.length; y+=2){
            for(int x = 0; x < lines[y].length(); x+=2){
                char c = lines[y].charAt(x);
                System.out.println("Grid[" + y/2 + "][" + x/2 + "] = " + c);
            }
        }
        
        
    }
    
    public void testAll(){
        String[] level = {
            "p . l . G",
            ". . . . .",
            ". . i . ."
        };
        
        String symbols = "pPqQlLiIcCdDsSzZGbBWO";
        int[] playerPos = {-1, -1};
        "pPqQ_lLiI_cCdD_sSzZ_GbBW_O"
        for(int y = 0; y < level.length; y+=2){
            for(int x = 0; x < level[y].length(); x+=2){
                char c = level[y].charAt(x);
                
                int indexOfCharInSymbols = symbols.indexOf(c);
                if(indexOfCharInSymbols == -1){
                    System.out.println("Unknown: " + c);
                }
                
            }
        }
    }
}